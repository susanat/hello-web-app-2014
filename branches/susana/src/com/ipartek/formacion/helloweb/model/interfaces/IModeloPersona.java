package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Modelo para gestionar el bean de <code>Persona</code>
 * @author ur00
 *
 */
public interface IModeloPersona {

	/**
	 * Retorna todas las perosnas de la BBDD alfabeticamente
	 * @return listado <code>Persona</code>, si no existen null
	 */
	ArrayList<Persona> getAll();
	
	/**
	 * Recuperar <code>Persona</code> por su identificador
	 * @param id identificador <code>Persona</code>
	 * @return <code>Persona</code>, si no existe null 
	 */
	Persona getById( int id );
	

	/**
	 * Insertar nueva  <code>Persona</code>
	 * @param p  <code>Persona</code> a insertar
	 * @return identificador de la  <code>Persona</code>, -1 si error 
	 */
	int insert ( Persona p );
	
	/**
	 * Modifica una  <code>Persona</code>
	 * @param p  <code>Persona</code> a insertar
	 * @return identificador de la  <code>Persona</code>, -1 si error
	 */
	int update ( Persona p );

	
	/**
	 * Eliminamos logicamente <code>Persona</code> por su identificador
	 * @param id identificador <code>Persona</code>
	 * @return true si eliminado, false en caso contrario
	 */
	boolean delete( int id );
	
}







