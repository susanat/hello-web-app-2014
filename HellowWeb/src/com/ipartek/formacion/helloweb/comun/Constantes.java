package com.ipartek.formacion.helloweb.comun;

public final class Constantes {

	
	static {
		//request.getSession().getServletContext().getRealPath("/");
	}

	/**
	 * Empty constructo to avoid instanciate class
	 */
	private Constantes() {

	}


	/**
	 * Numeración para acciones en los Modelos
	 * de manejo de datos.
	 * 
	 * @author Sergio Rubio Nieto
	 *
	 */
	public enum EModeloAccion{	 
		/**
		 * Flag que indica que se desea obtener datos
		 */
		GET("1"),
		/**
		 * Flag que indica que se desea realizar un insert
		 */
		INSERT("2"), 	       
		/**
		 * Flag que indica que se desea realizar una insercción
		 */
		UPDATE("3"),		
		/**
		 * Flag que indica que se desea realizar un borrado
		 */
		DELETE("4");

		private String value;

		private EModeloAccion(String value) {
			this.value = value;
		}
		public String getValue(){
			return value;
		}

		public final static  EModeloAccion getEnumNameForValue(Object value){

			EModeloAccion[] values = EModeloAccion.values();

			String enumValue = null;
			EModeloAccion res = null;

			for(EModeloAccion eachValue : values){
				enumValue = eachValue.getValue();
				if( enumValue.equals(value)){
					res = eachValue;
				}
			}
			return res;
		}
	}

	//*************** Arbol de PATHS
	
	/**
	 * path del sitio
	 */
	//public final static  String PATH_SITE = "http://localhost:8080/HelloWeb/";
	public final static  String PATH_SITE = "http://localhost:8090/HelloWeb/";
	
	

	//*** ARBOL DE LA PARTE BACKOFFICE
	public final static String PATH_BACK = "backoffice/";

	//** INCLUDES
	public final static String PATH_BACK_REL_INCLUDE = PATH_BACK + "include/";
	public final static String PATH_BACK_ABS_INCLUDE = PATH_SITE + PATH_BACK_REL_INCLUDE;
		
	//** THEMES
	private final static String theme_prueba = "st-admin-2/";
	private final static String theme_default = "default/";
	
	public final static  String PATH_BACK_REL_THEME = "backoffice/themes/" + theme_default;
	public final static  String PATH_BACK_ABS_THEME = PATH_SITE + PATH_BACK_REL_THEME;
	

	


	//*************** Ã�rbol de Servlet
	public final static  String CONTROLLER_PERSONA = "persona";
	public final static  String CONTROLLER_LOGIN = "login";
	public final static  String CONTROLLER_LOG_OUT = "logout";
	
	

	//*************** JSP'S
	public final static  String JSP_INDEX = PATH_SITE + "index.jsp";

	public final static  String JSP_SALUDO = PATH_SITE + "saludo.jsp";

	public final static  String JSP_LOGIN = PATH_SITE + "login.jsp";
	public final static  String JSP_LOGOUT = PATH_SITE + "logout.jsp";


	public final static  String JSP_PATH_BACK = PATH_SITE + "backoffice/";

	public final static  String JSP_BACK_ADMIN = JSP_PATH_BACK + "index.jsp";
	
	/**
	 * Ruta completa para <a> del jsp lista de personas
	 */
	public final static  String JSP_BACK_PERSONA_LIST = JSP_PATH_BACK + "persona/listPersonas.jsp";
	
	/**
	 * Ruta completa para <a> del jsp formulario de persona
	 */
	public final static  String JSP_BACK_PERSONA_FORM = JSP_PATH_BACK + "persona/formPersona.jsp";

	
	public final static String JSP_BACK_FOOTER = "footer.jsp";
	public final static String JSP_BACK_HEAD = "head.jsp";
	public final static String JSP_BACK_NAV = "nav.jsp";
	public final static String JSP_BACK_NAV_SIDEBAR = "nav_sidebar.jsp";


	//***************NAMES FORMULARIOS

	//*** Formulario login
	public final static  String PARAMETRO_USER = "cont1";
	public final static  String PARAMETRO_PASSWORD = "cont2";      


	//**************Session

	//*** general
	/**
	 * ContendrÃ¡ la Ãºltima url visitada (String)
	 */
	public final static  String PARAM_SESSION_LAST_URL = "lasturl";

	/**
	 * ContendrÃ¡ un mensaje
	 */
	public final static  String PARAM_SESSION_MSJ = "msj";

	/**
	 * ContendrÃ¡ el usuario  (Persona)
	 */
	public final static  String PARAM_SESSION_USER = "user_session";

	//*** login
	/**
	 * ContendrÃ¡ si se ha autentificado un usuario    
	 */
	public final static  String PARAM_SESSION_AUTHENTICATED = "authenticated";

	//*** logout
	/**
	 * Si se desea mantener datos o invalidar la sessiÃ³n completamente
	 */
	public final static  String PARAM_SESSION_INVALIDATE = "invalidate";

	//*** Servlet General
	//*Atributtes
	public final static  String ATTR_ERROR = "isError";
	public final static  String ATTR_ERROR_MSJ = "msj_error";
	public final static  String ATTR_ERROR_EXCEPTION = "ex_error";

	//*** Servlet Personas
	//*General
	public final static  String PARAM_ACTION = "accion";
	public final static  String PARAM_URL_FROM = "url_from";
	public final static  String PARAM_URL_TO = "url_to";

	//*Params (jsp to servlet)
	public final static  String PARAM_PERSONAS_ID = "id";
	public final static  String PARAM_PERSONAS_NOMBRE = "nombre";
	public final static  String PARAM_PERSONAS_EDAD = "edad";    
	public final static  String PARAM_PERSONAS_ROLE = "role";

	//*Attributtes (servlet to jsp)    
	public final static  String ATTR_PERSONAS_LIST = "personas";
	public final static  String ATTR_PERSONA = "persona";
	public final static  String ATTR_ROLES_LIST = "list_roles";

	
	
	//*** Servlet Logout
	public final static String ATTR_LOGOUT_ACTION = "logout";
	
	
	//*** LANG
	public final static String LANG_LOGIN_INCORRECT = "Usuario o contraseña incorrectos.";    
	public final static String LANG_LOG_OFF = "Usuario o contraseña incorrectos.";

	//*LANG administracion
	//strings a sacar de aquí o que son de idioma
	public final static String adm_index_desc = "Administración del sitio";
	public final static String adm_index_title = "Administración";
	
	public final static String general_login = "Login";	
	public final static String general_login_insert = "Please, insert username and password.";
	
	public final static String general_login_wellcome = "Wellcome %s";
	
	public final static String general_login_password = "Password";
	public final static String general_login_username = "Username";
	
	public final static String general_login_desconect_msj = "Usuario desconectado correctamente.";
}
