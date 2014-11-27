package com.ipartek.formacion.helloweb.bean;

public class Persona {
	private String nombre;
	private int edad;
	private String password;
	
	//Constructor
	public Persona(String nombre, int edad) {
		super();
		setNombre(nombre);
		setEdad(edad);
	}

	// Getters & Setters
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

	
}
