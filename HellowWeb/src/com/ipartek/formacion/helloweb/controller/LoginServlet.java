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
	
	RequestDispatcher dispatcher = null;
	
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
	
	public void onModelException(Persona obj, Exception ex) {
		
		actualRequest.setAttribute(Constantes.ATTR_ERROR, true);
		actualRequest.setAttribute(Constantes.ATTR_ERROR_MSJ, "Error en el modelo de datos de persona.");
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
		
		//obtenemos la redirección por defecto
		String urlToDefault = Constantes.JSP_LOGIN;
		String urlTo = urlToDefault;
				
		//obtenemos la redirección si nos la pasan
		if (request.getParameter(Constantes.PARAM_URL_TO) != null) 
		{
			
		}
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		HttpSession session = null;		
				
		String username = request.getParameter(Constantes.PARAMETRO_USER);
	    String password = request.getParameter(Constantes.PARAMETRO_PASSWORD);
	    String fromPath = request.getParameter(Constantes.PARAM_SESSION_LAST_URL);
	    
	    //recuperar session
	    session = request.getSession();
	    	    
		//recoger parametros del login
		
	    if(CargasTemporales.getPersona(username) != null) {
	    	//Correcto: redirigir a saludo.jsp si no existe procedencia
	    	
	    	if (fromPath != null && fromPath != "") {
	    		dispatcher = request.getRequestDispatcher(Utils.getUriFile(fromPath));
	    	} else {
	    		dispatcher = request.getRequestDispatcher(Constantes.JSP_SALUDO);
	    	}
	 	
		 	//guardar usuario en sesión TODO recuperer usuario de la base de datos
		 	//marcamos como autentificado
		 	session.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, true);
		 	
		 	//cargamos sus datos
		 	session.setAttribute(Constantes.PARAM_SESSION_USER, CargasTemporales.getPersona(username));
	    } else {
			//incorrecto: enviar de nuevo a login.jsp
		 	dispatch = request.getRequestDispatcher(Constantes.CONTROLLER_LOGIN);
		 	
		 	session.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, false);
		 	request.setAttribute(Constantes.PARAM_SESSION_MSJ, Constantes.LANG_LOGIN_INCORRECT);
		 			 	
		}		
				
		//despachar o servir JSP		
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
		//guardamos el httpServletRequest actual, siempre pasa por aquí, por lo que cada
		//petición tendrá su propio request.
		actualRequest = req;
		
		contador.enteringServiceMethod();	
		
		try {		
			super.service(req, resp);	
		} 
		finally {		
			contador.leavingServiceMethod();	
		}		
		
		//TODO comprobar Autorización del usuario		
	}


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {		
		super.service(req, res);
	}

}
