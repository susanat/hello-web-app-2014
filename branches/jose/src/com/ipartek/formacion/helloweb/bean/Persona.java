package com.ipartek.formacion.helloweb.bean;

import java.util.ArrayList;

public class Persona {

	private int id;
	private String nombre;
	private int edad;
	private Rol rol;

	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;

	// Constructor
	public Persona(String nombre) {
		super();
		setNombre(nombre);
		setEdad(EDAD_NULL);
		setRol(Rol.USER);
		setId(ID_NULL);
	}

	public Persona(String nombre, int edad) {
		super();
		setNombre(nombre);
		setEdad(edad);
		setRol(Rol.USER);
		setId(ID_NULL);
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
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ ", rol=" + rol + "]";
	}

	public ArrayList<String> getRoles() {
		ArrayList<String> lista = new ArrayList<String>();
		for (Rol auxRol : Rol.values()) {
			lista.add(auxRol.toString());
		}
		return lista;
	}

	/**
	 * Enumeracion para los Roles de las Personas
	 * 
	 * @author Curso
	 *
	 */
	public enum Rol {
		ADMINISTRADOR, USER;
	}

}
