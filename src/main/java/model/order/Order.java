package model.order;

import lombok.Data;
import model.cart.Cart;
import model.item.Producto;
import model.sucursal.Sucursal;
import model.sucursal.Ubicacion;
import model.user.Administrador;
import model.user.Contacto;
import model.user.Normal;
import model.user.Usuario;
import sistema.Observador;
import sistema.administradorDeEventos;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static utilidades.Utilidades.*;
@Data
public class Order  {
    private Integer id;
    private List<Producto> items;
    private Float precio;
    private Float shippingPrice;
    private LocalDateTime fechaPedido;
    private Ubicacion destino;
    private Boolean confirmado;
    private administradorDeEventos eventos;
    private Sucursal sucursal;
    private float descuento;

    public Order(Normal usuario, Cart carrito, Float shippingPrice){
        this.items = carrito.obtenerItems();
        this.precio = carrito.obtenerPrecio();
        this.shippingPrice = shippingPrice;
        this.descuento = (precio+shippingPrice-usuario.getSesion().getSaldo())<0?precio+shippingPrice:usuario.getSesion().getSaldo();
        this.destino = usuario.getSesion().getContacto().getUbicacion();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.fechaPedido = LocalDateTime.now();
        this.eventos = new administradorDeEventos("pedido confirmado","pedido en camino");
        this.sucursal = usuario.getSesion().getSucursal();
        this.eventos.suscribir("pedido en camino", usuario);

    }
    public LocalDateTime getDate(){
        return fechaPedido;
    }

    public float precioTotal(){
        return precio + shippingPrice - descuento;
    }
    public void asignarVendedor(Administrador vendedor){
        this.eventos.suscribir("pedido confirmado",vendedor);
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
                        + String.format("%-20s", "Cantidad")
                        + String.format("%-20s", "Precio U")
                        + String.format("%-20s", "Total")
        );
        items.stream().distinct().collect(Collectors.toList()).forEach((item) ->

                System.out.println(COLOR_CYAN+
                        String.format("%-20s", item.getNombre()) +COLOR_RESET
                                + String.format("%-20s",("x"+ Collections.frequency(items,item)))
                                + String.format("%-20s",("$"+ formatter.format(item.getPrecio())))
                                + String.format("%-20s", ("$" +    formatter.format((item.getPrecio() * Collections.frequency(items,item)))  ))
                ));
        System.out.println("--------------------------- Totales ---------------------------");
        System.out.println("Precio de envio:    " + COLOR_AZUL + "$" +  formatter.format(shippingPrice) + COLOR_RESET);
        System.out.println("Total artículos:    " + COLOR_AZUL + "$" + formatter.format(precio) + COLOR_RESET);
        System.out.println("Descuento:          " + COLOR_VERDE + "$" + formatter.format(descuento) + COLOR_RESET);
        System.out.println("Precio Final:       " + COLOR_ROJO + "$" + formatter.format((precio+shippingPrice-descuento)) + COLOR_RESET);
        System.out.println("\u001B[0m");
    }

    public void confirmarOrden(){
        this.confirmado = Boolean.TRUE;
        // subir a la base de datos
        //todo
        // avisar a un admin de la sucursal
        eventos.notificar("pedido confirmado","pedido confirmado",sucursal.getUbicacion().getDireccion(),destino.getDireccion()); //ver otros datos para poner
    }
    public void enviar(){
        eventos.notificar("pedido en camino","pedido confirmado",sucursal.getUbicacion().getDireccion(),destino.getDireccion()); //ver otros datos para poner
    }


}
