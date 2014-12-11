/**
 *
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;
import com.ipartek.formacion.helloweb.interfaces.IModeloCalificacion;

/**
 * Implementación para la persistencia de las personas
 *
 * @author Curso
 *
 */
public class ModeloCalificacion implements IModeloCalificacion {

	// TODO implementar BBDD
	static ArrayList<Calificacion> calificaciones = null;

	public static void createTable() {
		calificaciones = new ArrayList<Calificacion>();

		final Calificacion c1 = new Calificacion(0, "Muy Deficiente");
		c1.setId(0);
		calificaciones.add(c1);

		final Calificacion c2 = new Calificacion(1, "Muy Deficiente");
		c2.setId(1);
		calificaciones.add(c2);

		final Calificacion c3 = new Calificacion(2, "Insuficiente");
		c3.setId(2);
		calificaciones.add(c3);

		final Calificacion c4 = new Calificacion(3, "Insuficiente");
		c4.setId(3);
		calificaciones.add(c4);

		final Calificacion c5 = new Calificacion(4, "Insuficiente");
		c5.setId(4);
		calificaciones.add(c5);

		final Calificacion c6 = new Calificacion(5, "Suficiente");
		c6.setId(5);
		calificaciones.add(c6);

		final Calificacion c7 = new Calificacion(6, "Bien");
		c7.setId(6);
		calificaciones.add(c7);

		final Calificacion c8 = new Calificacion(7, "Notable");
		c8.setId(7);
		calificaciones.add(c8);

		final Calificacion c9 = new Calificacion(8, "Notable");
		c9.setId(8);
		calificaciones.add(c9);

		final Calificacion c10 = new Calificacion(9, "Sobresaliente");
		c10.setId(9);
		calificaciones.add(c10);

		final Calificacion c11 = new Calificacion(10, "Matrícula");
		c11.setId(10);
		calificaciones.add(c11);
	}

	static void truncateTable() {
		calificaciones = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.interfaces.IModeloCalificacion#getAll()
	 */
	public ArrayList<Calificacion> getAll() {
		ArrayList<Calificacion> calificacionesLogicas = null;

		if (calificaciones != null) {
			calificacionesLogicas = new ArrayList<Calificacion>();
			for (final Calificacion calificacion : calificaciones) {
				if (calificaciones != null) {
					calificacionesLogicas.add(calificacion);
				}
			}

			// Si todos están borrados lógicamente
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
	 * com.ipartek.formacion.helloweb.interfaces.IModeloCalificacion#getById()
	 */
	public Calificacion getById(final int id) {
		Calificacion res = null;

		for (final Calificacion calificacion : calificaciones) {
			if (calificacion != null) {
				if (calificacion.getId() == id) {
					res = calificacion;
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
	public int insert(final Calificacion c) {
		int res = Calificacion.ID_NULL;

		if (calificaciones == null) {
			calificaciones = new ArrayList<Calificacion>();
		}

		if (c != null) {
			c.setId(calificaciones.size());
			res = calificaciones.size();
			calificaciones.add(c);
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ipartek.formacion.helloweb.interfaces.IModeloCalificacion#update(
	 * com.ipartek .formacion.helloweb.bean.Persona)
	 */
	public int update(final Calificacion c) {
		int res = Calificacion.ID_NULL;

		if (c != null) {
			calificaciones.set(c.getId(), c);
			res = c.getId();
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.ipartek.formacion.helloweb.interfaces.IModeloCalificacion#delete(int)
	 */
	public boolean delete(final int id) {
		boolean res = false;

		try {
			if (calificaciones != null) {
				if (getById(id) != null) {
					calificaciones.set(id, null);
					res = true;
				}
			}
		} catch (final Exception e) {
			System.out.println("No existe el id.");
		}
		return res;
	}
}
