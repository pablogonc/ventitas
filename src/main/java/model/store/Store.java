package model.store;

import model.item.Item;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private Integer id;
    private String address;
    private String manager;
    private Integer telephone;
    private Map<Item,Integer> stock;


    public Store(Integer id, String address, String manager, Integer telephone){
        this.id = id;
        this.address = address;
        this.manager = manager;
        this.telephone = telephone;
        this.stock = new HashMap<>();
    }

}
