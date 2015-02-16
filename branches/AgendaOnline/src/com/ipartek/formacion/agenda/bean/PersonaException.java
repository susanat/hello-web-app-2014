package com.ipartek.formacion.agenda.bean;

public class PersonaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String NOMBRE_EMPTY = "El nombre del Contacto es obligatorio";
	public static final String NOMBRE_INVALID_CHAR = "El nombre del Contacto contiene un caracter invalido";
	public static final String APELLIDO_INVALID_CHAR = "Los apellidos del Contacto contiene un caracter invalido";
	public static final String TEL_INVALID_FORMAT = "El formato del telefono es invalido";
	public static final String DIRECCION_INVALID_CHAR = "La direccion del Contacto contiene un caracter invalido";
	public static final String POBLACION_INVALID_CHAR = "La poblacion del Contacto contiene un caracter invalido";
	public static final String PROVINCIA_INVALID_CHAR = "La provincia del Contacto contiene un caracter invalido";
	public static final String CP_INVALID_FORMAT = "El formato del CP es invalido";

	public PersonaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
