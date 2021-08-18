package noseque;

import model.cart.Cart;
import model.store.Store;
import model.user.Anonimo;
import model.user.Usuario;

public class Sesion {
    Store sucursal;
    Cart carrito;
    Usuario usuario;

    public Sesion(Store sucursal) {
        this.sucursal = sucursal;
        this.usuario = new Anonimo(this);
    }

    public Store getSucursal() {
        return sucursal;
    }

    public void setSucursal(Store sucursal) {
        this.sucursal = sucursal;
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
}
