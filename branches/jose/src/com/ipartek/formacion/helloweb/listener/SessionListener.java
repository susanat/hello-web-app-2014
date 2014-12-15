package com.ipartek.formacion.helloweb.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener,
		HttpSessionAttributeListener {

	/**
	 * Default constructor.
	 */
	public SessionListener() {
		System.out.println("SessionListener Default Constructor");
	}

	/* Eventos sobre los atributos de HttpSession */
	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("SessionListener attributeRemoved");
		// Cambiado usuario en sesion
		if (se.getName().equals(Constantes.USER_SESSION)) {
			Persona usuario = (Persona) se.getValue();
			System.out.println("Usuario eliminado: " + usuario.toString());
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("SessionListener attributeAdded");
		// Cambiado usuario en sesion
		if (se.getName().equals(Constantes.USER_SESSION)) {
			Persona usuario = (Persona) se.getValue();
			System.out.println("Nuevo usuario registrado: "
					+ usuario.toString());
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("SessionListener attributeReplaced " + se.getName());
		// Cambiado usuario en sesion
		if (se.getName().equals(Constantes.USER_SESSION)) {
			Persona usuario = (Persona) se.getValue();
			System.out.println("Nuevo usuario registrado y modificado: "
					+ usuario.toString());
		}
	}

	/* Ciclo de vida de HttpSession */
	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionListener sessionCreated");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionListener sessionDestroyed");
	}

}
