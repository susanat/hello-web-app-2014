package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	request.getSession().removeAttribute(Constantes.USER_SESSION);

	// Otra opcion
	// request.getSession().invalidate();
	request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_LOGOUT);
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
