package co.edu.unbosque.model.persistence;

public class RevistaDTO {

	private String tituloPublicacion;
	private String autorPublicacion;
	private String fechaEdicionPublicacion;
	private String fechaPublicacion;
	private String tipoFormato;
	private String clasificacionPublicacion;
	private String periodicidad; // mensual, trimestral, etc.
	private int numeroPaginas;
	private int numeroDeVolumen;
	private int citasInvestigadores;
	private int ISSN;
	private double precio;

	public RevistaDTO(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
			String fechaPublicacion, String tipoFormato, String clasificacionPublicacion, String periodicidad,
			int numeroPaginas, int numeroDeVolumen, int citasInvestigadores, int iSSN, double precio) {
		this.tituloPublicacion = tituloPublicacion;
		this.autorPublicacion = autorPublicacion;
		this.fechaEdicionPublicacion = fechaEdicionPublicacion;
		this.fechaPublicacion = fechaPublicacion;
		this.tipoFormato = tipoFormato;
		this.clasificacionPublicacion = clasificacionPublicacion;
		this.periodicidad = periodicidad;
		this.numeroPaginas = numeroPaginas;
		this.numeroDeVolumen = numeroDeVolumen;
		this.citasInvestigadores = citasInvestigadores;
		ISSN = iSSN;
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

	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public int getNumeroDeVolumen() {
		return numeroDeVolumen;
	}

	public void setNumeroDeVolumen(int numeroDeVolumen) {
		this.numeroDeVolumen = numeroDeVolumen;
	}

	public int getCitasInvestigadores() {
		return citasInvestigadores;
	}

	public void setCitasInvestigadores(int citasInvestigadores) {
		this.citasInvestigadores = citasInvestigadores;
	}

	public int getISSN() {
		return ISSN;
	}

	public void setISSN(int iSSN) {
		ISSN = iSSN;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

}
