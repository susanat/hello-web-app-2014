package com.ipartek.formacion.helloweb;

public class Constantes {

	// Usuarios
	public static final String USER_SESSION = "user_session";

	public static final String USER_ADMIN_NAME = "admin";
	public static final String USER_ADMIN_PASS = "admin";

	public static final String USER_USER_NAME = "user";
	public static final String USER_USER_PASS = "user";

	// Paths para Servlets
	public static final String CONTROLLER_LOGIN = "login";
	public static final String CONTROLLER_LOGOUT = "logout";
	public static final String CONTROLLER_PERSONA = "persona";

	// JSPs
	public static final String JSP_SALUDO = "saludo.jsp";
	public static final String JSP_LOGIN = "login.jsp";
	public static final String JSP_PERSONA_LIST = "list.jsp";
	public static final String JSP_PERSONA_FORM = "form.jsp";

	public static final String JSP_TITLE_PERSONA_LIST = "Lista de Personas";
	public static final String JSP_TITLE_PERSONA_FORM = "Formulario de Personas";

	// JSPs Backoffice
	public static final String JSP_BACKOFFICE = "backoffice/";
	public static final String JSP_BACKOFFICE_INDEX = JSP_BACKOFFICE + "index.jsp";

	public static final String JSP_BACKOFFICE_PERSONA_LIST = JSP_BACKOFFICE + "persona/list.jsp";
	public static final String JSP_BACKOFFICE_PERSONA_FORM = JSP_BACKOFFICE + "persona/form.jsp";

	// Parámetros
	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";

	// Mensajes
	public static final String MSG_KEY = "msg";
	public static final String MSG_LOGIN_INCORRECT = "Usuario o contraseña incorrecta";
	public static final String MSG_LOGOUT = "Usuario deslogueado";
	public static final String MSG_NO_AUTORIZADO = "No tienes permisos para acceder a esta página";

	public static final String MSG_REG_INSERTED = "Registro creado con éxito";
	public static final String MSG_REG_DELETED = "Registro eliminado con éxito";
	public static final String MSG_REG_UPDATED = "Registro modificado con éxito";

	public static final String MSG_ERR_PARAMETERS = "Error recogiendo parámetros";
	public static final String MSG_ERR_DELETE = "Error eliminando registro";

	public static final String MSG_OP_NOT_SUPPORTED = "Operación no permitida";

	// Atributos
	public static final String ATTR_PERSONAS = "personas";
	public static final String ATTR_PERSONA = "persona";

	// Operaciones CRUD
	/**
	 * Actualizar registro.
	 */
	public static final int OP_UPDATE = 0;
	/**
	 * Borrar registro.
	 */
	public static final int OP_DELETE = 1;
	/**
	 * Listar todos los registros.
	 */
	public static final int OP_LIST = 2;
	/**
	 * Mostrar el detalle.
	 */
	public static final int OP_DETAIL = 3;
	/**
	 * Crear registro.
	 */
	public static final int OP_INSERT = 4;

}
