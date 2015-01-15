package com.ipartek.formacion.buscarpersonas.bean;

public class Persona {
    private int codigo;
    private String nombre;
    private String apellidos;
    private int edad;
    private String foto;
    private String info_basic;
    private String info_expanded;

    public Persona() {
	this.codigo = -1;
	this.nombre = null;
	this.apellidos = null;
	this.foto = null;
    }

    public Persona(final int codigo) {
	this.codigo = codigo;
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

    public Persona(final int id, final String nombre, final String apellidos,
	    final int edad, final String url_foto) {
	super();
	this.codigo = id;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.edad = edad;
	this.foto = url_foto;
    }

    public Persona(final int id, final String nombre, final String apellidos,
	    final int edad, final String url_foto, final String basic,
	    final String expanded) {
	super();
	this.codigo = id;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.edad = edad;
	this.foto = url_foto;
	this.info_basic = basic;
	this.info_expanded = expanded;

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

    public int getEdad() {
	return edad;
    }

    public void setEdad(final int edad) {
	this.edad = edad;
    }

    public String getInfo_basic() {
	return info_basic;
    }

    public void setInfo_basic(final String info_basic) {
	this.info_basic = info_basic;
    }

    public String getInfo_expanded() {
	return info_expanded;
    }

    public void setInfo_expanded(final String info_expanded) {
	this.info_expanded = info_expanded;
    }

}
