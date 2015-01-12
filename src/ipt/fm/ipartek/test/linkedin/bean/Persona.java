package ipt.fm.ipartek.test.linkedin.bean;

public class Persona {
	private int id;
	private String nombre;
	private String apellidos;
	private String foto;

	public static final int ID_NULL = -1;

	public Persona() {
		super();
		this.id = ID_NULL;
		this.nombre = null;
		this.apellidos = null;
		this.foto = null;
	}

	/**
	 * Constructor de una Persona con un id Nulo y una fota Nula
	 * 
	 * @param nombre
	 * @param apellidos
	 */
	public Persona(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = ID_NULL;
		this.foto = null;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", foto=" + foto + "]";
	}
}