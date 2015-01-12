package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.util.ArrayList;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla persona de la
 * base de datos. La cual luego debemos implementar segun las bbdd que usemos.
 * 
 * @author Fran
 *
 */
public interface IPersonaDAO {
	/**
	 * Función para leer todas las personas de la tabla.
	 * 
	 * @return
	 */
	ArrayList<Persona> getAll();

	/**
	 * Función para leer una persona de la base de datos segun su id.
	 * 
	 * @param p
	 * @return
	 */
	Persona getById(Persona p);

	/**
	 * Función para insertar una persona en la base de datos.
	 * 
	 * @param p
	 * @return
	 */
	Persona insert(Persona p);

	/**
	 * Función para borrar una persona de la base de datos.
	 * 
	 * @param p
	 * @return
	 */
	boolean delete(Persona p);

	/**
	 * Función para modificar una persona de la base de datos.
	 * 
	 * @param p
	 * @return
	 */
	Persona update(Persona p);
}
