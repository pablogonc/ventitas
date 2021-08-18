package model.user;

import noseque.Sesion;

public class Administrador extends Usuario{


    public Administrador(Sesion sesion) {
        super(sesion);
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
