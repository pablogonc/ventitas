import apis.locationService.LocationService;
import model.order.Order;
import model.sucursal.Sucursal;
import model.sucursal.Ubicacion;
import model.user.Administrador;
import sesion.Sesion;
import org.junit.Test;

public class VentitasTests extends Recursos {

    @Test
    public void RegistrarUsuario()
    {
        iniciarArticulos();
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().registrarse("pabloo","123","jonte 2551",455528542,"goncalves.pab@gmail.com","mail");


    }
    @Test
    public void RegistrarUsuarioAdmin()
    {
        iniciarArticulos();
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().iniciarSesion("adminMozart","1234");
        sesion.getUsuario().registrarAdmin("adminNuevo","123","jonte 2551",455528542,"goncalves.pab@gmail.com","mail");


    }
    @Test
    public void IniciarSesion()
    {
        iniciarArticulos();
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().iniciarSesion("pabloo","123");
        sesion.getUsuario().notificar("hola");
    }

    @Test
    public void borrarUsuario()
    {
        iniciarArticulos();
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().iniciarSesion("admin","1234");

        sesion.getUsuario().eliminarUsuario("pabloo");

    }
    @Test
    public void verSaldo()
    {
        iniciarArticulos();
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().iniciarSesion("admin","1234");

        sesion.getUsuario().verSaldo();

    }


    @Test
    public void productos()
    {
        iniciarArticulos();
        iniciarSucursales();

        sucursalMEdrano.mostrarCatalogo();
    }

    @Test
    public void apiLocation() {

        Ubicacion ubicacion = LocationService.getUbicacion("Mozart 2300");

        assert ubicacion != null;
        System.out.println(ubicacion.getDireccion());

    }

    @Test
    public void ConfirmarPedido() {

        iniciarArticulos();
        iniciarSucursales();

        Sesion sesion = new Sesion(sucursalMEdrano);

        //sesion.getSucursal().mostrarCatalogo();

        sesion.addItem(consola,1);
        sesion.addItem(tv,1);
        sesion.addItem(notebook,1);
        sesion.addItem(controlConsola,2);

        sesion.getUsuario().iniciarSesion("pablo","1234");

        sesion.getUsuario().confirmarCarrito();

        sesion.getUsuario().verEstadoPedido();

        sesion.getOrdenes().get(0).confirmarOrden();

        sesion.getOrdenes().get(0).enviar();

    }

    @Test
    public void agotarStock() {

        iniciarArticulos();
        iniciarSucursales();

        Sesion sesion = new Sesion(sucursalMEdrano);

        //sesion.getSucursal().mostrarCatalogo();

        sesion.addItem(consola,4); //se agota de una
        sesion.addItem(tv,2); //no se agota
        sesion.addItem(homeTheather,5); //quedan otras 5
        sesion.addItem(homeTheather,5); // se agota
        sesion.addItem(controlConsola,2); // ya no habia stock suficiente en sucursal

        sesion.getUsuario().iniciarSesion("juan","1234");
        sesion.getUsuario().verSaldo();
        Order orden = sesion.getUsuario().confirmarCarrito();
        orden.asignarVendedor(adminMedrano);
        sesion.getUsuario().verSaldo();
        sesion.getUsuario().verEstadoPedido();

        orden.confirmarOrden();


        sesion.getOrdenes().get(0).enviar();
    }


    @Test
    public void registrarSucursal() {
        iniciarArticulos();
        Sucursal sucursal = new Sucursal(LocationService.getUbicacion("AV jonte 5250"),234) ;

        System.out.println("direccion: " + sucursal.getUbicacion().getDireccion());
        //----Articulos
        sucursal.agregarArticulo(consola,5);
        sucursal.agregarArticulo(guitarra,3);
        sucursal.agregarArticulo(mouse,3);
        sucursal.agregarArticulo(teclado,3);
        Sesion admin = new Sesion(sucursal);

        admin.getUsuario().iniciarSesion("admin","1234");

        sucursal.agregarEncaragado("Todo",(Administrador) admin.getUsuario());
    }
    @Test
    public void obtenerSucursal() {

        Sucursal sucursal = new Sucursal("AV jonte 5250") ;

        System.out.println("id: " + sucursal.getId());


    }
    @Test
    public void varios() {

        iniciarArticulos();

        Sucursal sucursal = new Sucursal("AV jonte 5250"); // la recupero de la base

        sucursal.articulos= articulos;
        sucursal.setStock();
        sucursal.setEncargados();

        sucursal.mostrarCatalogo();

        // ----admin
        Sesion sesionAdmin = new Sesion(sucursal);

        sesionAdmin.getUsuario().iniciarSesion("admin","1234");


        // ----comprador
        Sesion sesionComprador = new Sesion(sucursal);
        sesionComprador.getUsuario().iniciarSesion("juan","1234");
        //

        //.......agregar articulos
        sesionComprador.addItem(consola,2);
        sesionComprador.addItem(guitarra,1);
        sesionComprador.addItem(teclado,1);
        sesionComprador.addItem(mouse,1);
        //......confirmar
        Order orden = sesionComprador.getUsuario().confirmarCarrito();
        orden.asignarVendedor((Administrador) sesionAdmin.getUsuario());
        orden.showOrder();
        //........
        orden.confirmarOrden();

    }

}
