package com.ipartek.formacion.helloweb.comun;

public final class Constantes {
	
	static {
		//request.getSession().getServletContext().getRealPath("/");
	}
	
	/**
	 * Empty constructo to avoid instanciate class
	 */
	private Constantes() {
		
	}
	
	/**
	 * path del sitio
	 */
	public static String SITE_PATH = "http://localhost:8080/HelloWeb/";
	
	
	

	public static String JSP_INDEX = "index.jsp";
	
	public static String JSP_SALUDO = "saludo.jsp";
    
	public static String JSP_LOGIN = "login.jsp";
	public static String JSP_LOGOUT = "logout.jsp";
    
    
    public static String JSP_ADMINISTRACION = "backoffice/administracion.jsp";
    
    //***************NAMES FORMULARIOS
    
    //*** Formulario login
    public static String PARAMETRO_USER = "cont1";
    public static String PARAMETRO_PASSWORD = "cont2";      
        
    
    //**************Session
    
    //*** general
    /**
     * Contendrá la última url visitada (String)
     */
    public static String PARAM_SESSION_LAST_URL = "lasturl";
    
    /**
     * Contendrá un mensaje
     */
    public static String PARAM_SESSION_MSJ = "msj";
        
    /**
     * Contendrá el usuario  (Persona)
     */
    public static String PARAM_SESSION_USER = "user_session";
    
    //*** login
    /**
     * Contendrá si se ha autentificado un usuario    
     */
    public static String PARAM_SESSION_AUTHENTICATED = "authenticated";
        
    //*** logout
    /**
     * Si se desea mantener datos o invalidar la sessión completamente
     */
    public static String PARAM_SESSION_INVALIDATE = "invalidate";
    
    
    
    //*** LANG
    public static String LANG_LOGIN_INCORRECT = "Usuario o contraseña incorrectos.";
    
    public static String LANG_LOG_OFF = "Usuario o contraseña incorrectos.";
    
}
