import Apis.LocationService.LocationService;
import model.store.Ubicacion;
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
        System.out.println("la distancia entre las facus es de " + String.format("%.2f",sucursalMEdrano.getUbicacion().obtenerDistanciaA(sucursalMozart.getUbicacion())) + "km");

        sucursalMEdrano.mostrarCatalogo();

        //System.out.println(comboLiving.getNombre());

    }
    @Test
    public void apiLocation() throws Exception {
        LocationService ls = new LocationService();


        Ubicacion ubicacion = ls.getUbicacion("Mozart 2300");
        System.out.println("Direccion:" + ubicacion.getDireccion());
        System.out.println("latitud:" + ubicacion.getLatitud());
        System.out.println("longitud:" + ubicacion.getLongitud());
    }
}
