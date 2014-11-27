package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatch = null;
    HttpSession session = null;
	String pUser = null;
	String pPass = null;
	
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getParameters(request);
		session = request.getSession();
		
		
		if(Constantes.USER.equals(pUser) && Constantes.PASS.equals(pPass)){
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			Persona p = new Persona(pUser, 0);
			session.setAttribute(Constantes.USER_SESSION, p);
		} else {
			if(Constantes.ADMIN.equals(pUser) && Constantes.PASS.equals(pPass)) { 		
				dispatch = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE);
				Persona p = new Persona(pUser, 0);
				session.setAttribute(Constantes.USER_SESSION, p);
			} else { 
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_LOGIN_INCORRECT);
			}
		}
		
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}
	
	private void getParameters(HttpServletRequest request){
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
	}

}
