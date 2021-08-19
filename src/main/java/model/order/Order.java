package model.order;

import model.cart.Cart;
import model.item.Producto;
import model.store.Ubicacion;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static utilidades.Utilidades.*;

public class Order {
    private List<Producto> items;
    private Float precio;
    private Float shippingPrice;
    private LocalDateTime fechaPedido;
    private Ubicacion destino;
    private Boolean confirmado;

    public Order(Cart carrito, Float shippingPrice, Ubicacion destino){
        this.items = carrito.obtenerItems();
        this.precio = carrito.obtenerPrecio();
        this.shippingPrice = shippingPrice;
        this.destino = destino;
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.fechaPedido = LocalDateTime.now();
        // todo calcular envio
    }

    public void showOrder(){

        DecimalFormat formatter = new DecimalFormat("#,###.00");

        System.out.println(
                String.format("%-30s", "Fecha del pedido:") + COLOR_AMARILLO + fechaPedido + COLOR_RESET + "\n"
                +  String.format("%-30s", "Destino:")+ COLOR_AMARILLO + destino.getDireccion()
        );

        System.out.println(COLOR_MAGENTA +"-------------------------- Artículos --------------------------");

        System.out.println(
                String.format("%-20s", "Articulo")
                        + String.format("%-15s", "Cantidad")
                        + String.format("%-15s", "Precio U")
                        + String.format("%-15s", "Total")
        );
        items.stream().distinct().collect(Collectors.toList()).forEach((item) ->

                System.out.println(
                        String.format("%-29s", item.getNombre())
                                + String.format("%-15s",("x"+ Collections.frequency(items,item)))
                                + String.format("%-15s",("$"+ formatter.format(item.getPrecio())))
                                + String.format("%-15s", ("$" +    formatter.format((item.getPrecio() * Collections.frequency(items,item)))  ))
                ));
        System.out.println("--------------------------- Totales ---------------------------");
        System.out.println("Precio de envio:    " + COLOR_AZUL + "$" +  formatter.format(shippingPrice) + COLOR_RESET);
        System.out.println("Total artículos:    " + COLOR_AZUL + "$" + formatter.format(precio) + COLOR_RESET);
        System.out.println("Precio Final:       " + COLOR_VERDE + "$" + formatter.format((precio+shippingPrice)) + COLOR_RESET);
        System.out.println("\u001B[0m");
    }

    private void confirmarOrden(){
        this.confirmado = Boolean.TRUE;
        // subir a la base de datos
        // avisar a un admin de la sucursal
    }
}
