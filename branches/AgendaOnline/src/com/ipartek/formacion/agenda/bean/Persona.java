package com.ipartek.formacion.agenda.bean;

/**
 * Clase Persona con validación de los datos recogidos
 * 
 * @authores Susana Costoya, Kepa Escudero
 *
 */

public class Persona {

	// Constantes
	private static int LONG_CP = 5;
	private static int LONG_TEL = 9;

	// Variables
	private int idcontacto;
	private String nombre;
	private String apellidos;
	private int telFijo;
	private int telMovil;
	private String direccion;
	private String poblacion;
	private String provincia;
	private int cp;

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public int getIdcontacto() {
		return idcontacto;
	}

	public void setIdcontacto(int idcontacto) {
		this.idcontacto = idcontacto;
	}

	public boolean setNombre(String nombre) {
		if (nombre == null) {
			return false;
			// error nombre vacio
		} else {
			if (nombre.isEmpty()) {
				return false;
				// Error, esta vacio
			} else {
				if (nombre.matches("^.*\\d.*$")) {
					return false;
					// error, caracteres no admitidos
				} else {
					this.nombre = nombre;
					return true;
				}
			}
		}
	}

	public String getApellidos() {
		return apellidos;
	}

	public boolean setApellidos(String apellidos) {
		if (apellidos == null) {
			return false;
			// error nombre vacio
		} else {
			if (apellidos.isEmpty()) {
				return false;
				// Error, esta vacio
			} else {
				if (apellidos.matches("^.*\\d.*$")) {
					return false;
					// error, caracteres no admitidos
				} else {
					this.apellidos = apellidos;
					return true;
				}
			}
		}
	}

	public int getTelFijo() {
		return telFijo;
	}

	public boolean setTelFijo(int telFijo) {
		// TODO Comprobar telefonos extranjetos
		if (!(String.valueOf(telFijo).length() == LONG_TEL)) {
			return false;
			// error el codigo no contiene 9 caracteres
		} else {
			this.telFijo = telFijo;
			return true;
		}
	}

	public int getTelMovil() {
		return telMovil;
	}

	public boolean setTelMovil(int telMovil) {
		// TODO Comprobar telefonos extranjetos, simbolo + y parentesis ()
		if (!(String.valueOf(telMovil).length() == LONG_TEL)) {
			return false;
			// error el codigo no contiene 7 caracteres
		} else {
			this.telMovil = telMovil;
			return true;
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public boolean setDireccion(String direccion) {
		if (direccion == null) {
			return false;
			// error nombre vacio
		} else {
			if (direccion.isEmpty()) {
				return false;
				// Error, esta vacio
			} else {
				if (direccion.matches("^.*\\d.*$")) {
					return false;
					// error, caracteres no admitidos
				} else {
					this.direccion = direccion;
					return true;
				}
			}
		}
	}

	public String getPoblacion() {
		return poblacion;
	}

	public boolean setPoblacion(String poblacion) {
		if (poblacion == null) {
			return false;
			// error nombre vacio
		} else {
			if (poblacion.isEmpty()) {
				return false;
				// Error, esta vacio
			} else {
				if (poblacion.matches("^.*\\d.*$")) {
					return false;
					// error, caracteres no admitidos
				} else {
					this.poblacion = poblacion;
					return true;
				}
			}
		}
	}

	public String getProvincia() {
		return provincia;
	}

	public boolean setProvincia(String provincia) {
		if (provincia == null) {
			return false;
			// error nombre vacio
		} else {
			if (provincia.isEmpty()) {
				return false;
				// Error, esta vacio
			} else {
				if (provincia.matches("^.*\\d.*$")) {
					return false;
					// error, caracteres no admitidos
				} else {
					this.provincia = provincia;
					return true;
				}
			}
		}
	}

	public int getCp() {
		return cp;
	}

	public boolean setCp(int cp) {
		System.out.println("aa");
		if (!(String.valueOf(cp).length() == LONG_CP)) {
			return false;
			// error el codigo no contiene 5 caracteres
		} else {
			this.cp = cp;
			return true;
		}
	}

	// Constructores

	public Persona() {
		super();
	}

	public Persona(int idcontacto, String nombre, String apellidos,
			int telFijo, int telMovil, String direccion, String poblacion,
			String provincia, int cp) {
		super();
		this.idcontacto = idcontacto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telFijo = telFijo;
		this.telMovil = telMovil;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Persona [idcontacto = " + idcontacto + " + nombre=" + nombre
				+ ", apellidos=" + apellidos + ", telFijo=" + telFijo
				+ ", telMovil=" + telMovil + ", direccion=" + direccion
				+ ", poblacion=" + poblacion + ", provincia=" + provincia
				+ ", cp=" + cp + "]";
	}
	// COmprobacion de los campos nombre apellidos poblacion y provincia que no
	// contenga numeros o simbolos, y que el campo numero telefono fijo y movil,
	// codigo postal no contenga letras
	/*
	 * public static boolean comprobarDatosNoNumericos(String nombre, String
	 * apellidos, String poblacion, String provincia) { boolean resul = true; if
	 * ((nombre.matches("^.*\\d.*$")) || (apellidos.matches("^.*\\d.*$")) ||
	 * (poblacion.matches("^.*\\d.*$")) || (provincia.matches("^.*\\d.*$")) ||
	 * (telFijo.matches("^.*\\d.*$")) || (telMovil.matches("^.*\\d.*$")) ||
	 * (cp.matches("^.*\\d.*$"))) { resul = false; return resul; } return resul;
	 * 
	 * }
	 */
}
