package model.user;


import model.sucursal.Ubicacion;
import sistema.Observador;
import userDAO.UsuarioDAO;
import model.order.Order;
import sesion.Sesion;


import static utilidades.Utilidades.*;

public class Normal extends Usuario implements Observador {


    private String[] argumentos;

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
        System.out.println(COLOR_MAGENTA + "Saldo: " + COLOR_VERDE + "$" + getSesion().getSaldo() + COLOR_RESET);
    }

    @Override
    public void verEstadoPedido() {
        if (getSesion().getOrdenes().size()>0){
            Order orden = getSesion().getOrdenes().get(0);
            orden.showOrder();
        }else{
            System.out.println( COLOR_AMARILLO + "Advertencia usted no posee carritos" + COLOR_RESET );
        }

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
    public void notificar(String mensaje) {
        getSesion().getContacto().notificar(mensaje);
    }

    @Override
    public void confirmarCarrito() {
        Ubicacion destino = getSesion().getContacto().getUbicacion();

        float precioEnvio = getSesion().getSucursal().getPrecioEnvio(destino);

        getSesion().addOrden(getSesion().getCarrito().confirmarCarrito(this,precioEnvio)); //todo ¿registrar en base?
    }



    @Override
    public void update(String tipoEvento, String... argumentos) {
        String mensaje ="Estimado cliente le notificamos que su pedido en la sucursal de :" + argumentos[0] + " se encuentra en camino hacia su domicilio en :" + argumentos[1];
        notificar(mensaje);
    }
}
