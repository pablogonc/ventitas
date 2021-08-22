package model.sucursal;

import model.item.Producto;
import model.order.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sucursal {
    private Integer id;
    private Ubicacion ubicacion;
    private String manager;       //todo cambiarlo a un admin
    private Integer telefono;
    private Map<Producto,Integer> stock;
    private List<Order> orders;

    public Sucursal(Integer id, Ubicacion ubicacion, String manager, Integer telefono){
        this.id = id;
        this.ubicacion = ubicacion;
        this.manager = manager;
        this.telefono = telefono;
        this.stock = new HashMap<>();
        this.orders = new ArrayList<>();
    }

    public void agregarArticulo(Producto item, Integer cantidad){

       // for (Articulo articulo : item.getArticulos()) {
            if(stock.containsKey(item)){
                int old = stock.get(item);
                stock.replace(item, old + cantidad);
            }else{
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
        }else{
            System.out.println("No se pudo actualizar el item. Debe agregarlo primero");
            //stock.put(item,cantidad);
        }
    }

    public void mostrarCatalogo() {
        stock.forEach( (item,cantidad) -> System.out.println("Articulo: " + item.getNombre() + " Precio: $" + item.getPrecio() +" Stock: " + cantidad));
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
                if(old >= cantidad){
                    return true;
                }else{
                    return false;
                }
        }else{
            return false;
        }
    }
}
