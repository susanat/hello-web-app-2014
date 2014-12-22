package com.ipartek.formacion.helloweb.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.constantes.Constantes;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionAttributeListener,
		HttpSessionListener {

	private final static Logger log = Logger.getLogger("ACCESOS");

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeRemoved");
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeAdded");

			if (Constantes.USER.equalsIgnoreCase(((Persona) se.getValue())
					.getNombre())) {
				synchronized (this) {
					Integer i = (Integer) se.getSession().getServletContext()
							.getAttribute(Constantes.ATT_CONTADMIN);
					se.getSession().getServletContext()
					.setAttribute(Constantes.ATT_CONTADMIN, i + 1);
				}
			} else if (Constantes.USER_USER.equalsIgnoreCase(((Persona) se
					.getValue()).getNombre())) {
				synchronized (this) {
					Integer i = (Integer) se.getSession().getServletContext()
							.getAttribute(Constantes.ATT_CONTUSER);
					se.getSession().getServletContext()
					.setAttribute(Constantes.ATT_CONTUSER, i + 1);
				}
			}

		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeReplaced");
		}
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// Marcar el tiempo de expiración
		HttpSession session = se.getSession();
		// 30 minutos
		session.setMaxInactiveInterval(30 * 60);
		log.trace("nueva sesion id: " + session.getId() + " - "
				+ session.getMaxInactiveInterval());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if (session.getAttribute(Constantes.USER_SESSION) != null) {
			log.info(((Persona) session.getAttribute(Constantes.USER_SESSION))
					.getNombre()
					+ " ha dejado la web, sesion id: "
					+ session.getId());

			if (Constantes.USER.equalsIgnoreCase(((Persona) session
					.getAttribute(Constantes.USER_SESSION)).getNombre())) {
				synchronized (this) {
					Integer i = (Integer) se.getSession().getServletContext()
							.getAttribute(Constantes.ATT_CONTADMIN);
					se.getSession().getServletContext()
					.setAttribute(Constantes.ATT_CONTADMIN, i - 1);
				}
			} else if (Constantes.USER_USER.equalsIgnoreCase(((Persona) session
					.getAttribute(Constantes.USER_SESSION)).getNombre())) {
				synchronized (this) {
					Integer i = (Integer) se.getSession().getServletContext()
							.getAttribute(Constantes.ATT_CONTUSER);
					se.getSession().getServletContext()
					.setAttribute(Constantes.ATT_CONTUSER, i - 1);
				}
			}
		} else {
			log.info("Destroy sesion id: " + session.getId());
		}
	}

}
