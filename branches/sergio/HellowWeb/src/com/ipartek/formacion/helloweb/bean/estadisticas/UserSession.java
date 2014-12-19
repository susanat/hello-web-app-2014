package com.ipartek.formacion.helloweb.bean.estadisticas;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Constantes.EModeloAccion;

public class UserSession {
	
	
	/**
	 * Numeración para conocer la razón de borrado	
	 */
	public enum ECauseSessionOff {	 
		/**
		 * Flag para indicar que la sesión ha expirado
		 */
		EXPIRED("1"),
		/**
		 * Flag que indica que el usuario se ha deslogueado de la sesión
		 */
		LOGOUT("2");

		private String value;

		private ECauseSessionOff(String value) {
			this.value = value;
		}
		public String getValue(){
			return value;
		}

		public final static ECauseSessionOff getEnumNameForValue(Object value){

			ECauseSessionOff[] values = ECauseSessionOff.values();

			String enumValue = null;
			ECauseSessionOff res = null;

			for(ECauseSessionOff eachValue : values){
				enumValue = eachValue.getValue();
				if( enumValue.equals(value)){
					res = eachValue;
				}
			}
			return res;
		}
	}
	
	/**
	 * Identificador de la sesión del usuario.
	 */
	private String idSession;
	
	/**
	 * Objeto sesión con los parámetros en su creación
	 */
	private HttpSession sesion;
	
	/**
	 * Fecha de inicio de sesión
	 */
	private Long init;
		
	/**
	 * Fecha de fin de sesión
	 */
	private Long finish;
	
	/**
	 * Objeto del usuario
	 */
	private Persona usuario;
	
	/**
	 * Causa cierre de sesión
	 */
	private ECauseSessionOff causeSessionOf;
	
	/**
	 * Historial del usuario
	 */
	private List<String> historial;
	
	
	////////// Getter and setters	
	public HttpSession getSesion() {
		return sesion;
	}

	public ECauseSessionOff getCauseSessionOf() {
		return causeSessionOf;
	}

	public void setCauseSessionOf(ECauseSessionOff causeSessionOf) {
		this.causeSessionOf = causeSessionOf;
	}

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public void setSesion(HttpSession sesion) {
		this.sesion = sesion;
	}

	public Long getInit() {
		return init;
	}

	public void setInit(Long init) {
		this.init = init;
	}

	public Long getFinish() {
		return finish;
	}

	public void setFinish(Long finish) {
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
		finish = System.currentTimeMillis();
	}	
	
	public void setDateInitNow() {
		init = System.currentTimeMillis();
	}
	
	
	/**
	 * Comprueba si la session del usuario está terminada.
	 * @return True si está terminada, false si no.
	 */
	public boolean isSessionTerminated() {
		return finish != null;
	}
	
	
	/**
	 * Constructor de creación de usuario activo
	 * @param session
	 */
	public UserSession(HttpSession session) 
	{
		//obtenemos el id de la sesión
		this.idSession = session.getId();
		this.init = session.getLastAccessedTime();
		
		this.sesion = session;
		
		if(session.getAttribute(Constantes.ATTR_SESSION_USER) != null) {
			this.usuario = (Persona) session.getAttribute(Constantes.ATTR_SESSION_USER);
		}
		
		this.finish = null;
		this.causeSessionOf = null;
		
	}
	
	
	
	

}
