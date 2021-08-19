package model.user;

import Apis.Notificar;
import model.item.Producto;
import model.order.Order;
import noseque.Sesion;

public abstract class Usuario {
    private Integer id;
    private Sesion sesion;

    public Usuario(Sesion sesion) {
        this.sesion = sesion;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public abstract void iniciarSesion(String nombre,String contrasenia);

    public abstract void registrarse(String nombre,String contrasenia);

    public abstract void cerrarSesion();

    public abstract void verSaldo();

    public void verCatalogo(){
        sesion.getSucursal().mostrarCatalogo();
    }

    public void agregarAlCarro(Producto item, int cantidad){
        sesion.getCarrito().addItem(item, cantidad);
    }

    public abstract void confirmarCarrito();

    public abstract void verEstadoPedido();

    public abstract void cancelarPedido();

    public abstract void confirmarPedido();

    public abstract Order getOrden();

}
