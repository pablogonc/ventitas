package model.item;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto{
    private int id;
    private List<Producto> productos;
    private Integer descuento;
    private String nombreCombo;

    public Combo(int id,String nombreCombo,Integer descuento) {
        this.id = id;
        this.nombreCombo = "\u001b[35m" + nombreCombo + "\u001b[0m";
        this.descuento = descuento;
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public void eLiminarProducto(Producto producto){
        productos.remove(producto);
    }

    @Override
    public float getPrecio() {
        float precio =0f;

        for (Producto producto : productos) {
            precio += producto.getPrecio() * (100-descuento)/100f;
        }


        return precio;
    }

    @Override
    public String getNombre() {

        StringBuilder nombre = new StringBuilder(nombreCombo + ": ( ");

        for (Producto producto : productos) {

            nombre.append(producto.getNombre()).append(" + ");

        }

        nombre = new StringBuilder(nombre.substring(0, nombre.length() - 2));

        nombre.append("\u001b[0m)");
        return nombre.toString();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Articulo> getArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        for (Producto producto : productos) {
            articulos.addAll(producto.getArticulos());
        }
        return articulos;
    }
}
