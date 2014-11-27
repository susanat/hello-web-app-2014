package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
       
    //parametros
    String pUser = null;
    String pPass = null;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperar session
		session = request.getSession();
		
		//recoger parametros del login
		getParameters(request);
		//validar el usuario
		if ( Constantes.USER.equals(pUser) && 
			 Constantes.PASS.equals(pPass)	){
			//correcto: rediriguir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			//guardar usuario en session
			//TODO recuperar usuario de la BBDD
			Persona p = new Persona(pUser, 0);
			session.setAttribute(Constantes.USER_SESSION, p);
			
		}else{	
			//incorrecto: enviar de nuevo a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			request.setAttribute( Constantes.MSG_KEY, Constantes.MSG_LOGIN_INCORRECT );
		}	
		
		//despachar o servir JSP
		dispatch.forward(request, response);	
			
	}

	/**
	 * Recoger parametros de request
	 */
	private void getParameters(HttpServletRequest request) {
		pUser = request.getParameter( Constantes.PARAMETRO_USER );
		pPass = request.getParameter( Constantes.PARAMETRO_PASS );
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
