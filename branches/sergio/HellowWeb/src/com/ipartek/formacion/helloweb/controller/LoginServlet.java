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
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Message.ETypeAlert;
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
	 * Dispatcher para la redirecci�n
	 */
	RequestDispatcher dispatcher = null;
	
	/**
	 * Actual resquest para cada petici�n de servicio
	 */
	//HttpServletRequest actualRequest = null;
		
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
	 * Funci�n que prepara los mensajes de error del modelo
	 * 
	 * @param obj Persona o null, Objeto persona que ha dado el error
	 * @param ex Excepci�n o null
	 */
	public void onModelException(Persona obj, Exception ex) {
		//cumplimentamos el error		
		msg.setError(true);
		msg.setText("LoginServlet.java: Error en el modelo de datos de persona.");
		msg.setException(ex);
		msg.setType(ETypeAlert.DANGER);
	}
	
	@Override
	public void destroy() {		
		super.destroy();
		
		//destruimos el objeto al finalizar el ciclo de vida del servlet
		model = null;
	}
	
	/**
	 * Realizamos el proceso de validación y obtención de la autentificación del usuario
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private Message doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos la sesion
		HttpSession session = request.getSession();

		Message lMsg = new Message();
		
		//Inicializamos las variables necesarias
		Boolean validado = false;
		boolean autentificado = false;
		Persona perSesion = null;
				
		
		//obtenemos los par�metros del login
		String username = request.getParameter(Constantes.PARAMETRO_USER);
	    String password = request.getParameter(Constantes.PARAMETRO_PASSWORD);
	    	    
	    //si el usuario es válido, obtenemos el  por nombre el usuario
  		if (validarUsuario(username, password)) {
  			
  			//obtenemos el usuario del origen de datos
  			perSesion = model.getByName(username);			
  						
  			//TODO: falta campo de password en el usuario
  			//usuario autentificado 
  			if(perSesion != null) {				
  				autentificado = true;				
  			} else {				
  				validado = false;
  				
  				lMsg.setError(true);
  				lMsg.setText("Usuario o contraseña incorrecto");
  				lMsg.setType(ETypeAlert.DANGER);  								
  				
  			}
  		}	

						
		//Preparamos la respuesta:
		// añadimos el error (exista o no)
		request.setAttribute(Constantes.ATTR_ERROR, msg);		
		
		//Preparamos la sesion:
		// usuario (puede ser null)		
		session.setAttribute(Constantes.PARAM_SESSION_USER, perSesion);
		// autentificación (true o false)
		session.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, autentificado);
	
		return lMsg;
		
	}
	  
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//obtenemos la redireccion por defecto
		String urlToDefault = Constantes.JSP_LOGIN;
		String urlTo = urlToDefault;
				
		//obtenemos la redireccion si nos la pasan
		if (request.getParameter(Constantes.PARAM_URL_TO) != null) 
		{
			urlTo = request.getParameter(Constantes.PARAM_URL_TO);
		}
		
		if(!isAlreadyAutentificado(request)) {
			msg = doProcess(request, response);
			
			if(msg.isError()) {
				urlTo = urlToDefault;
			}
		}
		
		//si no ha habido fallo, modificamos la última url visitada con el login (evitamos problemas de redirección)
		if(!msg.isError()){
			session.setAttribute(Constantes.PARAM_SESSION_LAST_URL, Constantes.JSP_LOGIN);
		}
		
		
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
	
	
	/**
	 * Comprueba si un usuario ya está autentificado siempre que le pasemos el usuario y el password
	 * 
	 * @param request petición
	 * @return
	 */
	
	private boolean isAlreadyAutentificado(HttpServletRequest request) 
	{
		Boolean isAutentificado = false;
		HttpSession session = request.getSession();		
		
		//comprobamos si ya está logueado	    
	    if(session.getAttribute(Constantes.PARAM_SESSION_USER) != null){	    	
	    		isAutentificado = true;
	    		
	    		//TODO: log en el server de como ha llegado de nuevo al login estando autentificado, posible problema
	    		    	
	    }
	
		return isAutentificado;		
	}
	
	
	
	
	/**
	 * Comprueba si son válidos el dato usuario y el dato password
	 * @param username nombre de usuario
	 * @param password contraseña
	 * @return true si pasa la validacion, false en caso contrario
	 */
	private boolean validarUsuario (String username, String password) {
		Boolean validado = true;
		
		//validamos los par�metros del login
	    if(username == null || password == null) {
	    	validado = false;
			
			msg.setError(true);
			msg.setText("Usuario o contraseña vacíos");
			msg.setType(ETypeAlert.WARNING);
	    } else {	    

			if(username.equals("")) {
				validado = false;
				
				msg.setError(true);
				msg.setText("Usuario o contraseña vacíos");
				msg.setType(ETypeAlert.WARNING);
				
			}
			
			if (password.equals("")) {
				validado = false;
	
				msg.setError(true);
				msg.setText("Usuario o contraseña vacíos");
				msg.setType(ETypeAlert.WARNING);
			}
	    }
		
		return validado;
	}
	
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		//super.service(req, resp);
		//guardamos el httpServletRequest actual, siempre pasa por aquí, por lo que cada
		//petición tendrá su propio request.
		//actualRequest = req;

		//nuevo mensaje de error
		msg = new Message();
		
		contador.enteringServiceMethod();	
		
		try {		
			super.service(req, resp);	
		} 
		finally {		
			contador.leavingServiceMethod();	
		}		
		
		//TODO comprobar Autorizacion del usuario en el servlet tambi�n		
	}

	/*
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {		
		super.service(req, res);
	}
	*/

}
