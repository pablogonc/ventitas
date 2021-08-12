import model.cart.Cart;
import model.item.Item;

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

        carrito2.setShippingPrice(425.50f);

        System.out.println(" total = " + carrito2.getTotalPrice());

        carrito.deleteItem(silla);

        System.out.println(" total = " + carrito2.getTotalPrice());


    }

}
