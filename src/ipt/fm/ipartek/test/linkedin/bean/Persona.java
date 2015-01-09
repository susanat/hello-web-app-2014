package ipt.fm.ipartek.test.linkedin.bean;

public class Persona {

	private int id;
	private String nombre;
	private String apellidos;
	private String foto;
	
	public Persona(String nombre, String apellidos) {
		super();
		this.id = -1;
		this.nombre = nombre;
		this.apellidos = apellidos;
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
	
	
	
	
	
	
	
}
