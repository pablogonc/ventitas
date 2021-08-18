package model.store;

import model.item.Articulo;
import model.item.Producto;
import model.order.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private Integer id;
    private Ubicacion ubicacion;
    private String manager; //todo cambiarlo a un admin
    private Integer telephone;
    private Map<Producto,Integer> stock;
    private List<Order> orders;

    public Store(Integer id, Ubicacion ubicacion, String manager, Integer telephone){
        this.id = id;
        this.ubicacion = ubicacion;
        this.manager = manager;
        this.telephone = telephone;
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

    private void eliminarArticulo(Producto item){
        if(stock.containsKey(item)){
            stock.remove(item);
        } else {
            System.out.println("No se pudo eliminar el item");
        }
    }
    private void actualizarStock(Producto item, Integer cantidad){
        if(stock.containsKey(item)){
            stock.replace(item, cantidad);
        }else{
            System.out.println("No se pudo actualizar el item. Debe agregarlo primero");
            //stock.put(item,cantidad);
        }
    }

    public void mostrarCatalogo() {
        stock.forEach( (item,cantidad) -> System.out.println("Articulo: " + item.getNombre() + " Precio: $" + item.getPrecio() +" Stock: " + cantidad));
    }

    public Float getPrecioEnvio(String ubicacion) {
        return 250f; //todo calcular y cambiar la ubicacion quiza por un objeto
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
