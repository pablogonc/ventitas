package model.user;

import noseque.Sesion;

public class Normal extends Usuario{


    public Normal(Sesion sesion, String nombre ) {
        super(sesion);
        this.setNombre(nombre);
    }

    @Override
    public void iniciarSesion(String nombre ) {

    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public void verSaldo() {

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
}
