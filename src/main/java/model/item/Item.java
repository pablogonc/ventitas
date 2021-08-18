package model.item;

import java.util.ArrayList;
import java.util.List;

public class Item implements Precio {

    private String name;
    private String brand;
    private String description;
    private float price;

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Item(String name, String brand, String description, float price){
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }


    @Override
    public float obtenerPrecio() {
        return price;
    }

    @Override
    public List<Item> obtenerItems() {
        List<Item> items = new ArrayList<>();
        items.add(this);
        return items;
    }
}
