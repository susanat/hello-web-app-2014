package com.ipartek.formacion.helloweb;

public class Constantes {

	// Usuarios

	public static final String ADMIN_USER = "admin";
	public static final String ADMIN_PASS = "admin";
	public static final String ADMIN_ROL = "admin";

	public static final String USER_USER = "user";
	public static final String USER_PASS = "pass";
	public static final String USER_ROL = "user";

	public static final String USER_SESSION = "user_session";
	public static final String USER_LANGUAGE = "user_language";
	public static final String USER_LOGOUT_PETICION = "logout.pedida";

	public static final String PARAMETRO_RECUERDAME = "recuerdame";

	public static final String USER_ADMIN_CONT = "cont_admin";
	public static final String USER_USER_CONT = "cont_user";

	// cookies
	public static final String COOKIE_USER_NAME = "cuser";
	public static final String COOKIE_USER_PASS = "cpass";
	public static final String COOKIE_USER_IDIOM = "cidiom";

	// Paths para Servlets
	public static final String PATH_LOGIN = "login";
	public static final String PATH_LOGOUT = "logout";

	public static final String CONTROLLER_PERSONA = "persona";
	public static final String CONTROLLER_CALIFICACION = "calificacion";
	public static final String CONTROLLER_USUARIOS = "usuarios";

	// JSPs publicas

	public static final String JSP_SALUDO = "/saludo.jsp";
	public static final String JSP_LOGIN = "login.jsp";
	public static final String JSP_ERROR = "includes/error.jsp";

	// JSPs Backoffice
	public static final String JSP_BACKOFFICE = "backoffice/";
	public static final String JSP_BACK_INDEX = JSP_BACKOFFICE + "index.jsp";

	public static final String JSP_BACK_PERSONA_LIST = JSP_BACKOFFICE
			+ "persona/list.jsp";
	public static final String JSP_BACK_PERSONA_FORM = JSP_BACKOFFICE
			+ "persona/form.jsp";

	// Properties

	public static final String PROPERTY_I18N = "com.ipartek.formacion.helloweb.i18n.i18nmesages";

	// Parametros

	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";
	public static final String PARAMETRO_IDIOMA = "idioma";
	public static final String PARAMETRO_SELECT_ROL = "rol";

	// Mensajes

	public static final String MSG_KEY = "msg";
	public static final String MSG_LOGIN_INCORRECT = "Usuario o contraseña incorrecta";

	public static final String MSG_KEY_OUT = "msg";
	public static final String MSG_LOGOUT = "Usuario deslogueado";

	public static final String MSG_NOT_ALLOWED = "No tienes permisos";

	public static final String MSG_REG_CREATE = "Registro Creado con exito";
	public static final String MSG_REG_DELETE = "Registro Eliminado con exito";
	public static final String MSG_REG_UPDATE = "Registro Modificado con exito";

	public static final String MSG_ERROR_PARAMETERS = "Error recogiendo parametros";
	public static final String MSG_ERROR_REG_DELETE = "Error eliminando registros";
	public static final String MSG_ERROR_LOAD_PATH4J = "Error path log4j";

	// /Atributos

	public static final String ATT_PERSONAS = "personas";
	public static final String ATT_PERSONA = "persona";

	public static final String ATT_CALIFICACIONES = "calificaciones";
	public static final String ATT_CALIFICACION = "calificacion";

	// Operaciones CRUD

	public static final String OP_KEY = "key";
	public static final String OP_UPDATE = "0"; // Actualizar regsitro
	public static final String OP_DELETE = "1"; // Eliminar registro
	public static final String OP_LIST = "2"; // Listar todos los registros
	public static final String OP_DETAIL = "3"; // Mostrar detalle resgitro
	public static final String OP_CREATE = "4"; // Crear o insertar un nuevo
												// resgitro

}
