package com.ipartek.formacion.helloweb.bean;

public class Persona {
	private int id;
	private String nombre;
	private int edad;
	private Rol role;
	private String fechaBaja;

	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		this.edad = EDAD_NULL;
		this.role = Rol.USER;
		this.setId(ID_NULL);
		this.fechaBaja = null;
	}

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.role = Rol.USER;
		this.setId(ID_NULL);
		this.fechaBaja = null;
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

	public Rol getRole() {
		return role;
	}

	public void setRole(Rol role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	/**
	 * Enumeración para los roles de persona en la aplicación web
	 * 
	 * @author Fran
	 *
	 */
	public enum Rol {
		ADMINISTRADOR, USER;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ ", role=" + role + "]";
	}
}
