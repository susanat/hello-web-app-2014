/**
 *
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.interfaces.IModeloPersona;

/**
 * Implementación para la persistencia de las personas
 *
 * @author Curso
 *
 */
public class ModeloPersona implements IModeloPersona {

	// TODO implementar BBDD
	static ArrayList<Persona> personas = null;

	static void createTable() {
		personas = new ArrayList<Persona>();

		final Persona p1 = new Persona("Gorriti");
		p1.setId(1);
		personas.add(p1);

		final Persona p2 = new Persona("Antton");
		p2.setId(2);
		personas.add(p2);

		final Persona p3 = new Persona("Pirulero");
		p3.setId(3);
		personas.add(p3);

		final Persona p4 = new Persona("Duquesita");
		p4.setId(4);
		personas.add(p4);

		final Persona p5 = new Persona("Manoli");
		p5.setId(5);
		personas.add(p5);
	}

	static void truncateTable() {
		personas = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ipartek.formacion.helloweb.interfaces.IModeloPersona#getAll()
	 */
	public ArrayList<Persona> getAll() {
		ArrayList<Persona> personasLogicas = null;

		if (personas != null) {
			personasLogicas = new ArrayList<Persona>();
			for (final Persona persona : personas) {
				if (persona != null) {
					personasLogicas.add(persona);
				}
			}

			// Si todos están borrados lógicamente
			if (personasLogicas.isEmpty()) {
				personasLogicas = null;
			}
		}
		return personasLogicas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ipartek.formacion.helloweb.interfaces.IModeloPersona#getById()
	 */
	public Persona getById(final int id) {
		Persona res = null;

		for (final Persona persona : personas) {
			if (persona != null) {
				if (persona.getId() == id) {
					res = persona;
				}
			}
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.interfaces.IModeloPersona#insert(com.ipartek
	 * .formacion.helloweb.bean.Persona)
	 */
	public int insert(final Persona p) {
		int res = Persona.ID_NULL;

		if (p != null && personas != null) {
			p.setId(personas.size() + 1);
			personas.add(p);
			res = p.getId();
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.interfaces.IModeloPersona#update(com.ipartek
	 * .formacion.helloweb.bean.Persona)
	 */
	public int update(final Persona p) {
		int res = Persona.ID_NULL;

		if (p != null && p.getId() <= personas.size()) {
			personas.set(p.getId(), p);
			res = personas.get(p.getId()).getId();
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ipartek.formacion.helloweb.interfaces.IModeloPersona#delete(int)
	 */
	public boolean delete(final int id) {
		boolean res = false;

		try {
			if (personas != null) {
				if (getById(id) != null) {
					personas.set(id - 1, null);
					res = true;
				}
			}
		} catch (final Exception e) {
			System.out.println("No existe el id.");
		}
		return res;
	}
}
