package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.util.ArrayList;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la
 * BBDD. La cual luego deberemos implementar segun la BBDD que usemos.
 * 
 * @author Curso
 *
 */
public interface IPersonaDAO {

	static final String TABLA = "persona";
	static final String COL_ID = "id";
	static final String COL_NOMBRE = "nombre";
	static final String COL_APELLIDOS = "apellidos";
	static final String COL_FOTO = "foto";

	/**
	 * Listado de todas las personas de la BBDD
	 * 
	 * @return Listado de Personas
	 */
	ArrayList<Persona> getAll();

	/**
	 * Busca una Persona en la BBDD a partir de su Id
	 * 
	 * @param p
	 *            Persona con el Id que se busca
	 * @return Persona
	 */
	Persona getById(Persona p);

	/**
	 * Busca una Persona en la BBDD a partir de su nombre y apellidos
	 * 
	 * @param p
	 *            Persona con el nombre y apellidos que se busca
	 * @return indice de la persona buscada, si produce un error devuelve -1
	 */
	int getByNombreApellidos(Persona p);

	/**
	 * Anadir una Persona en la BBDD
	 * 
	 * @param p
	 *            Persona sin el Id
	 * @return indice de la persona anadida, si produce un error devuelve -1
	 */
	int insert(Persona p);

	/**
	 * Borrar una Persona de la BBDD
	 * 
	 * @param p
	 * @return true si se ha borrado con exito, false eoc
	 */
	boolean delete(Persona p);

	/**
	 * Actualizar los datos de una Persona
	 * 
	 * @param p
	 *            Persona con los datos actualizados (su Id no se podra
	 *            modificar)
	 * @return true si se ha modificado con exito, false eoc
	 */
	boolean update(Persona p);
}
