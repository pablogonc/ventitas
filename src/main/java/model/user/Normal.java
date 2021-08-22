package model.user;


import userDAO.UsuarioDAO;
import model.order.Order;
import sesion.Sesion;


import static utilidades.Utilidades.*;

public class Normal extends Usuario{


    public Normal(Sesion sesion) {
        super(sesion);
    }



    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {
        System.out.println(COLOR_AMARILLO +"Advertencia: sesion ya iniciada\u001b[0m");

    }

    @Override
    public void registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion) {
        System.out.println(COLOR_AMARILLO +"Advertencia: sesion ya iniciada\u001b[0m");

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

    @Override
    public Order getOrden() {
        return getSesion().getOrdenes().get(0);
    }

    @Override
    public void eliminarUsuario(String nombre) {
        UsuarioDAO oUsuario = new UsuarioDAO();
        if (nombre.equals(getSesion().getContacto().getNombreDeUsuario())){
            oUsuario.elimininar(nombre);
        }else{
            System.out.println(COLOR_ROJO + "Error usted no tiene permiso de eliminar otros usuarios" + COLOR_RESET);
        }

    }

    @Override
    public void notificar() {
        getSesion().getContacto().notificar();
    }

    @Override
    public void confirmarCarrito() {

    }
}
