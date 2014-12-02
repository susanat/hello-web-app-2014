package com.ipartek.formacion.helloweb.bean;

public class Persona {
	
	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;
	public static final int ROL_NULL = -1;
	
	private int id = ID_NULL;	
	private String nombre = "";	
	private int edad = EDAD_NULL;	
	private int idRol = ROL_NULL;

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

	public int getRol() {
		return idRol;
	}

	public void setRol(int idRol) {
		this.idRol = idRol;
	}
	
	public Persona() {
		
	}

	public Persona(int id, String nombre, int edad, int idRol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.idRol = idRol;
	}

	public Persona(String nombre, int edad, int idRol) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.idRol = idRol;
	}

	@Override
	public String toString() {
		
		return this.nombre;
	}
	
	
		
	
}
