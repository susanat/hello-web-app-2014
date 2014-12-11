package com.ipartek.formacion.helloweb.bean;

public class Role {

    private int id;
    private String nombre;
    private String descripcion;

    public static final int ID_NULL = -1;

    public Role(String nombre, String descripcion) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
    }

    public Role(String nombre) {
	super();
	this.nombre = nombre;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    @Override
    public String toString() {
	return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion="
		+ descripcion + "]";
    }

}
