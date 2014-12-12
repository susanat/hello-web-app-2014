package com.ipartek.formacion.helloweb.bean;

/**
 * Clase para representar una calificacion.
 * 
 * @author Fran
 *
 */
public class Calificacion {
	private int id;
	private int clave;
	private String descripcion;

	/**
	 * Valor por defecto en el id
	 */
	public static final int ID_NULL = -1;

	/**
	 * Constructor
	 * 
	 * @param clave
	 *            {@code Int} valor de la calificación.
	 * @param descripcion
	 *            {@code String} descripcion de la calificación
	 */
	public Calificacion(int clave, String descripcion) {
		super();
		this.id = ID_NULL;
		this.clave = clave;
		this.descripcion = descripcion;
	}

	public Calificacion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
