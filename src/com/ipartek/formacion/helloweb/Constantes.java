package com.ipartek.formacion.helloweb;

public interface Constantes {

	// JSPs publicas
	public static final String JSP_SALUDO = "/Saludo.jsp";
	public static final String JSP_LOGIN = "/Login.jsp";

	// JSPs backoffice
	public static final String JSP_BACKOFFICE_INDEX = "/backoffice/index.jsp";

	// parametros
	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";
	public static final String PARAMETRO_ROLL = "roll";

	// seguridad
	public static final String USER_ADMIN = "admin";
	public static final String PASS_ADMIN = "admin";
	public static final String ROLL_ADMIN = "admin";
	public static final String USER = "Aritz";
	public static final String PASS = "aritz";
	public static final String ROLL = "user";
	public static final String USER_SESSION = "user_session";

	// Paths para servlet
	public static final String PATH_LOGIN = "login";
	public static final String PATH_LOGOUT = "Logout";

	// mensajes
	public static final String MSG_KEY = "msg";
	public static final String MSG_LOGIN_INCORRECT = "Usuaro o contraseña incorrecto";
	public static final String MSG_LOGOUT_CORRECT = "Logout realizado con exito";
	public static final String MSG_NOT_ALLOWED = "No tienes permisos";

}
