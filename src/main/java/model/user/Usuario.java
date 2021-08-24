package model.user;


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

    public abstract Order confirmarCarrito();

    public abstract void verEstadoPedido();

    public abstract Order getOrden();

    public abstract void eliminarUsuario(String nombre);

    public abstract void notificar(String mensaje);
}
