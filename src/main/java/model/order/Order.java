package model.order;

import model.cart.Cart;
import model.item.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {
    private Integer id;
    private List<Item> items;
    private Float precio;
    private LocalDateTime fechaPedido;
    private Date fechaEnvio;

    private Order(Cart carrito){
        //this.items = carrito.getItems();
        //this.precio = carrito.getTotalPrice();
        //DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //fechaPedido = LocalDateTime.now();
    }


}
