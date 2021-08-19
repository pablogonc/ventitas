package model.user;

import Apis.LocationService.LocationService;
import Apis.Notificar;
import Apis.NotificarXEMAIL;
import Apis.NotificarXSMS;
import Apis.NotificarXWPP;
import model.order.Order;
import model.store.Ubicacion;
import noseque.Sesion;

public class Normal extends Usuario{

    private Notificar notificar;
    private Ubicacion ubicacion;
    private Order orden;
    private String mail;
    private Integer telefono;
    private Notificar medioDeNotificacion;

    public Normal(Sesion sesion, String nombre) {
        super(sesion);
        this.setNombre(nombre);
        this.ubicacion = LocationService.getUbicacion("Sarmiento 440");
        this.mail = "stevenhca12@gmail.com";
        this.telefono = 1169710820;
        String medio = "mail"; // todo obtener de la base de datos
        switch (medio) {
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
        return orden;
    }

    @Override
    public void confirmarCarrito() {

        float precioEnvio = getSesion().getSucursal().getPrecioEnvio( ubicacion );

        orden = getSesion().getCarrito().confirmarCarrito(precioEnvio,ubicacion);

    }
}
