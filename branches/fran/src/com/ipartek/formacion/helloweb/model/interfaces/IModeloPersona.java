package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Modelo para gestionar el bean de <code>Persona</code>.
 * 
 * @author Fran
 *
 */
public interface IModeloPersona {
	/**
	 * Obtener todas las personasde la base de datos alfabéticamente.
	 * 
	 * @return <code>ArrayList</code> con las personas si hay, null si no hay.
	 */
	ArrayList<Persona> getAll();

	/**
	 * Obtener una <code>Persona</code> por su identificador.
	 *
	 * @param i
	 *            Identificador del registro.
	 * @return <code>Persona</code> si existe, null si no existe.
	 */
	Persona getById(int id);

	/**
	 * Insertar una <code>Persona</code> en la base de datos.
	 * 
	 * @param p
	 *            <code>Persona</code> que se inserta.
	 * @return identificador del registro insertado, -1 si no se ha podido, -2
	 *         si existe insertar.
	 */
	int insert(Persona p);

	/**
	 * Actualizar una <code>Persona</code> en la base de datos.
	 * 
	 * @param p
	 *            <code>Persona</code> que se inserta.
	 * @return identificador del registro insertado, -1 si no se ha podido
	 *         actualizar.
	 */
	int update(Persona p);

	/**
	 * Borrar la <code>Persona</code> por su identificador. El borrado se
	 * realiza de forma lógica.
	 * 
	 * @param i
	 *            Identificador del registro.
	 * @return true si se ha borrado, false si no.
	 */
	boolean delete(int i);
}
