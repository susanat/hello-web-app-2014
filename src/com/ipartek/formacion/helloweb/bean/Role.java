package com.ipartek.formacion.helloweb.bean;

public class Role {

	private int id;
	private String nombre;
	private String descripcion = DESC_NULL;
	private boolean borrado = BORRADO_DEFAULT;

	public static final int ID_NULL = -1;
	public static final boolean BORRADO_DEFAULT = false;
	public static final String DESC_NULL = "";

	public Role(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;		

	}

	public Role(String nombre) {
		super();
		this.nombre = nombre;
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

	/**
	 * Borra o recupera el objeto
	 * @param borrado True borra el objeto, false, lo recupera
	 */
	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	/**
	 * Comprueba si el objeto está borrado 
	 * @return
	 */
	public boolean isBorrado() {
		return borrado;
	}



}
