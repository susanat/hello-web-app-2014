package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	ModeloPersona model = null;
	String msg="";
      
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		model = new ModeloPersona();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		model=null;
	}
	
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//TODO comprobar Autorizacion del usuario
		
		super.service(req, resp);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros
		
		//comprobar si es getAll o getById
		
		//acceder al modelo
		
		
		ArrayList<Persona> personas = model.getAll();
		
		//pasamos los atributos
		request.setAttribute( Constantes.ATT_PERSONAS , personas );
		
		//forward a la vista
		dispatcher = request.getRequestDispatcher( Constantes.JSP_BACK_PERSONA_LIST );
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros y validar
		Persona p = getParametrosPersona(request);		
		
		//insertarlo
		model.insert(p);
		
		//enviar atributos
		request.setAttribute(Constantes.MSG_KEY ,msg);
		request.setAttribute(Constantes.ATT_PERSONA ,p);
		
		//forward vista
		dispatcher = request.getRequestDispatcher( Constantes.JSP_BACK_PERSONA_FORM );
		dispatcher.forward(request, response);
	}

	/**
	 * Recoger los parametros de la request y crear <code>Persona</code>.
	 * Tambien gestiona los mensajes para el usuario
	 * @param request
	 * @return <code>Persona</code> inicializada con los parametros de la request, en caso de fallo null
	 */
	private Persona getParametrosPersona(HttpServletRequest request) {
		Persona p = null;
		try{
			p = new Persona("");
			p.setNombre( request.getParameter("name"));
			p.setEdad( Integer.parseInt(request.getParameter("edad")) );
			msg = "Persona creada";
		}catch(Exception e){
			p = null;
			msg = "Error crando Persona";
			e.printStackTrace();
		}
		
		return p;
	}

}
