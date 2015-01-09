package ipt.fm.ipartek.test.modelo.dao;

import ipt.fm.ipartek.test.bean.Persona;

import java.util.ArrayList;

public interface PersonaDAO {

	ArrayList<Persona> getAll();

	Persona getById(Persona p);

	Persona insert(Persona p);

	boolean delete(Persona p);

	Persona update(Persona p);
}
