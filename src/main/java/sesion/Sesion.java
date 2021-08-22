package sesion;


import lombok.Data;
import model.cart.Cart;
import model.item.Producto;
import model.order.Order;
import model.sucursal.Sucursal;
import model.user.Anonimo;
import model.user.Contacto;
import model.user.Usuario;

import java.util.List;

@Data
public class Sesion {
    private Contacto contacto;
    private Sucursal sucursal;
    private Cart carrito;
    private Usuario usuario;
    private List<Order> ordenes;

    public Sesion(Sucursal sucursal) {
        this.contacto = null;
        this.sucursal = sucursal;
        this.usuario = new Anonimo(this);
        carrito = new Cart();
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
