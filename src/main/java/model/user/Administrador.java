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

public class Administrador extends Usuario{


    private  String usuario;
    private  Ubicacion ubicacion;
    private  Integer telefono;
    private  String mail;
    private  Notificar medioDeNotificacion;

    public Administrador(Sesion sesion, int id, String usuario, String direccion, Integer telefono, String mail, String medioDeNotificacion) {
        super(sesion);
        this.id = id;
        this.usuario = usuario;
        this.ubicacion = LocationService.getUbicacion(direccion);
        this.telefono = telefono;
        this.mail = mail;

        switch (medioDeNotificacion) {
            case "mail":
                this.medioDeNotificacion = new NotificarXEMAIL();
                break;
            case "SMS":
                this.medioDeNotificacion = new NotificarXSMS();
                break;
            case "Wpp":
                this.medioDeNotificacion = new NotificarXWPP();
                break;
        }


    }

    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {
        System.out.println("\u001b[31m Error: sesion ya iniciada\u001b[0m");
    }

    @Override
    public void registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion){

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
    public void eliminarUsuario(int id) {
        UsuarioDAO oUsuario = new UsuarioDAO();
        oUsuario.elimininar(id);
    }

    @Override
    public Order getOrden() {
        return null;
    }

    @Override
    public void eliminarUsuario() {

    }
}
