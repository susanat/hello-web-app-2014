package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.util.Rol;

public class Persona {
    private String nombre;
    private int edad;
    private Rol rol;

    public Persona(String nombre, int edad) {
	super();
	setNombre(nombre);
	setEdad(edad);
	this.rol = Rol.USUARIO;
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

}
