import Apis.LocationService.LocationService;
import model.store.Ubicacion;
import noseque.Sesion;
import org.junit.Test;

public class VentitasTests extends Recursos {

    @Test
    public void testCart()
    {


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

        sesion.getUsuario().iniciarSesion("juan","sad");

        sesion.getUsuario().confirmarCarrito();

        sesion.getUsuario().getOrden().showOrder();

    }
}
