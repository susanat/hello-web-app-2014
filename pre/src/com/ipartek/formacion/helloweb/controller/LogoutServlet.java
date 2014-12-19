package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger("ACCESOS");
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperar session del usuario
		HttpSession session = request.getSession();
		
	
		session.setAttribute( Constantes.USER_LOGOUT_PETICION , true);
		//invalidar session
		session.invalidate();
		
		//forwar a login
		Mensaje msg = new Mensaje(Constantes.MSG_LOGOUT, Mensaje.MSG_TYPE_INFO);
		request.setAttribute( Constantes.MSG_KEY, msg );
		request.getRequestDispatcher(Constantes.JSP_LOGIN).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
