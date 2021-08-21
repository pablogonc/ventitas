package apis.locationService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.sucursal.Ubicacion;

import java.util.List;

class Position{
    public double lat;
    public double lng;
}

 class LocationDetails {
    public String title;
    public Position position;
}

public class LocationResponse {
    @JsonProperty("items")
    public List <LocationDetails> locaciones;

    public Ubicacion getubicacion(){
        LocationDetails locacion = locaciones.get(0);
        return new Ubicacion(locacion.title, locacion.position.lat, locacion.position.lng);
    }
}

