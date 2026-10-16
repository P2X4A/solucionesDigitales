package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArticuloInvestigacionDAOImpl;
import co.edu.unbosque.model.persistence.LibroDAOImpl;
import co.edu.unbosque.model.persistence.RevistaDAOImpl;

/**
 * SistemaSolucionDigital: lógica de negocio.
 * - No importa FileHandler.
 * - Mantiene inventario en memoria (listas de entidades).
 * - Delegación de persistencia a DAOImpls.
 * - Vender artículos: solo digitales (tipoFormato != "fisico").
 * - Provee métodos para obtener inventario formateado y leer historiales a través de los DAO.
 */
public class SistemaSolucionDigital {

    private final LibroDAOImpl libroDAO;
    private final RevistaDAOImpl revistaDAO;
    private final ArticuloInvestigacionDAOImpl articuloDAO;

    private ArrayList<Libro> registroLibros;
    private ArrayList<Revista> registroRevistas;
    private ArrayList<ArticuloInvestigacion> registroArticulos;

    // Constructor que intenta cargar inventario binario (propaga excepciones)
    public SistemaSolucionDigital() throws IOException, ClassNotFoundException {
        this.libroDAO = new LibroDAOImpl();
        this.revistaDAO = new RevistaDAOImpl();
        this.articuloDAO = new ArticuloInvestigacionDAOImpl();

        // cargar desde los DAO (estos métodos lanzan IOException/ClassNotFound)
        this.registroLibros = libroDAO.leerListaDesdeBinario();
        this.registroRevistas = revistaDAO.leerListaDesdeBinario();
        this.registroArticulos = articuloDAO.leerListaDesdeBinario();
    }

    // Constructor alternativo (fallback) que no carga archivos
    public SistemaSolucionDigital(boolean skipLoad) {
        this.libroDAO = new LibroDAOImpl();
        this.revistaDAO = new RevistaDAOImpl();
        this.articuloDAO = new ArticuloInvestigacionDAOImpl();

        this.registroLibros = new ArrayList<>();
        this.registroRevistas = new ArrayList<>();
        this.registroArticulos = new ArrayList<>();
    }

    // -------------------- REGISTRAR ENTIDADES --------------------

    public double registrarLibro(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
            String fechaPublicacion, String tipoFormato, String clasificacionPublicacion, int citasInvestigadores,
            int numeroPaginas, String generoLiterario, String editorial, int cantidadCapitulos, int ISBN)
            throws IOException {

        double precioCalculado = calcularPrecioSegunClasificacion(clasificacionPublicacion);

        Libro nuevoLibro = new Libro(tituloPublicacion, autorPublicacion, fechaEdicionPublicacion, fechaPublicacion,
                tipoFormato, clasificacionPublicacion, citasInvestigadores, numeroPaginas, precioCalculado,
                generoLiterario, editorial, cantidadCapitulos, ISBN);

        registroLibros.add(nuevoLibro);

        // delegar persistencia al DAO (texto + binario)
        libroDAO.guardar(nuevoLibro);
        libroDAO.guardarListaEnBinario(registroLibros);

        return precioCalculado;
    }

    public double registrarRevista(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
            String fechaPublicacion, String tipoFormato, String clasificacionPublicacion, int citasInvestigadores,
            int numeroPaginas, String periodicidad, int ISSN, int numeroDeVolumen) throws IOException {

        double precioCalculado = calcularPrecioSegunClasificacion(clasificacionPublicacion);

        Revista nuevaRevista = new Revista(tituloPublicacion, autorPublicacion, fechaEdicionPublicacion, fechaPublicacion,
                tipoFormato, clasificacionPublicacion, citasInvestigadores, numeroPaginas, precioCalculado,
                periodicidad, ISSN, numeroDeVolumen);

        registroRevistas.add(nuevaRevista);

        revistaDAO.guardar(nuevaRevista);
        revistaDAO.guardarListaEnBinario(registroRevistas);

        return precioCalculado;
    }

    public double registrarArticuloInvestigacion(String tituloPublicacion, String autorPublicacion,
            String fechaEdicionPublicacion, String fechaPublicacion, String tipoFormato, String clasificacionPublicacion,
            int citasInvestigadores, int numeroPaginas, String campoDeInvestigacion, int DOI) throws IOException {

        double precioCalculado = calcularPrecioSegunClasificacion(clasificacionPublicacion);

        ArticuloInvestigacion nuevoArticulo = new ArticuloInvestigacion(tituloPublicacion, autorPublicacion,
                fechaEdicionPublicacion, fechaPublicacion, tipoFormato, clasificacionPublicacion, citasInvestigadores,
                numeroPaginas, precioCalculado, campoDeInvestigacion, DOI);

        registroArticulos.add(nuevoArticulo);

        articuloDAO.guardar(nuevoArticulo);
        articuloDAO.guardarListaEnBinario(registroArticulos);

        return precioCalculado;
    }

