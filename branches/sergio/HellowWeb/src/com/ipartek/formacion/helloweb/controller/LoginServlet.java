package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Utils;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.onModelPersonaError;
import com.ipartek.formacion.helloweb.temp.ShutdownExample;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * Modelo de la persona
	 */
	private ModeloPersona model = null;
	
	/**
	 * Dispatcher para la redirección
	 */
	RequestDispatcher dispatcher = null;
	
	/**
	 * Actual resquest para cada petición de servicio
	 */
	HttpServletRequest actualRequest = null;
		
	/**
	 * Contador accesos
	 */
	ShutdownExample contador = null;

	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		
		//Creamos el objeto al iniciarse el servlet
		model = new ModeloPersona();
		model.setOnIError(new onModelPersonaError() {
			
			public void onException(Persona obj, Exception ex) {
				onModelException(obj, ex);
				
			}
		});
		
		contador = new ShutdownExample();
	}
	
	/**
	 * Función que prepara los mensajes de error del modelo
	 * 
	 * @param obj Persona o null, Objeto persona que ha dado el error
	 * @param ex Excepción o null
	 */
	public void onModelException(Persona obj, Exception ex) {
		
		actualRequest.setAttribute(Constantes.ATTR_ERROR, true);
		actualRequest.setAttribute(Constantes.ATTR_ERROR_MSJ, "LoginServlet.java: Error en el modelo de datos de persona.");
		actualRequest.setAttribute(Constantes.ATTR_ERROR_EXCEPTION, ex);
	}
	
	@Override
	public void destroy() {		
		super.destroy();
		
		//destruimos el objeto al finalizar el ciclo de vida del servlet
		model = null;
	}
	  
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		//Inicializamos las variables necesarias
		Boolean validado = true;
		boolean autentificado = false;
		Persona perSesion = null;
		
		//inicializamos las respuestas
		request.setAttribute(Constantes.ATTR_ERROR, false);
		request.setAttribute(Constantes.ATTR_ERROR_MSJ, "");
		request.setAttribute(Constantes.ATTR_ERROR_EXCEPTION, null);
		
		request.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, autentificado);
		
		//obtenemos la redireccion por defecto
		String urlToDefault = Constantes.JSP_LOGIN;
		String urlTo = urlToDefault;
				
		//obtenemos la redireccion si nos la pasan
		if (request.getParameter(Constantes.PARAM_URL_TO) != null) 
		{
			urlTo = request.getParameter(Constantes.PARAM_URL_TO);
		}
		
		//obtenemos los parámetros del login
		String username = request.getParameter(Constantes.PARAMETRO_USER);
	    String password = request.getParameter(Constantes.PARAMETRO_PASSWORD);
	    String fromPath = request.getParameter(Constantes.PARAM_SESSION_LAST_URL);
				
		//validamos los parámetros del login
		if(username.equals("")) {
			validado = false;
			request.setAttribute(Constantes.ATTR_ERROR, true);
			request.setAttribute(Constantes.ATTR_ERROR_MSJ, "Usuario o contraseña vacíos");
		}
		
		if (password.equals("")) {
			validado = false;
			request.setAttribute(Constantes.ATTR_ERROR, true);
			request.setAttribute(Constantes.ATTR_ERROR_MSJ, "Usuario o contraseña vacíos");			
		}
		
		//buscamos por nombre el usuario
		if (validado) {			
			//obtenemos el usuario del origen de datos
			perSesion = model.getByName(username);			
						
			//TODO: falta campo de password en el usuario
			//usuario autentificado 
			if(perSesion != null) {				
				autentificado = true; 
				
			} else {				
				validado = false;
				request.setAttribute(Constantes.ATTR_ERROR, true);
				request.setAttribute(Constantes.ATTR_ERROR_MSJ, "Usuario o contraseña incorrecto");
				
				//devolvemos al login
				urlTo = urlToDefault;
			}
		}		
		
		//preparamos la respuesta
		request.setAttribute(Constantes.PARAM_SESSION_USER, perSesion);		
		request.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, autentificado);
		
		//de regalo, la lista de roles
		request.setAttribute(Constantes.ATTR_ROLES_LIST, CargasTemporales.getListRoles());
		
		//preparamos la session
		session.setAttribute(Constantes.PARAM_SESSION_USER, perSesion);		
		session.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, autentificado);
		
		
		
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
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		//super.service(req, resp);
		//guardamos el httpServletRequest actual, siempre pasa por aquÃ­, por lo que cada
		//peticiÃ³n tendrÃ¡ su propio request.
		actualRequest = req;
		
		contador.enteringServiceMethod();	
		
		try {		
			super.service(req, resp);	
		} 
		finally {		
			contador.leavingServiceMethod();	
		}		
		
		//TODO comprobar Autorizacion del usuario en el servlet también		
	}


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {		
		super.service(req, res);
	}

}
