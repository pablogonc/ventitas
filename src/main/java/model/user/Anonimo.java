package model.user;

import noseque.Sesion;

public class Anonimo extends Usuario {

    public Anonimo(Sesion sesion) {
        super(sesion);
    }

    private void solicitarInicioDeSesion(){
        System.out.println("\u001b[31mPara poder realizar esta accion, antes debe iniciar Sesion");
    }

    @Override
    public void iniciarSesion(String nombre ) {
        getSesion().setUsuario(new Normal(getSesion(),nombre));
    }

    @Override
    public void cerrarSesion() {
        solicitarInicioDeSesion();
    }

    @Override
    public void verSaldo() {
        solicitarInicioDeSesion();
    }

    @Override
    public void confirmarCarrito() {
        solicitarInicioDeSesion();
    }

    @Override
    public void verEstadoPedido() {
        solicitarInicioDeSesion();
    }

    @Override
    public void cancelarPedido() {
        solicitarInicioDeSesion();
    }

    @Override
    public void confirmarPedido() {
        solicitarInicioDeSesion();
    }
}
