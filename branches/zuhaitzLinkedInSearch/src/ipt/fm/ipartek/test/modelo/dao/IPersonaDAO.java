package ipt.fm.ipartek.test.modelo.dao;

import ipt.fm.ipartek.test.bean.Persona;

import java.util.ArrayList;

public interface IPersonaDAO {

	static final String TABLE = "persona";
	static final String COL_ID = "id";
	static final String COL_NOMBRE = "nombre";
	static final String COL_APELLIDOS = "apellidos";
	static final String COL_FOTO = "foto";

	ArrayList<Persona> getAll();

	Persona getById(Persona p);

	Persona getById(int parseInt);

	int insert(Persona p);

	boolean delete(Persona p);

	Persona update(Persona p);

}
