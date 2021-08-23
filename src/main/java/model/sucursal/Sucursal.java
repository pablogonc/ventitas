package model.sucursal;

import model.item.Producto;
import model.order.Order;
import model.user.Administrador;
import model.user.Contacto;
import sistema.administradorDeEventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utilidades.Utilidades.COLOR_CYAN;
import static utilidades.Utilidades.COLOR_RESET;

public class Sucursal {
    private Integer id;
    private Ubicacion ubicacion;
    private Integer telefono;
    private Map<Producto,Integer> stock;
    private List<Order> orders;
    private administradorDeEventos eventos;

    public Sucursal(Integer id, Ubicacion ubicacion, Integer telefono){
        this.id = id;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.stock = new HashMap<>();
        this.orders = new ArrayList<>();
        eventos = new administradorDeEventos("Todo");

    }

    public void agregarEncaragado(String articulo,Administrador encargado){ //si dice "todo" controla todo el stock, si no uno en particular
        eventos.suscribir(articulo,encargado);
    }

    public void eliminarEncaragado(String articulo,Administrador encargado){
        eventos.desuscribir(articulo,encargado);
    }

    public void agregarArticulo(Producto item, Integer cantidad){

       // for (Articulo articulo : item.getArticulos()) {
            if(stock.containsKey(item)){
                int old = stock.get(item);
                stock.replace(item, old + cantidad);
            }else{
                eventos.agregarOperacion(item.getNombre());
                stock.put(item,cantidad);
            }
        //}


    }

    public void eliminarArticulo(Producto item){
        if(stock.containsKey(item)){
            stock.remove(item);
        } else {
            System.out.println("No se pudo eliminar el item");
        }
    }

    public void eliminarStock(Producto item, Integer cantidad){
        if(stock.containsKey(item)){
            int old = stock.get(item);
            stock.replace(item, old - cantidad);

            if (stock.get(item) == 0){
                eventos.notificar("Todo","stock",item.getNombre(),ubicacion.getDireccion());
                eventos.notificar(item.getNombre(),"stock",item.getNombre(),ubicacion.getDireccion());
            }

        }else{
            System.out.println("No se pudo actualizar el item. Debe agregarlo primero");
            //stock.put(item,cantidad);
        }
    }

    public void mostrarCatalogo() {
        stock.forEach( (item,cantidad) -> System.out.println("Articulo: " + COLOR_CYAN+ item.getNombre()+ COLOR_RESET + " Precio: $" + item.getPrecio() +" Stock: " + cantidad));
    }

    public Float getPrecioEnvio(Ubicacion ubicacionUsuario) {
        double distancia = (this.ubicacion.obtenerDistanciaA(ubicacionUsuario));
        return Math.round((float) distancia *20*100f)/100f;  //TODO ver si pasarlo por variable
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean validarStock(Producto producto, Integer cantidad) {
        if(stock.containsKey(producto)){
            int old = stock.get(producto);
            return old >= cantidad;
        }else{
            return false;
        }
    }
}
