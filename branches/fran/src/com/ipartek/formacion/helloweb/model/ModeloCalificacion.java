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

	static ArrayList<Calificacion> calificaciones = null;
	static int indiceMax = 0;

	public static void createTable() {
		calificaciones = new ArrayList<Calificacion>();
		Calificacion c = new Calificacion(0, 0, "Muy Deficiente");
		calificaciones.add(c);
		c = new Calificacion(1, 1, "Muy Deficiente");
		calificaciones.add(c);
		c = new Calificacion(2, 2, "Muy Deficiente");
		calificaciones.add(c);
		c = new Calificacion(3, 3, "Insuficiente");
		calificaciones.add(c);
		c = new Calificacion(4, 4, "Insuficiente");
		calificaciones.add(c);
		c = new Calificacion(5, 5, "Suficiente");
		calificaciones.add(c);
		c = new Calificacion(6, 6, "Bien");
		calificaciones.add(c);
		c = new Calificacion(7, 7, "Notable");
		calificaciones.add(c);
		c = new Calificacion(8, 8, "Notable");
		calificaciones.add(c);
		c = new Calificacion(9, 9, "Sobresaliente");
		calificaciones.add(c);
		c = new Calificacion(10, 10, "Matricula");
		calificaciones.add(c);
		indiceMax = 9;
	}

	public static void truncateTable() {
		calificaciones = null;
		indiceMax = 0;
	}

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

	public Calificacion getById(int id) {
		Calificacion c = null;
		for (Calificacion calif : calificaciones) {
			if (calif.getId() == id) {
				c = calif;
			}
		}
		return c;
	}

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

	public boolean delete(int i) {
		boolean resul = false;
		int index = 0;
		for (Calificacion calif : calificaciones) {
			if (calif.getId() == i) {
				calificaciones.set(index, null);
				resul = true;
			}
			index++;
		}
		return resul;
	}

}
