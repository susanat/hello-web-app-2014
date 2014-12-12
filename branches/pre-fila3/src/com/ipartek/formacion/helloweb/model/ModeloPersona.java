/**
 * 
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;

/**
 * Implementacion para la Persistencia de las Personas
 * 
 * @author ur00
 *
 */
public class ModeloPersona implements IModeloPersona {

	// TODO implementar base BBDD
	static ArrayList<Persona> personas = null;

	public static void createTable() {
		personas = new ArrayList<Persona>();
		Persona p = new Persona("");
		p.setNombre("Gorriti");
		p.setId(0);
		personas.add(p);

		p = new Persona("");
		p.setNombre("Antton");
		p.setId(1);
		personas.add(p);

		p = new Persona("");
		p.setNombre("Pirulero");
		p.setId(2);
		personas.add(p);

		p = new Persona("");
		p.setNombre("Duquesita");
		p.setId(3);
		personas.add(p);

		p = new Persona("");
		p.setNombre("Manoli");
		p.setId(4);
		personas.add(p);

	}

	static void truncateTable() {
		personas = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getAll()
	 */
	public ArrayList<Persona> getAll() {
		ArrayList<Persona> personasLogicas = null;
		if (personas != null) {
			personasLogicas = new ArrayList<Persona>();
			for (Persona p : personas) {
				if (p != null) {
					personasLogicas.add(p);
				}
			}
			
			//Si todos estan borrados logicamente
			if ( personasLogicas.isEmpty() ){
				personasLogicas = null;
			}
		}
		return personasLogicas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getById()
	 */
	public Persona getById(int id) {
		Persona resul = null;
		if (personas != null) {
			for (Persona p : personas) {
				if (p != null) {
					if (p.getId() == id) {
						resul = p;
						break;
					}
				}
			}
		}
		return resul;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#insert
	 * (com.ipartek.formacion.helloweb.bean.Persona)
	 */
	public int insert(Persona p) {
		int resul = Persona.ID_NULL;
		
		if ( personas == null ){
			personas = new ArrayList<Persona>();
		}
		
		if ( p != null  ) {
			personas.add(p);
			p.setId((personas.size()-1));
			resul = (personas.size()-1);
		}
		
		
		return resul;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#update
	 * (com.ipartek.formacion.helloweb.bean.Persona)
	 */
	public int update(Persona p) {
		int resul = Persona.ID_NULL;
		if (personas != null) {
			personas.set(p.getId(), p);
			resul = p.getId();
		}
		return resul;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#delete
	 * (int)
	 */
	public boolean delete(int id) {
		boolean resul = false;
		try{
			if (personas != null) {
				if ( getById(id) != null ){
					personas.set(id, null);
					resul =  true;
				}	
			}
		}catch( Exception e ){
			//TODO traza de Log
			System.out.print( "No existe el ID["+id+"] queremos eliminar" );
		}				
		return resul;
	}

}
