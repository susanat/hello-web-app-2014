package com.ipartek.formacion.buscadorLinkedIn.bean;

public class Persona {

    private String nombre;
    private String apellidos;
    private String urlImagen;
    private int id;

    public Persona() {
	super();
    }

    public Persona(String nombre, String apellidos) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;

    }

    public Persona(String nombre, String apellidos, int id) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.id = id;
    }

    public Persona(String nombre, String apellidos, String urlImagen) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.urlImagen = urlImagen;

    }

    public Persona(String nombre, String apellidos, String urlImagen, int id) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.urlImagen = urlImagen;
	this.id = id;
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

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
    }

    public void setUrlImagen(String urlImagen) {
	this.urlImagen = urlImagen;
    }

    public int getId() {
	return id;
    }

}
