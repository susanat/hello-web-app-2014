package com.ipartek.formacion.helloweb.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;

/**
 * Modelo para gestionar el bean de <code>Calificacion</code>
 *
 * @author Curso
 *
 */
public interface IModeloCalificacion {

	/**
	 * Retorna todas las calificaciones de la BBDD
	 *
	 * @return ArrayList de <code>Calificacion</code>, si no existe null
	 */
	ArrayList<Calificacion> getAll();

	/**
	 * Recuperar <code>Calificacion</code> por su identificador
	 *
	 * @return <code>Calificacion</code>, si no existe null
	 */
	Calificacion getById(int id);

	/**
	 * Inserta nueva <code>Calificacion</code>
	 *
	 * @param c
	 *            <code>Calificacion</code> a insertar
	 * @return identificador de la <code>Calificacion</code> insertada, -1 si es
	 *         error
	 */
	int insert(Calificacion c);

	/**
	 * Modifica una <code>Calificacion</code>
	 *
	 * @param c
	 *            <code>Calificacion</code> a modificar
	 * @return identificador de la <code>Calificacion</code> modificada, -1 si
	 *         es error
	 */
	int update(Calificacion c);

	/**
	 * Elimina lógicamente una <code>Calificacion</code> de la BBDD por su
	 * identificador
	 *
	 * @param id
	 *            identificador <code>Calificacion</code>
	 * @return true si lo ha eliminado, false en caso contrario
	 */
	boolean delete(int id);

}
