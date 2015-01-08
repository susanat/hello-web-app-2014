package com.ipartek.formacion.linkedin.bean;

public class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private String foto;
	
	public Persona(int id, String nombre, String apellido, String foto){
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setFoto(foto);
	}
	
	public String getFoto(){
		return foto;
	}
	
	public void setFoto(String url){
		this.foto = url;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
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
	
	
}
