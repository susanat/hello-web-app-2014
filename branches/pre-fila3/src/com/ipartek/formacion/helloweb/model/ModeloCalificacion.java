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
	static ArrayList<Calificacion> calificacion = null;
	/**
	 * Indice del último registro
	 */
	static int indiceMax = 0;

	/**
	 * Crear tabla base
	 */
	public static void createTable() {
		calificacion = new ArrayList<Calificacion>();
		Calificacion c = new Calificacion(0, "Muy Deficiente");
		c.setId(0);
		calificacion.add(c);
		c = new Calificacion(1, "Muy Deficiente");
		c.setId(1);
		calificacion.add(c);
		c = new Calificacion(2, "Muy Deficiente");
		c.setId(2);
		calificacion.add(c);
		c = new Calificacion(3, "Insuficiente");
		c.setId(3);
		calificacion.add(c);
		c = new Calificacion(4, "Insuficiente");
		c.setId(4);
		calificacion.add(c);
		c = new Calificacion(5, "Suficiente");
		c.setId(5);
		calificacion.add(c);
		c = new Calificacion(6, "Bien");
		c.setId(6);
		calificacion.add(c);
		c = new Calificacion(7, "Notable");
		c.setId(7);
		calificacion.add(c);
		c = new Calificacion(8, "Notable");
		c.setId(8);
		calificacion.add(c);
		c = new Calificacion(9, "Sobresaliente");
		c.setId(9);
		calificacion.add(c);
		c = new Calificacion(10, "Matricula");
		c.setId(10);
		calificacion.add(c);
		indiceMax = 11;
	}

	static void truncateTable() {
		calificacion = null;
	}

	public ArrayList<Calificacion> getAll() {
		ArrayList<Calificacion> calificaAuxi = null;
		if (calificacion != null) {
			calificaAuxi = new ArrayList<Calificacion>();
			for (Calificacion c : calificacion) {
				if (c != null) {
					calificaAuxi.add(c);
				}
			}

			// Si todos estan borrados logicamente
			if (calificaAuxi.isEmpty()) {
				calificaAuxi = null;
			}
		}
		return calificaAuxi;
	}

	public Calificacion getById(int id) {
		Calificacion resul = null;
		if (calificacion != null) {
			for (Calificacion c : calificacion) {
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

	public int insert(Calificacion c) {
		int resul = Calificacion.ID_NULL;

		if (calificacion == null) {
			calificacion = new ArrayList<Calificacion>();
		}

		if (c != null) {
			calificacion.add(c);
			c.setId(calificacion.size());
			resul = calificacion.size();
		}

		return resul;
	}

	public int update(Calificacion c) {
		int resul = Calificacion.ID_NULL;
		if (calificacion != null) {
			calificacion.set((c.getId() - 1), c);
			resul = c.getId();
		}
		return resul;
	}

	public boolean delete(int id) {
		boolean resul = false;
		try {
			if (calificacion != null) {
				if (getById(id) != null) {
					calificacion.set((id - 1), null);
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
