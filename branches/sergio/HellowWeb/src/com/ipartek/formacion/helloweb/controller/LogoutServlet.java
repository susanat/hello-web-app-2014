package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.estadisticas.UserSession;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Utils;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.onModelPersonaError;
import com.ipartek.formacion.helloweb.temp.ShutdownExample;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * Dispatcher para la redirecci�n
	 */
	RequestDispatcher dispatcher = null;
	/**
	 * Contador accesos
	 */
	ShutdownExample contador = null;

	/**
	 * Mensaje de error
	 */
	Message msg = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
				
		contador = new ShutdownExample();
	}
	
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = null;
		
		//obtenemos la redireccion por defecto
		//TODO parametrizable, por ahora, login o index
		String urlToDefault = Constantes.JSP_REL_LOGIN;
		String urlTo = urlToDefault;
		
		//redirigimos al login por defecto no a donde se ha deslogueado
		/**
		//obtenemos la redireccion si nos la pasan
		if (request.getParameter(Constantes.PARAM_URL_TO) != null) 
		{
			urlTo = request.getParameter(Constantes.PARAM_URL_TO);
		}
		*/
		
		
		//obtenemos la sesión
		session = request.getSession();
				
		
		/*
		//obtenemos los datos
		if (session != null) {
			
			//comprobamos si deseamos invalidar
			if ( request.getParameter(Constantes.PARAM_SESSION_INVALIDATE) != null)	{
				session.invalidate();
				//casca si no la obtenemos de nuevo
				session = request.getSession();
				
			} else {
				//anulamos la session, solo los datos
				session.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, false);
				session.setAttribute(Constantes.PARAM_SESSION_USER, null);				
			}
						
		}
		*/
		
		
		session.setAttribute(Constantes.ATTR_SESSION_OFF_CAUSE, UserSession.ECauseSessionOff.LOGOUT);
		
		//Invalido siempre (TODO: ver si cambiar y solo borrar usuario o por defecto invalidar)
		session.invalidate();
		//casca si no la obtenemos de nuevo
		session = request.getSession();
		
		
		
		//creamos una nueva session si está invalidada
		
		//si no ha habido fallo, modificamos la última url visitada con el login
		if(! msg.isError()){
			session.setAttribute(Constantes.ATTR_SESSION_LAST_URL, Constantes.JSP_REL_LOGIN);
		}
		
		
		//request.setAttribute(Constantes.ATTR_LOGOUT_ACTION, true);
		
		//redirigimos con redirect
		response.sendRedirect(Constantes.JSP_REL_LOGIN);
		
		
		
		//dispatcher = request.getRequestDispatcher(Utils.getUriFile(urlTo));	    
		//dispatcher.forward(request, response);		
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
	

		//nuevo mensaje de error
		msg = new Message();
		
		contador.enteringServiceMethod();	
		
		try {		
			super.service(req, resp);	
		} 
		finally {		
			contador.leavingServiceMethod();	
		}	
	}

}
