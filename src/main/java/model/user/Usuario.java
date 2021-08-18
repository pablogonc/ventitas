package model.user;

import model.item.Producto;
import model.store.Ubicacion;
import noseque.Sesion;

public abstract class Usuario {
    private Sesion sesion;
    private Integer id;
    private String nombre;
    private Ubicacion ubicacion;
    private Integer telefono;
    private String mail;

    public Usuario(Sesion sesion) {
        this.sesion = sesion;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void iniciarSesion(String nombre );

    public abstract void cerrarSesion();

    public abstract void verSaldo();

    public void verCatalogo(){
        sesion.getSucursal().mostrarCatalogo();
    }

    public void agregarAlCarro(Producto item, int cantidad){
        sesion.getCarrito().addItem(item, cantidad);
    }

    public void confirmarCarrito(){
        sesion.getCarrito().confirmarCarrito( sesion.getSucursal().getPrecioEnvio(ubicacion) );
    }

    public abstract void verEstadoPedido();

    public abstract void cancelarPedido();

    public abstract void confirmarPedido();
}
