package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloCalificacion;

/**
 * Implementación sobre estructuras de datos de la interfaz
 * <code>IModeloCalificacion</code>.
 * 
 * @author Fran
 *
 */
public class ModeloCalificacion implements IModeloCalificacion {

	/**
	 * Lista de registros de la bbdd
	 */
	static ArrayList<Calificacion> calificaciones = null;
	/**
	 * Indice del último registro
	 */
	static int indiceMax = 0;

	/**
	 * Crear tabla base
	 */
	public static void createTable() {
		calificaciones = new ArrayList<Calificacion>();
		Calificacion c = new Calificacion(0, "Muy Deficiente");
		c.setId(0);
		calificaciones.add(c);
		c = new Calificacion(1, "Muy Deficiente");
		c.setId(1);
		calificaciones.add(c);
		c = new Calificacion(2, "Muy Deficiente");
		c.setId(2);
		calificaciones.add(c);
		c = new Calificacion(3, "Insuficiente");
		c.setId(3);
		calificaciones.add(c);
		c = new Calificacion(4, "Insuficiente");
		c.setId(4);
		calificaciones.add(c);
		c = new Calificacion(5, "Suficiente");
		c.setId(5);
		calificaciones.add(c);
		c = new Calificacion(6, "Bien");
		c.setId(6);
		calificaciones.add(c);
		c = new Calificacion(7, "Notable");
		c.setId(7);
		calificaciones.add(c);
		c = new Calificacion(8, "Notable");
		c.setId(8);
		calificaciones.add(c);
		c = new Calificacion(9, "Sobresaliente");
		c.setId(9);
		calificaciones.add(c);
		c = new Calificacion(10, "Matricula");
		c.setId(10);
		calificaciones.add(c);
		indiceMax = 11;
	}

	/**
	 * Limpiar bbdd
	 */
	public static void truncateTable() {
		calificaciones = null;
		indiceMax = 0;
	}

	/**
	 * Obtener tabla completa
	 */
	public ArrayList<Calificacion> getAll() {
		ArrayList<Calificacion> al = new ArrayList<Calificacion>();
		if (calificaciones == null || calificaciones.size() == 0) {
			al = null;
		} else {
			for (Calificacion calif : calificaciones) {
				al.add(calif);
			}
		}
		return al;
	}

	/**
	 * Obtener un registro de la tabla
	 */
	public Calificacion getById(int id) {
		Calificacion c = null;
		for (Calificacion calif : calificaciones) {
			if (calif.getId() == id) {
				c = calif;
			}
		}
		return c;
	}

	/**
	 * Insertar un registro en la tabla
	 */
	public int insert(Calificacion c) {
		int resul = -1;
		if (c != null) {
			if (calificaciones == null) {
				calificaciones = new ArrayList<Calificacion>();
				indiceMax = 0;
			}

			int indice = indiceMax + 1;
			c.setId(indice);
			calificaciones.add(c);
			indiceMax++;
			resul = indice;
		}
		return resul;
	}

	/**
	 * Actualizar un registro
	 */
	public int update(Calificacion c) {
		int resul = -1;
		if (c != null) {
			int index = 0;
			for (Calificacion calif : calificaciones) {
				if (calif.getId() == c.getId()) {
					calificaciones.set(index, c);
					resul = c.getId();
				}
				index++;
			}
		}
		return resul;
	}

	/**
	 * Borrar un registro
	 */
	public boolean delete(int i) {
		boolean resul = false;
		try {
			if (calificaciones != null) {
				if (getById(i) != null) {
					calificaciones.set(i, null);
					resul = true;
				}
			}
		} catch (Exception e) {
			// TODO traza de Log
			System.out.print("No existe el ID[" + i + "] queremos eliminar");
		}
		return resul;
	}
}
