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
	private String nombre = "";
	private String apellidos = "";
	private int telFijo;
	private int telMovil;
	private String direccion = "";
	private String poblacion = "";
	private String provincia = "";
	private int cp;
	private String anotaciones = "";

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

	/**
	 * Comprueba que el nombre sea correcto y lo anade
	 * 
	 * @param nombre
	 *            : nombre del Contacto
	 * @return boolean:
	 *         <ul>
	 *         <li>False: si el nombre es NULL</li>
	 *         <li>False: si el nombre es vacio</li>
	 *         <li>False: si el nombre contiene algun caracter que no sea letra
	 *         y su tamanio no este entre 2 y 20 caracteres</li>
	 *         <li>True: si el nombre es correcto</li>
	 *         </ul>
	 * 
	 */
	public boolean setNombre(String nombre) {
		if (nombre == null) {
			return false;
			// error nombre vacio
		} else {
			if (nombre.isEmpty()) {
				return false;
				// Error, esta vacio
			} else {
				if (!nombre.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{2,20}")) {
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

	/**
	 * Comprueba los Apellidos del contacto y lo anade
	 * 
	 * @param apellidos
	 *            : apellidos del contacto
	 * @return boolean
	 *         <ul>
	 *         <li>False: si los apellidos son NULL</li>
	 *         <li>False: si los apellidos contiene algun caracter que no sea
	 *         letra y su tamanio sea manior a 50 caracteres</li>
	 *         <li>True: si los apellidos son correctos</li>
	 *         </ul>
	 */
	public boolean setApellidos(String apellidos) {
		if (apellidos == null) {
			return false;
			// error nombre vacio
		} else {
			// NOTA: Vale unos apellidos vacios
			if (!apellidos.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{0,50}")) {
				return false;
				// error, caracteres no admitidos
			} else {
				this.apellidos = apellidos;
				return true;
			}
		}
	}

	public int getTelFijo() {
		return telFijo;
	}

	/**
	 * Comprueba el Telefono Fijo del contacto y lo anade
	 * 
	 * @param telFijo
	 *            : Telefono Fijo del contacto
	 * @return boolean
	 *         <ul>
	 *         <li>False: si es un numero negativo</li>
	 *         <li>False: si la longitud del telefono no es de 9 digitos</li>
	 *         <li>True: si el telefono es correcto</li>
	 *         </ul>
	 */
	public boolean setTelFijo(int telFijo) {
		// TODO Comprobar telefonos extranjetos
		if (telFijo < 0) {
			return false;
		} else {
			if (!(String.valueOf(telFijo).length() == LONG_TEL)) {
				return false;
				// error el codigo no contiene 9 caracteres
			} else {
				this.telFijo = telFijo;
				return true;
			}
		}
	}

	public int getTelMovil() {
		return telMovil;
	}

	/**
	 * Comprueba el Telefono Movil del contacto y lo anade
	 * 
	 * @param telFijo
	 *            : Telefono Movil del contacto
	 * @return boolean
	 *         <ul>
	 *         <li>False: si es un numero negativo</li>
	 *         <li>False: si la longitud del telefono no es de 9 digitos</li>
	 *         <li>True: si el telefono es correcto</li>
	 *         </ul>
	 */
	public boolean setTelMovil(int telMovil) {
		// TODO Comprobar telefonos extranjetos, simbolo + y parentesis ()
		if (telMovil < 0) {
			return false;
		} else {
			if (!(String.valueOf(telMovil).length() == LONG_TEL)) {
				return false;
				// error el codigo no contiene 7 caracteres
			} else {
				this.telMovil = telMovil;
				return true;
			}
		}
	}

	public String getDireccion() {
		return direccion;
	}

	/**
	 * Comprueba la Direccion del contacto y lo anade
	 * 
	 * @param direccion
	 *            : Direccion del contacto
	 * @return boolean
	 *         <ul>
	 *         <li>False: si la direccion es NULL</li>
	 *         <li>False: si la direccion contiene algun caracter que no sea
	 *         letra o / o ª o ºy su tamanio sea manior a 60 caracteres</li>
	 *         <li>True: si la direccion es correcta</li>
	 *         </ul>
	 */
	public boolean setDireccion(String direccion) {
		if (direccion == null) {
			return false;
			// error nombre vacio
		} else {
			// NOTA: Vale una direccion vacia
			if (!direccion.matches("[A-Za-z 0-9 / ª º ÑñáéíóúÁÉÍÓÚüÜ]{0,60}")) {
				return false;
				// error, caracteres no admitidos
			} else {
				this.direccion = direccion;
				return true;
			}
		}
	}

	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Comprueba la Poblacion del contacto y lo anade
	 * 
	 * @param poblacion
	 *            : Nombre de la poblacion del contacto
	 * @return boolean
	 *         <ul>
	 *         <li>False: si el nombre de la poblacion es NULL</li>
	 *         <li>False: si el nombre de la poblacion contiene algun caracter
	 *         que no sea letra o su tamanio sea manior a 50 caracteres</li>
	 *         <li>True: si el nombre de la poblacion es correcta</li>
	 *         </ul>
	 */
	public boolean setPoblacion(String poblacion) {
		if (poblacion == null) {
			return false;
			// error nombre vacio
		} else {
			// NOTA: Vale una Poblacion vacia
			if (!poblacion.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{0,50}")) {
				return false;
				// error, caracteres no admitidos
			} else {
				this.poblacion = poblacion;
				return true;
			}
		}
	}

	public String getProvincia() {
		return provincia;
	}

	/**
	 * Comprueba la Provincia del contacto y la anade
	 * 
	 * @param provincia
	 *            : Nombre de la provincia del contacto
	 * @return boolean
	 *         <ul>
	 *         <li>False: si el nombre de la provincia es NULL</li>
	 *         <li>False: si el nombre de la provincia contiene algun caracter
	 *         que no sea letra o su tamanio sea mayor a 50 letras</li>
	 *         <li>True: si el nombre de la provincia es correcto</li>
	 *         </ul>
	 */
	public boolean setProvincia(String provincia) {
		if (provincia == null) {
			return false;
			// error nombre vacio
		} else {
			// NOTA: Vale una Provincia vacia
			if (!provincia.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{0,50}")) {
				return false;
				// error, caracteres no admitidos
			} else {
				this.provincia = provincia;
				return true;
			}
		}
	}

	public int getCp() {
		return cp;
	}

	/**
	 * Comprueba que el Codigo Postal del contacto sea correcto y lo anade
	 * 
	 * @param cp
	 *            : Codigo Postal del contacto
	 * @return boolean
	 *         <ul>
	 *         <li>False: si es un numero negativo</li>
	 *         <li>False: si el tamanio del Codigo Postal no es de 5 digitos</li>
	 *         <li>True: si el Codigo Postal es correcto</li>
	 *         </ul>
	 */
	public boolean setCp(int cp) {
		if (cp < 0) {
			return false;
		} else {
			if (!(String.valueOf(cp).length() == LONG_CP)) {
				return false;
				// error el codigo no contiene 5 caracteres
			} else {
				this.cp = cp;
				return true;
			}
		}
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	// Constructores

	public Persona() {
		super();
	}

	public Persona(int idcontacto, String nombre, String apellidos,
			int telFijo, int telMovil, String direccion, String poblacion,
			String provincia, int cp, String anotaciones) {
		super();
		this.idcontacto = idcontacto;
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setTelFijo(telFijo);
		this.setTelMovil(telMovil);
		this.setDireccion(direccion);
		this.setPoblacion(poblacion);
		this.setProvincia(provincia);
		this.setCp(cp);
		this.setAnotaciones(anotaciones);
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
