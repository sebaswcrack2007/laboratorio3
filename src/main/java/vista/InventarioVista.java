package vista;

import java.util.Scanner;

public class InventarioVista {

    private final Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    public int pedirOpcion() {
        System.out.println("\n=== Sistema de Inventario ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Listar productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        String line = scanner.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String pedirNombre() {
        System.out.print("Ingrese nombre del producto: ");
        return scanner.nextLine().trim();
    }

    public String pedirSku() {
        System.out.print("Ingrese SKU: ");
        return scanner.nextLine().trim();
    }

    public int pedirCantidad() {
        System.out.print("Ingrese cantidad: ");
        String line = scanner.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public double pedirPrecio() {
        System.out.print("Ingrese precio: ");
        String line = scanner.nextLine().trim();
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

}