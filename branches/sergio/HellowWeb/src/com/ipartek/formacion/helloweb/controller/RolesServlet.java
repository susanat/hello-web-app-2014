package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Roles;
import com.ipartek.formacion.helloweb.bean.Message.ETypeAlert;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Constantes.EModeloAccion;
import com.ipartek.formacion.helloweb.comun.Utils;
import com.ipartek.formacion.helloweb.model.ModeloRoles;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles.onModelRolesError;
import com.ipartek.formacion.helloweb.temp.ShutdownExample;

/**
 * Servlet implementation class ROLEServlet
 */
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Modelo de la Roles
	 */
	private ModeloRoles model = null;	
	
	RequestDispatcher dispatcher = null;	
			
	/**
	 * Contador accesos
	 */
	ShutdownExample contador = null;
	
	/**
	 * Mensaje de error
	 */
	Message msg = null;

	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		
		//Creamos el objeto al iniciarse el servlet
		model = new ModeloRoles();
		model.setOnIError(new onModelRolesError() {
			
			public void onException(Roles obj, Exception ex) {
				onModelException(obj, ex);
				
			}
		});
		
		contador = new ShutdownExample();
	}
	
	public void onModelException(Roles obj, Exception ex) {
		
		//cumplimentamos el error		
		msg.setError(true);
		msg.setText("LoginServlet.java: Error en el modelo de datos de Roles.");
		msg.setException(ex);
		msg.setType(ETypeAlert.DANGER);
	}
	
	@Override
	public void destroy() {		
		super.destroy();
		
		//destruimos el objeto al finalizar el ciclo de vida del servlet
		model = null;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RolesServlet() {
        super();
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
		
		
		//recoger parámetros
		
		//comprobar si es getAll o getById
		
		//acceder al modelo
		//List<Roles> ROLES = model.getAll();
		
		//pasamos los atributos
		//request.setAttribute(Constantes.ATTR_ROLES_LIST, ROLES);
		
		//fordward a la vista
		//dispatcher = this.getServletContext().getRequestDispatcher(path)
		
		//dispatcher = request.getRequestDispatcher(Utils.getUriFile(Constantes.JSP_BACK_ROLES_LIST));
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							
		///////////////// Obtención de urls
		//obtenemos la url de referencia y de destino. Asumimos destino igual a referencia si no se dice lo contrario.
		String urlReferer = (String) request.getSession().getAttribute(Constantes.ATTR_SESSION_LAST_URL);
		String urlTo = urlReferer;
		
		//obtenemos la página de origen (si no existe se asume que es la que ha relizado la petición):
		if(request.getParameter(Constantes.PARAM_URL_FROM) != null) {
			urlReferer = request.getParameter(Constantes.PARAM_URL_FROM);
			urlTo = request.getParameter(Constantes.PARAM_URL_FROM);
		}
		
		//obtenemos la página de destino (si no existe se asume que es la misma que la de origen):
		if(request.getParameter(Constantes.PARAM_URL_TO) != null) {
			urlTo = request.getParameter(Constantes.PARAM_URL_TO);
		}

		
		//comprobamos si nos llega el parámetro de acción
		if(request.getParameter(Constantes.PARAM_ACTION) != null) {			
			//lo obtenemos
			//TODO: Control de errores
			EModeloAccion accion = EModeloAccion.getEnumNameForValue(request.getParameter(Constantes.PARAM_ACTION));
			if(accion != null) 
			{				
				switch (accion) {
				case GET:
					get(request, response);
					break;
					
				case INSERT:
					insert(request, response);
					break;
					
				case UPDATE:
					insert(request, response);
					break;
					
				case DELETE:
					try {						
						delete(request, response);
					} catch (Exception e) {						
						msg.setError(true);
						msg.setText("Error en el delete.");
						msg.setException(e);
						msg.setType(ETypeAlert.DANGER);
					}
					break;

				default:
					break;
				}				
			} else {
				//TODO error, acción errónea
			}
		} else {
			//TODO error, no ha llegado acción
		}
		
				
		//fordward a la vista sí o sí
		dispatcher = request.getRequestDispatcher(Utils.getUriFile(urlTo));
		dispatcher.forward(request, response);
		
		
	}
	
	/**
	 * Procesa el borrado del objeto
	 * 
	 * @param request
	 * @param response
	 * @return true si ha sido borrado correctamente o false si no
	 * @throws Exception
	 */
	private Boolean delete (HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Borramos por identificador, nos llega un parámetro con ese identificador
		
		Boolean res = false;
		int id = Roles.ID_NULL;
		
		if(request.getParameter(Constantes.PARAM_ROLES_ID) != null) {
			id = Integer.valueOf(request.getParameter(Constantes.PARAM_ROLES_ID));
			res = model.delete(id, IModeloRoles.EBorrado.FISICA);
		}
				
		return res;
	}
	
	/**
	 * Inserta una Roles 
	 * @param request
	 * @param response
	 * @return el objeto insertado o null si ha habido error
	 */
	private Roles insert (HttpServletRequest request, HttpServletResponse response) {
		Roles p = null;
		
		Roles pRetorno = null;	
		List<Roles> lstRoles =  null;
		Boolean isError = false;
		
		//obtenemos los datos pasados
		try {
			p = getRolesFromRequest(request);
			
			//insertamos o actualizamos si no es null
			if(p != null) {
				if( p.getId() == Roles.ID_NULL) {
					pRetorno = model.Insert(p);
				} else {
					pRetorno = model.update(p.getId(), p);
				}
				
			} else {
				isError = true;
			}
			
			//si ha ocurrido algún error en las operaciones
			if (pRetorno != null) {
				lstRoles = new ArrayList<Roles>();
				lstRoles.add(pRetorno);
				
			} else {
				isError = true;
			}
			
			//Error propio controlado
			if( isError ) {
				msg.setError(true);
				msg.setText("Error en el insert del objeto del servlet, el objeto está a null o no se ha retornado ningún objeto.");				
				msg.setType(ETypeAlert.DANGER);
				
			}
			
		} catch (Exception e) {
			msg.setError(true);
			msg.setText("Excepción en el insert del objeto del servlet: " + e.getMessage());
			msg.setException(e);
			msg.setType(ETypeAlert.DANGER);
		}
		
		//devolvemos. Null, no existen elementos encontrados
		request.setAttribute(Constantes.ATTR_ROLES_LIST, lstRoles);
		
		
		return p;
	}
	
	/**
	 * Crea los atributos necesario para la respuesta al request de tipo SELECT
	 * 
	 * @param request
	 * @param response
	 */
	private void get (HttpServletRequest request, HttpServletResponse response) {
		List<Roles> lstRoles = null;
		//actualmente dos opciones. Obtener la lista completa u obtener solo un objeto
		//se diferencia por el campo PARAM_ROLES_ID si viene indicado		
		try {
		
			if (request.getParameter(Constantes.PARAM_ROLES_ID) != null) {
				//obtenemos la Roles por el id
				int id = Integer.parseInt(request.getParameter(Constantes.PARAM_ROLES_ID));
				
				Roles p = model.getById(id);
				
				//error, no existe
				if(p == null) {
					msg.setError(true);
					msg.setText("No existe Roles con ese identificador.");					
					msg.setType(ETypeAlert.DANGER);
				} else {
					lstRoles = new ArrayList<Roles>();
					lstRoles.add(p);
				}
				
			} else  {
				//obtenemos el listado completo
				lstRoles = model.getAll();			
			}
			
			
			//devolvemos. Null, no existen elementos encontrados
			request.setAttribute(Constantes.ATTR_ROLES_LIST, lstRoles);
			
				
		} catch (Exception ex) {
			//mandamos el error para el peticionario. Aqui no nos interesa saber por qué.
			//TODO: meterlo en log también
			msg.setError(true);
			msg.setText("Accion Get Roles: " + ex.getMessage());
			msg.setException(ex);
			msg.setType(ETypeAlert.DANGER);			
		} 
				
	}
		
	private Roles getRolesFromRequest(HttpServletRequest request) throws Exception {
		
		Roles  obj = null;
		boolean isValidado = true;
		
		//inicializamos
		int id = Roles.ID_NULL;
		String alias = "";
		String nombre = Roles.ROLE_NAME_NULL;
		String descripcion = Roles.ROLE_DESC_NULL;
		
		try {
		
			if(request.getParameter(Constantes.PARAM_ROLES_ID) != null) {
				id = Integer.valueOf(request.getParameter(Constantes.PARAM_ROLES_ID));
			}
			
			if(request.getParameter(Constantes.PARAM_ROLES_NOMBRE) != null) {
				alias = request.getParameter(Constantes.PARAM_ROLES_ALIAS).toString();
				if("".equals(alias.trim()) ) {
					isValidado = false;
				}
			} else {
				isValidado = false;
			}
			
			if(request.getParameter(Constantes.PARAM_ROLES_NOMBRE) != null) {
				nombre = request.getParameter(Constantes.PARAM_ROLES_NOMBRE).toString();
			}
			
			if(request.getParameter(Constantes.PARAM_ROLES_DESC) != null) {
				descripcion = request.getParameter(Constantes.PARAM_ROLES_DESC);
			}
			
			if (isValidado) {
				
				obj = new Roles(alias);
				
				obj.setId(id);
				obj.setNombre(nombre);
				obj.setDescripcion(descripcion);
				
			}
			
			return obj;
			
		} catch (Exception ex){
			throw ex;
		}
			
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		//super.service(req, resp);
		//guardamos el httpServletRequest actual, siempre pasa por aquí, por lo que cada
		//petición tendrá su propio request.
		//nuevo mensaje de error
		msg = new Message();
		
		contador.enteringServiceMethod();	
		
		try {		
			super.service(req, resp);	
		} 
		finally {		
			contador.leavingServiceMethod();	
		}		
		
		//TODO comprobar Autorización del usuario		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {		
		super.service(req, res);
	}
	
	//public void processRequestHttp(ServletRequest request, HttpServletResponse response, Peticion get/post) 

}
