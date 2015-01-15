package com.ipartek.formacion.linkedin.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la
 * BD, la cual luego deberemos implementar segun la BD que usemos
 *
 * @author
 *
 */
public interface IPersonaDAO {

	static final String TABLA = "persona";
	static final String COL_ID = "id";
	static final String COL_NOMBRE = "nombre";
	static final String COL_APELLIDOS = "apellidos";
	static final String COL_FOTO = "foto";

	ArrayList<Persona> getAll() throws ModelException;

	Persona getById(Persona p) throws ModelException;

	int insert(Persona p) throws ModelException;

	boolean delete(Persona p) throws ModelException;

	boolean update(Persona p) throws ModelException;

}
