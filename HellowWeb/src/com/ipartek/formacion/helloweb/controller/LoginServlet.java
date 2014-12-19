package com.ipartek.formacion.helloweb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Message.ETypeAlert;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Globales;
import com.ipartek.formacion.helloweb.comun.Utils;
import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.onModelPersonaError;
import com.ipartek.formacion.helloweb.temp.ShutdownExample;
import com.ipartek.formacion.helloweb.temp.UtilsTemp;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends CustomServlet {
	
	private static final long serialVersionUID = 1L;
       	
	
	public LoginServlet() {
		super();
		
		//añado el nombre de la clase para el log, sito en el CustomServlet
		this.nameClass = this;
		
	}
	
	
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
		
		this.getClass();
		
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
		log.trace("Entrando en doProcess");
		
		//obtenemos la sesion y la creamos si es necesario
		HttpSession session = request.getSession(true);
		


		/*
		try {
			Properties properties = new Properties();
			
			//Abrir un properties
			InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/com/ipartek/formacion/helloweb/i18n/" + "lang_es_ES.properties");			
			properties.load(input);
			request.setAttribute("properties", properties);
						
			//añado una propiedad
			properties.put("puesta.por.el.ayuntamiento", "Sí, me han puesto");
						
			//salvar
			//URL resourceUrl = getServletContext().getResource("/WEB-INF/classes/com/ipartek/formacion/helloweb/i18n/" + "lang_es_ES.properties");
			
			//File file = new File(resourceUrl.toURI());
			File file = new File("C:\\desarrollo\\Web\\apache-tomcat-6.0.43\\webapps\\HelloWeb\\WEB-INF\\classes\\com\\ipartek\\formacion\\helloweb\\i18n\\lang_en_ES.properties");
			
			//File file = new File(getServletContext().getContextPath() + resourceUrl.toURI());
			OutputStream output = new FileOutputStream(file);
			properties.store(output, "Prueba");
						
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		//request.getRequestDispatcher("/WEB-INF/properties.jsp").forward(request, response);
		*/	
		
		
		
		Message lMsg = new Message();
		
		//Inicializamos las variables necesarias
		Boolean validado = false;
		boolean autentificado = false;
		Persona perSesion = null;
				
		
		//obtenemos los par�metros del login
		String username = request.getParameter(Constantes.PARAMETRO_USER);
	    String password = request.getParameter(Constantes.PARAMETRO_PASSWORD);
	    	    
	    log.trace("Procesando usuario: " + username);
	    log.trace("Procesando password: " + username);
	    	    
	    //si el usuario es válido, obtenemos el  por nombre el usuario
  		if (validarUsuario(username, password)) {
  			
  			//***obtenemos el usuario del origen de datos
  			perSesion = model.getByName(username);			
  						
  			//TODO: falta campo de password en el usuario
  			//*********************************usuario autentificado y valido 
  			if(perSesion != null) {				
  				
  				//***marcamos como autentificado
  				autentificado = true;		
  				
  				Object remember = request.getParameter(Constantes.PARAM_LOGIN_REMEMBER);
  				if(remember != null) {
  					//1- creamos la cookie y la guardamos
  					gestionCoockies(response, request, session, username, password, false );
  				} else {
  					//1- Expiramos las existentes de username y password si existen
  					gestionCoockies(response, request, session, username, password, true );
  				}
  				
  				
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
		session.setAttribute(Constantes.ATTR_SESSION_USER, perSesion);
		// autentificación (true o false)
		session.setAttribute(Constantes.ATTR_SESSION_AUTHENTICATED, autentificado);
	
		
		//ESTADÍSTICAS
		UtilsTemp.setStadistics(session);
		
		
		return lMsg;
		
	}
	  
    
	private void gestionCoockies(HttpServletResponse response, HttpServletRequest request, HttpSession session, 
			String username, String password, boolean expirar) {

			if(!expirar) {
				//creamos la cookie
				Cookie user = new Cookie(Constantes.cookie_user_name, username);
				user.setMaxAge(Globales.COOKIES_MAX_EXP);
				response.addCookie(user);
			
				Cookie pass = new Cookie(Constantes.cookie_user_pass, password);
				pass.setMaxAge(Globales.COOKIES_MAX_EXP);
				response.addCookie(pass);
			
				if(session.getAttribute(Constantes.ATTR_SESSION_LOCALE) != null) {
					Cookie lang = new Cookie(Constantes.cookie_user_lang, session.getAttribute(Constantes.ATTR_SESSION_LOCALE).toString() );
					lang.setMaxAge(Globales.COOKIES_MAX_EXP);
					response.addCookie(lang);
				}
			} else {
				
				//expiramos las existentes
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equalsIgnoreCase(Constantes.cookie_user_name) || 
							cookie.getName().equals(Constantes.cookie_user_pass)) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					
				}				
			}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		
		//obtenemos la redireccion por defecto
		String urlToDefault = Constantes.JSP_REL_LOGIN;
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
			session.setAttribute(Constantes.ATTR_SESSION_LAST_URL, Constantes.JSP_REL_LOGIN);
		}
		
		if(msg.isError()) {
			log.warn("Error: " + msg.getText());
		}else {
			log.info("Info: Proceso de logueado correcto");
		}
		
				
		//codificamos la url
		urlTo = response.encodeRedirectURL(urlTo);
		
		//redirigimos
		dispatcher = request.getRequestDispatcher(Utils.getUriFile(urlTo));	    
		dispatcher.forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("Entrando por doPost");
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
	    if(session.getAttribute(Constantes.ATTR_SESSION_USER) != null){	    	
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
		
		
		
		log.info(String.valueOf(contador.getNumServices()));
		
		
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
