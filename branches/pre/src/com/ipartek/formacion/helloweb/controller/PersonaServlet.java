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
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	//ModeloPersona model = null;
	Mensaje msg = null;
	int id = Persona.ID_NULL; // identificador Persona
      
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		//model = new ModeloPersona();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//model=null;
	}
	
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//TODO comprobar Autorizacion del usuario
		
		
		//recoger paramtro identificador Persona
		try{
			id = Integer.parseInt( req.getParameter("id") );
		}catch( Exception e){
			id = Persona.ID_NULL; 
		}
		
		super.service(req, resp);
		
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//comprobar si es getAll o getById
		if ( id == Persona.ID_NULL ){
			getAll(request);
		}else{
			getById(request);
		}
		
		dispatcher.forward(request, response);
		
	}
	
	
	
	
	

	private void getById(HttpServletRequest request) {
		//Persona p = model.getById(id);
		Persona p = InitListener.modelPersona.getById(id);
		//pasamos los atributos
		request.setAttribute( Constantes.ATT_PERSONA , p );
		//forward a la vista del formulario
	    dispatcher = request.getRequestDispatcher( Constantes.JSP_BACK_PERSONA_FORM );
		
	}


	private void getAll(HttpServletRequest request) {
		//ArrayList<Persona> personas = model.getAll();		
		ArrayList<Persona> personas = InitListener.modelPersona.getAll();
		//pasamos los atributos
		request.setAttribute( Constantes.ATT_PERSONAS , personas );		
		//forward a la vista
		dispatcher = request.getRequestDispatcher( Constantes.JSP_BACK_PERSONA_LIST );		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//check Operacion
		String op = request.getParameter(Constantes.OP_KEY);
		if ( Constantes.OP_UPDATE.equals( op ) ){
			update(request);
		}else if ( Constantes.OP_DELETE.equals( op ) ){
			delete(request);
		}else if ( Constantes.OP_CREATE.equals( op ) ){
			create(request);
		}else{
			opNotSuported(request);
		}
		
		request.setAttribute(Constantes.MSG_KEY , msg );
		
		dispatcher.forward(request, response);
	}

	/**
	 * Actulizar los datos de una Persona, foward a form.jsp
	 * @param request
	 */
	private void update(HttpServletRequest request) {
		
		Persona p = getParametrosPersona(request);		
		if ( p != null ){
			//modificar
			p.setId(id);
			//TODO comprobar que realmente se a modificado
			//model.update(p);
			InitListener.modelPersona.update(p);
			//enviar atributos
			msg =  new Mensaje(Constantes.MSG_REG_UPDATE , Mensaje.MSG_TYPE_SUCCESS);			
		}else{
			msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS, Mensaje.MSG_TYPE_DANGER);
		}	
				
		request.setAttribute(Constantes.ATT_PERSONA ,p);
		
		//forward vista
		dispatcher = request.getRequestDispatcher( Constantes.JSP_BACK_PERSONA_FORM );
		
	}


	/**
	 * Elimina la Persona por su ID y nos retorna a list.jsp
	 * @param request
	 */
	private void delete(HttpServletRequest request) {
				
		//if (model.delete(id) ){
		if ( InitListener.modelPersona.delete(id) ){
			msg = new Mensaje( Constantes.MSG_REG_DELETE, Mensaje.MSG_TYPE_WARNING);
		}else{
			msg = new Mensaje( Constantes.MSG_ERR_REG_DELETE, Mensaje.MSG_TYPE_DANGER);
		}		
		getAll(request);		
		
	}


	/**
	 * Si no existe la Operacion a realizar mensaje y forward al list.jsp
	 * @param request
	 */
	private void opNotSuported(HttpServletRequest request) {				
		getAll(request);
		msg = new Mensaje(  Constantes.MSG_NOT_ALLOWED , Mensaje.MSG_TYPE_DANGER);	
	}


	/**
	 * Crear nueva persona e insertarla en la BBDD
	 * @param request
	 */
	private void create(HttpServletRequest request) {
		//recoger parametros y validar
		Persona p = getParametrosPersona(request);		
		
		if ( p != null ){
			//insertarlo
			//TODO comprobar la inserccion
			//model.insert(p);					
			InitListener.modelPersona.insert(p);
			//enviar atributos
			msg = new Mensaje( Constantes.MSG_REG_CREATE, Mensaje.MSG_TYPE_SUCCESS);	
		}else{
			msg = new Mensaje( Constantes.MSG_ERR_PARAMETERS, Mensaje.MSG_TYPE_DANGER);
		}	
				
		request.setAttribute(Constantes.ATT_PERSONA ,p);
		
		//forward vista
		dispatcher = request.getRequestDispatcher( Constantes.JSP_BACK_PERSONA_FORM );
		
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
			p.setRol ( Persona.Rol.valueOf(request.getParameter("rol")) );
		}catch(Exception e){
			p = null;		
			e.printStackTrace();
		}
		
		return p;
	}

}
