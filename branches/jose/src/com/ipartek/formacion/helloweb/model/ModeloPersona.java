/**
 * 
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;

/**
 * Implementacion para la Persistencia de Persona
 * 
 * @author Curso
 *
 */
public class ModeloPersona implements IModeloPersona {

	// TODO implementar base BBDD

	// ESTO ES TEMPORAL - MIENTRAS NO EXISTA BBDD
	// inicio TEMPORAL
	static ArrayList<Persona> personas = null;

	static public void createTable() {
		personas = new ArrayList<Persona>();
		Persona p;

		p = new Persona("Gorriti");
		p.setId(1);
		personas.add(p);

		p = new Persona("Antton");
		p.setId(2);
		personas.add(p);

		p = new Persona("Pirulero");
		p.setId(3);
		personas.add(p);

		p = new Persona("Duquesita");
		p.setId(4);
		personas.add(p);

		p = new Persona("Manoli");
		p.setId(5);
		personas.add(p);

	}

	static public void truncateTable() {
		personas = null;
	}

	// fin TEMPORAL


	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getAll()
	 */
	public ArrayList<Persona> getAll() {
		ArrayList<Persona> listaPersonas = null;

		if (personas != null) {
			listaPersonas = new ArrayList<Persona>();
			for (Persona persona : personas) {
				if (persona != null) {
					listaPersonas.add(persona);
				}
			}
			if (listaPersonas.isEmpty()) {
				listaPersonas = null;
			}
		}
		return listaPersonas;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getByd()
	 */
	public Persona getByd(int id) {
		return personas.get(id - 1);
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#insert(com.ipartek.formacion.helloweb.bean.Persona)
	 */
	public int insert(Persona p) {
		int resul=Persona.ID_NULL;
		
		//Comprobamos que esa persona no sea Null
		if (p!=null){
			// Si no existe el array lo creamos
			if(personas==null){
				personas=new ArrayList<Persona>();
			}
			
		// Anadimos la persona al Array
		personas.add(p);
		// Le asignamos un indice
		p.setId(personas.size());
			resul = p.getId();
		}

		return resul;
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
		boolean resul = false;

		int tamPersonas = personas.size();
		int i;

		for (i = 0; i < tamPersonas && personas.get(i).getId() != id; i++)
			;
		if (i < tamPersonas){
			personas.get(i).setId(Persona.ID_NULL);
			return true;
		} else {
			return false;
		}
	}

}
