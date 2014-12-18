package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.Rol;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.i18n.Idioma;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RequestDispatcher dispatch = null;
    HttpSession session = null;
    private static Logger log = null;

    ResourceBundle messages = null;

    // parametros
    String pUser = null;
    String pPass = null;
    String pIdioma = Idioma.INGLES.getLocale();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * Se ejecuta una sola vez e inicializa el Servlet.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
	log = Logger.getLogger("ACCESOS");
	loadLog4j(config.getServletContext());
	super.init(config);

    }

    /**
     * Cargar la configuracion de Log4j
     */
    private void loadLog4j(ServletContext sce) {
	String prefix = sce.getRealPath("/");
	PropertyConfigurator
		.configure(prefix + "WEB-INF/conf/log4j.properties");
	log.info("LOG cargado");

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// recuperar sesion
	session = request.getSession();

	if (!checkSession(request)) {
	    // recoger parametros del login
	    getParameters(request);

	    // cargar fichero de mensajes
	    loadMessages();

	    // validar usuario
	    validateUser(request);
	}

	// despachar o servir JSP
	dispatch.forward(request, response);
    }

    /**
     * Check si existe usuario en session y cargar el dispatcher segun su rol
     *
     * @param request
     * @return true si existe session de usuario, false en caso contrario
     */
    private boolean checkSession(HttpServletRequest request) {
	boolean resul = false;

	if (session.getAttribute(Constantes.USER_SESSION) != null) {
	    Persona usuario = (Persona) session
		    .getAttribute(Constantes.USER_SESSION);
	    // segun Rol cargar el dispatcher
	    switch (usuario.getRol()) {
	    case ADMINISTRADOR:
		dispatch = request
			.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
		resul = true;
		break;
	    case USUARIO:
		dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
		resul = true;
		break;
	    } // end switch

	}

	return resul;
    }

    /**
     * Comprobar los datos del Login y mirar si el rol es "administrador" o
     * "usuario"
     *
     * <ol>
     * <li>Administrador: ir a backoffice</li>
     * <li>Usuario: ir a backoffice</li>
     * <li >Si no validado: retornar al login</li>
     * <ol>
     *
     */
    private void validateUser(HttpServletRequest request) {
	// Administrador: ir a backoffice
	if (Constantes.USER_ADMIN.equals(pUser)
		&& Constantes.PASS_ADMIN.equals(pPass)) {
	    // correcto: redirigir a un JSP
	    log.info("Acceso usuario ADMINISTRADOR: " + pUser + " " + pPass);
	    dispatch = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);

	    // guardar datos en session
	    // TODO recuperar usuario de la BD
	    Persona p = new Persona(pUser, 0, Rol.ADMINISTRADOR);
	    session.setAttribute(Constantes.USER_SESSION, p);

	    // Usuario: ir a saludo
	} else if (Constantes.USER.equals(pUser)
		&& Constantes.PASS.equals(pPass)) {

	    // correcto: redirigir a un JSP
	    dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
	    log.info("Acceso usuario NORMAL: " + pUser + " " + pPass);
	    // guardar datos en session
	    // TODO recuperar usuario de la BD
	    Persona p = new Persona(pUser, 0, Rol.USUARIO);
	    session.setAttribute(Constantes.USER_SESSION, p);

	} else if ((pUser == null) && (pPass == null)) {

	    log.trace("entrada sin submitar formulario");
	    dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);

	} else {
	    // incorrecto: enviar de nuevo a login.jsp
	    dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);

	    // Si NO es null el password, no hemos entrado por el formulario de
	    // login

	    Mensaje msg = new Mensaje(
		    messages.getString("msg.login.incorrect"),
		    Mensaje.MSG_TYPE_DANGER);
	    request.setAttribute(Constantes.MSG_KEY, msg);
	    // TODO cambiar por mensajes de Properties
	    log.warn("Usuario incorrecto [" + pUser + "," + pPass + "]");

	}

    }

    /**
     * Recoger parametros de request
     */
    private void getParameters(HttpServletRequest request) {
	pUser = request.getParameter(Constantes.PARAMETRO_USER);
	pPass = request.getParameter(Constantes.PARAMETRO_PASS);
	pIdioma = request.getParameter(Constantes.PARAMETRO_IDIOMA);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
    }

    /**
     * Carga los mensajes con el idioma establecido
     */
    private void loadMessages() {
	if (pIdioma == null) {
	    pIdioma = Idioma.INGLES.getLocale();
	    log.warn("NO viene parametro idioma Ponemos " + pIdioma
		    + " por defecto");
	}

	Locale locale = new Locale(pIdioma.split("_")[0], pIdioma.split("_")[1]);
	messages = ResourceBundle.getBundle(Constantes.PROPERTY_I18N, locale);

	// guardar en session el language
	session.setAttribute(Constantes.USER_LANGUAGE, pIdioma);
    }
}
