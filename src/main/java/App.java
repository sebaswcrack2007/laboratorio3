import modelo.BaseDeDatos;
import vista.InventarioVista;
import controlador.ControladorInventario;

public class App {

    public static void main(String[] args) {
        BaseDeDatos base = new BaseDeDatos();
        InventarioVista vista = new InventarioVista();
        ControladorInventario controlador = new ControladorInventario(base, vista);

        controlador.iniciar();
    }
}