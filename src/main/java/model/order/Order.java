package model.order;

import model.cart.Cart;
import model.item.Producto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<Producto> items;
    private Float precio;
    private Float shippingPrice;
    private LocalDateTime fechaPedido;
    private Boolean confirmado;

    public Order(Cart carrito, Float shippingPrice){
        this.items = carrito.obtenerItems();
        this.precio = carrito.obtenerPrecio();
        this.shippingPrice = shippingPrice;
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.fechaPedido = LocalDateTime.now();
        // todo calcular envio
    }

    public void showOrder(){
        System.out.println("\u001b[36mFecha del pedido:       " + fechaPedido);
        System.out.println("\u001B[35m" +"-------------------------- Artículos --------------------------");

        System.out.println(
                String.format("%-20s", "Articulo")
                        + String.format("%-15s", "Cantidad")
                        + String.format("%-15s", "Precio U")
                        + String.format("%-15s", "Total")
        );
        items.stream().distinct().collect(Collectors.toList()).forEach((item) ->

                System.out.println(
                        String.format("%-20s", item.getNombre())
                                + String.format("%-15s",("x"+ Collections.frequency(items,item)))
                                + String.format("%-15s",("$"+item.getPrecio()))
                                + String.format("%-15s", ("$" + (item.getPrecio() * Collections.frequency(items,item))))
                ));
        System.out.println("--------------------------- Totales ---------------------------");
        System.out.println("Precio de envio:    $" + shippingPrice);
        System.out.println("Total artículos:    $" + precio);
        System.out.println("Precio Final:       $" + (precio+shippingPrice));
        System.out.println("\u001B[0m");
    }

    private void confirmarOrden(){
        this.confirmado = Boolean.TRUE;
        // subir a la base de datos
        // avisar a un admin de la sucursal
    }
}
