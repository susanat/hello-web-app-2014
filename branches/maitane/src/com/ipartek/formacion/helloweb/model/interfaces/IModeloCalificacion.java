package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;

public interface IModeloCalificacion {

	/**
	 * Retorna todas las calificaciones de la BBDD alfabeticamente
	 * 
	 * @return listado <code>Calificacion</code>, si no existen null
	 */
	ArrayList<Calificacion> getAll();

	/**
	 * Recuperar <code>Calificacion</code> por su identificador
	 * 
	 * @param id
	 *            identificador <code>Calificacion</code>
	 * @return <code>Calificacion</code>, si no existe null
	 */
	Calificacion getById(int id);

	/**
	 * Insertar nueva <code>Calificacion</code>
	 * 
	 * @param c
	 *            <code>Calificacion</code> a insertar
	 * @return identificador de la <code>Calificacion</code>, -1 si error
	 */
	int insert(Calificacion c);

	/**
	 * Modifica una <code>Calificacion</code>
	 * 
	 * @param c
	 *            <code>Calificacion</code> a insertar
	 * @return identificador de la <code>Calificacion</code>, -1 si error
	 */
	int update(Calificacion c);

	/**
	 * Eliminamos logicamente <code>Calificacion</code> por su identificador
	 * 
	 * @param id
	 *            identificador <code>Calificacion</code>
	 * @return true si eliminado, false en caso contrario
	 */
	boolean delete(int id);

}
