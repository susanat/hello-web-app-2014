package com.ipartek.formacion.helloweb;

public interface Constantes {

	// JSPs
	public static final String JSP_SALUDO = "/Saludo.jsp";
	public static final String JSP_LOGIN = "/Login.jsp";
	public static final String JSP_BACKOFFICE = "/backoffice/Login.jsp";

	// parametros
	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";

	// seguridad
	public static final String USER_ADMIN = "admin";
	public static final String PASS_ADMIN = "admin";
	public static final String USER = "Aritz";
	public static final String PASS = "aritz";
	public static final String USER_SESSION = "user_session";

	// Paths para servlet
	public static final String PATH_LOGIN = "login";

	// mensajes
	public static final String MSG_KEY = "msg";
	public static final String MSG_LOGIN_INCORRECT = "Usuaro o contraseña incorrecto";

}
