package co.edu.unbosque.view;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Consola {

    private Scanner consola;

    public Consola() {
        consola = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== SISTEMA SOLUCIONES DIGITALES ===");
        System.out.println("1. Registrar Libro");
        System.out.println("2. Registrar Revista");
        System.out.println("3. Registrar Artículo de Investigación");
        System.out.println("4. Mostrar inventario");
        System.out.println("5. Vender artículo de investigación (solo digital)");
        System.out.println("6. Mostrar historial de ventas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = -1;
        try {
            opcion = consola.nextInt();
            consola.nextLine(); // limpiar buffer
        } catch (InputMismatchException e) {
            consola.nextLine(); // limpiar buffer incorrecto
            opcion = -1;
        }
        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // --- Pedidos generales de publicación ---
    public String pedirTituloPublicacion() {
        System.out.print("\nIngrese el título de la publicación: ");
        return consola.nextLine();
    }

    public String pedirAutorPublicacion() {
        System.out.print("Ingrese el autor de la publicación: ");
        return consola.nextLine();
    }

    public String pedirFechaEdicionPublicacion() {
        System.out.print("Ingrese la fecha de edición (formato libre): ");
        return consola.nextLine();
    }

    public String pedirFechaPublicacion() {
        System.out.print("Ingrese la fecha de publicación (formato libre): ");
        return consola.nextLine();
    }

    public String pedirTipoFormato() {
        System.out.print("Ingrese el tipo de formato (físico, epub, pdf, digital, etc.): ");
        return consola.nextLine();
    }

    public String pedirClasificacionPublicacion() {
        System.out.print("Ingrese la clasificación (Q1, Q2, Q3, etc.): ");
        return consola.nextLine();
    }

    public int pedirCitasInvestigadores() {
        while (true) {
            try {
                System.out.print("Ingrese la cantidad de citas de investigadores (número): ");
                int citas = consola.nextInt();
                consola.nextLine();
                return citas;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                consola.nextLine();
            }
        }
    }

    public int pedirNumeroPaginas() {
        while (true) {
            try {
                System.out.print("Ingrese el número de páginas: ");
                int paginas = consola.nextInt();
                consola.nextLine();
                return paginas;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                consola.nextLine();
            }
        }
    }

    // --- Libro específicos ---
    public String pedirGeneroLiterario() {
        System.out.print("Ingrese el género literario: ");
        return consola.nextLine();
    }

    public String pedirEditorial() {
        System.out.print("Ingrese la editorial: ");
        return consola.nextLine();
    }

    public int pedirCantidadCapitulos() {
        while (true) {
            try {
                System.out.print("Ingrese la cantidad de capítulos: ");
                int capitulos = consola.nextInt();
                consola.nextLine();
                return capitulos;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                consola.nextLine();
            }
        }
    }

    public int pedirISBN() {
        while (true) {
            try {
                System.out.print("Ingrese el ISBN (número): ");
                int isbn = consola.nextInt();
                consola.nextLine();
                return isbn;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                consola.nextLine();
            }
        }
    }

    // --- Revista específicos ---
    public String pedirPeriodicidad() {
        System.out.print("Ingrese la periodicidad (mensual, trimestral, etc.): ");
        return consola.nextLine();
    }

    public int pedirISSN() {
        while (true) {
            try {
                System.out.print("Ingrese el ISSN (número): ");
                int issn = consola.nextInt();
                consola.nextLine();
                return issn;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                consola.nextLine();
            }
        }
    }

    public int pedirNumeroDeVolumen() {
        while (true) {
            try {
                System.out.print("Ingrese el número de volumen: ");
                int vol = consola.nextInt();
                consola.nextLine();
                return vol;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                consola.nextLine();
            }
        }
    }

    // --- Artículo investigación específicos ---
    public String pedirCampoDeInvestigacion() {
        System.out.print("Ingrese el campo de investigación: ");
        return consola.nextLine();
    }

    public int pedirDOI() {
        while (true) {
            try {
                System.out.print("Ingrese el DOI (número): ");
                int doi = consola.nextInt();
                consola.nextLine();
                return doi;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                consola.nextLine();
            }
        }
    }

    // --- Métodos para historial/ventas ---
    public int pedirTipoHistorial() {
        System.out.println("\n¿Qué historial desea ver?");
        System.out.println("1. Historial ventas Libros");
        System.out.println("2. Historial ventas Revistas");
        System.out.println("3. Historial ventas Artículos");
        System.out.print("Seleccione: ");
        int opcion = -1;
        try {
            opcion = consola.nextInt();
            consola.nextLine();
        } catch (InputMismatchException e) {
            consola.nextLine();
            opcion = -1;
        }
        return opcion;
    }
}
