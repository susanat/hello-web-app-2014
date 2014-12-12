package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Idioma;

/**
 * Modelo para gestionar el bean de <code>Idioma</code>
 *
 * @author curso
 *
 */
public interface IModeloIdioma {

	/**
	 * Retorna todas los idiomas de la BBDD alfabeticamente
	 *
	 * @return listado <code>Idioma</code>, si no existen null
	 */
	ArrayList<Idioma> getAll();

	/**
	 * Recuperar <code>Idioma</code> por su identificador
	 *
	 * @param id
	 *            identificador del <code>Idioma</code>
	 * @return <code>Idioma</code>, si no existe null
	 */
	Idioma getById(int id);

	/**
	 * Insertar nuevo <code>Idioma</code>
	 *
	 * @param i
	 *            <code>Idioma</code> a insertar
	 * @return identificador del <code>Idioma</code>, -1 si error
	 */
	int insert(Idioma i);

	/**
	 * Modifica una <code>Idioma</code>
	 *
	 * @param i
	 *            <code>Idioma</code> a insertar
	 * @return identificador del <code>Idioma</code>, -1 si error
	 */
	int update(Idioma i);

	/**
	 * Eliminamos lógicamente <code>Idioma</code> por su identificador
	 *
	 * @param id
	 *            identificador del <code>Idioma</code>
	 * @return true si eliminado, false en caso contrario
	 */
	boolean delete(int id);

}
