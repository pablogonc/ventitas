package model.cart;

import model.item.Producto;

import java.util.*;

public class Cart {

    private final List<Producto> items;

    public  List<Producto> getItems() {
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

    public void addItem(Producto item,int cantidad){
        for(int i =0; i<cantidad ; i++){
            items.add(item);
        }

    }

    public void deleteItem(Producto item){

        items.remove(item);
    }
/*
    public Order confirmarCarrito(Float shippingPrice, Ubicacion destino){
        return new Order(this,shippingPrice,destino);
    }*/


    public float obtenerPrecio() {
        float retorno = 0;
        for (Producto item : items) {
            retorno += item.getPrecio();
        }
        return retorno;
    }

    public List<Producto> obtenerItems() {
        List<Producto> listItems = new ArrayList<>();
        for (Producto item : items) {
            listItems.addAll(item.getArticulos());
        }
        return listItems;
    }
}