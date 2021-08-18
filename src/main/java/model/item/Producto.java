package model.item;

import java.util.List;

public interface Producto {
    float getPrecio();
    String getNombre();

    List<Articulo> getArticulos();
}
