package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.Constantes;
/**
 * Usuario
 * <ul>
 * 	<li>usuario {@code String}</li>
 * 	<li>password {@code String}</li>
 * </ul>
 * @author Curso
 *
 */
public class Usuario {
	private String usuario;
	private String password;
	
	// Constructor
	public Usuario(String usuario, String password) {
		super();
		setUsuario(usuario);
		setPassword(password);
	}

	// Getters & Setters
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Indica si el usuario es ADMINISTRADOR
	 * @return
	 */
	public boolean esAdministrador(){
		boolean bUsuario = Constantes.USER_ADMIN.equals(this.usuario)?true:false;
		boolean bPassword = Constantes.PASS_ADMIN.equals(this.password)?true:false;
		return (bUsuario && bPassword);
	}
	
}
