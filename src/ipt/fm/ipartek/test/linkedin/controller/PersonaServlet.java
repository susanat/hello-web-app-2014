package ipt.fm.ipartek.test.linkedin.controller;

import ipt.fm.ipartek.test.linkedin.Constantes;
import ipt.fm.ipartek.test.linkedin.bean.Persona;
import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPersonaDAO daoPersona = null;
	RequestDispatcher dispatcher = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			getListado(request);
			dispatcher.forward(request, response);
		}else{
			// Accion modificar
			Persona p = new Persona();
			p.setId(Integer.parseInt(id));
			p = daoPersona.getById(p);
			request.setAttribute("persona", p);
			request.getRequestDispatcher(Constantes.CTE_PERSONAS_FORM).forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Persona persona = null;
		
		// Recogemos la accion a ejecutar
		String accion = request.getParameter("action");

		// Miramos que accion ejecutamos
		// Si es una nueva persona
		if (Constantes.CTE_ACC_NUEVO.equalsIgnoreCase(accion)) {
			// Recogemos los datos de la Persona
			persona=obtenerPersona(request);
			// Anadimos la Persona a la Tabla
			daoPersona.insert(persona);
		} else {
			String id = request.getParameter("id");
			//Si es actualizar
			if(Constantes.CTE_ACC_ACTUALIZAR.equalsIgnoreCase(accion)){
				// Recogemos los datos de la Persona
				persona=obtenerPersona(request);
				persona.setId(Integer.parseInt(id));
				// Actualizamos la Persona en la Tabla
				daoPersona.update(persona);
			}else{
				//Si es eliminar
				persona=new Persona();
				persona.setId(Integer.parseInt(id));
				daoPersona.delete(persona);
			}
		}
		// Redireccionamos al Listado de Personas
		getListado(request);
		dispatcher.forward(request, response);
		}

	/**
	 * Obtiene el listado de las Personas de las tablas y redirecciona al listado de personas
	 * @param request
	 */
	private void getListado(HttpServletRequest request) {
		ArrayList<Persona> vPersonas = daoPersona.getAll();
		// pasar attributo resultado
		request.setAttribute("personas", vPersonas);
		// forward a la vista
		dispatcher = request.getRequestDispatcher(Constantes.CTE_PERSONAS_LIST);
	}
	
	/**
	 * Crea un objeto Persona a partir de sus datos (nombre, apellidos y foto)
	 * @param request
	 * @return Persona
	 */
	private Persona obtenerPersona(HttpServletRequest request){
		Persona p=null;
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String foto = request.getParameter("foto");
		p = new Persona(nombre, apellidos, foto);
		return p;
	}
}
