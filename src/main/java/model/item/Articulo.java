package model.item;

import java.util.ArrayList;
import java.util.List;

public class Articulo implements Producto{
    private String nombre;
    private String marca;
    private String descripcion;
    private float precio;

    public Articulo(String nombre, String marca, String descripcion, float precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

    @Override
    public String getNombre() {
        return "\u001b[36m" + nombre + "\u001b[0m";
    }

    @Override
    public List<Articulo> getArticulos() {
        List<Articulo> articulo = new ArrayList<>();
        articulo.add(this);
        return articulo;

    }
}
