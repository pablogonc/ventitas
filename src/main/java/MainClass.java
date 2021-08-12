import model.cart.Cart;
import model.item.Item;
import model.order.Order;

public class MainClass {

    public static void main(String[] args){
        Item escoba = new Item("escoba","stratokaster","escoba",25);
        Item saco = new Item("saco","stratokaster","escoba",10);
        Item silla = new Item("silla","stratokaster","escoba",35);

        Cart carrito = new Cart();
        carrito.addItem(escoba,20);
        carrito.addItem(escoba,32);
        carrito.addItem(saco,1);
        carrito.addItem(saco,1);
        carrito.addItem(silla,5);
        carrito.addItem(silla,2);

        Cart carrito2 = new Cart();
        carrito2.addItem(carrito,2);
        carrito2.addItem(silla,2);

        Order order = carrito2.confirmarCarrito(200F);
        order.showOrder();

        System.out.println(" total = " + carrito2.obtenerPrecio());

        carrito2.deleteItem(carrito);

        System.out.println(" total = " + carrito2.obtenerPrecio());


    }

}
