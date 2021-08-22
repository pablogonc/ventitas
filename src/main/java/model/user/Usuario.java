package model.user;

import apis.contacto.Contacto;
import model.order.Order;
import sesion.Sesion;

public abstract class Usuario {
    private Sesion sesion;

    public Usuario(Sesion sesion) {
        this.sesion = sesion;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public abstract void iniciarSesion(String nombre, String contrasenia);

    public abstract void registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion);

    public abstract void cerrarSesion();

    public abstract void verSaldo();

    public abstract void confirmarCarrito();

    public abstract void verEstadoPedido();

    public abstract void cancelarPedido();

    public abstract void confirmarPedido();

    public abstract void eliminarUsuario(int id) ;

    public abstract Order getOrden();

    public abstract void eliminarUsuario();

    public void notificar(){}
}
