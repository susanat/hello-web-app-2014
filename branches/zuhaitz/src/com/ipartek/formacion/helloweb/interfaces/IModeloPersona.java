package com.ipartek.formacion.helloweb.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Modelo para gestionar el bean de <code>Persona</code>
 *
 * @author Curso
 *
 */
public interface IModeloPersona {

	/**
	 * Retorna todas las personas de la BBDD ordenadas alfabéticamente
	 *
	 * @return ArrayList de <code>Persona</code>, si no existe null
	 */
	ArrayList<Persona> getAll();

	/**
	 * Recuperar <code>Persona</code> por su identificador
	 *
	 * @return <code>Persona</code>, si no existe null
	 */
	Persona getById(int id);

	/**
	 * Inserta nueva <code>Persona</code>
	 *
	 * @param p
	 *            <code>Persona</code> a insertar
	 * @return identificador de la <code>Persona</code> insertada, -1 si es
	 *         error
	 */
	int insert(Persona p);

	/**
	 * Modifica una <code>Persona</code>
	 *
	 * @param p
	 *            <code>Persona</code> a modificar
	 * @return identificador de la <code>Persona</code> modificada, -1 si es
	 *         error
	 */
	int update(Persona p);

	/**
	 * Elimina lógicamente una <code>Persona</code> de la BBDD por su
	 * identificador
	 *
	 * @param id
	 *            identificador <code>Persona</code>
	 * @return true si lo ha eliminado, false en caso contrario
	 */
	boolean delete(int id);

}
