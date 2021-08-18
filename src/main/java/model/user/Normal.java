package model.user;

import Apis.LocationService.LocationService;
import Apis.Notificar;
import model.order.Order;
import model.store.Ubicacion;
import noseque.Sesion;

public class Normal extends Usuario{

    private Notificar notificar;
    private Ubicacion ubicacion;
    private Order orden;

    public Normal(Sesion sesion, String nombre) {
        super(sesion);
        this.setNombre(nombre);
        this.ubicacion = LocationService.getUbicacion("Sarmiento 440");
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
