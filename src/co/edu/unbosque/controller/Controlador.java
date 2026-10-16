package co.edu.unbosque.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.ArrayList;

import co.edu.unbosque.model.SistemaSolucionDigital;
import co.edu.unbosque.view.Consola;

public class Controlador {

    private Consola consola;
    private SistemaSolucionDigital sistema;

    public Controlador() {
        this.consola = new Consola();
        try {
            this.sistema = new SistemaSolucionDigital(); // intenta cargar inventario binario
        } catch (IOException | ClassNotFoundException e) {
            consola.mostrarMensaje("Advertencia: no se pudo cargar inventario binario: " + e.getMessage());
            // fallback: sistema vacío (constructor que no lanza excepciones)
            this.sistema = new SistemaSolucionDigital(true);
        }
    }

    public void ejecutar() {
        boolean ejecutando = true;
        while (ejecutando) {
            int opcion = consola.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    registrarRevista();
                    break;
                case 3:
                    registrarArticuloInvestigacion();
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    venderArticuloInvestigacion();
                    break;
                case 6:
                    mostrarHistorialVentas();
                    break;
                case 0:
                    consola.mostrarMensaje("\nSaliendo... ¡Hasta luego!");
                    ejecutando = false;
                    break;
                default:
                    consola.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // ---------- Métodos de registro ----------
    private void registrarLibro() {
        try {
            consola.mostrarMensaje("\n--- REGISTRAR LIBRO ---");
            String titulo = consola.pedirTituloPublicacion();
            String autor = consola.pedirAutorPublicacion();
            String fechaEdicion = consola.pedirFechaEdicionPublicacion();
            String fechaPublicacion = consola.pedirFechaPublicacion();
            String tipoFormato = consola.pedirTipoFormato();
            String clasificacion = consola.pedirClasificacionPublicacion();
            int citas = consola.pedirCitasInvestigadores();
            int paginas = consola.pedirNumeroPaginas();
            String genero = consola.pedirGeneroLiterario();
            String editorial = consola.pedirEditorial();
            int capitulos = consola.pedirCantidadCapitulos();
            int isbn = consola.pedirISBN();

            double precio = sistema.registrarLibro(titulo, autor, fechaEdicion, fechaPublicacion, tipoFormato, clasificacion,
                    citas, paginas, genero, editorial, capitulos, isbn);

            consola.mostrarMensaje("Libro registrado exitosamente.");
            consola.mostrarMensaje("Precio calculado: " + precio + "\n");
        } catch (IOException e) {
            consola.mostrarMensaje("Error al guardar archivo del libro: " + e.getMessage());
        } catch (InputMismatchException e) {
            consola.mostrarMensaje("Error: dato inválido. Revise los valores numéricos.");
        } catch (Exception e) {
            consola.mostrarMensaje("Error inesperado: " + e.getMessage());
        }
    }

    private void registrarRevista() {
        try {
            consola.mostrarMensaje("\n--- REGISTRAR REVISTA ---");
            String titulo = consola.pedirTituloPublicacion();
            String autor = consola.pedirAutorPublicacion();
            String fechaEdicion = consola.pedirFechaEdicionPublicacion();
            String fechaPublicacion = consola.pedirFechaPublicacion();
            String tipoFormato = consola.pedirTipoFormato();
            String clasificacion = consola.pedirClasificacionPublicacion();
            int citas = consola.pedirCitasInvestigadores();
            int paginas = consola.pedirNumeroPaginas();
            String periodicidad = consola.pedirPeriodicidad();
            int issn = consola.pedirISSN();
            int volumen = consola.pedirNumeroDeVolumen();

            double precio = sistema.registrarRevista(titulo, autor, fechaEdicion, fechaPublicacion, tipoFormato, clasificacion,
                    citas, paginas, periodicidad, issn, volumen);

            consola.mostrarMensaje("Revista registrada exitosamente.");
            consola.mostrarMensaje("Precio calculado: " + precio + "\n");
        } catch (IOException e) {
            consola.mostrarMensaje("Error al guardar archivo de la revista: " + e.getMessage());
        } catch (InputMismatchException e) {
            consola.mostrarMensaje("Error: dato inválido. Revise los valores numéricos.");
        } catch (Exception e) {
            consola.mostrarMensaje("Error inesperado: " + e.getMessage());
        }
    }

    private void registrarArticuloInvestigacion() {
        try {
            consola.mostrarMensaje("\n--- REGISTRAR ARTÍCULO DE INVESTIGACIÓN ---");
            String titulo = consola.pedirTituloPublicacion();
            String autor = consola.pedirAutorPublicacion();
            String fechaEdicion = consola.pedirFechaEdicionPublicacion();
            String fechaPublicacion = consola.pedirFechaPublicacion();
            String tipoFormato = consola.pedirTipoFormato();
            String clasificacion = consola.pedirClasificacionPublicacion();
            int citas = consola.pedirCitasInvestigadores();
            int paginas = consola.pedirNumeroPaginas();
            String campo = consola.pedirCampoDeInvestigacion();
            int doi = consola.pedirDOI();

            double precio = sistema.registrarArticuloInvestigacion(titulo, autor, fechaEdicion, fechaPublicacion,
                    tipoFormato, clasificacion, citas, paginas, campo, doi);

            consola.mostrarMensaje("Artículo registrado exitosamente.");
            consola.mostrarMensaje("Precio calculado: " + precio + "\n");
        } catch (IOException e) {
            consola.mostrarMensaje("Error al guardar archivo del artículo: " + e.getMessage());
        } catch (InputMismatchException e) {
            consola.mostrarMensaje("Error: dato inválido. Revise los valores numéricos.");
        } catch (Exception e) {
            consola.mostrarMensaje("Error inesperado: " + e.getMessage());
        }
    }

    // ---------- Mostrar inventario ----------
    private void mostrarInventario() {
        try {
            consola.mostrarMensaje("\n--- INVENTARIO COMPLETO ---");

            consola.mostrarMensaje("\n>>> LIBROS REGISTRADOS:");
            for (String linea : sistema.obtenerInventarioLibrosFormateado()) {
                consola.mostrarMensaje(linea);
            }

            consola.mostrarMensaje("\n>>> REVISTAS REGISTRADAS:");
            for (String linea : sistema.obtenerInventarioRevistasFormateado()) {
                consola.mostrarMensaje(linea);
            }

            consola.mostrarMensaje("\n>>> ARTÍCULOS REGISTRADOS:");
            for (String linea : sistema.obtenerInventarioArticulosFormateado()) {
                consola.mostrarMensaje(linea);
            }

            // opcional: forzar guardado binario actualizado
            sistema.guardarInventarioBinario();
            consola.mostrarMensaje("\nInventario guardado en binario (actualizado).");
        } catch (IOException e) {
            consola.mostrarMensaje("Error al guardar inventario binario: " + e.getMessage());
        } catch (Exception e) {
            consola.mostrarMensaje("Error inesperado al mostrar inventario: " + e.getMessage());
        }
    }

    // ---------- Vender artículo (solo digital) ----------
    private void venderArticuloInvestigacion() {
        try {
            consola.mostrarMensaje("\n--- VENDER ARTÍCULO DE INVESTIGACIÓN (SOLO DIGITAL) ---");
            int doi = consola.pedirDOI();
            double precioVenta = sistema.venderArticuloPorDOI(doi);
            consola.mostrarMensaje("Artículo vendido. Precio: " + precioVenta + "\n");
        } catch (IllegalArgumentException e) {
            consola.mostrarMensaje("No se pudo vender: " + e.getMessage());
        } catch (IOException e) {
            consola.mostrarMensaje("Error al actualizar archivos de persistencia: " + e.getMessage());
        } catch (Exception e) {
            consola.mostrarMensaje("Error inesperado al vender artículo: " + e.getMessage());
        }
    }

    // ---------- Mostrar historial de ventas ----------
    private void mostrarHistorialVentas() {
        try {
            int tipo = consola.pedirTipoHistorial();
            ArrayList<String> lineas = null;
            switch (tipo) {
                case 1:
                    lineas = sistema.leerHistorialVentasLibros();
                    consola.mostrarMensaje("\n--- HISTORIAL VENTAS LIBROS ---");
                    break;
                case 2:
                    lineas = sistema.leerHistorialVentasRevistas();
                    consola.mostrarMensaje("\n--- HISTORIAL VENTAS REVISTAS ---");
                    break;
                case 3:
                    lineas = sistema.leerHistorialVentasArticulos();
                    consola.mostrarMensaje("\n--- HISTORIAL VENTAS ARTÍCULOS ---");
                    break;
                default:
                    consola.mostrarMensaje("Opción de historial no válida.");
                    return;
            }

            if (lineas == null || lineas.isEmpty()) {
                consola.mostrarMensaje("No hay registros en el historial seleccionado.");
            } else {
                for (String linea : lineas) {
                    consola.mostrarMensaje(linea);
                }
            }

        } catch (IOException e) {
            consola.mostrarMensaje("Error al leer historial de ventas: " + e.getMessage());
        } catch (Exception e) {
            consola.mostrarMensaje("Error inesperado al mostrar historial: " + e.getMessage());
        }
    }
}
