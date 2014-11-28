package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.bean.Persona;

/**
 * nodelo para gestionar el bean de <code>Persona</code>.
 *
 * @author Aritz Tellaeche
 *
 */
public interface IModeloPersona {

	/**
	 * retorna todas las personas de la bbdd alfabeticamente.
	 *
	 * @return <code>Persona</code>, si no existe null
	 */
	ArrayList<Persona> getAll();

	/**
	 * <code>Persona</code> obtenida por su identificador.
	 * 
	 * @param id
	 *            identificador de la <code>Persona</code>
	 * @return <code>Persona</code>, si no existe null
	 */
	Persona getById(int id);

	/**
	 * Inserta nueva <code>Persona</code>.
	 *
	 * @param p
	 *            <code>Persona</code> a insertar
	 * @return identificador de la <code>Persona</code>, -1 si es error
	 */
	int insert(Persona p);

	/**
	 * Modifica nueva <code>Persona</code>.
	 *
	 * @param p
	 *            <code>Persona</code> a modificar
	 * @return identificador de la <code>Persona</code>, -1 si es error
	 */
	int update(Persona p);

	/**
	 * eliminar logicamente una <code>Persona</code> por su id.
	 *
	 * @param id
	 *            de <code>Persona</code> a eliminar
	 * @return true si eliminad, false en caso contrario
	 */
	boolean delete(int id);

}
