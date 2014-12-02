package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.Rol;

public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private Rol rol;

    public static final int ID_NULL = -1;
    public static final int EDAD_NULL = 0;

    public Persona(String nombre) {
	super();
	setNombre(nombre);
	setEdad(EDAD_NULL);
	setRol(Rol.USUARIO);
	this.id = ID_NULL;
    }

    public Persona(String nombre, int edad, Rol rol) {
	super();
	setNombre(nombre);
	setEdad(edad);
	setRol(rol);
	this.id = ID_NULL;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(int edad) {
	this.edad = edad;
    }

    public Rol getRol() {
	return rol;
    }

    public void setRol(Rol rol) {
	this.rol = rol;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return "Persona [id=" + id + ", rol=" + rol + ", nombre=" + nombre
		+ ", edad=" + edad + "]";
    }

}
