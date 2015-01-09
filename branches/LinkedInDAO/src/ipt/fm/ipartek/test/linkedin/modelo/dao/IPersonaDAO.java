package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.util.ArrayList;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la BBDD
 * La cual luego deberemos implementar segun las BBDD que usemos
 * @author ur00
 *
 */
public interface IPersonaDAO {

	ArrayList<Persona> getAll ();
	
	Persona getById(Persona p);	
	
	Persona insert (Persona p);
	
	boolean delete (Persona p);
	
	Persona update (Persona p);
	
}
