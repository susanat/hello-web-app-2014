package com.ipartek.formacion.helloweb.bean;

public class Persona {

	private String nombre;
	private int edad;
	private Rol rol;
	
	

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.rol = Rol.USER;
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
	
	/**
	 * Enumeracion para los Roles de las Personas
	 */
	public enum Rol {
		 ADMINISTRADOR, USER;
	}
	
}
