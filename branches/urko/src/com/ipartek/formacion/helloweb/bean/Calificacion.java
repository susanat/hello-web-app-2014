package com.ipartek.formacion.helloweb.bean;

public class Calificacion {
    private int id;
    private String nombre;

    public Calificacion() {
	this.id = 0;
	this.nombre = "";
    }

    public Calificacion(final int id, final String nombre) {
	super();
	this.id = id;
	this.nombre = nombre;
    }

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }
}
