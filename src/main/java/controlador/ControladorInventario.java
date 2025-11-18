package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;

import java.util.List;

public class ControladorInventario {

    private final BaseDeDatos base;
    private final InventarioVista vista;

    public ControladorInventario(BaseDeDatos base, InventarioVista vista) {
        this.base = base;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.pedirOpcion();
            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> buscarProducto();
                case 3 -> listarProductos();
                case 4 -> eliminarProducto();
                case 5 -> vista.mostrarMensaje("Saliendo...");
                default -> vista.mostrarMensaje("Opción no válida. Intente otra vez.");
            }
        } while (opcion != 5);
    }

    private void agregarProducto() {
        String nombre = vista.pedirNombre();
        String sku = vista.pedirSku();
        int cantidad = vista.pedirCantidad();
        double precio = vista.pedirPrecio();

        Producto producto = new Producto(nombre, sku, cantidad, precio);
        base.agregarProducto(producto);

        vista.mostrarMensaje("Producto agregado correctamente.");
    }

    private void buscarProducto() {
        String sku = vista.pedirSku();
        Producto encontrado = base.buscarPorSKU(sku);

        if (encontrado != null) {
            vista.mostrarProducto(encontrado);
        } else {
            vista.mostrarMensaje("Producto no encontrado.");
        }
    }

    private void listarProductos() {
        List<Producto> lista = base.buscarTodos();
        vista.mostrarLista(lista);
    }

    private void eliminarProducto() {
        String sku = vista.pedirSku();
        boolean eliminado = base.eliminarProducto(sku);

        if (eliminado) {
            vista.mostrarMensaje("Producto eliminado correctamente.");
        } else {
            vista.mostrarMensaje("No existe un producto con ese SKU.");
        }
    }
}

