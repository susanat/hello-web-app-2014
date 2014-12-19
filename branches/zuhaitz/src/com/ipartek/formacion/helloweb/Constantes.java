package com.ipartek.formacion.helloweb;

public class Constantes {

	// Usuarios
	public static final String USER_SESSION = "user_session";
	public static final String USER_LANGUAGE = "user_language";
	public static final String USER_LOGOUT_PETICION = "user_logout_peticion";

	public static final String USER_ADMIN_NAME = "admin";
	public static final String USER_ADMIN_PASS = "admin";

	public static final String USER_USER_NAME = "user";
	public static final String USER_USER_PASS = "user";

	public static final String ROLE_DEFAULT = "Invitado";
	public static final String ROLE_ADMIN = "Administrador";

	// Cookies
	public static final String COOKIE_USER_NAME = "cuser";
	public static final String COOKIE_USER_PASS = "cpass";
	public static final String COOKIE_USER_LANG = "clang";

	// Paths para Servlets
	public static final String CONTROLLER_LOGIN = "login";
	public static final String CONTROLLER_LOGOUT = "logout";

	public static final String CONTROLLER_PERSONA = "persona.do";
	public static final String CONTROLLER_CALIFICACION = "calificacion.do";
	public static final String CONTROLLER_ROLE = "role.do";
	public static final String CONTROLLER_IDIOMA = "idioma.do";

	// JSPs
	public static final String JSP_SALUDO = "saludo.jsp";
	public static final String JSP_LOGIN = "login.jsp";
	public static final String JSP_ERROR = "includes/error.jsp";

	public static final String JSP_PERSONA_LIST = "list.jsp";
	public static final String JSP_PERSONA_FORM = "form.jsp";
	public static final String JSP_TITLE_PERSONA_LIST = "Lista de Personas";
	public static final String JSP_TITLE_PERSONA_FORM = "Formulario de Persona";

	public static final String JSP_CALIFICACION_LIST = "list.jsp";
	public static final String JSP_CALIFICACION_FORM = "form.jsp";
	public static final String JSP_TITLE_CALIFICACION_LIST = "Lista de Calificaciones";
	public static final String JSP_TITLE_CALIFICACION_FORM = "Formulario de Calificacion";

	// JSPs Backoffice
	public static final String JSP_BACKOFFICE = "backoffice/";
	public static final String JSP_BACKOFFICE_INDEX = JSP_BACKOFFICE + "index.jsp";

	public static final String JSP_BACKOFFICE_PERSONA_LIST = JSP_BACKOFFICE + "persona/list.jsp";
	public static final String JSP_BACKOFFICE_PERSONA_FORM = JSP_BACKOFFICE + "persona/form.jsp";

	public static final String JSP_BACKOFFICE_CALIFICACION_LIST = JSP_BACKOFFICE + "calificacion/list.jsp";
	public static final String JSP_BACKOFFICE_CALIFICACION_FORM = JSP_BACKOFFICE + "calificacion/form.jsp";

	public static final String JSP_BACKOFFICE_ROLE_LIST = JSP_BACKOFFICE + "role/list.jsp";
	public static final String JSP_BACKOFFICE_ROLE_FORM = JSP_BACKOFFICE + "role/form.jsp";

	public static final String JSP_BACKOFFICE_IDIOMA_LIST = JSP_BACKOFFICE + "idioma/list.jsp";
	public static final String JSP_BACKOFFICE_IDIOMA_FORM = JSP_BACKOFFICE + "idioma/form.jsp";

	// Parámetros
	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";
	public static final String PARAMETRO_LANG = "lang";
	public static final String PARAMETRO_RECUERDAME = "recuerdame";

	// Mensajes
	public static final String MSG_KEY = "msg";
	public static final String MSG_NO_AUTORIZADO = "No tienes permisos para acceder a esta página";

	public static final String MSG_ERR_LOAD_LOG4J = "Error cargando LOG4J";

	// Atributos
	public static final String ATTR_PERSONAS = "personas";
	public static final String ATTR_PERSONA = "persona";

	public static final String ATTR_CALIFICACIONES = "calificaciones";
	public static final String ATTR_CALIFICACION = "calificacion";

	public static final String ATT_ROLES = "roles";
	public static final String ATT_ROLE = "role";
	public static final String ATT_MENSAJE = "mensaje";

	public static final String ATT_IDIOMAS = "idiomas";
	public static final String ATT_IDIOMA = "idioma";

	public static final String ALERT_TYPE_SUCCESS = "alert-success";
	public static final String ALERT_TYPE_DANGER = "alert-danger";

	// Operaciones CRUD
	public static final String OP_CRUD = "op";
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

	// Packages
	public static final String PROPERTY_I18N = "com.ipartek.formacion.helloweb.i18n.i18nmessages";

	// Mensajes
	public static final String MSG_UNAUTHORIZED = "No le esta permitido el acceso";
	public static final String MSG_REG_NOT_DELETED = "Error borrando registro";
	public static final String MSG_REG_DELETED = "Registro eliminado con exito";
	public static final String MSG_REG_UPDATED = "Registro actualizado con exito";
	public static final String MSG_NOT_UPDATED = "Error modificando registro";
	public static final String MSG_ERROR_PARAMETERS = "Error recogiendo parametros";
	public static final String MSG_REG_CREATED = "Registro creado con exito";
	public static final String MSG_ERR_REG_DELETED = "Error Elimnando Registro";
	public static final String MSG_NOT_ALLOWED = "No tienes permisos";

	public static final String LETRERO_CREAR = "Crear";
	public static final String LETRERO_BORRAR = "Borrar";
	public static final String LETRERO_DETALLE = "Detalle";

	// Formulario idioma
	public static final String FORM_IDIOMA_ID = "id";
	public static final String FORM_IDIOMA_LOCALE = "locale";
	public static final String FORM_IDIOMA_PAIS = "pais";
	public static final String FORM_IDIOMA_LENGUAJE = "lenguaje";
	public static final String FORM_IDIOMA_TEXTO = "texto";

}
