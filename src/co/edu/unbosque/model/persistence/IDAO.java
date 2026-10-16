package co.edu.unbosque.model.persistence;

import java.io.IOException;

public interface IDAO  <T> {
	void guardar(T entidad) throws IOException;

}
