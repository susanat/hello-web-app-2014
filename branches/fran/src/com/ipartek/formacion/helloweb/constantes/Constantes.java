package com.ipartek.formacion.helloweb.constantes;

public class Constantes {
	// Seguridad
	public static final String USER = "admin";
	public static final String PASS = "admin";
	public static final String ROLE_ADMIN = "admin";
	public static final String USER_USER = "user";
	public static final String PASS_USER = "user";
	public static final String ROLE_USER = "user";
	public static final String USER_SESSION = "user_session";
	public static final String USER_ROLE = "user_role";
	public static final String USER_SESSION_IDIOMA = "user_session_idioma";

	// JSPs púbicas
	public static final String JSP_SALUDO = "/saludo.jsp";
	public static final String JSP_LOGIN = "/login.jsp";

	// JSPs backoffice
	public static final String JSP_BACKOFFICE = "backoffice";
	public static final String JSP_BACK_INDEX = JSP_BACKOFFICE + "/index.jsp";
	public static final String JSP_BACK_PERSONA_LIST = JSP_BACKOFFICE
			+ "/persona/list.jsp";
	public static final String JSP_BACK_PERSONA_FORM = JSP_BACKOFFICE
			+ "/persona/form.jsp";

	// Path para servlets
	public static final String PATH_LOGIN = "login";
	public static final String PATH_LOGOUT = "logout";
	public static final String CONTROLLER_PERSONA = "persona";

	// Parámetros
	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";
	public static final String PARAMETRO_IDIOMA = "idioma";

	// Mensajes
	public static final String MSG_KEY = "msg";
	public static final int COD_LOGIN_INCORRECT = 0;
	public static final String MSG_LOGIN_INCORRECT = "Usuario o clave incorrecta";
	public static final int COD_NOT_ALLOWED = 0;
	public static final String MSG_NOT_ALLOWED = "No tienes permisos";
	public static final int COD_REG_CREATE = 0;
	public static final String MSG_REG_CREATE = "Registro creado con éxito";
	public static final int COD_REG_DELETE = 0;
	public static final String MSG_REG_DELETE = "Registro eliminado con éxito";
	public static final int COD_REG_UPDATE = 0;
	public static final String MSG_REG_UPDATE = "Registro modificado con éxito";
	public static final int COD_ERR_PARAM = 0;
	public static final String MSG_ERR_PARAM = "Error al recibir parámetros";
	public static final int COD_ERR_DELETE = 0;
	public static final String MSG_ERR_DELETE = "Error al eliminar el registro";

	// Atributos
	public static final String ATT_PERSONAS = "personas";
	public static final String ATT_PERSONA = "persona";

	// Operaciones
	public static final String OP_KEY = "mode";
	public static final String OP_UPDATE = "0";
	public static final String OP_DELETE = "1";
	public static final String OP_LIST = "2";
	public static final String OP_DETAIL = "3";
	public static final String OP_INSERT = "4";

	// Properties
	public static final String PROPERTI_I18N = "com.ipartek.formacion.helloweb.i18n.i18nmesages";
}
