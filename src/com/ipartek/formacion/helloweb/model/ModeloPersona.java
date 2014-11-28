/**
 * 
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;

/**
 * Implementacion para la Persistencia de las Personas 
 * @author ur00
 *
 */
public class ModeloPersona implements IModeloPersona {

	//TODO implementar base BBDD	
	static ArrayList<Persona> personas = null;
	
	static void createTable(){
		personas = new ArrayList<Persona>();
		Persona p = new Persona("");
		p.setNombre("Gorriti");
		p.setId(1);
		personas.add(p);
		
		p.setNombre("Antton");
		p.setId(2);
		personas.add(p);
		
		p.setNombre("Pirulero");
		p.setId(3);
		personas.add(p);
		
		p.setNombre("Duquesita");
		p.setId(4);
		personas.add(p);
		
		p.setNombre("Manoli");
		p.setId(5);
		personas.add(p);
		
	}
	
	static void truncateTable(){
		personas = null;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getAll()
	 */
	public ArrayList<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getById()
	 */
	public Persona getById( int id ) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#insert(com.ipartek.formacion.helloweb.bean.Persona)
	 */
	public int insert(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#update(com.ipartek.formacion.helloweb.bean.Persona)
	 */
	public int update(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#delete(int)
	 */
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
