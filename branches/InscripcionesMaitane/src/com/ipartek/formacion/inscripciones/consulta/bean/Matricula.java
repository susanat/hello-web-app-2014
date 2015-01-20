package com.ipartek.formacion.inscripciones.consulta.bean;

public class Matricula {

	private int id;
	private long fInscripcion;
	private String nombre;
	private String apellido;
	private String email;
	private long fUltimoAcceso;
	private long fUltimoLogin;
	
	
	public Matricula() {
		super();
		this.id = -1;
		this.fInscripcion = 0;
		this.nombre = "";
		this.apellido = "";
		this.email = "";
		this.fUltimoAcceso = 0;
		this.fUltimoLogin = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getfInscripcion() {
		return fInscripcion;
	}
	public void setfInscripcion(long fInscripcion) {
		this.fInscripcion = fInscripcion;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getfUltimoAcceso() {
		return fUltimoAcceso;
	}
	public void setfUltimoAcceso(long fUltimoAcceso) {
		this.fUltimoAcceso = fUltimoAcceso;
	}
	public long getfUltimoLogin() {
		return fUltimoLogin;
	}
	public void setfUltimoLogin(long fUltimoLogin) {
		this.fUltimoLogin = fUltimoLogin;
	}
	
	
		
}
