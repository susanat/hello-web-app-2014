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
	 * @return Lista de personas. Null si error.
	 */
	ArrayList<Persona> getAll();

	/**
	 * Función para leer una persona de la base de datos segun su id.
	 * 
	 * @param Persona
	 *            a buscar, solo se necesita su id.
	 * @return Persona buscada, contiene todos los datos. Null si error.
	 */
	Persona getById(Persona p);

	/**
	 * Función para insertar una persona en la base de datos.
	 * 
	 * @param Persona
	 *            con los datos a insertar.
	 * @return Persona insertada (con id nuevo). Null si error.
	 */
	Persona insert(Persona p);

	/**
	 * Función para borrar una persona de la base de datos.
	 * 
	 * @param Persona
	 *            a borrar, solo es necesario su id.
	 * @return True si ha sido borrada. False si no ha sido borrada.
	 */
	boolean delete(Persona p);

	/**
	 * Función para modificar una persona de la base de datos.
	 * 
	 * @param Persona
	 *            a modificar.
	 * @return Persona modificada. Null si error.
	 */
	Persona update(Persona p);
}
