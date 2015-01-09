package ipt.fm.ipartek.test.linkedin.bean;

public class Persona {

	private int id;
	private String nombre;
	private String apellido1;
	private String foto;

	public static final int ID_NULL = -1;

	public Persona() {
		super();
	}

	public Persona(String nombre, String _ape) {
		super();
		this.nombre = nombre;
		this.foto = null;
		this.apellido1 = _ape;
		this.id = ID_NULL;
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;

		this.id = ID_NULL;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido1="
				+ apellido1 + "]";
	}

}
