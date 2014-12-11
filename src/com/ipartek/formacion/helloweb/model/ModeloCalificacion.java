package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloCalificacion;

public class ModeloCalificacion implements IModeloCalificacion {

	// TODO implementar base BBDD
	static ArrayList<Calificacion> calificacion = null;

	public static void createTable() {
		calificacion = new ArrayList<Calificacion>();
		Calificacion c = new Calificacion();
		c.setId(1);
		c.setValor("7");
		c.setDescripcion("Notable");

		c = new Calificacion();
		c.setId(2);
		c.setValor("5");
		c.setDescripcion("Suficiente");

		c = new Calificacion();
		c.setId(3);
		c.setValor("9");
		c.setDescripcion("Sobresaliente");

		c = new Calificacion();
		c.setId(4);
		c.setValor("3");
		c.setDescripcion("Insuficiente");

		c = new Calificacion();
		c.setId(5);
		c.setValor("6");
		c.setDescripcion("Bien");

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
