package co.edu.unbosque.model;

import java.io.Serializable;

public class ArticuloInvestigacion extends PublicacionTienda implements Serializable {

	private String campoDeInvestigacion;
	private int DOI;
	private static final long serialVersionUID = 1L;

	public ArticuloInvestigacion(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
			String fechaPublicacion, String tipoFormato, String clasificacionPublicacion, int citasInvestigadores,
			int numeroPaginas, double precio, String campoDeInvestigacion, int dOI) {
		super(tituloPublicacion, autorPublicacion, fechaEdicionPublicacion, fechaPublicacion, tipoFormato,
				clasificacionPublicacion, citasInvestigadores, numeroPaginas, precio);
		this.campoDeInvestigacion = campoDeInvestigacion;
		DOI = dOI;
	}

	public String getCampoDeInvestigacion() {
		return campoDeInvestigacion;
	}

	public void setCampoDeInvestigacion(String campoDeInvestigacion) {
		this.campoDeInvestigacion = campoDeInvestigacion;
	}

	public int getDOI() {
		return DOI;
	}

	public void setDOI(int dOI) {
		DOI = dOI;
	}

	public String informacionArticuloInvestigacionArchivoPlano() {
		return tituloPublicacion + ";" + autorPublicacion + ";" + fechaEdicionPublicacion + ";" + fechaPublicacion + ";"
				+ tipoFormato + ";" + clasificacionPublicacion + ";" + citasInvestigadores + ";" + numeroPaginas + ";"
				+ campoDeInvestigacion + ";" + DOI + ";";
	}

}
