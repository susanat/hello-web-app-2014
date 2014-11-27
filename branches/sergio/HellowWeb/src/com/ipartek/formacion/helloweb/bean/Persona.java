package com.ipartek.formacion.helloweb.bean;

public class Persona {

	private String nombre;
	private int edad;
	private Roles rol;
	
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
		
	public Roles getRol() {
		return rol;
	}
	public void setRol(Roles rol) {
		this.rol = rol;
	}
	public Persona(String nombre, int edad, Roles rol) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.rol = rol;
	}
	
	
}
