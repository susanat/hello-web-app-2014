package com.ipartek.formacion.helloweb.comun;

public final class Constantes {
	
	static {
		//request.getSession().getServletContext().getRealPath("/");
	}

	/**
	 * Empty constructor to avoid instanciate class
	 */
	private Constantes() {

	}


	/**
	 * Numeración para acciones en los Modelos
	 * de manejo de datos.
	 * 
	 * Ejemplo de uso:
	 * - Mandar a request
	 * 		EModeloAccion accion = EModeloAccion.GET; 
	 * 		accion.getValue()
	 * 
	 * - Obtener de request
	 * 		EModeloAccion accion = EModeloAccion.getEnumNameForValue(request.getParameter(Constantes.PARAM_ACTION));
	 * 
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
	
	//*************** PROPIEDADES DEL PROGRAMA
	
	
	
	
	
	public final static String PACKAGE_LANG = "com.ipartek.formacion.helloweb.i18n.lang.properties";
	
	
	///tengo que obtener el archivo properties

	//*************** Arbol de PATHS
	
	/**
	 * path del sitio
	 */	
	public static  String PATH_SITE = Globales.SITE_ROOT_PATH;
	
	

	//*** ARBOL DE LA PARTE BACKOFFICE
	public final static String NAME_FOLDER_BACK = "backoffice/";
	public final static String NAME_FOLDER_FRONT = "frontoffice/";
	
	

	//** INCLUDES (head, footer, nav, side_nav, etc)
	public final static String NAME_FOLDER_BACK_INC = "include/";
	
	//** Folder for backofice
	public final static String PATH_BACK_REL_INCLUDE = NAME_FOLDER_BACK + NAME_FOLDER_BACK_INC;
	public final static String PATH_BACK_ABS_INCLUDE = PATH_SITE + NAME_FOLDER_FRONT + PATH_BACK_REL_INCLUDE;
		
	//** Folder for THEMES
	public final static String NAME_FOLDER_BACK_THEMES = "themes/";
	public final static String NAME_FOLDER_FRONT_THEMES = "themes/";
	
	

		
	
	public final static  String PATH_BACK_REL_THEME = NAME_FOLDER_BACK + NAME_FOLDER_BACK_THEMES + Globales.SITE_BACKOFFICE_THEME + "/";
	public final static  String PATH_BACK_ABS_THEME = PATH_SITE + PATH_BACK_REL_THEME;
	
	public final static  String PATH_FRONT_REL_THEME = NAME_FOLDER_FRONT + NAME_FOLDER_FRONT_THEMES + Globales.SITE_FRONTOFFICE_THEME + "/";
	public final static  String PATH_FRONT_ABS_THEME = PATH_SITE + PATH_FRONT_REL_THEME;
	
	//*************** JSP'S
	public final static  String JSP_REL_INDEX = "index.jsp";
	public final static  String JSP_ABS_INDEX = PATH_SITE + "index.jsp";

	public final static  String JSP_REL_SALUDO = "saludo.jsp";
	public final static  String JSP_ABS_SALUDO = PATH_SITE + "saludo.jsp";

	
	public final static  String JSP_REL_LOGIN = PATH_SITE + "login_jstl.jsp";
	public final static  String JSP_ABS_LOGIN = PATH_SITE + "login_jstl.jsp";
	
	
	public final static  String JSP_REL_LOGOUT = "logout.jsp";
	public final static  String JSP_ABS_LOGOUT = PATH_SITE + "logout.jsp";


	public final static String JSP_REL_BACK_INDEX = NAME_FOLDER_BACK + "index.jsp";
	public final static String JSP_ABS_BACK_INDEX = PATH_SITE + NAME_FOLDER_BACK + "index.jsp";
		

	//*************** Ã�rbol de Servlet
	
	//nombre
	public final static  String CONTROLLER_PERSONA = "persona";
	public final static  String CONTROLLER_ROLES = "roles";
	public final static  String CONTROLLER_LOGIN = "login";
	public final static  String CONTROLLER_LOG_OUT = "logout";
	
	//path_completo
	public final static  String CONTROLLER_ABS_PERSONA = PATH_SITE + CONTROLLER_PERSONA;
	public final static  String CONTROLLER_ABS_LOGIN = PATH_SITE + CONTROLLER_LOGIN;
	public final static  String CONTROLLER_ABS_LOG_OUT = PATH_SITE + CONTROLLER_LOG_OUT;
	

	
	
	/**
	 * Ruta completa para <a> del jsp lista de personas
	 */
	public final static  String JSP_BACK_PERSONA_LIST = PATH_SITE + NAME_FOLDER_BACK + "persona/listPersonas.jsp";
	
	/**
	 * Ruta completa para <a> del jsp formulario de persona
	 */
	public final static  String JSP_BACK_PERSONA_FORM = PATH_SITE + NAME_FOLDER_BACK + "persona/formPersona.jsp";
	
