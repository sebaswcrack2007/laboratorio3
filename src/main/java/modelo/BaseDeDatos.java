package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto buscarPorSKU(String sku) {
        if (sku == null)
            return null;

        String clave = sku.trim().toLowerCase();

        for (Producto p : productos) {
            if (p.getSku() != null &&
                p.getSku().trim().toLowerCase().equals(clave)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos);
    }

    public boolean eliminarProducto(String sku) {
        Producto p = buscarPorSKU(sku);
        if (p != null) {
            return productos.remove(p);
        }
        return false;
    }
}