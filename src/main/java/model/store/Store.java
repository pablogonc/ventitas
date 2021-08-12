package model.store;

import model.item.Item;
import model.order.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private Integer id;
    private String address;
    private String manager; //todo cambiarlo a un admin
    private Integer telephone;
    private Map<Item,Integer> stock;
    private List<Order> orders;

    public Store(Integer id, String address, String manager, Integer telephone){
        this.id = id;
        this.address = address;
        this.manager = manager;
        this.telephone = telephone;
        this.stock = new HashMap<>();
        this.orders = new ArrayList<>();
    }

    private void agregarArticulo(Item item, Integer cantidad){
        if(stock.containsKey(item)){
            int old = stock.get(item);
            stock.replace(item, old + cantidad);
        }else{
            stock.put(item,cantidad);
        }
    }

    private void eliminarArticulo(Item item){
        if(stock.containsKey(item)){
            stock.remove(item);
        } else {
            System.out.println("No se pudo eliminar el item");
        }
    }
    private void actualizarStock(Item item,Integer cantidad){
        if(stock.containsKey(item)){
            stock.replace(item, cantidad);
        }else{
            System.out.println("No se pudo actualizar el item. Debe agregarlo primero");
            //stock.put(item,cantidad);
        }
    }

}
