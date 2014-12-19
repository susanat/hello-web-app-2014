package com.ipartek.formacion.helloweb;

public class Constantes {
    // Usuarios
    public static final String USER_SESSION = "user_session";
    public static final String USER_LANGUAGE = "user_language";
    public static final String USER_LOGOUT_PETICION = "logout.pedida";

    public static final String USER_ADMIN_CONT = "cont_admin";
    public static final String USER_USER_CONT = "cont_user";

    public static final String USER_ADMIN = "admin";
    public static final String PASS_ADMIN = "admin";

    public static final String USER = "user";
    public static final String PASS = "user";

    // Cookies

    public static final String COOKIE_USER_NAME = "cuser";
    public static final String COOKIE_USER_PASS = "cpass";
    public static final String COOKIE_USER_IDIOM = "cidiom";

    // Paths para Servlets
    public static final String PATH_LOGIN = "login";
    public static final String PATH_LOGOUT = "logout";
    public static final String CONTROLLER_PERSONA = "persona.do";
    public static final String CONTROLLER_CALIFICACION = "calificacion.do";

    // JSPs
    public static final String JSP_SALUDO = "/saludo.jsp";
    public static final String JSP_LOGIN = "/login.jsp";
    public static final String JSP_LOGOUT = "/logout.jsp";

    // JSPs Backoffice
    public static final String BACKOFFICE_FOLDER = "backoffice/";
    public static final String JSP_BACK_INDEX = BACKOFFICE_FOLDER + "index.jsp";
    public static final String JSP_BACK_PERSONA_LIST = BACKOFFICE_FOLDER
	    + "persona/list.jsp";
    public static final String JSP_BACK_PERSONA_FORM = BACKOFFICE_FOLDER
	    + "persona/form.jsp";

    public static final String JSP_BACK_CALIFICACION_LIST = BACKOFFICE_FOLDER
	    + "calificacion/list.jsp";

    public static final String JSP_BACK_CALIFICACION_FORM = BACKOFFICE_FOLDER
	    + "calificacion/form.jsp";
    public static final String JSP_ERROR = "includes/error.jsp";

    // Properties
    public static final String PROPERTY_I18N = "com.ipartek.formacion.helloweb.i18n.i18nmesages";

    // Parametros login
    public static final String PARAMETRO_USER = "user";
    public static final String PARAMETRO_PASS = "pass";
    public static final String PARAMETRO_IDIOMA = "idioma";
    public static final String PARAMETRO_RECUERDAME = "recuerdame";

    // Mensajes
    public static final String MSG_KEY = "msg";
    public static final String MSG_LOGIN_INCORRECT = "Usuario o contraseña incorrecta!!";
    public static final String MSG_LOGOUT = "Hasta la vista Baby recuerda visitarnos!!";
    public static final String MSG_NOT_ALLOWED = "No tienes permisos";
    public static final String MSG_REG_CREATE = "Registro creado con éxito";
    public static final String MSG_REG_DELETE = "Registro eliminado con éxito";
    public static final String MSG_REG_UPDATE = "Registro modificado con éxito";
    public static final String MSG_ERR_PARAMETERS = "Error recogiendo parametros";
    public static final String MSG_ERR_DELETE = "Error eliminando registro";
    public static final String MSG_ERR_LOAD_LOG4J = "Error cargando LOG4J";

    // Tipo Mensajes
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_INFO = "info";
    public static final String MSG_WARNING = "warning";
    public static final String MSG_DANGER = "danger";

    // Atributos
    public static final String ATT_PERSONAS = "personas";
    public static final String ATT_PERSONA = "persona";
    public static final String ATT_CALIFICACIONES = "calificaciones";
    public static final String ATT_CALIFICACION = "calificacion";

    // Operaciones CRUD
    public static final String OP_KEY = "op"; // Actualizar registro
    public static final String OP_UPDATE = "0"; // Actualizar registro
    public static final String OP_DELETE = "1"; // Eliminar registro
    public static final String OP_LIST = "2"; // Listar todos los registros
    public static final String OP_DETAIL = "3"; // Mostrar detalle registro
    public static final String OP_CREATE = "4"; // Mostrar detalle registro

}
