package co.edu.unbosque.model.persistence;

public class ArticuloInvestigacionDTO {

	private String tituloPublicacion;
	private String autorPublicacion;
	private String fechaEdicionPublicacion;
	private String fechaPublicacion;
	private String tipoFormato;
	private String clasificacionPublicacion;
	private String campoDeInvestigacion;
	private int DOI;
	private int numeroPaginas;
	private int citasInvestigadores;
	private double precio;

	public ArticuloInvestigacionDTO(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
			String fechaPublicacion, String tipoFormato, String clasificacionPublicacion, String campoDeInvestigacion,
			int dOI, int numeroPaginas, int citasInvestigadores, double precio) {
		this.tituloPublicacion = tituloPublicacion;
		this.autorPublicacion = autorPublicacion;
		this.fechaEdicionPublicacion = fechaEdicionPublicacion;
		this.fechaPublicacion = fechaPublicacion;
		this.tipoFormato = tipoFormato;
		this.clasificacionPublicacion = clasificacionPublicacion;
		this.campoDeInvestigacion = campoDeInvestigacion;
		DOI = dOI;
		this.numeroPaginas = numeroPaginas;
		this.citasInvestigadores = citasInvestigadores;
		this.precio = precio;
	}

	public String getTituloPublicacion() {
		return tituloPublicacion;
	}

	public void setTituloPublicacion(String tituloPublicacion) {
		this.tituloPublicacion = tituloPublicacion;
	}

	public String getAutorPublicacion() {
		return autorPublicacion;
	}

	public void setAutorPublicacion(String autorPublicacion) {
		this.autorPublicacion = autorPublicacion;
	}

	public String getFechaEdicionPublicacion() {
		return fechaEdicionPublicacion;
	}

	public void setFechaEdicionPublicacion(String fechaEdicionPublicacion) {
		this.fechaEdicionPublicacion = fechaEdicionPublicacion;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getTipoFormato() {
		return tipoFormato;
	}

	public void setTipoFormato(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	public String getClasificacionPublicacion() {
		return clasificacionPublicacion;
	}

	public void setClasificacionPublicacion(String clasificacionPublicacion) {
		this.clasificacionPublicacion = clasificacionPublicacion;
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

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public int getCitasInvestigadores() {
		return citasInvestigadores;
	}

	public void setCitasInvestigadores(int citasInvestigadores) {
		this.citasInvestigadores = citasInvestigadores;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
