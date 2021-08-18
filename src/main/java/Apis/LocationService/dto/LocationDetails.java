package Apis.LocationService.dto;


import model.store.Ubicacion;

class Position{
    public double lat;
    public double lng;
}

public class LocationDetails {
    public String title;
    public Position position;

    public Ubicacion getubicacion(){
        return new Ubicacion(title, position.lat, position.lng);
    }
}
