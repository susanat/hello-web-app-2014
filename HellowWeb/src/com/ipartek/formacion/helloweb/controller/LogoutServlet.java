package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Utils;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	RequestDispatcher dispatcher = null;
	HttpSession session = null;
	String lastPath = "index.jsp";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//obtenemos la redireccion por defecto
		String urlToDefault = Constantes.JSP_LOGIN;
		String urlTo = urlToDefault;
				
		//obtenemos la redireccion si nos la pasan
		if (request.getParameter(Constantes.PARAM_URL_TO) != null) 
		{
			urlTo = request.getParameter(Constantes.PARAM_URL_TO);
		}
		
		
		//obtenemos la sesión
		session = request.getSession();
		
		//obtenemos los datos
		if (session != null) {
			
			//comprobamos si deseamos invalidar
			if ( request.getParameter(Constantes.PARAM_SESSION_INVALIDATE) != null)	{
				session.invalidate();
			} else {
				//anulamos la session, solo los datos
				session.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, false);
				session.setAttribute(Constantes.PARAM_SESSION_USER, null);				
			}
						
		}
		
		request.setAttribute(Constantes.ATTR_LOGOUT_ACTION, true);
		
		
		//redirigimos necesario
		dispatcher = request.getRequestDispatcher(Utils.getUriFile(urlTo));	    
		dispatcher.forward(request, response);			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
