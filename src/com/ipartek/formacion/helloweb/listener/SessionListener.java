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
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public SessionListener() {
		System.out.println("---- Constructor por defecto de SessionListener ----");
	}

	/************** Eventos sobre los atributos de HttpSession **************/
	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(final HttpSessionBindingEvent se) {
		System.out.println("---- Llamada al método attributeRemoved ----");
		if (se.getName().equals(Constantes.USER_SESSION)) {
			final Persona usuario = (Persona) se.getValue();
			System.out.println("Usuario deslogueado");
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(final HttpSessionBindingEvent se) {
		System.out.println("---- Llamada al método attributeAdded ----");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(final HttpSessionBindingEvent se) {
		System.out.println("---- Llamada al método attributeReplaced ----");
		System.out.println(se.getName());
		if (se.getName().equals(Constantes.USER_SESSION)) {
			final Persona usuario = (Persona) se.getValue();
			System.out.println("Nuevo usuario registrado: " + usuario.toString());
		}
	}

	/**************** Eventos sobre el ciclo de vida de Session ****************/
	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(final HttpSessionEvent se) {
		System.out.println("---- Llamada al método sessionCreated ----");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(final HttpSessionEvent se) {
		System.out.println("---- Llamada al método sessionDestroyed ----");
	}

}
