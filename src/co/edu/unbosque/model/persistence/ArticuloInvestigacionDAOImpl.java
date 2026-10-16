package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.ArticuloInvestigacion;

//DAO para ArticuloInvestigacion.

public class ArticuloInvestigacionDAOImpl implements IDAO<ArticuloInvestigacion> {

	private final String archivoTextoArticulos = "ventaArticuloInvestigacion.txt";
	private final String archivoBinarioArticulos = "inventarioArticulos.bin";
	private final String archivoHistorialVentas = "historialVentasArticulo.txt";

	@Override
	public void guardar(ArticuloInvestigacion articuloAGuardar) throws IOException {
		String informacion = articuloAGuardar.informacionArticuloInvestigacionArchivoPlano()
				+ articuloAGuardar.getPrecio() + ";";
		FileHandler.guardarArchivoArticuloInvestigacion(informacion, archivoTextoArticulos);
	}

	//Guarda la lista completa de artículos en binario.
	 
	public void guardarListaEnBinario(List<ArticuloInvestigacion> listaArticulos) throws IOException {
		FileHandler.guardarListaBinario(listaArticulos, archivoBinarioArticulos);
	}

	//Lee la lista completa de artículos desde el archivo binario.
	 
	public ArrayList<ArticuloInvestigacion> leerListaDesdeBinario() throws IOException, ClassNotFoundException {
		return FileHandler.leerListaBinario(archivoBinarioArticulos);
	}

	//Registra la venta de un artículo en el archivo historial.
	 
	public void registrarVenta(ArticuloInvestigacion articuloVendido) throws IOException {
		String lineaVenta = articuloVendido.informacionArticuloInvestigacionArchivoPlano() + articuloVendido.getPrecio()
				+ ";VENDIDO;";
		FileHandler.guardarArchivoArticuloInvestigacion(lineaVenta, archivoHistorialVentas);
	}

	//Lee el historial de ventas (líneas).
	 
	public ArrayList<String> leerHistorialVentas() throws IOException {
		return FileHandler.leerArchivoTextoLines(archivoHistorialVentas);
	}
}
