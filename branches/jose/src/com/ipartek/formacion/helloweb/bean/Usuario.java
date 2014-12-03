package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.Constantes;

/**
 * Usuario
 * <ul>
 * <li>usuario {@code String}</li>
 * <li>password {@code String}</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public class Usuario {
	private String usuario;
	private String password;
	private Rol rol;

	// Constructor
	public Usuario() {
		super();
		this.rol = Rol.USER;
	}

	public Usuario(String usuario, String password) {
		this();
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * Indica si el usuario es ADMINISTRADOR
	 * 
	 * @return
	 */
	public boolean esAdministrador() {
		boolean bUsuario = Constantes.USER_ADMIN_NAME.equals(this.usuario) ? true
				: false;
		boolean bPassword = Constantes.USER_ADMIN_PASS.equals(this.password) ? true
				: false;
		return (bUsuario && bPassword);

	}

	/**
	 * Enumeracion para los Roles de las Personas
	 * 
	 * @author Curso
	 *
	 */
	public enum Rol {
		ADMINISTRADOR, USER;
	}
}
