package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;

/**
 * Implementación sobre estructuras de datos de la interfaz
 * <code>IModeloPersona</code>.
 * 
 * @author Fran
 *
 */
public class ModeloPersona implements IModeloPersona {

	static ArrayList<Persona> personas = null;
	static int indiceMax = 0;

	public static void createTable() {
		personas = new ArrayList<Persona>();
		Persona p = new Persona("");
		p.setNombre("Gorriti");
		p.setId(1);
		personas.add(p);
		p = new Persona("");
		p.setNombre("Antxon");
		p.setId(2);
		personas.add(p);
		p = new Persona("");
		p.setNombre("Pili");
		p.setId(3);
		personas.add(p);
		p = new Persona("");
		p.setNombre("Mili");
		p.setId(4);
		personas.add(p);
		indiceMax = 4;
	}

	static void truncateTable() {
		personas = null;
		indiceMax = 0;
	}

	public ArrayList<Persona> getAll() {
		ArrayList<Persona> al = new ArrayList<Persona>();
		if (personas == null || personas.size() == 0) {
			al = null;
		} else {
			for (Persona persona : personas) {
				if (persona.getFechaBaja() == null) {
					al.add(persona);
				}
			}
		}
		return al;
	}

	public Persona getById(int id) {
		Persona p = null;
		for (Persona persona : personas) {
			if (persona.getId() == id && persona.getFechaBaja() == null) {
				p = persona;
			}
		}
		return p;
	}

	public int insert(Persona p) {
		int resul = Persona.ID_NULL;
		if (p != null) {
			if (personas == null) {
				personas = new ArrayList<Persona>();
				indiceMax = 0;
			}

			int indice = indiceMax + 1;
			p.setId(indice);
			personas.add(p);
			indiceMax++;
			resul = indice;
		}
		return resul;
	}

	public int update(Persona p) {
		int resul = Persona.ID_NULL;
		if (p != null) {
			int index = 0;
			for (Persona persona : personas) {
				if (persona.getId() == p.getId()
						&& persona.getFechaBaja() == null) {
					// persona = p;
					personas.set(index, p);
					resul = p.getId();
				}
				index++;
			}
		}
		return resul;
	}

	public boolean delete(int i) {
		boolean resul = false;
		int index = 0;
		for (Persona persona : personas) {
			if (persona.getId() == i && persona.getFechaBaja() == null) {
				persona.setFechaBaja("01/01/2014");
				personas.set(index, persona);
				resul = true;
			}
			index++;
		}
		return resul;
	}

}
