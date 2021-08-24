package model.user;


import model.item.Producto;
import model.order.Order;
import model.sucursal.Sucursal;
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

    public abstract void agregarSaldo(float saldo,Usuario usuario);

    public abstract void notificar(String mensaje);

    public abstract void agregarStock(Sucursal sucursal, Producto producto, Integer cantidad);

    public abstract void confirmarEnvio(Order orden);

    public abstract void registrarAdmin(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion);
}
