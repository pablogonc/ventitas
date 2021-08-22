package sesion;

import apis.contacto.Contacto;
import model.cart.Cart;
import model.item.Producto;
import model.sucursal.Sucursal;
import model.user.Anonimo;
import model.user.Usuario;

public class Sesion {
    private Contacto contacto;
    private Sucursal sucursal;
    private Cart carrito;
    private Usuario usuario;

    public Sesion(Sucursal sucursal) {
        this.contacto = null;
        this.sucursal = sucursal;
        this.usuario = new Anonimo(this);
        carrito = new Cart();
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setContacto(Contacto contacto){
        this.contacto = contacto;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void seleccionarSucursal(Sucursal sucursal2){
        this.sucursal = sucursal2;
    }

    public void addItem(Producto producto,Integer cantidad){
        if(sucursal.validarStock(producto,cantidad)){
            sucursal.eliminarStock(producto,cantidad);
            carrito.addItem(producto,cantidad);
        }else{
            System.out.println("No se pudo validar el stock del item. El stock no alcanza o no existe el item");
        }

    }

    public void vaciarCarrito(){
        for (Producto item : carrito.getItems()) {
            sucursal.agregarArticulo(item,1);
        }
        carrito = new Cart();
    }
}
