package ipt.fm.ipartek.test.bean;

public class Persona {

	private int id;
	private String nombre;
	private String apellidos;
	private int edad;

	/**
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 */
	public Persona(final String nombre, final String apellidos, final int edad) {
		super();
		setNombre(nombre);
		setApellidos(apellidos);
		setEdad(edad);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(final String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(final int edad) {
		this.edad = edad;
	}

}
