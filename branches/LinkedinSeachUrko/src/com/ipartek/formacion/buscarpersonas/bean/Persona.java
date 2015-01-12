package com.ipartek.formacion.buscarpersonas.bean;

public class Persona {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String foto;

    public Persona() {
	this.codigo = -1;
	this.nombre = null;
	this.apellidos = null;
	this.foto = null;
    }

    public Persona(final String nombre, final String apellidos) {
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.foto = null;
    }

    public Persona(final String nombre, final String apellidos,
	    final String foto) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.foto = foto;

    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    public String getApellidos() {
	return apellidos;
    }

    public void setApellidos(final String apellidos) {
	this.apellidos = apellidos;
    }

    public String getFoto() {
	return foto;
    }

    public void setFoto(final String foto) {
	this.foto = foto;
    }

    public String getHTML() {
	return this.nombre + " " + this.apellidos + " " + "<img src='"
		+ this.foto + "' >";
    }

    public void setCodigo(final int codigo) {
	this.codigo = codigo;
    }

    public int getCodigo() {
	return codigo;
    }

}
