package ipt.fm.ipartek.test.bean;

public class Persona {

	private String nombre;
	private String apellidos;
	private int id;

	/**
	 * @param nombre
	 * @param apellidos
	 * @param id
	 */
	public Persona(final String nombre, final String apellidos, final int id) {
		super();
		setNombre(nombre);
		setApellidos(apellidos);
		setId(id);
	}

	/**
	 * @param nombre
	 * @param apellidos
	 */
	public Persona(final String nombre, final String apellidos) {
		super();
		setNombre(nombre);
		setApellidos(apellidos);
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

}
