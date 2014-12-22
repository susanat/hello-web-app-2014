package com.ipartek.formacion.helloweb.util;

public class Constante {

    public static final String USER_SESSION = "user_session";
    public static final String LANG_SESSION = "lang_session";
    public static final String USER_LOGOUT_PETICION = "logout.pedida";

    public static final String USER_ADMIN_CODE = "0";
    public static final String USER_ADMIN_NAME = "admin";
    public static final String USER_ADMIN_PASS = "admin";

    public static final String USER_USER_CODE = "1";
    public static final String USER_USER_NAME = "user";
    public static final String USER_USER_PASS = "user";
    // cookies
    public static final String COOKIE_USER_NAME = "c_user";
    public static final String COOKIE_USER_PASS = "c_pass";
    public static final String COOKIE_USER_IDIOMA = "c_idioma";
    public static final int COOKIE_DEFAULT_TIME = 3600 * 24 * 365 * 1000;
    // roles
    public static final String ROL_USER_CODE = "1";
    public static final String ROL_USER_NAME = "user";
    public static final String ROL_ADMIN_CODE = "0";
    public static final String ROL_ADMIN_NAME = "admin";
    // rutas
    public static final String JSP_BACKOFFICE = "backoffice/";
    public static final String JSP_SALUDO = "saludo.jsp";
    public static final String JSP_LOGIN = "login.jsp";
    public static final String JSP_ERROR = "includes/error.jsp";
    public static final String JSP_BACKOFFICE_INDEX = JSP_BACKOFFICE
	    + "index.jsp";
    public static final String JSP_BACKOFFICE_PERSONA_LIST = JSP_BACKOFFICE
	    + "persona/listado.jsp";
    public static final String JSP_BACKOFFICE_PERSONA_FORM = JSP_BACKOFFICE
	    + "persona/form.jsp";
    public static final String JSP_BACKOFFICE_IDIOMA_LIST = JSP_BACKOFFICE
	    + "idioma/listado.jsp";
    public static final String JSP_BACKOFFICE_IDIOMA_FORM = JSP_BACKOFFICE
	    + "idioma/form.jsp";
    public static final String JSP_BACKOFFICE_SESSION_LIST = JSP_BACKOFFICE
	    + "session/listado.jsp";
    /* servlets */
    public static final String SERVLET_LOGIN = "login.do";
    public static final String SERVLET_LOGOUT = "logout.do";
    public static final String CONTROLER_PERSONA = "persona.do";
    public static final String CONTROLER_IDIOMA = "idioma.do";
    public static final String CONTROLER_ROL = "rol.do";
    public static final String CONTROLER_CALIFICACION = "calificacion.do";
    public static final String CONTROLER_SESSION = "session.do";
    // properties
    public static final String PROPERTI_I18N = "com.ipartek.formacion.helloweb.i18n.i18nmesages";
    // parametros
    public static final String PARAMETRO_USER = "user";
    public static final String PARAMETRO_PASS = "pass";
    public static final String PARAMETRO_ID = "codigo";
    public static final String PARAMETRO_ACCION = "codigo";
    public static final String PARAMETRO_IDIOMA = "idioma";
    public static final String PARAMETRO_RECUERDAME = "recuerdame";

    // mensajes
    public static final String MSG_KEY = "msg";
    public static final String MSG_LOGIN_INCORRECT = "mensaje.loginIncorrect";
    public static final String MSG_SIN_PERMISOS = "mensaje.sinPermiso";
    public static final String MSG_LOGOUT = "mensaje.logout";
    public static final String MSG_CREATE = "mensaje.create";
    public static final String MSG_REMOVE = "mensaje.remove";
    public static final String MSG_UPDATE = "mensaje.update";
    public static final String MSG_ERROR = "mensaje.error";
    public static final String MSG_ERROR_BBDD = "mensaje.error";
    // Atributos
    public static final String ATT_PERSONAS = "personas";
    public static final String ATT_PERSONA = "persona";
    public static final String ATT_OPERACION = "op";
    public static final String ATT_REGISTERED_USERS = "usuarios";

    // Operacion CRUD
    public static final String OP_KEY = "op";
    public static final int OP_CREATE = 0;
    public static final int OP_REMOVE = 1;
    public static final int OP_UPDATE = 2;
    public static final int OP_DETAIL = 3;
    public static final int OP_LIST = 4;

    private Constante() {
    }
}
