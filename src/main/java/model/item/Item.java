package model.item;

public class Item {

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

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Item(String name, String brand, String description,float price){
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }


}
