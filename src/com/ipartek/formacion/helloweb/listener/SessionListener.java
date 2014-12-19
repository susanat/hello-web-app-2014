package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContext;
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
public class SessionListener implements HttpSessionListener,
		HttpSessionAttributeListener {

	static final String charset = "javax.servlet.jsp.jstl.fmt.request.charset";
	private final static Logger log = Logger.getLogger("ACCESOS");

	/* Eventos sobre los atributos de HttpSession */

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeRemoved");
			gestionContadorUsuarios(se.getSession(), true);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeAdded");
			gestionContadorUsuarios(se.getSession(), true);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeReplaced");
			gestionContadorUsuarios(se.getSession(), true);
		}
	}

	/* Ciclo de Vida de HttpSession */

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session creada");

		// marcar el tiempo de expiracion 30 min
		HttpSession session = se.getSession();

		session.setMaxInactiveInterval(60 * 30);
		log.trace("nueva session id:" + session.getId() + " - "
				+ session.getMaxInactiveInterval() + " s");

		ServletContext contexto = session.getServletContext();
		synchronized (contexto) {

			Integer usuarioConectados = (Integer) contexto
					.getAttribute("usuariosConectados");
			if (usuarioConectados == null) {
				usuarioConectados = new Integer(0);
			}
			usuarioConectados += 1;
			contexto.setAttribute("usuariosConectados", usuarioConectados);
			System.out.println("Usuarios conectados: " + usuarioConectados);

		}
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
			gestionContadorUsuarios(session, false);
		} else {
			motivo += " usuario nulo";
		}

		log.info(motivo);

		System.out.println("Session destruida");
		ServletContext contexto = se.getSession().getServletContext();
		synchronized (contexto) {

			Integer usuarioConectados = (Integer) contexto
					.getAttribute("usuariosConectados");
			if (usuarioConectados == null) {
				usuarioConectados = new Integer(0);
			}
			usuarioConectados -= 1;
			contexto.setAttribute("usuariosConectados", usuarioConectados);
			System.out.println("Usuarios conectados: " + usuarioConectados);
		}

	}

	/**
	 * Compruba si hay un usuario nuevo en session y guarda en el contexto de
	 * los servlet un contador
	 * 
	 * @param se
	 */
	private synchronized void gestionContadorUsuarios(HttpSession session,
			boolean isSumar) {
		ServletContext sc = session.getServletContext();

		Persona usuario = (Persona) session
				.getAttribute(Constantes.USER_SESSION);
		if (usuario != null) {
			switch (usuario.getRol()) {
			case ADMINISTRADOR:
				int contAdmin = (Integer) sc
						.getAttribute(Constantes.USER_ADMIN_CONT);
				contAdmin = (isSumar) ? ++contAdmin : --contAdmin;
				sc.setAttribute(Constantes.USER_ADMIN_CONT, contAdmin);
				if (isSumar) {
					log.trace(">> Nuevo Administrador en session");
				} else {
					log.trace("<< Sale Administrador en session");
				}
				break;

			case USER:
				int contUser = (Integer) sc
						.getAttribute(Constantes.USER_USER_CONT);
				contUser = (isSumar) ? ++contUser : --contUser;
				sc.setAttribute(Constantes.USER_USER_CONT, contUser);
				if (isSumar) {
					log.trace(">> Nuevo Usuario en session");
				} else {
					log.trace("<< Sale Usuario en session");
				}
				break;
			}
		}

	}

}
