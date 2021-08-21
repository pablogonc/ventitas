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

import java.util.List;

import static utilidades.Utilidades.*;

public class Normal extends Usuario{
    private String usuario; // contraseña
    private Ubicacion ubicacion;
    private Integer telefono;
    private String mail;
    private List<Order> orden;
    private Notificar medioDeNotificacion;



    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Normal(Sesion sesion, int id, String usuario, String direccion, Integer telefono, String mail, String medioDeNotificacion) {
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

    public void notificar(){
        this.medioDeNotificacion.notificar(this);
    }

    public String getMail(){
        return mail;
    }

    public Integer getTelefono(){
        return telefono;
    }

    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {
        System.out.println("\u001b[31m Error: sesion ya iniciada\u001b[0m");
    }

    @Override
    public void registrarse(String nombre,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion) {

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
    public void eliminarUsuario(int id)  {
        System.out.println(COLOR_ROJO + "error usted no puede eliminar usuarios" + COLOR_RESET);
    }

    @Override
    public Order getOrden() {
        return orden.get(0);
    }

    @Override
    public void eliminarUsuario() {
        UsuarioDAO oUsuario = new UsuarioDAO();
        oUsuario.elimininar(this.id);
    }

    @Override
    public void confirmarCarrito() {

        float precioEnvio = getSesion().getSucursal().getPrecioEnvio( ubicacion );

        orden.add(getSesion().getCarrito().confirmarCarrito(precioEnvio,ubicacion));

    }
}
