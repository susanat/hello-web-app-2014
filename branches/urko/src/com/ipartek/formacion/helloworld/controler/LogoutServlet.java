package com.ipartek.formacion.helloworld.controler;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloworld.bean.Persona;
import com.ipartek.formacion.helloworld.util.Constante;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HttpSession session = null;
    private Persona user = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
	super();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
    }

    /**
     * @see Servlet#destroy()
     */
    @Override
    public void destroy() {
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
	HttpSession session = request.getSession();
	// Persona user = (Persona)
	// session.getAttribute(Constante.USER_SESSION);
	// if (user != null) {
	// destruirSession();

	// }

	session.removeAttribute(Constante.USER_SESSION);
	// session.setAttribute(Constante.USER_SESSION, null);

	// request.setAttribute(Constante.MSG_KEY, Constante.MSG_LOGOUT);

	// response.sendRedirect(Constante.JSP_LOGIN);
	Mensaje ms = new Mensaje(Constante.MSG_LOGOUT, "");
	request.getRequestDispatcher(Constante.JSP_LOGIN).forward(request,
		response);

    }

    private void destruirSession() {
	session.invalidate();
    }

}
