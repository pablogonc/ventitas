package model.cart;

import model.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    //item,cantidad
    private Map<Item,Integer> items;
    private float itemsPrice;
    private float shippingPrice;
    private float totalPrice;

    public float getItemsPrice() {
        return itemsPrice;
    }

    public void setShippingPrice(float shippingPrice) {
        this.shippingPrice = shippingPrice;
        updatePrices();
    }

    public float getShippingPrice() {
        return shippingPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public Cart() {
        items = new HashMap<>();

    }

    public void showCart(){
        System.out.println("-------------------------- Articulos --------------------------");

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
        System.out.println("Total articulos:    $" + itemsPrice);
        System.out.println("Precio Final:       $" + totalPrice);
    }

    public void addItem(Item item,int cantidad){

        if ( items.containsKey(item) ){
            int old = items.get(item);
            items.replace(item, old + cantidad);
        }else{
            items.put(item,cantidad);
        }

        updatePrices();

    }

    public void deleteItem(Item item){
        items.remove(item);
        updatePrices();
    }

    private void updatePrices(){
        itemsPrice = 0;
        items.forEach( (i,c) ->
                itemsPrice += i.getPrice()*c
        );

        totalPrice = itemsPrice + shippingPrice;
    }
}