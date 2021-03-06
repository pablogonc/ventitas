package model.sucursal;

import DAOS.sucursalDAO.sucursalDAO;
import lombok.Data;
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
@Data
public class Sucursal {
    public List<Producto> articulos; //para testear mientras no esta la nosql

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
    public Sucursal(Ubicacion ubicacion, Integer telefono){ //crea el objeto y lo registra en la base
        sucursalDAO sucursaldao = new sucursalDAO();
        this.id = sucursaldao.registrarSucursal(ubicacion,telefono);
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.stock = new HashMap<>();
        this.orders = new ArrayList<>();
        eventos = new administradorDeEventos("Todo");


    }
    public Sucursal(String direccion){ //instancia la sucursal a partir de la que esta en la base de datos
        sucursalDAO sucursaldao = new sucursalDAO();
        Sucursal temp = sucursaldao.obtenerSucursal(direccion);

        this.id = temp.getId();
        this.ubicacion = temp.getUbicacion();
        this.telefono = temp.getTelefono();
        this.stock = temp.getStock();
        this.orders = temp.orders;
        eventos = new administradorDeEventos("Todo");

    }
    public void setStock(){ //instancia la sucursal a partir de la que esta en la base de datos
        sucursalDAO sucursaldao = new sucursalDAO();
        sucursaldao.setStock(this);
    }
    public void setEncargados() {
        sucursalDAO sucursaldao = new sucursalDAO();
        sucursaldao.setEncargados(this);
    }
    public void agregarEncaragado(String articulo,Administrador encargado){ //si dice "todo" controla todo el stock, si no uno en particular
        eventos.suscribir(articulo,encargado);
        sucursalDAO sucursaldao = new sucursalDAO();
        sucursaldao.insertEncargado(id,encargado.getSesion().getId(),articulo);
    }

    public void eliminarEncaragado(String articulo,Administrador encargado){
        eventos.desuscribir(articulo,encargado);
        sucursalDAO sucursaldao = new sucursalDAO();
        sucursaldao.deleteEncargado(id,encargado.getSesion().getId(),articulo);
    }

    public void agregarArticulo(Producto item, Integer cantidad){
        sucursalDAO sucursaldao = new sucursalDAO();
       // for (Articulo articulo : item.getArticulos()) {
            if(stock.containsKey(item)){
                int old = stock.get(item);
                stock.replace(item, old + cantidad);
                sucursaldao.updateStock(id,item.getId(),cantidad + old);
            }else{
                eventos.agregarOperacion(item.getNombre());
                stock.put(item,cantidad);
                sucursaldao.insertStock(id,item.getId(),cantidad);
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
        sucursalDAO sucursaldao = new sucursalDAO();
        if(stock.containsKey(item)){
            int old = stock.get(item);
            stock.replace(item, old - cantidad);
            sucursaldao.updateStock(id,item.getId(),old-cantidad);
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
