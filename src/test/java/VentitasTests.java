import apis.locationService.LocationService;
import model.order.Order;
import model.sucursal.Sucursal;
import model.sucursal.Ubicacion;
import sesion.Sesion;
import org.junit.Test;

public class VentitasTests extends Recursos {

    @Test
    public void RegistrarUsuario()
    {
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().registrarse("pabloo","123","jonte 2551",455528542,"goncalves.pab@gmail.com","mail");


    }

    @Test
    public void IniciarSesion()
    {
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().iniciarSesion("pabloo","123");
        sesion.getUsuario().notificar("hola");
    }

    @Test
    public void borrarUsuario()
    {
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);

        sesion.getUsuario().iniciarSesion("admin","1234");

        sesion.getUsuario().eliminarUsuario("pabloo");

    }
    @Test
    public void verSaldo()
    {
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
    public void obtenerSucursal() {

        Sucursal sucursal = new Sucursal("AV Medrano 951") ;

        System.out.println("id: " + sucursal.getId());


    }
    @Test
    public void registrarSucursal() {
        Sucursal sucursal = new Sucursal(LocationService.getUbicacion("AV Medrano 951"),234) ;

        System.out.println("direccion: " + sucursal.getUbicacion().getDireccion());
    }

}
