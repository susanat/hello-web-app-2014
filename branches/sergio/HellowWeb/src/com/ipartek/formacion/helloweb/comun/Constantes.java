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

	public static String JSP_SALUDO = "saludo.jsp";
    public static String JSP_LOGIN = "login.jsp";
    
    
    //**************************KEYS
    //login
    public static String PARAMETRO_USER = "cont1";
    public static String PARAMETRO_PASSWORD = "cont2";        
    public static String PARAMETRO_REQUEST_USERNAME = "username";
    
    
    public static String PARAMETRO_REQUEST_RESULT = "result";
    
    
    //session
    public static String PARAMETRO_SESSION_USER = "user_session";
    
    public static String SESSION_AUTHENTICATED = "authenticated";
    
    public static String SESSION_LAST_URL = "lasturl";
    
    
    
    
    
    
    //LANG
    public static String LANG_LOGIN_INCORRECT = "Usuario o contraseña incorrectos.";
    
}
