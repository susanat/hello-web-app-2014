package com.ipartek.formacion.linkedin.bean;

public class Persona {

	public final static String NOMBRE_DEFAULT = "Default";
	public final static String APELLIDOS_DEFAULT = "Default";
	public final static int EDAD_DEFAULT = 18;
	public final static String FOTO_DEFAULT = "Default";
	public final static String INFO_BASIC_DEFAULT = "Default";
	public final static String INFO_EXPANDED_DEFAULT = "Default";

	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String url_foto;
	private String info_basic;
	private String info_expanded;

	public Persona(int id) {
		super();
		this.id = id;
		this.nombre = NOMBRE_DEFAULT;
		this.apellido = APELLIDOS_DEFAULT;
		this.edad = EDAD_DEFAULT;
		this.url_foto = FOTO_DEFAULT;
		this.info_basic = INFO_BASIC_DEFAULT;
		this.info_expanded = INFO_EXPANDED_DEFAULT;

	}

	public Persona(int id, String nombre, String apellido, int edad,
			String url_foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.url_foto = url_foto;
		this.info_basic = INFO_BASIC_DEFAULT;
		this.info_expanded = INFO_EXPANDED_DEFAULT;
	}

	public Persona(int id, String nombre, String apellido, int edad,
			String url_foto, String basic, String expanded) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.url_foto = url_foto;
		this.info_basic = basic;
		this.info_expanded = expanded;

	}

	public Persona() {
		super();
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;

	}

	public String getInfo_basic() {
		return info_basic;
	}

	public void setInfo_basic(String info_basic) {
		this.info_basic = info_basic;
	}

	public String getInfo_expanded() {
		return info_expanded;
	}

	public void setInfo_expanded(String info_expanded) {
		this.info_expanded = info_expanded;
	}

}
