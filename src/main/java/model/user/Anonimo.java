package model.user;

import DAOS.userDAO.UsuarioDAO;
import model.item.Producto;
import model.order.Order;
import model.sucursal.Sucursal;
import sesion.Sesion;

import static utilidades.Utilidades.*;

public class Anonimo extends Usuario {

    public Anonimo(Sesion sesion) {
        super(sesion);
    }

    private void solicitarInicioDeSesion(){
        System.out.println("\u001b[31mPara poder realizar esta accion, antes debe iniciar Sesion\u001b[0m");
    }

    @Override
    public void iniciarSesion(String nombre,String contrasenia ) {

        UsuarioDAO oUsuario = new UsuarioDAO();

        getSesion().setUsuario(oUsuario.iniciarSesion(getSesion(),nombre,contrasenia));
        getSesion().setContacto(oUsuario.getContacto(nombre));

    }

    @Override
    public void registrarse(String usuario,String contrasenia,String direccion,int telefono,String mail,String metodoNotificacion){
        UsuarioDAO oUsuario = new UsuarioDAO();
        if(oUsuario.esValido(usuario)){
            System.out.println(COLOR_VERDE + "El usuario es valido"+ COLOR_RESET);

            int id = oUsuario.registrarUsuario(usuario,contrasenia,direccion,telefono,mail,metodoNotificacion);

            getSesion().setUsuario( new Normal( getSesion()));
            getSesion().setContacto(oUsuario.getContacto(usuario));
        }else {
            System.out.println(COLOR_ROJO + "El usuario no es valido" + COLOR_RESET);

        }



    }

    @Override
    public void cerrarSesion() {
        solicitarInicioDeSesion();
    }

    @Override
    public void verSaldo() {
        solicitarInicioDeSesion();
    }

    @Override
    public Order confirmarCarrito() {
        solicitarInicioDeSesion();
        return null;
    }

    @Override
    public void verEstadoPedido() {
        solicitarInicioDeSesion();
    }

    @Override
    public void eliminarUsuario(String nombre)  {
        System.out.println(COLOR_ROJO + "Error usted no puede eliminar usuarios" + COLOR_RESET);
    }

    @Override
    public void notificar(String mensaje) {
        solicitarInicioDeSesion();
    }

    @Override
    public void agregarStock(Sucursal sucursal, Producto producto, Integer cantidad) {
        System.out.println( COLOR_ROJO + "Error usted no posee permisos para modificar el stock" + COLOR_RESET );
    }

    @Override
    public Order getOrden() {
        solicitarInicioDeSesion();
        return null;
    }

    }

