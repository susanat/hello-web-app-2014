/**
 *
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloCalifiacion;

/**
 * Implementacion para la Persistencia de las Personas
 *
 * @author ur00
 *
 */
public class ModeloCalificacion implements IModeloCalifiacion {

    // TODO implementar base BBDD
    public static ArrayList<Calificacion> calificaciones = null;

    public static void createTable() {
	calificaciones = new ArrayList<Calificacion>();

	Calificacion cal = new Calificacion(0, "Muy Deficiente");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(1, "Muy Deficiente");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(2, "Muy Deficiente");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(3, "Insuficiente");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(4, "Insuficiente");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(5, "Suficiente");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(6, "Bien");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(7, "Notable");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(8, "Notable");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(9, "Sobresaliente");
	cal.setId(1);
	calificaciones.add(cal);

	cal = new Calificacion(10, "Matricula");
	cal.setId(1);
	calificaciones.add(cal);
    }

    static void truncateTable() {
	calificaciones = null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getAll()
     */
    public ArrayList<Calificacion> getAll() {
	ArrayList<Calificacion> calificacionesLogicas = null;
	if (calificaciones != null) {
	    calificacionesLogicas = new ArrayList<Calificacion>();
	    for (Calificacion c : calificaciones) {
		if (c != null) {
		    calificacionesLogicas.add(c);
		}
	    }

	    // Si todos estan borrados logicamente
	    if (calificacionesLogicas.isEmpty()) {
		calificacionesLogicas = null;
	    }
	}
	return calificacionesLogicas;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getById()
     */
    public Calificacion getById(int id) {
	Calificacion resul = null;
	if (calificaciones != null) {
	    for (Calificacion p : calificaciones) {
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
    public int insert(Calificacion p) {
	int resul = Calificacion.ID_NULL;

	if (calificaciones == null) {
	    calificaciones = new ArrayList<Calificacion>();
	}

	if (p != null) {
	    calificaciones.add(p);
	    p.setId(calificaciones.size() - 1);
	    resul = calificaciones.size() - 1;
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
    public int update(Calificacion p) {
	int resul = Calificacion.ID_NULL;
	if (calificaciones != null) {
	    calificaciones.set(p.getId(), p);
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
	    if (calificaciones != null) {
		if (getById(id) != null) {
		    calificaciones.set(id, null);
		    resul = true;
		}
	    }
	} catch (Exception e) {
	    // TODO traza de Log
	    System.out.print("No existe el ID[" + id + "] queremos eliminar");
	}
	return resul;
    }

}