    // -------------------- VENDER (solo artículos digitales) --------------------

    /**
     * Vender artículo por DOI — solo si su formato es digital (no 'fisico').
     * Propaga IOException si la persistencia falla; lanza IllegalArgumentException si no
     * existe o si el artículo no es digital.
     */
    public double venderArticuloPorDOI(int doi) throws IOException {
        ArticuloInvestigacion articuloEncontrado = null;

        for (ArticuloInvestigacion articulo : registroArticulos) {
            if (articulo.getDOI() == doi) {
                articuloEncontrado = articulo;
                break;
            }
        }

        if (articuloEncontrado == null) {
            throw new IllegalArgumentException("No se encontró un artículo con DOI: " + doi);
        }

        // verificar que sea digital: asumimos 'fisico' como formato presencial/no digital
        String tipoFormato = articuloEncontrado.getTipoFormato();
        if (tipoFormato != null && tipoFormato.trim().equalsIgnoreCase("fisico")) {
            throw new IllegalArgumentException("El artículo con DOI " + doi + " NO es digital y no puede venderse (según el taller).");
        }

        // eliminar del inventario en memoria
        registroArticulos.remove(articuloEncontrado);

        // delegar en DAO: actualizar binario e ingresar registro de venta
        articuloDAO.guardarListaEnBinario(registroArticulos);
        articuloDAO.registrarVenta(articuloEncontrado);

        return articuloEncontrado.getPrecio();
    }

    // -------------------- OBTENER INVENTARIOS FORMATEADOS (para controlador) --------------------

    public ArrayList<String> obtenerInventarioLibrosFormateado() {
        ArrayList<String> salida = new ArrayList<>();
        for (Libro libro : registroLibros) {
            salida.add(libro.informacionLibroArchivoPlano() + libro.getPrecio());
        }
        return salida;
    }

    public ArrayList<String> obtenerInventarioRevistasFormateado() {
        ArrayList<String> salida = new ArrayList<>();
        for (Revista revista : registroRevistas) {
            salida.add(revista.informacionRevistaArchivoPlano() + revista.getPrecio());
        }
        return salida;
    }

    public ArrayList<String> obtenerInventarioArticulosFormateado() {
        ArrayList<String> salida = new ArrayList<>();
        for (ArticuloInvestigacion articulo : registroArticulos) {
            salida.add(articulo.informacionArticuloInvestigacionArchivoPlano() + articulo.getPrecio());
        }
        return salida;
    }

    // -------------------- LEER HISTORIALES (delegado a DAO) --------------------

    public ArrayList<String> leerHistorialVentasLibros() throws IOException {
        return libroDAO.leerHistorialVentas(); // DAO devuelve ArrayList<String>
    }

    public ArrayList<String> leerHistorialVentasRevistas() throws IOException {
        return revistaDAO.leerHistorialVentas();
    }

    public ArrayList<String> leerHistorialVentasArticulos() throws IOException {
        return articuloDAO.leerHistorialVentas();
    }

    // -------------------- UTILIDADES --------------------

    /**
     * Forzar guardado de inventario binario (propaga IOException)
     */
    public void guardarInventarioBinario() throws IOException {
        libroDAO.guardarListaEnBinario(registroLibros);
        revistaDAO.guardarListaEnBinario(registroRevistas);
        articuloDAO.guardarListaEnBinario(registroArticulos);
    }

    /**
     * Calcula precio con factor según clasificación (Q1/Q2/Q3,...).
     */
    private double calcularPrecioSegunClasificacion(String clasificacionPublicacion) {
        double base = (double) PublicacionTienda.getCostoarticulo();
        double factor = 0.0;
        if (clasificacionPublicacion == null) {
            factor = 0.0;
        } else {
            String c = clasificacionPublicacion.trim().toUpperCase();
            switch (c) {
                case "Q1":
                    factor = 0.50;
                    break;
                case "Q2":
                    factor = 0.30;
                    break;
                case "Q3":
                    factor = 0.10;
                    break;
                default:
                    factor = 0.0;
            }
        }
        double precio = base + (base * factor);
        return Math.round(precio * 100.0) / 100.0;
    }
}
