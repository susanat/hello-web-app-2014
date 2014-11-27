package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.comun.Constantes;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
				
		RequestDispatcher dispatch = null;
		HttpSession session = null;
				
		String username = request.getParameter(Constantes.PARAMETRO_USER);
	    String password = request.getParameter(Constantes.PARAMETRO_PASSWORD);

	    
	    //recuperar session
	    session = request.getSession();
	    
		//recoger parametros del login
		
	    if(CargasTemporales.getPersona(username) != null) {
	    	//Correcto: redirigir a saludo.jsp
		 	dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
		 	
		 	//guardar usuario en sesión TODO recuperer usuario de la base de datos
		 	//marcamos como autentificado
		 	session.setAttribute(Constantes.SESSION_AUTHENTICATED, true);
		 	
		 	//cargamos sus datos
		 	session.setAttribute(Constantes.PARAMETRO_SESSION_USER, CargasTemporales.getPersona(username));
	    } else {
			//incorrecto: enviar de nuevo a login.jsp
		 	dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
		 	
		 	session.setAttribute(Constantes.SESSION_AUTHENTICATED, false);
		 	request.setAttribute(Constantes.PARAMETRO_REQUEST_RESULT, Constantes.LANG_LOGIN_INCORRECT);
		 			 	
		}
		
				
		//despachar o servir JSP		
		dispatch.forward(request, response);
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
