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

public class Administrador extends Usuario{


    public Administrador(Sesion sesion) {
        super(sesion);
    }

    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {
        System.out.println(COLOR_AMARILLO +"Advertencia: sesion ya iniciada\u001b[0m");
    }

    @Override
    public void registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion){
        System.out.println(COLOR_AMARILLO +"Advertencia: sesion ya iniciada\u001b[0m");
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

    public void eliminarUsuario(String nombre) {
        UsuarioDAO oUsuario = new UsuarioDAO();
        oUsuario.elimininar(nombre);
    }

    @Override
    public void notificar() {

    }

    @Override
    public Order getOrden() {
        return null;
    }

}
