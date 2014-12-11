package com.ipartek.formacion.helloweb.bean;

public class Calificacion {

	private int id;
	private String valor;
	private String descripcion;

	public static final int ID_NULL = -1;

	// Constructores

	public Calificacion(int id, String valor, String descripcion) {
		super();
		this.id = id;
		this.valor = valor;
		this.descripcion = descripcion;
	}

	public Calificacion() {
		super();
	}

	// Getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
