package com.ipartek.formacion.helloweb.bean.estadisticas;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.Persona;

public class UserSession {
	
	private HttpSession sesion;
	private Date init;
	private Date finish;
	private Persona usuario;
	private List<String> historial;
	
	
	////////// Getter and setters	
	public HttpSession getSesion() {
		return sesion;
	}

	public void setSesion(HttpSession sesion) {
		this.sesion = sesion;
	}

	public Date getInit() {
		return init;
	}

	public void setInit(Date init) {
		this.init = init;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public void setUsuario(Persona usuario) {
		this.usuario = usuario;
	}

	public List<String> getHistorial() {
		return historial;
	}

	public void setHistorial(List<String> historial) {
		this.historial = historial;
	}
	
	
	///////// Funciones de apoyo
	public void setDateFinishNow() {
		finish = new Date();
	}	
	
	public void setDateInitNow() {
		init = new Date();
	}
	

}
