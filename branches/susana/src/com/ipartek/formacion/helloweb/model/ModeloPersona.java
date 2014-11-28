/**
 * 
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;

/**
 * Implementacion para la persistencia de las Personas
 * 
 * @author Curso
 *
 */
public class ModeloPersona implements IModeloPersona {

    // TODO implementar BBDD

    static ArrayList<Persona> personas = null;

    static void createTable() {
	personas = new ArrayList<Persona>();

	Persona p = new Persona("");

	p = new Persona("");
	p.setNombre("Gorriti");
	p.setId(1);
	personas.add(p);

	p = new Persona("");
	p.setNombre("Antton");
	p.setId(2);
	personas.add(p);

	p = new Persona("");
	p.setNombre("Pirulero");
	p.setId(3);
	personas.add(p);

	p = new Persona("");
	p.setNombre("Duquesita");
	p.setId(4);
	personas.add(p);

	p = new Persona("");
	p.setNombre("Manoli");
	p.setId(5);
	personas.add(p);

    }

    public ModeloPersona() {
	// TODO Auto-generated constructor stub
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
	    for (Persona p : personas) {
		if (p != null) {
		    personasLogicas.add(p);
		}
	    }
	    return personasLogicas;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getByID()
     */
    public Persona getByID(int id) {
	// como nos tenia que dar null al final
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
	return null;
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

	// persona es nula existe o no devolvemos el resul
	if (personas == null) {
	    personas = new ArrayList<Persona>();
	}

	if (p != null) {
	    personas.add(p);
	    p.setId(personas.size());
	    resul = personas.size();
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
	try {
	    if (personas != null) {
		if (getByID(id) != null) {
		    personas.set(id, null);
		    resul = true;
		}
	    }
	} catch (Exception e) {
	    // TODO traza de log
	    System.out.print("No existe el ID[" + id
		    + "] que queremos eliminar");
	}
	return false;

    }

}
