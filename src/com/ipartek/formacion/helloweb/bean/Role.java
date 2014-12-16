package com.ipartek.formacion.helloweb.bean;

import java.util.ArrayList;

/**
 * Clase del objeto role.
 *
 * @author Fila-2
 *
 */
public class Role {

	/**
	 * Identificador null del objeto.
	 */
	public static final int ID_NULL = -1;

	/**
	 * Estado por defecto del borrado del objeto.
	 */
	public static final boolean BORRADO_DEFAULT = false;

	/**
	 * Descripción por defecto del objeto.
	 */
	public static final String DESC_NULL = "";

	/**
	 * Identificador del objeto.
	 */
	private int id;

	/**
	 * Nombre del objeto.
	 */
	private String nombre;

	/**
	 * Descripción del objeto.
	 */
	private String descripcion = DESC_NULL;

	/**
	 * Estado borrado del objeto.
	 */
	private boolean borrado = BORRADO_DEFAULT;

	/**
	 * Constructor del objeto.
	 *
	 * @param lNombre
	 *            String nombre del objeto
	 * @param lDescripcion
	 *            String descripción del objeto
	 */
	public Role(final String lNombre, final String lDescripcion) {
		super();
		this.nombre = lNombre;
		this.descripcion = lDescripcion;
	}

	/**
	 * Constructor del objeto.
	 *
	 * @param lNombre
	 *            String nombre del objeto
	 */
	public Role(final String lNombre) {
		super();
		this.nombre = lNombre;
	}

	/**
	 * Obtiene el identificador del objeto.
	 *
	 * @return Integer con el identificador del objeto
	 */
	public final int getId() {
		return id;
	}

	/**
	 * Añade identificador al objeto.
	 *
	 * @param ident
	 *            Integer identificador del objeto
	 */
	public final void setId(final int ident) {
		this.id = ident;
	}

	/**
	 * Obtiene el nombre del objeto.
	 *
	 * @return String con el nombre del objeto
	 */
	public final String getNombre() {
		return nombre;
	}

	/**
	 * Añade un nombre al objeto.
	 *
	 * @param lNombre
	 *            String nombre del objeto
	 */
	public final void setNombre(final String lNombre) {
		this.nombre = lNombre;
	}

	/**
	 * Devuelve el texto del objeto.
	 *
	 * @return String texto del objeto
	 */
	public final String getDescripcion() {
		return descripcion;
	}

	/**
	 * Añade una descripción al objeto.
	 *
	 * @param lDescripcion
	 *            Descripción del objeto
	 */
	public final void setDescripcion(final String lDescripcion) {
		this.descripcion = lDescripcion;
	}

	@Override
	public final String toString() {
		return nombre;
	}

	/**
	 * Borra o recupera el objeto.
	 *
	 * @param lBorrado
	 *            True borra el objeto, false, lo recupera
	 */
	public final void setBorrado(final boolean lBorrado) {
		this.borrado = lBorrado;
	}

	/**
	 * Comprueba si el objeto está borrado.
	 *
	 * @return true si está borrado y false si no
	 */
	public final boolean isBorrado() {
		return borrado;
	}

	public static ArrayList<String> getNombreRolesList(final ArrayList<Role> roles) {
		final ArrayList<String> nombreRoles = new ArrayList<String>();
		for (final Role rol : roles) {
			nombreRoles.add(rol.getNombre());
		}
		return nombreRoles;
	}

	public static ArrayList<String> getIdRolesList(final ArrayList<Role> roles) {
		final ArrayList<String> idRoles = new ArrayList<String>();
		for (final Role rol : roles) {
			idRoles.add(String.valueOf(rol.getId()));
		}
		return idRoles;
	}

}
