package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Revista;

//DAO para Revista: persistencia texto / binario / historial.

public class RevistaDAOImpl implements IDAO<Revista> {

	private final String archivoTextoRevistas = "ventaRevista.txt";
	private final String archivoBinarioRevistas = "inventarioRevistas.bin";
	private final String archivoHistorialVentas = "historialVentasRevista.txt";

	@Override
	public void guardar(Revista revistaAGuardar) throws IOException {
	//Guardar revista con el precio.
		String informacion = revistaAGuardar.informacionRevistaArchivoPlano() + revistaAGuardar.getPrecio() + ";";
		FileHandler.guardarArchivoRevista(informacion, archivoTextoRevistas);
	}

	//Serializa la lista completa de revistas en binario (sobrescribe).
	 
	public void guardarListaEnBinario(List<Revista> listaRevistas) throws IOException {
		FileHandler.guardarListaBinario(listaRevistas, archivoBinarioRevistas);
	}

	//Lee la lista de revistas desde el archivo binario.
	 
	public ArrayList<Revista> leerListaDesdeBinario() throws IOException, ClassNotFoundException {
		return FileHandler.leerListaBinario(archivoBinarioRevistas);
	}

	//Registra la venta en el historial de ventas (archivo de texto).
	 
	public void registrarVenta(Revista revistaVendida) throws IOException {
		String lineaVenta = revistaVendida.informacionRevistaArchivoPlano() + revistaVendida.getPrecio() + ";VENDIDO;";
		FileHandler.guardarArchivoRevista(lineaVenta, archivoHistorialVentas);
	}

	//Lee el historial de ventas (líneas).
	 
	public ArrayList<String> leerHistorialVentas() throws IOException {
		return FileHandler.leerArchivoTextoLines(archivoHistorialVentas);
	}
}
