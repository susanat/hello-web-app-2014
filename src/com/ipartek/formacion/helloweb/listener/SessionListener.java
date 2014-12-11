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
public class SessionListener implements HttpSessionAttributeListener,
		HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public SessionListener() {
		System.out.print("SessionListener Default Constructor");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.print("Session attributeRemoved ");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {

		System.out.print("attributeAdded Default Constructor");

		if (se.getName().equals(Constantes.USER_SESSION)) {

			Persona usuario = (Persona) se.getValue();

			System.out
					.println("nuevo usuario registrado " + usuario.toString());

		}
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {

		System.out.print("Session created");

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {

		System.out.print("Session attributeReplaced ");

		if (se.getName().equals(Constantes.USER_SESSION)) {

			Persona usuario = (Persona) se.getValue();

			System.out.println("nuevo usuario registrado y modificado "
					+ usuario.toString());

		}
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.print("session Destroyed");
	}

}
