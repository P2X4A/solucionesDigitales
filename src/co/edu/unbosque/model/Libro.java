package co.edu.unbosque.model;

import java.io.Serializable;

public class Libro extends PublicacionTienda implements Serializable {

	private String generoLiterario;
	private String editorial;
	private int cantidadCapitulos;
	private int ISBN;
	private static final long serialVersionUID = 1L;

	public Libro(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
			String fechaPublicacion, String tipoFormato, String clasificacionPublicacion, int citasInvestigadores,
			int numeroPaginas, double precio, String generoLiterario, String editorial, int cantidadCapitulos,
			int iSBN) {
		super(tituloPublicacion, autorPublicacion, fechaEdicionPublicacion, fechaPublicacion, tipoFormato,
				clasificacionPublicacion, citasInvestigadores, numeroPaginas, precio);
		this.generoLiterario = generoLiterario;
		this.editorial = editorial;
		this.cantidadCapitulos = cantidadCapitulos;
		ISBN = iSBN;
	}

	public String getGeneroLiterario() {
		return generoLiterario;
	}

	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getCantidadCapitulos() {
		return cantidadCapitulos;
	}

	public void setCantidadCapitulos(int cantidadCapitulos) {
		this.cantidadCapitulos = cantidadCapitulos;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String informacionLibroArchivoPlano() {
		return tituloPublicacion + ";" + autorPublicacion + ";" + fechaEdicionPublicacion + ";" + fechaPublicacion + ";"
				+ tipoFormato + ";" + clasificacionPublicacion + ";" + citasInvestigadores + ";" + numeroPaginas + ";"
				+ generoLiterario + ";" + editorial + ";" + cantidadCapitulos + ";" + ISBN + ";";
	}

}
