package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class PersonaMySqlDAO implements IPersonaDAO {

    Connection comn = null;
    
	@Override
	public ArrayList<Persona> getAll() {
		// TODO implementar
		return null;
	}

	@Override
	public Persona getById(Persona p) {	
		//TODO implementar hardcodeado
		return new Persona("pepe", "Gorriti");
	}

	@Override
	public Persona insert(Persona p) {
		// TODO implementar
		return null;
	}

	@Override
	public boolean delete(Persona p) {
		// TODO implementar
		return false;
	}

	@Override
	public Persona update(Persona p) {
		// TODO implementar
		return null;
	}

}
