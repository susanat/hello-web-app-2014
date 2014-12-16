package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.i18n.Idioma;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final static Logger log = Logger.getLogger(LoginServlet.class);

    RequestDispatcher dispatch = null;
    HttpSession sesion = null;
    Message msg;
    // Parametros
    String pUser = null;
    String pPass = null;
    String pIdioma = Idioma.INGLES.getLocale();
    ResourceBundle messages = null;

    @Override
    public void init(ServletConfig config) throws ServletException {

	super.init(config);
	PropertyConfigurator
		.configure("C:/desarrollo/apache-tomcat-6.0.37/webapps/log4j.properties");
	// log.info("Log cargado");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	msg = new Message();
	// recuperar sesion
	sesion = request.getSession();

	// recoger parametros del login
	getParameters(request);

	// cargar fichero de mensajes
	loadMensajes();

	System.out.println(I18n.getStringParametros(
		messages.getString("ejem.parametros"), "uno", "dos"));
	// Validar el usuario

	// TODO: Meterlo en funcion
	if (Constantes.USUARIO.equals(pUser)
		&& Constantes.USUARIO_PASS.equals(pPass)) {
	    // Usuario de rol usuario: vamos a saludo
	    dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // TODO: Recuperar usuario de la base de datos
	    Persona p = new Persona(pUser);
	    sesion.setAttribute(Constantes.USER_SESSION, p);
	    log.info("Usuario " + pUser + " logeado");
	} else if (Constantes.USER_ADMIN_NAME.equals(pUser)
		&& Constantes.USER_ADMIN_PASS.equals(pPass)) {
	    // Usuario de tipo administrador, tiene que ir al backoffice
	    dispatch = request
		    .getRequestDispatcher(Constantes.JSP_BACKOFFICE_INDEX);
	    Persona p = new Persona(pUser);
	    // TODO: Fallo aqui
	    p.setRol(Persona.Rol.ADMINISTRADOR);
	    sesion.setAttribute(Constantes.USER_SESSION, p);
	    // Ponemos mensaje en fichero de log
	    log.info("Usuario " + pUser + " logeado");
	} else if (pUser == null && pPass == null) {
	    System.out.println("Entrada sin enviar formulario");
	    dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);

	} else {
	    // Incorrecto: Enviar de nuevo a login.jsp
	    log.warn("Error al logearse con " + pUser + " - " + pPass);
	    // TODO: Mirar si el login es vacio

	    msg.setMsg(messages.getString("msg.login.incorrect"));
	    // msg.setMsg(Constantes.MSG_LOGIN_INCORRECT);

	    msg.setType(Constantes.ALERT_TYPE_DANGER);
	    dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
	    request.setAttribute(Constantes.ATT_MENSAJE, msg);
	}

	// despachar o servir el jsp

	dispatch.forward(request, response);
    }

    private void loadMensajes() {

	if (pIdioma == null) {
	    pIdioma = Idioma.INGLES.getLocale();
	    System.out
		    .println("No viene parametro de idioma, ponemos idioma por defecto en ingles");
	}
	Locale locale = new Locale(pIdioma.split("_")[0], pIdioma.split("_")[1]);
	messages = ResourceBundle.getBundle(Constantes.PROPERTY_I18N, locale);

	// guardar en sesion el idioma
	sesion.setAttribute(Constantes.USER_LANGUAGE, pIdioma);
	log.debug("Cargados mensajes de properties " + Constantes.PROPERTY_I18N
		+ locale);

    }

    /**
     * Recoger parametros de request
     *
     * @param request
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

}
