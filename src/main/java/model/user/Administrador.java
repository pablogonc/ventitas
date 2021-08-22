package model.user;

import apis.locationService.LocationService;
import apis.Notificar;
import apis.NotificarXEMAIL;
import apis.NotificarXSMS;
import apis.NotificarXWPP;
import userDAO.UsuarioDAO;
import model.order.Order;
import model.sucursal.Ubicacion;
import sesion.Sesion;

import static utilidades.Utilidades.COLOR_AMARILLO;
import static utilidades.Utilidades.COLOR_RESET;

public class Administrador extends Usuario{


    public Administrador(Sesion sesion) {
        super(sesion);
    }

    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {
        System.out.println(COLOR_AMARILLO +"Advertencia: sesion ya iniciada"+ COLOR_RESET);
    }

    @Override
    public void registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion){
        System.out.println(COLOR_AMARILLO +"Advertencia: sesion ya iniciada"+ COLOR_RESET);
    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public void verSaldo() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
    }

    @Override
    public void confirmarCarrito() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
    }

    @Override
    public void verEstadoPedido() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
    }

    @Override
    public void cancelarPedido() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
    }

    @Override
    public void confirmarPedido() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
    }

    public void eliminarUsuario(String nombre) {
        UsuarioDAO oUsuario = new UsuarioDAO();
        oUsuario.elimininar(nombre);
    }

    @Override
    public void notificar() {

    }

    @Override
    public Order getOrden() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
        return null;
    }

}
