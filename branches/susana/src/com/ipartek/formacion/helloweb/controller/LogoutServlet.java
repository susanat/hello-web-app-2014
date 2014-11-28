package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// recuperar session del usuario - asi ya tendo el objeto session
	HttpSession session = request.getSession();

	// poner a null su session - Otra opcion session.invalidate();
	session.setAttribute(Constantes.USER_SESSION, null);

	// forwar a login - tambien se podria usar como en LoginServlet - poner
	// al final para evitar problemas
	request.getRequestDispatcher(Constantes.JSP_SALUDO).forward(request,
		response);
	request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_LOGOUT);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// lo puenteo de este te va el GET
	doGet(request, response);
    }

}
