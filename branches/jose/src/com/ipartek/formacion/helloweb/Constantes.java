package com.ipartek.formacion.helloweb;

public class Constantes {
	//Seguridad
	public static final String USER_SESSION = "user_session";
	public static final String USER_ADMIN = "admin";
	public static final String PASS_ADMIN = "admin";
	
	public static final String USER_USER = "user";
	public static final String PASS_USER = "user";
	
	// Path para Servlets
	public static final String PATH_LOGIN = "login";
	public static final String PATH_LOGOUT = "logout";

	//JSPs
	public static final String JSP_BACKOFFICE = "/backoffice/index.jsp";
	public static final String JSP_SALUDO = "/saludo.jsp";
	public static final String JSP_LOGIN = "/login.jsp";

	//Parametros
	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";
	
	//Mensajes
	public static final String MSG_KEY = "msg";
	public static final String MSG_LOGIN_INCORRECTO = "Usuario o contraseña incorrecta";
	public static final String MSG_LOGOUT = "Hasta la vista BABY, recuerda visitarnos!!!";
	public static final String MSG_NOT_ALLOWED = "No tienes presmisos";
	
	
}
