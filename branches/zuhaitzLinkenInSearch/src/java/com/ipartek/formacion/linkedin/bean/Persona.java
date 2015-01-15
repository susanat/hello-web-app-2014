package com.ipartek.formacion.linkedin.bean;

import org.apache.catalina.startup.SetNextNamingRule;

public class Persona {
	public final static String NOMBRE_DEFAULT = "Default";
	public final static String APELLIDOS_DEFAULT = "Default";
	public final static String FOTO_DEFAULT = "Default";
	public final static String INFO_BASIC_DEFAULT = "Default";
	public final static String INFO_EXPANDED_DEFAULT = "Default";

	private int id;
	private String nombre;
	private String apellido;
	private String url_foto;
	private String info_basic;
	private String info_expanded;

	public Persona(final int id) {
		super();
		setId(id);
		setNombre(NOMBRE_DEFAULT);
		setApellido(APELLIDOS_DEFAULT);
		setUrl_foto(FOTO_DEFAULT);
		setInfo_basic(INFO_BASIC_DEFAULT);
		setInfo_expanded(INFO_EXPANDED_DEFAULT);

	}

	public Persona(final int id, final String nombre, final String apellido, final String url_foto) {
		super();
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setUrl_foto(url_foto);
		setInfo_basic(INFO_BASIC_DEFAULT);
		setInfo_expanded(INFO_EXPANDED_DEFAULT);
	}

	public Persona(final int id, final String nombre, final String apellido, final String url_foto, final String basic,
			final String expanded) {
		super();
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setUrl_foto(url_foto);
		setInfo_basic(basic);
		setInfo_expanded(expanded);

	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(final String url_foto) {
		this.url_foto = url_foto;

	}

	public String getInfo_basic() {
		return info_basic;
	}

	public void setInfo_basic(final String info_basic) {
		this.info_basic = info_basic;
	}

	public String getInfo_expanded() {
		return info_expanded;
	}

	public void setInfo_expanded(final String info_expanded) {
		this.info_expanded = info_expanded;
	}

}
