package com.ipartek.formacion.helloweb;

public class Constantes {

    // Seguridad o Usuarios
    public static final String USER_SESSION = "user_session";

    public static final String USER_ADMIN_NAME = "admin";
    public static final String USER_ADMIN_PASS = "admin";

    public static final String USER_USER_NAME = "user";
    public static final String USER_USER_PASS = "user";

    // Paths para Servlets -- mirar en web.xml
    public static final String PATH_LOGIN = "login";
    public static final String PATH_LOGOUT = "logout";

    // JSPs publicas
    public static final String JSP_SALUDO = "saludo.jsp";
    public static final String JSP_LOGIN = "login.jsp";

    // JSPs Backoffices
    public static final String JSP_BACKOFFICES = "backoffice/backoffices_index.jsp";

    // Parametros
    public static final String PARAMETRO_USER = "user";
    public static final String PARAMETRO_PASS = "pass";

    // Mensajes
    public static final String MSG_KEY = "msg";
    public static final String MSG_LOGIN_INCORRECT = "Usuario o contraseña incorrecta";
    public static final String MSG_LOGOUT = "Gracias, por su visita";

    public static final String MSG_NOT_ALLOWED = "No tienes permisos de acceso";

}
