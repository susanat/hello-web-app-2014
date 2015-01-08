package com.ipartek.formacion.buscadorLinkedIn.bean;

public class Persona {

    private String nombre;
    private String apellidos;

    public Persona(String nombre, String apellidos) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
    }

    public String getNombre() {
	return nombre;
    }

    public String getApellidos() {
	return apellidos;
    }

}
