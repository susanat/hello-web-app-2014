package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.bean.Persona;
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
		p.setId(1);
		personas.add(p);

		p.setNombre("Antxon");
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

		p.setNombre("Tashi");
		p.setId(6);
		personas.add(p);

	}

	public static void truncateTable() {

	}

	public ArrayList<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona getById() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Persona getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
