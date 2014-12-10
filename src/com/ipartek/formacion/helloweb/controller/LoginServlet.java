package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.i18n.Idioma;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    RequestDispatcher dispatch = null;
    HttpSession sesion = null;
    Message msg;
    // Parametros
    String pUser = null;
    String pPass = null;
    String pIdioma = Idioma.INGLES.getLocale();
    ResourceBundle messages = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
	super();
	// TODO Auto-generated constructor stub
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
	// Validar el usuario

	// TODO: Meterlo en funcion
	if (Constantes.USUARIO.equals(pUser)
		&& Constantes.USUARIO_PASS.equals(pPass)) {
	    // Usuario de rol usuario: vamos a saludo
	    dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // TODO: Recuperar usuario de la base de datos
	    Persona p = new Persona(pUser);
	    sesion.setAttribute(Constantes.USER_SESSION, p);

	} else if (Constantes.USER_ADMIN_NAME.equals(pUser)
		&& Constantes.USER_ADMIN_PASS.equals(pPass)) {
	    // Usuario de tipo administrador, tiene que ir al backoffice
	    dispatch = request
		    .getRequestDispatcher(Constantes.JSP_BACKOFFICE_INDEX);
	    Persona p = new Persona(pUser);
	    // TODO: Fallo aqui
	    p.setRol(Persona.Rol.ADMINISTRADOR);
	    sesion.setAttribute(Constantes.USER_SESSION, p);
	} else {
	    // Incorrecto: Enviar de nuevo a login.jsp
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

	Locale locale = new Locale(pIdioma.split("_")[0], pIdioma.split("_")[1]);
	messages = ResourceBundle.getBundle(Constantes.PROPERTY_I18N, locale);

	// guardar en sesion el idioma
	sesion.setAttribute(Constantes.USER_LANGUAGE, pIdioma);

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
