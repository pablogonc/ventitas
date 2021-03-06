package model.user;


import DAOS.orden.OrdenDAO;
import model.item.Producto;
import model.sucursal.Sucursal;
import model.sucursal.Ubicacion;
import sistema.Observador;
import DAOS.userDAO.UsuarioDAO;
import model.order.Order;
import sesion.Sesion;


import static utilidades.Utilidades.*;

public class Normal extends Usuario implements Observador {


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
    public Order getOrden() {
        return getSesion().getOrdenes().get(0);
    }

    @Override
    public void eliminarUsuario(String nombre) {
        UsuarioDAO oUsuario = new UsuarioDAO();
        if (nombre.equals(getSesion().getContacto().getNombreDeUsuario())){
            oUsuario.eliminar(nombre);
        }else{
            System.out.println(COLOR_ROJO + "Error usted no tiene permiso de eliminar otros usuarios" + COLOR_RESET);
        }

    }

    @Override
    public void agregarSaldo(float saldo,Usuario usuario) {
        System.out.println(COLOR_ROJO + "Error usted no tiene permiso de agregar saldo" + COLOR_RESET);
    }

    @Override
    public void notificar(String mensaje) {
        getSesion().getContacto().notificar(mensaje);
    }

    @Override
    public void agregarStock(Sucursal sucursal, Producto producto, Integer cantidad) {
        System.out.println( COLOR_ROJO + "Error usted no posee permisos para modificar el stock" + COLOR_RESET );
    }

    @Override
    public void confirmarEnvio(Order orden) {
        System.out.println( COLOR_ROJO + "Error usted no posee permisos para confirmar envio" + COLOR_RESET );
    }

    @Override
    public void registrarAdmin(String nombre, String contrasenia, String direccion, int telefono, String mail, String metodoNotificacion) {
        System.out.println( COLOR_ROJO + "Error usted no posee permisos para registrar administradores" + COLOR_RESET );
    }

    @Override
    public Order confirmarCarrito() {
        Ubicacion destino = getSesion().getContacto().getUbicacion();

        float precioEnvio = getSesion().getSucursal().getPrecioEnvio(destino);

        Order orden = getSesion().getCarrito().confirmarCarrito(this,precioEnvio);
        getSesion().addOrden(orden);
        float precio =  getSesion().getCarrito().obtenerPrecio();
        float saldo =  getSesion().getSaldo();
        getSesion().setSaldo( (saldo>precio)?saldo-precio:0 );
        UsuarioDAO oUsuario = new UsuarioDAO();
        oUsuario.updateSaldo(getSesion().getId(),getSesion().getSaldo());

        OrdenDAO ordendao = new OrdenDAO();
        ordendao.registrarOrden(getSesion().getId(),
                getSesion().getSucursal().getId(),
                orden.precioTotal(),
                orden.getDate(),
                orden.getItems());
        return  orden;
    }

    @Override
    public void update(String tipoEvento, String... argumentos) {
        String mensaje ="Estimado cliente le notificamos que su pedido en la sucursal de :" + argumentos[0] + " se encuentra en camino hacia su domicilio en :" + argumentos[1];
        notificar(mensaje);
    }
}
