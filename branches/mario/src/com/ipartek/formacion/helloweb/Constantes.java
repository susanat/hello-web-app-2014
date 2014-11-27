package com.ipartek.formacion.helloweb;

public class Constantes {
    // Seguridad
    public static final String USER_SESSION = "user_session";
    public static final String USER_ADMIN = "admin";
    public static final String PASS_ADMIN = "admin";

    public static final String USER = "user";
    public static final String PASS = "user";

    // Paths para Servlets
    public static final String PATH_LOGIN = "login";
    public static final String PATH_LOGOUT = "logout";

    // JSPs
    public static final String JSP_SALUDO = "/saludo.jsp";
    public static final String JSP_LOGIN = "/login.jsp";
    public static final String JSP_ADMIN_LOGIN = "backoffice/index.jsp";
    // Parametros login
    public static final String PARAMETRO_USER = "user";
    public static final String PARAMETRO_PASS = "pass";

    // Mensajes
    public static final String MSG_KEY = "msg";
    public static final String MSG_LOGIN_INCORRECT = "Usuario o contraseña incorrecta";

}
