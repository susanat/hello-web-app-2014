package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.util.Rol;

public class Persona {

	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;

	private int id;
	private String nombre;
	private int edad;
	private Rol rol;

	public Persona(final String nombre, final int edad, final Rol rol) {
		super();
		setNombre(nombre);
		setEdad(edad);
		setRol(rol);
		this.id = ID_NULL;
	}

	public Persona(final String nombre, final Rol rol) {
		super();
		setNombre(nombre);
		setEdad(EDAD_NULL);
		setRol(rol);
		this.id = ID_NULL;
	}

	public Persona(final String nombre) {
		super();
		setNombre(nombre);
		setEdad(EDAD_NULL);
		setRol(Rol.INVITADO);
		this.id = -1;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(final int edad) {
		this.edad = edad;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(final Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "rol = " + rol + ", nombre = " + nombre + ", edad = " + edad;
	}
}
