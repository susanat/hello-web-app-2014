package com.ipartek.formacion.helloworld.util;

public class Constante {

    public static final String USER_SESSION = "user_session";
    public static final String LANG_SESSION = "lang_session";

    public static final String USER_ADMIN_CODE = "0";
    public static final String USER_ADMIN_NAME = "admin";
    public static final String USER_ADMIN_PASS = "admin";

    public static final String USER_USER_CODE = "1";
    public static final String USER_USER_NAME = "user";
    public static final String USER_USER_PASS = "user";

    public static final String ROL_USER_CODE = "1";
    public static final String ROL_USER_NAME = "user";
    public static final String ROL_ADMIN_CODE = "0";
    public static final String ROL_ADMIN_NAME = "admin";

    public static final String JSP_BACKOFFICE = "backoffice/";
    public static final String JSP_SALUDO = "saludo.jsp";
    public static final String JSP_LOGIN = "login.jsp";
    public static final String JSP_BACKOFFICE_INDEX = JSP_BACKOFFICE
	    + "index.jsp";
    public static final String JSP_BACKOFFICE_PERSONA_LIST = JSP_BACKOFFICE
	    + "persona/listado.jsp";
    public static final String JSP_BACKOFFICE_PERSONA_FORM = JSP_BACKOFFICE
	    + "persona/form.jsp";
    /* */
    public static final String SERVLET_LOGIN = "login";
    public static final String SERVLET_LOGOUT = "logout";
    public static final String CONTROLER_PERSONA = "persona";

    public static final String PARAMETRO_USER = "user";
    public static final String PARAMETRO_PASS = "pass";
    public static final String PARAMETRO_ID = "codigo";
    public static final String PARAMETRO_ACCION = "codigo";
    public static final String PARAMETRO_IDIOMA = "idioma";

    public static final String MSG_KEY = "msg";
    public static final String MSG_LOGIN_INCORRECT = "Nombre de Usuario o Contraseña incorrecta";
    public static final String MSG_LOGOUT = "Hasta la vista vuelve pronto WE MISS YOU";
    public static final String MSG_CREATE = "Registro creado";
    public static final String MSG_REMOVE = "Registro eliminado";
    public static final String MSG_UPDATE = "Registro actualizado";
    public static final String MSG_ERROR = "Problema en la operación";
    public static final String MSG_ERROR_BBDD = "Problema en la operación";
    // Atributos
    public static final String ATT_PERSONAS = "personas";
    public static final String ATT_PERSONA = "persona";
    public static final String ATT_OPERACION = "op";

    // Operacion CRUD
    public static final String OP_KEY = "op";
    public static final int OP_CREATE = 0;
    public static final int OP_REMOVE = 1;
    public static final int OP_UPDATE = 2;
    public static final int OP_DETAIL = 3;

    private Constante() {
    }
}
