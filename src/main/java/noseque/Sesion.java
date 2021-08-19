package noseque;

import model.cart.Cart;
import model.store.Store;
import model.user.Anonimo;
import model.user.Usuario;

import java.util.ArrayList;

public class Sesion {
    Store sucursal;
    Cart carrito;
    Usuario usuario;

    public Sesion(Store sucursal) {
        this.sucursal = sucursal;
        this.usuario = new Anonimo(this);
        carrito = new Cart();
    }

    public Store getSucursal() {
        return sucursal;
    }

    public void setSucursal(Store sucursal) {
        this.sucursal = sucursal;
    }

    public void confirmarCarrito(){

    }

    public Cart getCarrito() {
        return carrito;
    }

    public void setCarrito(Cart carrito) {
        this.carrito = carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion){
        this.usuario.registrarse(nombre,contrasenia,direccion,telefono,mail,metodoNotificacion);
    }

    public void iniciarSesion(String usuario, String contrasenia){
        this.usuario.iniciarSesion(usuario, contrasenia);
    }
}
