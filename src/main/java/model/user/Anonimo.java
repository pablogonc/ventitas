package model.user;

import userDAO.UsuarioDAO;
import model.order.Order;
import sesion.Sesion;

import static utilidades.Utilidades.*;

public class Anonimo extends Usuario {

    public Anonimo(Sesion sesion) {
        super(sesion);
    }

    private void solicitarInicioDeSesion(){
        System.out.println("\u001b[31mPara poder realizar esta accion, antes debe iniciar Sesion\u001b[0m");
    }

    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {

        UsuarioDAO oUsuario = new UsuarioDAO();

        getSesion().setUsuario(oUsuario.iniciarSesion(getSesion(),nombre,contrasenia));
      //  getSesion().setUsuario(new Normal(getSesion(),nombre));
    }

    @Override
    public void registrarse(String usuario,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion){
        UsuarioDAO oUsuario = new UsuarioDAO();
        if(oUsuario.esValido(usuario)){
            System.out.println(COLOR_VERDE + "El usuario es valido"+ COLOR_RESET);

            int id = oUsuario.registrarse(usuario,contrasenia,direccion,telefono,mail,metodoNotificacion);

            getSesion().setUsuario( new Normal( getSesion(),id,usuario,direccion,telefono,mail,metodoNotificacion ) );

        }else {
            System.out.println(COLOR_ROJO + "El usuario no es valido" + COLOR_RESET);
        }



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

    @Override
    public void eliminarUsuario(int id)  {
        System.out.println(COLOR_ROJO + "error usted no puede eliminar usuarios" + COLOR_RESET);
    }

    @Override
    public Order getOrden() {
        return null;
    }

    @Override
    public void eliminarUsuario() {

    }
}
