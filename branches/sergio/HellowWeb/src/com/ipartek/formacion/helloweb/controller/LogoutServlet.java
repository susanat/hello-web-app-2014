package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.comun.Constantes;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	RequestDispatcher dispatch = null;
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

		//obtenemos la sesión
		session = request.getSession();
		
		//obtenemos los datos
		if (session != null) {
			
			//comprobamos si deseamos invalidar
			if ( request.getParameter(Constantes.PARAM_SESSION_INVALIDATE) != null &&  request.getParameter(Constantes.PARAM_SESSION_INVALIDATE).equals(true)) {
				session.invalidate();
			} else {
				
				session.removeAttribute(Constantes.PARAM_SESSION_AUTHENTICATED);
				session.removeAttribute(Constantes.PARAM_SESSION_USER);				
			}
			
			session.setAttribute(Constantes.PARAM_SESSION_MSJ, Constantes.LANG_LOG_OFF);
						
		}
		
		dispatch = request.getRequestDispatcher(Constantes.JSP_INDEX);
		
		dispatch.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
