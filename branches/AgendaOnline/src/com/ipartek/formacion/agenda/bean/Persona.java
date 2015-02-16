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
	 * @throws PersonaException
	 *             <ul>
	 *             <li>NOMBRE_EMPTY: si el nombre es NULL</li>
	 *             <li>NOMBRE_EMPTY: si el nombre es vacio</li>
	 *             <li>NOMBRE_INVALID_CHAR: si el nombre contiene algun caracter
	 *             que no sea letra y su tamanio no este entre 2 y 20 caracteres
	 *             </li>
	 *             </ul>
	 * 
	 */
	public void setNombre(String nombre) throws PersonaException {
		if (nombre == null) {
			// error nombre vacio
			throw new PersonaException(PersonaException.NOMBRE_EMPTY);
		} else {
			if (nombre.isEmpty()) {
				// Error, esta vacio
				throw new PersonaException(PersonaException.NOMBRE_EMPTY);
			} else {
				if (!nombre.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{2,20}")) {
					// error, caracteres no admitidos
					throw new PersonaException(
							PersonaException.NOMBRE_INVALID_CHAR);
				} else {
					this.nombre = nombre;
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
	 * @throws PersonaException
	 *             APELLIDO_INVALID_CHAR: si los apellidos contiene algun
	 *             caracter que no sea letra y su tamanio sea manior a 50
	 *             caracteres</li>
	 */
	public void setApellidos(String apellidos) throws PersonaException {
		if (apellidos != null) {
			// NOTA: Vale unos apellidos vacios
			if (!apellidos.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{0,50}")) {
				// error, caracteres no admitidos
				throw new PersonaException(
						PersonaException.APELLIDO_INVALID_CHAR);
			} else {
				this.apellidos = apellidos;
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
	public void setTelFijo(int telFijo) throws PersonaException {
		// TODO Comprobar telefonos extranjetos
		if (telFijo < 0) {
			// error: no valen datos negativos
			throw new PersonaException(PersonaException.TEL_INVALID_FORMAT);
		} else {
			if (telFijo == 0) {
				this.telFijo = telFijo;
			} else {
				if (!(String.valueOf(telFijo).length() == LONG_TEL)) {
					// error el codigo no contiene 9 caracteres
					throw new PersonaException(
							PersonaException.TEL_INVALID_FORMAT);
				} else {
					this.telFijo = telFijo;
				}
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
	public void setTelMovil(int telMovil) throws PersonaException {
		// TODO Comprobar telefonos extranjetos, simbolo + y parentesis ()
		if (telMovil < 0) {
			// error: no valen datos negativos
			throw new PersonaException(PersonaException.TEL_INVALID_FORMAT);
		} else {
			if (!(String.valueOf(telMovil).length() == LONG_TEL)) {
				// error el codigo no contiene 7 caracteres
				throw new PersonaException(PersonaException.TEL_INVALID_FORMAT);
			} else {
				this.telMovil = telMovil;
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
	 */
	public void setDireccion(String direccion) throws PersonaException {
		if (direccion != null) {
			// NOTA: Vale una direccion vacia
			if (!direccion
					.matches("[A-Za-z 0-9 / \\ ª º ÑñáéíóúÁÉÍÓÚüÜ]{0,60}")) {
				throw new PersonaException(
						PersonaException.DIRECCION_INVALID_CHAR);
				// error, caracteres no admitidos
			} else {
				this.direccion = direccion;
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
	 */
	public void setPoblacion(String poblacion) throws PersonaException {
		if (poblacion != null) {
			// NOTA: Vale una Poblacion vacia
			if (!poblacion.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{0,50}")) {
				throw new PersonaException(
						PersonaException.POBLACION_INVALID_CHAR);
				// error, caracteres no admitidos
			} else {
				this.poblacion = poblacion;
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
	 */
	public void setProvincia(String provincia) throws PersonaException {
		if (provincia != null) {
			// NOTA: Vale una Provincia vacia
			if (!provincia.matches("[A-Za-z ÑñáéíóúÁÉÍÓÚüÜ]{0,50}")) {
				throw new PersonaException(
						PersonaException.PROVINCIA_INVALID_CHAR);
				// error, caracteres no admitidos
			} else {
				this.provincia = provincia;

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
	 */
	public void setCp(int cp) throws PersonaException {
		if (cp < 0) {
			throw new PersonaException(PersonaException.CP_INVALID_FORMAT);
		} else {
			if (cp == 0) {
				this.cp = cp;
			} else {
				if (!(String.valueOf(cp).length() == LONG_CP)) {
					throw new PersonaException(
							PersonaException.CP_INVALID_FORMAT);
					// error el codigo no contiene 5 caracteres
				} else {
					this.cp = cp;
				}
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
			String provincia, int cp, String anotaciones)
			throws PersonaException {
		super();
		this.idcontacto = idcontacto;
		try {
			this.setNombre(nombre);
			this.setApellidos(apellidos);
			this.setTelFijo(telFijo);
			this.setTelMovil(telMovil);
			this.setDireccion(direccion);
			this.setPoblacion(poblacion);
			this.setProvincia(provincia);
			this.setCp(cp);
			this.setAnotaciones(anotaciones);
		} catch (PersonaException e) {
			throw e;
		}
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
