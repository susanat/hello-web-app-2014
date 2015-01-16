package com.ipartek.formacion.linkedin.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

/**
 * Interfaz para definir las operacioes de CRUD contra la tabla Persona de la
 * bbdd la cual luego debemos implementar segun la bbdd q tenemos
 *
 * @author Aritz Tellaeche
 *
 */
public interface IPersonaDAO {

	static final String TABLA = "persona";
	static final String COL_ID = "id";
	static final String COL_NOMBRE = "nombre";
	static final String COL_APELLIDOS = "apellido1";
	static final String COL_FOTO = "foto";

	ArrayList<Persona> getAll() throws ModelException;

	Persona getById(Persona p);

	int insert(Persona p);

	boolean delete(Persona p);

	boolean update(Persona p);

}
