package ipt.fm.ipartek.test.bean;

public class Persona {

	private int id;
	private String nombre;
	private String apellidos;
	private String foto;

	public Persona() {
		setId(-1);
		setNombre("");
		setApellidos("");
		setFoto("");
	}

	/**
	 * @param nombre
	 * @param apellidos
	 */
	public Persona(final String nombre, final String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param foto
	 */
	public Persona(final String nombre, final String apellidos, final String foto) {
		setNombre(nombre);
		setApellidos(apellidos);
		setFoto(foto);
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param foto
	 */
	public Persona(final int id, final String nombre, final String apellidos, final String foto) {
		this.id = id;
		setNombre(nombre);
		setApellidos(apellidos);
		setFoto(foto);
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
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto
	 *            the foto to set
	 */
	public void setFoto(final String foto) {
		this.foto = foto;
	}

}
