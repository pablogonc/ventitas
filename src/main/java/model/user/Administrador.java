package model.user;

import model.order.Order;
import noseque.Sesion;

public class Administrador extends Usuario{


    public Administrador(Sesion sesion) {
        super(sesion);
    }

    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {

    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public void verSaldo() {

    }

    @Override
    public void confirmarCarrito() {

    }

    @Override
    public void verEstadoPedido() {

    }

    @Override
    public void cancelarPedido() {

    }

    @Override
    public void confirmarPedido() {

    }

    @Override
    public Order getOrden() {
        return null;
    }
}
