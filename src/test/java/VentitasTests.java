import apis.locationService.LocationService;
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

        sesion.getUsuario().notificar();

    }

    @Test
    public void IniciarSesion()
    {
        iniciarSucursales();
        Sesion sesion = new Sesion(sucursalMEdrano);


        sesion.getUsuario().iniciarSesion("pabloo","123");

        sesion.getUsuario().notificar();
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
    public void usuarios() {

        iniciarArticulos();
        iniciarSucursales();

        Sesion sesion = new Sesion(sucursalMEdrano);

        //sesion.getSucursal().mostrarCatalogo();

        sesion.getCarrito().addItem(consola,1);
        sesion.getCarrito().addItem(tv,1);
        sesion.getCarrito().addItem(notebook,1);
        sesion.getCarrito().addItem(controlConsola,2);

        sesion.getUsuario().iniciarSesion("juan","sad");

        sesion.getUsuario().confirmarCarrito();

        sesion.getUsuario().getOrden().showOrder();

    }
}
