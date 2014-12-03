package com.ipartek.formacion.helloweb;

public interface Constantes {

	// JSPs publicas
	public static final String JSP_SALUDO = "/Saludo.jsp";
	public static final String JSP_LOGIN = "/Login.jsp";

	// JSPs backoffice
	public static final String JSP_BACKOFFICE = "backoffice/";
	public static final String JSP_BACK_INDEX = JSP_BACKOFFICE + "index.jsp";
	public static final String JSP_BACK_PERSONA_LIST = JSP_BACKOFFICE
			+ "Persona/Listado.jsp";
	public static final String JSP_BACK_PERSONA_FORM = JSP_BACKOFFICE
			+ "Persona/Form.jsp";

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

	public static final String CONTROLLER_PERSONA = "Personas";

	// mensajes
	public static final String MSG_KEY = "msg";
	public static final String MSG_LOGIN_INCORRECT = "Usuaro o contraseña incorrecto";
	public static final String MSG_LOGOUT_CORRECT = "Logout realizado con exito";
	public static final String MSG_NOT_ALLOWED = "No tienes permisos";
	public static final String MSG_ERROR_PARAMETERS = "Error recogiendo parametros";

	public static final String MSG_REG_CREADO = "Registro creado con exito";
	public static final String MSG_REG_UPDATE = "Registro Modificado con exito";
	public static final String MSG_REG_DELETE = "Registro eliminado con exito";
	public static final String MSG_REG_NOT_DELETE = "Registro NO eliminado";

	// Atributos
	public static final String ATT_PERSONAS = "personas";
	public static final String ATT_PERSONA = "persona";

	// Operaciones CRUD
	public static final String OP_KEY = "op";
	public static final String OP_UPDATE = "0";// Actualizar registro
	public static final String OP_DELETE = "1";// eliminar registro
	public static final String OP_LIST = "2";// listar todos los registros
	public static final String OP_DETAIL = "3";// mostrar detalle registros
	public static final String OP_CREATE = "3";// crea nuevo registros

}
