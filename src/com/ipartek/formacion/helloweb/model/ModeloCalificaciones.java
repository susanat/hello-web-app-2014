package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificaciones;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloCalificaciones;

public class ModeloCalificaciones implements IModeloCalificaciones {

    // TODO implementar en la BBDD
    // Creo primeramente el array que me recoja todas las posibles notas y sus
    // descripciones
    static ArrayList<Calificaciones> calificaciones = null;

    // Creamos las tablas a mano
    public static void createTableCalificacion() {

	// Inicialiazo el arrayList
	calificaciones = new ArrayList<Calificaciones>();
	// creo las nuevas notas indicandolas una a una
	// 0
	Calificaciones c = new Calificaciones("");
	c.setId(0);
	c.setNota(0);
	c.setDescripcionNota("Muy deficiente");

	// 1
	c = new Calificaciones("");
	c.setId(1);
	c.setNota(1);
	c.setDescripcionNota("Muy deficiente");

	// 2
	c = new Calificaciones("");
	c.setId(2);
	c.setNota(2);
	c.setDescripcionNota("Muy deficiente");

	// 3
	c = new Calificaciones("");
	c.setId(3);
	c.setNota(3);
	c.setDescripcionNota("Insuficiente");

	// 4
	c = new Calificaciones("");
	c.setId(4);
	c.setNota(4);
	c.setDescripcionNota("Insuficiente");

	// 5
	c = new Calificaciones("");
	c.setId(5);
	c.setNota(5);
	c.setDescripcionNota("Suficiente");

	// 6
	c = new Calificaciones("");
	c.setId(6);
	c.setNota(6);
	c.setDescripcionNota("Bien");

	// 7
	c = new Calificaciones("");
	c.setId(7);
	c.setNota(7);
	c.setDescripcionNota("Notable");

	// 8
	c = new Calificaciones("");
	c.setId(8);
	c.setNota(8);
	c.setDescripcionNota("Notable");

	// 9
	c = new Calificaciones("");
	c.setId(9);
	c.setNota(9);
	c.setDescripcionNota("Sobresaliente");

	// 10
	c = new Calificaciones("");
	c.setId(10);
	c.setNota(10);
	c.setDescripcionNota("Matricula de Honor");

    }

    // Para resetar todos los valores

    static void truncateTableCalificaciones() {
	calificaciones = null;
    }

    // Recogemos todas las Calificaciones esto luego lo indicamos en la
    // ImodeloCalificaciones

    public ArrayList<Calificaciones> getAll() {
	ArrayList<Calificaciones> calificacionesordenadas = null;
	if (calificacionesordenadas != null) {
	    calificacionesordenadas = new ArrayList<Calificaciones>();
	    for (Calificaciones c : calificacionesordenadas) {
		if (c != null) {
		    calificacionesordenadas.add(c);
		}
	    }

	    // Si todos estan borrados logicamente
	    if (calificacionesordenadas.isEmpty()) {
		calificacionesordenadas = null;
	    }
	}
	return calificacionesordenadas;
    }

    // Recojo las calificaciones por ID

    public Calificaciones getById(int id) {
	Calificaciones resul = null;
	if (calificaciones != null) {
	    for (Calificaciones c : calificaciones) {
		if (c != null) {
		    if (c.getId() == id) {
			resul = c;
			break;
		    }
		}
	    }
	}
	return resul;
    }

    // Inserto una nueva calificacion sino hay ningun ID ninguna nota

    public int insertCalificacion(Calificaciones c) {
	int resul = Calificaciones.ID_NULL;

	if (calificaciones == null) {
	    calificaciones = new ArrayList<Calificaciones>();
	}

	if (c != null) {
	    calificaciones.add(c);
	    c.setId((calificaciones.size() - 1));
	    resul = (calificaciones.size() - 1);
	}

	return resul;
    }

    // Para recuperar una calificacion

    // //Para borrar una calificacion

}
