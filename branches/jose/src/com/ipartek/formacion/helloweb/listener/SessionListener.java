package com.ipartek.formacion.helloweb.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionAttributeListener,
		HttpSessionListener {

	static final String charset = "javax.servlet.jsp.jstl.fmt.request.charset";
	private final static Logger log = Logger.getLogger("ACCESOS");


	/* Eventos sobre los atributos de HttpSession */

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

			// obtenemos la session
			HttpSession session = se.getSession();

			// comprobamos que la session no sea NULL
			if (session.getAttribute(Constantes.USER_SESSION) != null) {
				// obtenemos la Persona
				Persona usuario = (Persona) session
						.getAttribute(Constantes.USER_SESSION);

				// segun Rol actualizamos la cookie
				// TODO actualizar cookie
				int numPersonas = 0;
				switch (usuario.getRol()) {
				case ADMINISTRADOR:
					log.trace("Usuario Creado: " + usuario.getRol().toString());
					numPersonas = (Integer) se.getSession()
							.getServletContext()
							.getAttribute(Constantes.NUM_ADMIN) + 1;
					se.getSession()
							.getServletContext()
							.setAttribute(Constantes.NUM_ADMIN,
 numPersonas);
					break;

				case USER:
					log.trace("Usuario Creado: " + usuario.getRol().toString());
					numPersonas = (Integer) se.getSession().getServletContext()
							.getAttribute(Constantes.NUM_USER) + 1;
					se.getSession().getServletContext()
							.setAttribute(Constantes.NUM_USER, numPersonas);
					break;
				}// end switch
				log.trace("Numero de Administradores: "
						+ (String) se.getSession().getServletContext()
								.getAttribute("numAdministradores"));
				log.trace("Numero de Usuarios: "
						+ (String) se.getSession().getServletContext()
								.getAttribute("numUsuarios"));
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

	/* Ciclo de Vida de HttpSession */

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// marcar el tiempo de expiracion 30 min
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(60 * 30);
		log.trace("nueva session id:" + session.getId() + " - "
				+ session.getMaxInactiveInterval() + " s");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		String motivo = "";

		if (session.getAttribute(Constantes.USER_LOGOUT_PETICION) != null) {
			motivo = "Logout voluntario";
		} else {
			motivo = "Expiracion";
		}

		if (null != session.getAttribute(Constantes.USER_SESSION)) {
			Persona usuario = (Persona) session
					.getAttribute(Constantes.USER_SESSION);
			motivo += " usuario " + usuario.toString();
			log.trace("Usuario Eliminado: " + usuario.getRol().toString());

			// Comprobamos que usuario se ha desconectado
			int numPersonas = 0;
			if (Persona.Rol.ADMINISTRADOR == usuario.getRol()) {
				// vecesAdmin--;
				se.getSession().getAttribute(Constantes.NUM_ADMIN);
			} else {
				// vecesUser--;
			}
		} else {
			motivo += " usuario nulo";
		}

		log.info(motivo);

	}

}
