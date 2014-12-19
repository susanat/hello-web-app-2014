package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.Constantes;

public class Persona {

	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;

	private int id;
	private String nombre;
	private int edad;
	private Role role;

	public Persona(final String nombre, final int edad, final Role role) {
		super();
		setNombre(nombre);
		setEdad(edad);
		setRole(role);
		this.id = ID_NULL;
	}

	public Persona(final String nombre, final Role role) {
		super();
		setNombre(nombre);
		setEdad(EDAD_NULL);
		setRole(role);
		this.id = ID_NULL;
	}

	public Persona(final String nombre) {
		super();
		setNombre(nombre);
		setEdad(EDAD_NULL);
		setRole(new Role(Constantes.ROLE_DEFAULT));
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

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Rol = " + role + ", nombre = " + nombre + ", edad = " + edad + ".";
	}
}
