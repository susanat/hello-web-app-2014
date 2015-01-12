package ipt.fm.ipartek.test.linkedin.bean;

public class Persona {
	private static final int ID_INSERT = -1;

	private String nombre;
	private String apellidos;
	private int id;
	private String foto;

	public Persona(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = ID_INSERT;
		this.setFoto(null);
	}

	public Persona(String nombre, String apellidos, int id) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = id;
		this.setFoto(null);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
