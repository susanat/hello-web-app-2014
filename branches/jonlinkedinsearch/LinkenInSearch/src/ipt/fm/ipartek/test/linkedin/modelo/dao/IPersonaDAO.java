package ipt.fm.ipartek.test.linkedin.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

public interface IPersonaDAO {
	public ArrayList<Persona> getAll();
	
	public Persona getById(Persona p);
	
	public Persona insert(Persona p);
	public boolean delete(Persona p);
	public Persona update(Persona p);
	
}
