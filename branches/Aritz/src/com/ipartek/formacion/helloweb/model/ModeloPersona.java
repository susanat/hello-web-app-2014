package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;

/**
 * Implementaciode para la persistencia de las personas
 *
 * @author Aritz Tellaeche
 *
 */
public class ModeloPersona implements IModeloPersona {

	// TODO implementar bbdd

	static ArrayList<Persona> personas = null;

	public static void createTable() {

		personas = new ArrayList<Persona>();
		Persona p = new Persona("");
		p.setNombre("Gorriti");
		p.setId(0);
		personas.add(p);

		p = new Persona("");
		p.setNombre("Antxon");
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

		p = new Persona("");
		p.setNombre("Tashi");
		p.setId(5);
		personas.add(p);

	}

	public static void truncateTable() {

	}

	public ArrayList<Persona> getAll() {

		ArrayList<Persona> personasLogicas = null;

		if (personas != null) {
			personasLogicas = new ArrayList<Persona>();
			for (Persona p : personas) {
				if (p != null) {
					personasLogicas.add(p);
				}
			}
			// Si todos estan borrados logicamente
			if (personasLogicas.isEmpty()) {
				personasLogicas = null;
			}
		}

		return personasLogicas;
	}

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

	public int insert(Persona p) {

		int resul = Persona.ID_NULL;

		if (personas == null) {
			personas = new ArrayList<Persona>();
		}

		if (personas != null && p != null) {
			personas.add(p);
			p.setId(personas.size() - 1);
			resul = personas.size() - 1;
		}
		return resul;
	}

	public int update(Persona p) {

		int resul = Persona.ID_NULL;

		if (personas != null) {

			personas.set(p.getId(), p);
			resul = p.getId();
		}
		return resul;
	}

	public boolean delete(int id) {

		boolean resul = false;

		try {

			if (personas != null) {
				if (getById(id) != null) {
					personas.set(id - 1, null);
					resul = true;
				}
			}

		} catch (Exception e) {
			System.out
					.println("No existe el [" + id + "] que queremos elminar");
		}

		return resul;
	}

}
