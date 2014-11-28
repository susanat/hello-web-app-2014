package com.ipartek.formacion.bean;

public class Persona {

	private int id;
	private String nombre;
	private int edad;
	private Roll roll;

	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = EDAD_NULL;
		this.roll = roll.USER;
		this.id = ID_NULL;
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		this.edad = EDAD_NULL;
		this.roll = roll.USER;
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

	public Roll getRoll() {
		return roll;
	}

	public void setRoll(Roll roll) {
		this.roll = roll;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * enumeracion para los rolles de personas
	 *
	 * @author Aritz Tellaeche
	 *
	 */
	public enum Roll {
		ADMINISTRADOR, USER

	}

}
