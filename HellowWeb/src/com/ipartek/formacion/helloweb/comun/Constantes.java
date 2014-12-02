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

		public static EModeloAccion getEnumNameForValue(Object value){

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

	/**
	 * path del sitio
	 */
	public static String SITE_PATH = "http://localhost:8080/HelloWeb/";
	
	public static String TEMP_REL_PATH_THEME = "backoffice/themes/sb-admin-2/";
	public static String TEMP_ABS_PATH_THEME = SITE_PATH + TEMP_REL_PATH_THEME;


	


	//*************** Ã�rbol de Servlet
	public static String CONTROLLER_PERSONA = "persona";
	public static String CONTROLLER_LOGIN = "login";

	//*************** Ã�rbol de JSP
	public static String JSP_INDEX = SITE_PATH + "index.jsp";

	public static String JSP_SALUDO = SITE_PATH + "saludo.jsp";

	public static String JSP_LOGIN = SITE_PATH + "login.jsp";
	public static String JSP_LOGOUT = SITE_PATH + "logout.jsp";


	public static String JSP_PATH_BACK = SITE_PATH + "backoffice/";

	public static String JSP_BACK_ADMIN = JSP_PATH_BACK + "index.jsp";
	public static String JSP_BACK_PERSONA_LIST = JSP_PATH_BACK + "persona/listPersonas.jsp";
	public static String JSP_BACK_PERSONA_FORM = JSP_PATH_BACK + "persona/formPersona.jsp";



	//***************NAMES FORMULARIOS

	//*** Formulario login
	public static String PARAMETRO_USER = "cont1";
	public static String PARAMETRO_PASSWORD = "cont2";      


	//**************Session

	//*** general
	/**
	 * ContendrÃ¡ la Ãºltima url visitada (String)
	 */
	public static String PARAM_SESSION_LAST_URL = "lasturl";

	/**
	 * ContendrÃ¡ un mensaje
	 */
	public static String PARAM_SESSION_MSJ = "msj";

	/**
	 * ContendrÃ¡ el usuario  (Persona)
	 */
	public static String PARAM_SESSION_USER = "user_session";

	//*** login
	/**
	 * ContendrÃ¡ si se ha autentificado un usuario    
	 */
	public static String PARAM_SESSION_AUTHENTICATED = "authenticated";

	//*** logout
	/**
	 * Si se desea mantener datos o invalidar la sessiÃ³n completamente
	 */
	public static String PARAM_SESSION_INVALIDATE = "invalidate";

	//*** Servlet General
	//*Atributtes
	public static String ATTR_ERROR = "isError";
	public static String ATTR_ERROR_MSJ = "msj_error";
	public static String ATTR_ERROR_EXCEPTION = "ex_error";

	//*** Servlet Personas
	//*General
	public static String PARAM_ACTION = "accion";
	public static String PARAM_URL_FROM = "url_from";
	public static String PARAM_URL_TO = "url_to";

	//*Params (jsp to servlet)
	public static String PARAM_PERSONAS_ID = "id";
	public static String PARAM_PERSONAS_NOMBRE = "nombre";
	public static String PARAM_PERSONAS_EDAD = "edad";    
	public static String PARAM_PERSONAS_ROLE = "role";

	//*Attributtes (servlet to jsp)    
	public static String ATTR_PERSONAS_LIST = "personas";
	public static String ATTR_PERSONA = "persona";
	public static String ATTR_ROLES_LIST = "list_roles";

	//*** LANG
	public static String LANG_LOGIN_INCORRECT = "Usuario o contraseÃ±a incorrectos.";    
	public static String LANG_LOG_OFF = "Usuario o contraseÃ±a incorrectos.";


}
