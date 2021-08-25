package model.item;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
public class Articulo implements Producto{
    private int id;
    private String nombre;
    private String marca;
    private String descripcion;
    private float precio;

    @Override
    public float getPrecio() {
        return precio;
    }

    @Override
    public String getNombre() {
        return nombre ;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Articulo> getArticulos() {
        List<Articulo> articulo = new ArrayList<>();
        articulo.add(this);
        return articulo;

    }
}
