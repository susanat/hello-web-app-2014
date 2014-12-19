package com.ipartek.formacion.helloweb;

public class Constantes {

	// Usuarios
	public static final String USER_SESSION = "user_session";
	public static final String USER_LANGUAGE = "user_language";
	public static final String USER_LOGOUT_PETICION = "logout.pedida";

        public static final String USER_ADMIN_NAME = "admin";
	public static final String USER_ADMIN_PASS = "admin";

	public static final String USER_USER_NAME = "user";
	public static final String USER_USER_PASS = "user";

	// cookies
	public static final String COOKIE_USER_NAME = "cuser";
	public static final String COOKIE_USER_PASS = "cpass";
	public static final String COOKIE_USER_IDIOM = "cidiom";

        // Paths para Servlets
	public static final String PATH_LOGIN = "login";
	public static final String PATH_LOGOUT = "logout";

	public static final String CONTROLLER_PERSONA = "persona.do";
	public static final String CONTROLLER_CALIFICACION = "calificacion.do";
	public static final String CONTROLLER_ROLE = "RoleServlet.do";

	// JSPs publicas
	public static final String JSP_SALUDO = "saludo.jsp";
	public static final String JSP_LOGIN = "login.jsp";
	public static final String JSP_ERROR = "includes/error.jsp";

	// JSPs Backoffice
	public static final String JSP_BACKOFFICE = "backoffice/";
	public static final String JSP_BACK_INDEX = JSP_BACKOFFICE + "index.jsp";

	public static final String JSP_BACK_PERSONA_LIST = JSP_BACKOFFICE
			+ "persona/list.jsp";
	public static final String JSP_BACK_PERSONA_FORM = JSP_BACKOFFICE
			+ "persona/form.jsp";



	// Calificacion
	public static final String JSP_BACK_CALIFICACION_LIST = JSP_BACKOFFICE
			+ "calificacion/list.jsp";
	public static final String JSP_BACK_CALIFICACION_FORM = JSP_BACKOFFICE
			+ "calificacion/form.jsp";

	public static final String JSP_BACKOFFICE_ROLE_LIST = JSP_BACKOFFICE
			+ "role/list.jsp";

	public static final String JSP_BACKOFFICE_ROLE_FORM = JSP_BACKOFFICE
			+ "role/form.jsp";

	// Properties
	public static final String PROPERTI_I18N = "com.ipartek.formacion.helloweb.i18n.i18nmesages";

	// Parametros
	public static final String PARAMETRO_USER = "user";
	public static final String PARAMETRO_PASS = "pass";
	public static final String PARAMETRO_IDIOMA = "idioma";
	public static final String PARAMETRO_RECUERDAME = "recuerdame";

	// Mensajes
	public static final String MSG_KEY = "msg";
	public static final String MSG_LOGIN_INCORRECT = "Usuario o contraseña incorrecta";
	public static final String MSG_LOGOUT = "Hasta la Vista BABY, recuerda visitarnos!!!";

	public static final String MSG_REG_CREATE = "Registro Creado con exito";
	public static final String MSG_REG_DELETE = "Registro Eliminado con exito";
	public static final String MSG_REG_UPDATE = "Registro Modificado con exito";

	public static final String MSG_NOT_ALLOWED = "No tienes permisos";

	public static final String MSG_ERR_PARAMETERS = "Error recogiendo Parametros";
	public static final String MSG_ERR_REG_DELETE = "Error Elimnando Registro";

	public static final String MSG_ERR_LOAD_LOG4J = "Error cargando LOG4J";

	public static final String MSG_UNAUTHORIZED = "No le esta permitido el acceso";
    public static final String MSG_REG_CREATED = "Registro creado con exito";
    public static final String MSG_REG_DELETED = "Registro eliminado con exito";
    public static final String MSG_REG_UPDATED = "Registro actualizado con exito";
    public static final String MSG_ERROR_PARAMETERS = "Error recogiendo parametros";
    public static final String MSG_REG_NOT_DELETED = "Error borrando registro";
    public static final String MSG_NOT_UPDATED = "Error modificando registro";

	// Atrinuttos
	public static final String ATT_PERSONAS = "personas";
	public static final String ATT_PERSONA = "persona";
	public static final String ATT_ROLES = "roles";
    public static final String ATT_ROLE = "role";
    public static final String ATT_MENSAJE = "mensaje";

	public static final String ATT_CALIFICACIONES = "calificaciones";
	public static final String ATT_CALIFICACION = "calificacion";

	public static final String ALERT_TYPE_SUCCESS = "alert-success";
    public static final String ALERT_TYPE_DANGER = "alert-danger";

    public static final String LETRERO_CREAR = "Crear";
    public static final String LETRERO_BORRAR = "Borrar";
    public static final String LETRERO_DETALLE = "Detalle";

	// Operaciones CRUD
	public static final String OP_KEY = "op"; // Actualizar Registro
	public static final String OP_UPDATE = "0"; // Actualizar Registro
	public static final String OP_DELETE = "1"; // Eliminar Registro
	public static final String OP_LIST = "2"; // Listar todos los Regsitros
	public static final String OP_DETAIL = "3"; // Mostrar Detalle Registro
	public static final String OP_CREATE = "4"; // Crear o insertar Registro

}

