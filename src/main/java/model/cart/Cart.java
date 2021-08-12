package model.cart;

import model.item.Item;
import model.item.Precio;
import model.order.Order;

import java.util.*;

public class Cart implements Precio {

    private final List<Precio> items;

    public  List<Precio> getItems() {
        return items;
    }

    public Cart() {
        items = new ArrayList<>();
    }

    /*
    public void showCart(){
        System.out.println("\u001B[35m" +"-------------------------- Artículos --------------------------");

        System.out.println(
                String.format("%-20s", "Articulo")
                + String.format("%-15s", "Cantidad")
                + String.format("%-15s", "Precio U")
                + String.format("%-15s", "Total")
        );
        items.forEach( (item,cant) ->

                System.out.println(
                        String.format("%-20s", item.getName())
                        + String.format("%-15s",("x"+cant))
                        + String.format("%-15s",("$"+item.getPrice()))
                        + String.format("%-15s", ("$" + (item.getPrice() * cant)))
                ));
        System.out.println("--------------------------- Totales ---------------------------");
        System.out.println("Precio de envio:    $" + shippingPrice);
        System.out.println("Total artículos:    $" + itemsPrice);
        System.out.println("Precio Final:       $" + totalPrice);
        System.out.println("\u001B[0m");
    }*/

    public void addItem(Precio item,int cantidad){
        for(int i =0; i<cantidad ; i++){
            items.add(item);
        }

    }

    public void deleteItem(Precio item){

        items.remove(item);
    }

    public Order confirmarCarrito(Float shippingPrice){
        return new Order(this,shippingPrice);
    }

    @Override
    public float obtenerPrecio() {
        float retorno = 0;
        for (Precio item : items) {
            retorno += item.obtenerPrecio();
        }
        return retorno;
    }

    @Override
    public List<Item> obtenerItems() {
        List<Item> listItems = new ArrayList<>();
        for (Precio item : items) {
            listItems.addAll(item.obtenerItems());
        }
        return listItems;
    }
}