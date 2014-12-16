package com.ipartek.formacion.helloweb.controler;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.i18n.Idioma;
import com.ipartek.formacion.helloweb.service.UserService;
import com.ipartek.formacion.helloweb.util.Constante;
import com.ipartek.formacion.helloweb.util.Util;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String pUser = null;
    private String pPass = null;
    private String pIdioma = Idioma.INGLES.getLocale();
    private Persona user = null;
    private RequestDispatcher dispatch = null;
    private HttpSession session = null;
    private ResourceBundle messages = null;
    private final static Logger log = Logger.getLogger("ACCESOS");

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
	super.init(config);
	log.trace("Init");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {

	getParameters(request);
	// loadMessages();
	session = request.getSession();
	user = UserService.find(pUser, pPass);
	log.debug(messages.getString("ejem.parametros"));
	log.debug(I18n.getStringParametros(
		messages.getString("ejem.paramtros"), "uno", "dos"));
	Object arguments = null;
	MessageFormat.format(messages.getString("ejem.parametros"), arguments);

	validateLanguaje(request);
	validateUser(request);

	dispatch.forward(request, response);
    }

    private void validateLanguaje(final HttpServletRequest request) {
	if (pIdioma != null) {
	    session.setAttribute(Constante.LANG_SESSION, pIdioma);

	} else {
	    dispatch = request.getRequestDispatcher(Constante.JSP_LOGIN);

	    Mensaje mensaje = new Mensaje(Constante.MSG_LOGIN_INCORRECT,
		    Mensaje.MSG_TYPE_WARNING);
	    mensaje = new Mensaje(
		    messages.getString(Constante.MSG_LOGIN_INCORRECT));
	    request.setAttribute(Constante.LANG_SESSION, mensaje);
	    request.setAttribute(Constante.MSG_KEY, mensaje);
	}
    }

    private void loadMessages() {
	Locale locale = I18n.getStringLocale(pIdioma);
	messages = ResourceBundle.getBundle(Constante.PROPERTI_I18N, locale);
    }

    private void validateUser(final HttpServletRequest request) {
	if (user != null) {
	    session.setAttribute(Constante.USER_SESSION, user);
	    String ruta = Util.obtenerRutaPersona(user);
	    dispatch = request.getRequestDispatcher(ruta);
	} else {
	    dispatch = request.getRequestDispatcher(Constante.JSP_LOGIN);
	    Mensaje mensaje = new Mensaje(Constante.MSG_LOGIN_INCORRECT,
		    Mensaje.MSG_TYPE_WARNING);
	    // System.out.println(mensaje.getMsg());
	    request.setAttribute(Constante.MSG_KEY, mensaje);
	}
    }

    private void getParameters(final HttpServletRequest request) {
	pUser = request.getParameter(Constante.PARAMETRO_USER);
	pPass = request.getParameter(Constante.PARAMETRO_PASS);
	pIdioma = request.getParameter(Constante.PARAMETRO_IDIOMA);
    }
}
