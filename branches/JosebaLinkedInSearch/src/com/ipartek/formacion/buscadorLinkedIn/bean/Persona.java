package com.ipartek.formacion.buscadorLinkedIn.bean;

public class Persona {

    private String nombre;
    private String apellidos;
    private String urlImagen;

    public Persona(String nombre, String apellidos) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
    }

    public Persona(String nombre, String apellidos, String urlImagen) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.urlImagen = urlImagen;
    }

    public String getNombre() {
	return nombre;
    }

    public String getApellidos() {
	return apellidos;
    }

    public String getUrlImagen() {
	return urlImagen;
    }

}
