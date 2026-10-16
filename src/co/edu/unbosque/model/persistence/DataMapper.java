package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.ArticuloInvestigacion;
import co.edu.unbosque.model.Libro;
import co.edu.unbosque.model.Revista;


public class DataMapper {

    //  ENTIDAD -> DTO 

    public static RevistaDTO deEntidadADTO(Revista revista) {
        return new RevistaDTO(
                revista.getTituloPublicacion(),
                revista.getAutorPublicacion(),
                revista.getFechaEdicionPublicacion(),
                revista.getFechaPublicacion(),
                revista.getTipoFormato(),
                revista.getClasificacionPublicacion(),
                revista.getPeriodicidad(),
                revista.getNumeroPaginas(),
                revista.getNumeroDeVolumen(),
                revista.getCitasInvestigadores(),
                revista.getISSN(),
                revista.getPrecio()
        );
    }

    public static ArticuloInvestigacionDTO deEntidadADTO(ArticuloInvestigacion articulo) {
        return new ArticuloInvestigacionDTO(
                articulo.getTituloPublicacion(),
                articulo.getAutorPublicacion(),
                articulo.getFechaEdicionPublicacion(),
                articulo.getFechaPublicacion(),
                articulo.getTipoFormato(),
                articulo.getClasificacionPublicacion(),
                articulo.getCampoDeInvestigacion(),
                articulo.getDOI(),
                articulo.getNumeroPaginas(),
                articulo.getCitasInvestigadores(),
                articulo.getPrecio()
        );
    }

    public static LibroDTO deEntidadADTO(Libro libro) {
        return new LibroDTO(
                libro.getTituloPublicacion(),
                libro.getAutorPublicacion(),
                libro.getFechaEdicionPublicacion(),
                libro.getFechaPublicacion(),
                libro.getGeneroLiterario(),
                libro.getClasificacionPublicacion(),
                libro.getEditorial(),
                libro.getTipoFormato(),
                libro.getCantidadCapitulos(),
                libro.getNumeroPaginas(),
                libro.getISBN(),
                libro.getPrecio()
        );
    }

    //  DTO -> ENTIDAD 

    public static Revista deDTOAEntidad(RevistaDTO dto) {
        return new Revista(
                dto.getTituloPublicacion(),
                dto.getAutorPublicacion(),
                dto.getFechaEdicionPublicacion(),
                dto.getFechaPublicacion(),
                dto.getTipoFormato(),
                dto.getClasificacionPublicacion(),
                dto.getCitasInvestigadores(),
                dto.getNumeroPaginas(),
                dto.getPrecio(),
                dto.getPeriodicidad(),
                dto.getISSN(),
                dto.getNumeroDeVolumen()
        );
    }

    public static ArticuloInvestigacion deDTOAEntidad(ArticuloInvestigacionDTO dto) {
        return new ArticuloInvestigacion(
                dto.getTituloPublicacion(),
                dto.getAutorPublicacion(),
                dto.getFechaEdicionPublicacion(),
                dto.getFechaPublicacion(),
                dto.getTipoFormato(),
                dto.getClasificacionPublicacion(),
                dto.getCitasInvestigadores(),
                dto.getNumeroPaginas(),
                dto.getPrecio(),
                dto.getCampoDeInvestigacion(),
                dto.getDOI()
        );
    }

    public static Libro deDTOAEntidad(LibroDTO dto) {
        return new Libro(
                dto.getTituloPublicacion(),
                dto.getAutorPublicacion(),
                dto.getFechaEdicionPublicacion(),
                dto.getFechaPublicacion(),
                dto.getTipoFormato(),
                dto.getClasificacionPublicacion(),
                0, // citasInvestigadores no existe en LibroDTO ni en libro ya que un libro no tiene citas Investigativas
                dto.getNumeroPaginas(),
                dto.getPrecio(),
                dto.getGeneroLiterario(),
                dto.getEditorial(),
                dto.getCantidadCapitulos(),
                dto.getISBN()
        );
    }
}
