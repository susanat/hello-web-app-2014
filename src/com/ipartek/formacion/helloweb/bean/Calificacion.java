package com.ipartek.formacion.helloweb.bean;

public class Calificacion {
	private int id;
	private int clave;
	private String descripcion;

	public Calificacion(int id, int clave, String descripcion) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
