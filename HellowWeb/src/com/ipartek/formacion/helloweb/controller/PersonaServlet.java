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
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.Roles;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Utils;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
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

	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		
		//Creamos el objeto al iniciarse el servlet
		model = new ModeloPersona();
		
		contador = new ShutdownExample();
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
		dispatcher = request.getRequestDispatcher(Utils.getUriFile(Constantes.JSP_BACK_PERSONA_LIST));
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.doGet(request, response);
		
		request.setAttribute(Constantes.ATTR_ERROR, false);
		request.setAttribute(Constantes.ATTR_ERROR_MSJ, "");
		request.setAttribute(Constantes.ATTR_ERROR_EXCEPTION, null);
		
		
		
		
		Persona p = null;
		Persona pRetorno = null;	
		List<Persona> lstPersona =  null;
		Boolean isError = false;
		
		//obtenemos los datos pasados
		try {
			p = getPersona(request);
			
			//insertamos o actualizamos si no es null
			if(p != null) {
				if( p.getId() == p.ID_NULL) {
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
				request.setAttribute(Constantes.ATTR_ERROR, true);
				request.setAttribute(Constantes.ATTR_ERROR_MSJ, "Error personalizado.");
				request.setAttribute(Constantes.ATTR_ERROR_EXCEPTION, null);
				
			}
			
		} catch (Exception e) {
			request.setAttribute(Constantes.ATTR_ERROR, true);
			request.setAttribute(Constantes.ATTR_ERROR_MSJ, "Error con excepción.");
			request.setAttribute(Constantes.ATTR_ERROR_EXCEPTION, e);
		}
		
				
		//fordward a la vista sí o sí
		dispatcher = request.getRequestDispatcher(Utils.getUriFile(Constantes.JSP_BACK_PERSONA_FORM));
		dispatcher.forward(request, response);
		
		
	}
	
	
	private Persona getPersona(HttpServletRequest request) throws Exception {
		
		Persona  per = null;
		boolean isValidado = true;
		
		int id = -1;
		String name = "";
		int edad = 0;
		Roles rol = null;
		
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
			
			if (isValidado) {
				
				per = new Persona();
				
				per.setId(id);
				per.setNombre(name);
				per.setEdad(edad);
				//TODO: Puesto a pelo
				per.setRol(CargasTemporales.roles.get(1));
				
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
	
	

}
