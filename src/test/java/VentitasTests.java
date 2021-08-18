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

       // System.out.println(comboLiving.getNombre());

    }

}
