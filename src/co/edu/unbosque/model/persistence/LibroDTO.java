package co.edu.unbosque.model.persistence;

public class LibroDTO {

	private String tituloPublicacion;
	private String autorPublicacion;
	private String fechaEdicionPublicacion;
	private String fechaPublicacion;
	private String generoLiterario;
	private String clasificacionPublicacion;
	private String editorial;
	private String tipoFormato;
	private int cantidadCapitulos;
	private int numeroPaginas;
	private int ISBN;
	private double precio;

	public LibroDTO(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
			String fechaPublicacion, String generoLiterario, String clasificacionPublicacion, String editorial,
			String tipoFormato, int cantidadCapitulos, int numeroPaginas, int iSBN, double precio) {
		this.tituloPublicacion = tituloPublicacion;
		this.autorPublicacion = autorPublicacion;
		this.fechaEdicionPublicacion = fechaEdicionPublicacion;
		this.fechaPublicacion = fechaPublicacion;
		this.generoLiterario = generoLiterario;
		this.clasificacionPublicacion = clasificacionPublicacion;
		this.editorial = editorial;
		this.tipoFormato = tipoFormato;
		this.cantidadCapitulos = cantidadCapitulos;
		this.numeroPaginas = numeroPaginas;
		ISBN = iSBN;
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

	public String getGeneroLiterario() {
		return generoLiterario;
	}

	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}

	public String getClasificacionPublicacion() {
		return clasificacionPublicacion;
	}

	public void setClasificacionPublicacion(String clasificacionPublicacion) {
		this.clasificacionPublicacion = clasificacionPublicacion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getTipoFormato() {
		return tipoFormato;
	}

	public void setTipoFormato(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	public int getCantidadCapitulos() {
		return cantidadCapitulos;
	}

	public void setCantidadCapitulos(int cantidadCapitulos) {
		this.cantidadCapitulos = cantidadCapitulos;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
