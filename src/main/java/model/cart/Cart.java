package model.cart;

import model.item.Item;

import java.util.List;

public class Cart {


    private List<Item> items;

    public void addItem(Item item){
        items.add(item);
    }
}
