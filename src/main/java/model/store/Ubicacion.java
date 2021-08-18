package model.store;

public class Ubicacion {
    private String direccion;
    private double latitud;
    private double longitud;

    public Ubicacion(String direccion, double latitud, double longitud) {
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    private double radianes(double num){
        return num * Math.PI /180;
    }

    public double obtenerDistanciaA(Ubicacion ubicacion){

        double distanciaLat = radianes(latitud) - radianes(ubicacion.getLatitud());
        double distanciaLong = radianes(longitud) - radianes(ubicacion.getLongitud());

        return  2 *Math.asin(Math.sqrt(Math.pow(Math.sin(distanciaLat/2),2)+Math.cos(radianes(latitud))*Math.cos(radianes(ubicacion.getLatitud()))*Math.pow(Math.sin(distanciaLong/2),2)))* 6378137 /1000;


    }

}