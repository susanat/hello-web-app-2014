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

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.Roles;
import com.ipartek.formacion.helloweb.bean.Message.ETypeAlert;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Constantes.EModeloAccion;
import com.ipartek.formacion.helloweb.comun.Utils;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.onModelPersonaError;
import com.ipartek.formacion.helloweb.temp.ShutdownExample;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Modelo de la persona
	 */
	private ModeloPersona model = null;	
	
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
		model = new ModeloPersona();
		model.setOnIError(new onModelPersonaError() {
			
			public void onException(Persona obj, Exception ex) {
				onModelException(obj, ex);
				
			}
		});
		
		contador = new ShutdownExample();
	}
	
	public void onModelException(Persona obj, Exception ex) {
		
		//cumplimentamos el error		
		msg.setError(true);
		msg.setText("LoginServlet.java: Error en el modelo de datos de persona.");
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
    public PersonaServlet() {
        super();
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//recoger parámetros
		
		//comprobar si es getAll o getById
		
		//acceder al modelo
		List<Persona> personas = model.getAll();
		
		//pasamos los atributos
		request.setAttribute(Constantes.ATTR_PERSONAS_LIST, personas);
		
		//fordward a la vista
		//dispatcher = this.getServletContext().getRequestDispatcher(path)
		
		dispatcher = request.getRequestDispatcher(Utils.getUriFile(Constantes.JSP_BACK_PERSONA_LIST));
		dispatcher.forward(request, response);
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
	
	private Boolean delete (HttpServletRequest request, HttpServletResponse response) throws Exception {
		Boolean res = false;
		int id = Persona.ID_NULL;
		
		if(request.getParameter(Constantes.PARAM_PERSONAS_ID) != null) {
			id = Integer.valueOf(request.getParameter(Constantes.PARAM_PERSONAS_ID));
			res = model.delete(id, IModeloPersona.EBorrado.FISICA);
		}
				
		return res;
	}
	
	/**
	 * Inserta una persona 
	 * @param request
	 * @param response
	 * @return
	 */
	private Persona insert (HttpServletRequest request, HttpServletResponse response) {
		Persona p = null;
		
		Persona pRetorno = null;	
		List<Persona> lstPersona =  null;
		Boolean isError = false;
		
		//obtenemos los datos pasados
		try {
			p = getPersonaFromRequest(request);
			
			//insertamos o actualizamos si no es null
			if(p != null) {
				if( p.getId() == Persona.ID_NULL) {
					pRetorno = model.Insert(p);
				} else {
					pRetorno = model.update(p.getId(), p);
				}
				
			} else {
				isError = true;
			}
			
			//si ha ocurrido algún error en las operaciones
			if (pRetorno != null) {
				lstPersona = new ArrayList<Persona>();
				lstPersona.add(pRetorno);
				
			} else {
				isError = true;
			}
			
			//Error propio controlado
			if( isError ) {
				msg.setError(true);
				msg.setText("Error Personalizado.");				
				msg.setType(ETypeAlert.DANGER);
				
			}
			
		} catch (Exception e) {
			msg.setError(true);
			msg.setText("Error Personalizado.");
			msg.setException(e);
			msg.setType(ETypeAlert.DANGER);
		}
		
		//de regalo incluimos los roles (habitualmente será para obtener datos para modificar)
		request.setAttribute(Constantes.ATTR_ROLES_LIST, CargasTemporales.getListRoles() );
		
		//devolvemos. Null, no existen elementos encontrados
		request.setAttribute(Constantes.ATTR_PERSONAS_LIST, lstPersona);
		
		
		return p;
	}
	
	/**
	 * Crea los atributos necesario para la respuesta al request de tipo SELECT
	 * 
	 * @param request
	 * @param response
	 */
	private void get (HttpServletRequest request, HttpServletResponse response) {
		List<Persona> lstPersona = null;
		//actualmente dos opciones. Obtener la lista completa u obtener solo un objeto
		//se diferencia por el campo PARAM_PERSONAS_ID si viene indicado		
		try {
		
			if (request.getParameter(Constantes.PARAM_PERSONAS_ID) != null) {
				//obtenemos la persona por el id
				int id = Integer.parseInt(request.getParameter(Constantes.PARAM_PERSONAS_ID));
				
				Persona p = model.getById(id);
				
				//error, no existe
				if(p == null) {
					msg.setError(true);
					msg.setText("No existe persona con ese identificador.");					
					msg.setType(ETypeAlert.DANGER);
				} else {
					lstPersona = new ArrayList<Persona>();
					lstPersona.add(p);
				}
				
			} else  {
				//obtenemos el listado completo
				lstPersona = model.getAll();			
			}
			
			//de regalo incluimos los roles (habitualmente será para obtener datos para modificar)
			request.setAttribute(Constantes.ATTR_ROLES_LIST, CargasTemporales.getListRoles() );
			
			//devolvemos. Null, no existen elementos encontrados
			request.setAttribute(Constantes.ATTR_PERSONAS_LIST, lstPersona);
			
				
		} catch (Exception ex) {
			//mandamos el error para el peticionario. Aqui no nos interesa saber por qué.
			//TODO: meterlo en log también
			msg.setError(true);
			msg.setText("Accion Get Persona: " + ex.getMessage());
			msg.setException(ex);
			msg.setType(ETypeAlert.DANGER);			
		} 
				
	}
		
	private Persona getPersonaFromRequest(HttpServletRequest request) throws Exception {
		
		Persona  per = null;
		boolean isValidado = true;
		
		//inicializamos
		int id = Persona.ID_NULL;
		String name = "";
		int edad = Persona.EDAD_NULL;
		int rol = Persona.ROL_NULL;
		
		try {
		
			if(request.getParameter(Constantes.PARAM_PERSONAS_ID) != null) {
				id = Integer.valueOf(request.getParameter(Constantes.PARAM_PERSONAS_ID));
			}
			
			if(request.getParameter(Constantes.PARAM_PERSONAS_NOMBRE) != null) {
				name = request.getParameter(Constantes.PARAM_PERSONAS_NOMBRE).toString();
				if(name == "") {
					isValidado = false;
				}
			} else {
				isValidado = false;
			}
			
			if(request.getParameter(Constantes.PARAM_PERSONAS_EDAD) != null) {
				edad = Integer.valueOf(request.getParameter(Constantes.PARAM_PERSONAS_EDAD));
			}
			
			if(request.getParameter(Constantes.PARAM_PERSONAS_ROLE) != null) {
				rol = Integer.valueOf(request.getParameter(Constantes.PARAM_PERSONAS_ROLE));
			}
			
			if (isValidado) {
				
				per = new Persona();
				
				per.setId(id);
				per.setNombre(name);
				per.setEdad(edad);
				//TODO: Puesto a pelo
				per.setRol(rol);
				
			}
			
			return per;
			
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
