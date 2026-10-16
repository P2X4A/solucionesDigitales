package co.edu.unbosque.model;

import java.io.Serializable;

public class PublicacionTienda implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String tituloPublicacion;
    protected String autorPublicacion;
    protected String fechaEdicionPublicacion;
    protected String fechaPublicacion;
    protected String tipoFormato; // fisico, epub,pdf,etc.
    protected String clasificacionPublicacion; // Q1, Q2, Q3, etc.
    protected int citasInvestigadores;
    protected int numeroPaginas;
    protected double precio;
    private static final int costoArticulo = 150000;

    public PublicacionTienda(String tituloPublicacion, String autorPublicacion, String fechaEdicionPublicacion,
                             String fechaPublicacion, String tipoFormato, String clasificacionPublicacion,
                             int citasInvestigadores, int numeroPaginas, double precio) {

        this.tituloPublicacion = tituloPublicacion;
        this.autorPublicacion = autorPublicacion;
        this.fechaEdicionPublicacion = fechaEdicionPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.tipoFormato = tipoFormato;
        this.clasificacionPublicacion = clasificacionPublicacion;
        this.citasInvestigadores = citasInvestigadores;
        this.numeroPaginas = numeroPaginas;
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

    public int getCitasInvestigadores() {
        return citasInvestigadores;
    }

    public void setCitasInvestigadores(int citasInvestigadores) {
        this.citasInvestigadores = citasInvestigadores;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static int getCostoarticulo() {
        return costoArticulo;
    }
}
