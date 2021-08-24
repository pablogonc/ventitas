package model.user;

import model.item.Producto;
import model.sucursal.Sucursal;
import sistema.Observador;
import DAOS.userDAO.UsuarioDAO;
import model.order.Order;
import sesion.Sesion;

import static utilidades.Utilidades.*;
import static utilidades.Utilidades.COLOR_ROJO;

public class Administrador extends Usuario implements Observador {


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
    public Order confirmarCarrito() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
        return null;
    }

    @Override
    public void verEstadoPedido() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
    }

    public void eliminarUsuario(String nombre) {
        UsuarioDAO oUsuario = new UsuarioDAO();
        oUsuario.eliminar(nombre);
    }

    @Override
    public void notificar(String mensaje) {
        getSesion().getContacto().notificar(mensaje);
    }

    @Override
    public Order getOrden() {
        System.out.println(COLOR_AMARILLO +"Advertencia: Debe ser usuario normal para realizar esta accion"+ COLOR_RESET);
        return null;
    }

    @Override
    public void update(String tipoEvento, String... argumentos) {
        String mensaje;
        switch (tipoEvento){
            case "stock":
                mensaje ="Le comunicamos que se agoto el stock de " +argumentos[0] +" de la sucursal :" + argumentos[1] ;
                notificar(mensaje);
                break;
            case "pedido confirmado":
                mensaje ="Le comunicamos que se confirmo un pedido de la sucursal :" + argumentos[0] + " para ser enviado a:" + argumentos[1];
                notificar(mensaje);
                break;
        }

    }

    @Override
    public void agregarStock(Sucursal sucursal, Producto producto, Integer cantidad){
        sucursal.agregarArticulo(producto,cantidad);
    }

    @Override
    public void confirmarEnvio(Order orden) {
        orden.enviar();
    }

    @Override
    public void registrarAdmin(String nombre, String contrasenia, String direccion, int telefono, String mail, String metodoNotificacion) {
        UsuarioDAO oUsuario = new UsuarioDAO();
        if(oUsuario.esValido(nombre)){
            System.out.println(COLOR_VERDE + "El usuario es valido"+ COLOR_RESET);

            oUsuario.registrarUsuarioAdmin(nombre,contrasenia,direccion,telefono,mail,metodoNotificacion);

        }else {
            System.out.println(COLOR_ROJO + "El usuario no es valido" + COLOR_RESET);

        }

    }

}
