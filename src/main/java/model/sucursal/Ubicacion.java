package model.sucursal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ubicacion {
    @JsonProperty("title")
    private String direccion;
    @JsonProperty("lat")
    private double latitud;
    @JsonProperty("lng")
    private double longitud;


    private double radianes(double num){
        return num * Math.PI /180;
    }

    public double obtenerDistanciaA(Ubicacion ubicacion){

        double distanciaLat = radianes(latitud) - radianes(ubicacion.getLatitud());
        double distanciaLong = radianes(longitud) - radianes(ubicacion.getLongitud());
        double distancia = 2 *Math.asin(Math.sqrt(Math.pow(Math.sin(distanciaLat/2),2)+Math.cos(radianes(latitud))*Math.cos(radianes(ubicacion.getLatitud()))*Math.pow(Math.sin(distanciaLong/2),2)))* 6378137 /1000 ;
        return Math.round(distancia*100.0)/100.0;

    }

}
