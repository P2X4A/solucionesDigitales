package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Libro;

//DAO para Libro: persistencia texto / binario / historial.
 
public class LibroDAOImpl implements IDAO<Libro> {

    private final String archivoTextoLibros = "ventaLibro.txt";
    private final String archivoBinarioLibros = "inventarioLibros.bin";
    private final String archivoHistorialVentas = "historialVentasLibro.txt";

    @Override
    public void guardar(Libro libroAGuardar) throws IOException {
        // Guardar línea en archivo de ventas (append), agregando el precio
        String informacion = libroAGuardar.informacionLibroArchivoPlano() + libroAGuardar.getPrecio() + ";";
        FileHandler.guardarArchivoLibro(informacion, archivoTextoLibros);
    }

    //Serializa la lista completa de libros en binario (sobrescribe).
     
    public void guardarListaEnBinario(List<Libro> listaLibros) throws IOException {
        FileHandler.guardarListaBinario(listaLibros, archivoBinarioLibros);
    }

    //Lee la lista de libros desde el archivo binario.
     
    public ArrayList<Libro> leerListaDesdeBinario() throws IOException, ClassNotFoundException {
        return FileHandler.leerListaBinario(archivoBinarioLibros);
    }

    //Registra la venta en el historial de ventas (archivo de texto).
     
    public void registrarVenta(Libro libroVendido) throws IOException {
        String lineaVenta = libroVendido.informacionLibroArchivoPlano() + libroVendido.getPrecio() + ";VENDIDO;";
        FileHandler.guardarArchivoLibro(lineaVenta, archivoHistorialVentas);
    }

    // Lee el historial de ventas (líneas).

    public ArrayList<String> leerHistorialVentas() throws IOException {
        return FileHandler.leerArchivoTextoLines(archivoHistorialVentas);
    }
}