	/**
	 * Ruta completa para <a> del jsp lista de roles
	 */
	public final static  String JSP_BACK_ROLES_LIST = PATH_SITE + NAME_FOLDER_BACK + "roles/listRoles.jsp";
	
	/**
	 * Ruta completa para <a> del jsp formulario de roles
	 */
	public final static  String JSP_BACK_ROLES_FORM = PATH_SITE + NAME_FOLDER_BACK + "roles/formRoles.jsp";

	
	public final static String JSP_BACK_FOOTER = "footer.jsp";
	public final static String JSP_BACK_HEAD = "head.jsp";
	public final static String JSP_BACK_NAV = "nav.jsp";
	public final static String JSP_BACK_NAV_SIDEBAR = "nav_sidebar.jsp";


	//***************************************** PARÁMETROS Y ATRIBUTOS
	//************** URL GET
	public final static String PARAMETRO_URL_GET_LANGUAGE = "language";
	
	
	
	//*** Formulario login
	public final static  String PARAMETRO_USER = "cont1";
	public final static  String PARAMETRO_PASSWORD = "cont2";      
	public final static  String PARAM_LOGIN_REMEMBER = "cont3";


	//**************Session
	//*** general
	/**
	 * Contendra la Última url visitada (String)
	 */
	public final static  String ATTR_SESSION_LAST_URL = "lasturl";

	/**
	 * Contendra un mensaje de tipo message
	 */
	public final static  String ATTR_SESSION_MSJ = "msj";

	/**
	 * Contendra el usuario  (Persona)
	 */
	public final static  String ATTR_SESSION_USER = "user_session";
	
	/**
	 * Contendrá el locale del usuario
	 */
	public final static  String ATTR_SESSION_LOCALE = "user_locale";

	//*** login
	/**
	 * Contendra si se ha autentificado un usuario    
	 */
	public final static  String ATTR_SESSION_AUTHENTICATED = "authenticated";

	//*** logout
	/**
	 * Si se desea mantener datos o invalidar la sessiÃ³n completamente
	 */
	public final static  String PARAM_SESSION_INVALIDATE = "invalidate";
	
	/**
	 * Causa fin de sesión
	 */
	public static final String ATTR_SESSION_OFF_CAUSE = "session_cause_off";

	////************** Servlet General
	//*Atributtes
	/**
	 * Contendrá el mensaje de tipo <code>Message</code> a devolver por el servlet
	 */
	public final static  String ATTR_ERROR = "object_msg_error";
	

	////************** Servlets
	//*General
	/**
	 * Accion a realizar dentro de los modelos de datos (update, insert, delete, get, etc) 
	 */
	public final static  String PARAM_ACTION = "EModeloAccion_accion";
	
	/**
	 * Url de la que proviene la petición
	 */
	public final static  String PARAM_URL_FROM = "url_from";
	
	/**
	 * Url para redirigir la petición al servlet
	 */
	public final static  String PARAM_URL_TO = "url_to";

	//*Params Personas (jsp to servlet)
	public final static  String PARAM_PERSONAS_ID = "id";
	public final static  String PARAM_PERSONAS_NOMBRE = "nombre";
	public final static  String PARAM_PERSONAS_EDAD = "edad";    
	public final static  String PARAM_PERSONAS_ROLE = "role";

	//*Attributtes Personas (servlet to jsp)    
	public final static  String ATTR_PERSONAS_LIST = "personas";
	
	
	//*Params Personas (jsp to servlet)
	public final static  String PARAM_ROLES_ID = "id_roles";
	public final static  String PARAM_ROLES_ALIAS = "alias_roles";
	public final static  String PARAM_ROLES_NOMBRE = "nombre_roles";    
	public final static  String PARAM_ROLES_DESC = "descripcion_roles";
	
	
	//TODO: esto tendría que desaparecer
	public final static  String ATTR_ROLES_LIST = "list_roles";

	
	
	//*** Servlet Logout
	public final static String ATTR_LOGOUT_ACTION = "logout";
	

	
	
	//********************** GENERAL
	/**
     * Salto de línea genérico independiente del S.O. 
     * (uso de System.getProperty).
     */
    public static final String SALTO_DE_LINEA = 
	    System.getProperty("line.separator");

    /**
     * Comprueba si ha ocurrido algún error en la carga
     */
	public static final boolean LOAD_ERROR = false;

	/**
	 * Ruta página jsp de error
	 */
	public static final String JSP_ERROR = "error.jsp";

	
	//********************** coockies
	public static final String cookie_user_name = "ADFDSFGSDFGASFE21234WDGASER";
	public static final String cookie_user_pass = "GHJFGHJRTYE345634523Q2AWEVR";
	public static final String cookie_user_lang = "clang";
	
}
