package com.ipartek.formacion.helloweb.bean;

public class Persona {
	
	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;
	
	private int id = ID_NULL;
	
	private String nombre;
	
	private int edad = EDAD_NULL;
	
	private Roles rol;

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
	
	public Persona() {
		
	}

	public Persona(int id, String nombre, int edad, Roles rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.rol = rol;
	}

	public Persona(String nombre, int edad, Roles rol) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.rol = rol;
	}

	@Override
	public String toString() {
		
		return this.nombre;
	}
	
	
		
	
}
