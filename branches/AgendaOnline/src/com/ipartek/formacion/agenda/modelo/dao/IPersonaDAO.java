package com.ipartek.formacion.agenda.modelo.dao;

/**
 * Interfaz IPersonaDAO, este archivo define las operaciones de CRUD contra la
 * tabla Persona de la base de datos (MySQL). Si en el futuro se usase otro tipo
 * de base de datos habria que cambiar este archivo
 * 
 * @author Susana Costoya, Kepa Escudero
 *
 */

import java.util.ArrayList;

import com.ipartek.formacion.agenda.bean.Persona;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la
 * BD, la cual luego deberemos implementar segun la BD que usemos
 *
 * @author Maitane Casado
 *
 */
public interface IPersonaDAO {

	static final String TABLA = "persona";
	static final String COL_ID = "id";
	static final String COL_NOMBRE = "nombre";
	static final String COL_APELLIDOS = "apellidos";
	static final String COL_TEL_FIJO = "tel fijo";
	static final String COL_TEL_MOVIL = "tel movil";
	static final String COL_DOMICILIO = "domicilio";
	static final String COL_LOCALIDAD = "localidad";
	static final String COL_PROVINCIA = "provincia";
	static final String COL_CP = "cp";
	static final String COL_ANOTACIONES = "anotaciones";

	ArrayList<Persona> getAll() throws ModelException;

	Persona getById(Persona p) throws ModelException;

	int insert(Persona p) throws ModelException;

	boolean delete(Persona p) throws ModelException;

	boolean update(Persona p) throws ModelException;

}
