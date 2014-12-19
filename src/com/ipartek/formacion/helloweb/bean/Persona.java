package com.ipartek.formacion.helloweb.bean;

public class Persona {

	private int id;
	private String nombre;
	private int edad;
	private Rol rol;
	
	public static final int ID_NULL = -1;	
	public static final int EDAD_NULL = 0;

	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		this.edad = EDAD_NULL;
		this.rol = Rol.USER;
		this.id = ID_NULL;
	}
	
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.rol = Rol.USER;
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

	/**
	 * Enumeracion para los Roles de las Personas
	 */
	public enum Rol {
		 ADMINISTRADOR, USER;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", rol=" + rol + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
}
