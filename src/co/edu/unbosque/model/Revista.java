package co.edu.unbosque.model;

import java.io.Serializable;

public class Revista extends PublicacionTienda implements Serializable {

	private String periodicidad; // mensual, trimestral,etc.
	private int ISSN;
	private int numeroDeVolumen;
	private static final long serialVersionUID = 1L;

	public Revista(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
			String fechaPublicacion, String tipoFormato, String clasificacionPublicacion, int citasInvestigadores,
			int numeroPaginas, double precio, String periodicidad, int iSSN, int numeroDeVolumen) {
		super(tituloPublicacion, autorPublicacion, fechaEdicionPublicacion, fechaPublicacion, tipoFormato,
				clasificacionPublicacion, citasInvestigadores, numeroPaginas, precio);
		this.periodicidad = periodicidad;
		ISSN = iSSN;
		this.numeroDeVolumen = numeroDeVolumen;
	}

	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	public int getISSN() {
		return ISSN;
	}

	public void setISSN(int iSSN) {
		ISSN = iSSN;
	}

	public int getNumeroDeVolumen() {
		return numeroDeVolumen;
	}

	public void setNumeroDeVolumen(int numeroDeVolumen) {
		this.numeroDeVolumen = numeroDeVolumen;
	}

	public String informacionRevistaArchivoPlano() {
		return tituloPublicacion + ";" + autorPublicacion + ";" + fechaEdicionPublicacion + ";" + fechaPublicacion + ";"
				+ tipoFormato + ";" + clasificacionPublicacion + ";" + citasInvestigadores + ";" + numeroPaginas + ";"
				+ periodicidad + ";" + ISSN + ";" + numeroDeVolumen + ";";
	}

}
