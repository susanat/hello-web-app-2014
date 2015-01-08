package ipt.fm.ipartek.bean;

public class Persona {

	private int id;
	private String nombre;
	private String apellido1;
	private int edad;

	public static final int ID_NULL = -1;
	public static final int EDAD_NULL = 0;

	public Persona(String nombre, String _ape) {
		super();
		this.nombre = nombre;
		this.edad = EDAD_NULL;
		this.apellido1 = _ape;
		this.id = ID_NULL;
	}

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;

		this.id = ID_NULL;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido1="
				+ apellido1 + ", edad=" + edad + "]";
	}

}
