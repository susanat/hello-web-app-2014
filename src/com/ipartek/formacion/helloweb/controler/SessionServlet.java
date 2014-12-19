package com.ipartek.formacion.helloweb.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.util.Constante;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ServletContext context = null;
    int op = -1;
    private RequestDispatcher dispatcher = null;

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	context = request.getSession().getServletContext();
	ArrayList<Persona> personas = (ArrayList<Persona>) context
		.getAttribute(Constante.ATT_REGISTERED_USERS);

	dispatcher = request
		.getRequestDispatcher(Constante.JSP_BACKOFFICE_SESSION_LIST);
	// doOperations(request, response);
	dispatcher.forward(request, response);
    }

    private void doOperations(final HttpServletRequest request,
	    final HttpServletResponse response) {
	switch (op) {
	case 0:

	    break;

	default:// ver el listado de usuarios conectados
	    dispatcher = request
		    .getRequestDispatcher(Constante.JSP_BACKOFFICE_SESSION_LIST);
	    break;
	}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	// TODO Auto-generated method stub
    }

}
