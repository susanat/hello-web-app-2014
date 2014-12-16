package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

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

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final static Logger log = Logger.getLogger(LoginServlet.class);

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

	HttpSession session = request.getSession();
	if (null != session.getAttribute(Constantes.USER_SESSION)) {
	    Persona usuario = (Persona) session
		    .getAttribute(Constantes.USER_SESSION);
	    System.out.println("Deslogeando a" + usuario.toString());

	} else {
	    System.out.println("Usuario en sesion es nulo");
	}

	request.getSession().removeAttribute(Constantes.USER_SESSION);

	// Otra opcion
	// request.getSession().invalidate();
	Message mensaje = new Message();
	mensaje.setMsg(Constantes.MSG_LOGOUT);
	mensaje.setType(Constantes.ALERT_TYPE_SUCCESS);
	request.setAttribute(Constantes.ATT_MENSAJE, mensaje);
	// TODO: Sacar usuario
	log.info("Usuario desconectado");
	request.getRequestDispatcher(Constantes.JSP_LOGIN).forward(request,
		response);

	// response.sendRedirect(request.getContextPath() + "/"
	// + Constantes.JSP_LOGIN);
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
