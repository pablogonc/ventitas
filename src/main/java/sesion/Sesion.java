package sesion;


import lombok.Data;
import model.cart.Cart;
import model.item.Producto;
import model.order.Order;
import model.sucursal.Sucursal;
import model.user.Anonimo;
import model.user.Contacto;
import model.user.Usuario;

import java.util.ArrayList;
import java.util.List;

@Data
public class Sesion {
    private Integer id;
    private Contacto contacto;
    private Sucursal sucursal;
    private Cart carrito;
    private Usuario usuario;
    private List<Order> ordenes;
    private float saldo;


    public Sesion(Sucursal sucursal) {
        this.id = -1;
        this.contacto = null;
        this.sucursal = sucursal;
        this.usuario = new Anonimo(this);
        this.saldo = 0f;
        this.carrito = new Cart();
        ordenes = new ArrayList<>();
    }

    public void setId(Integer id){
        this.id = id;
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


    public void addOrden(Order orden) {
        ordenes.add(orden);
    }
}
