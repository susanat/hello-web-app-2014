package com.ipartek.formacion.busredsociales.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.busredsociales.bean.Usuario;
import com.ipartek.formacion.busredsociales.comun.Constantes;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;



/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private IUsuarioDAO modelUsuario = null;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		
		//Creamos el objeto al iniciarse el servlet
		modelUsuario = (IUsuarioDAO) getServletContext().getAttribute("modelUsuario");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = new ArrayList<Usuario>();
		
		String toRedirect = "";
		
		
		//TODO: Importante para la codificación de los caracteres
		request.setCharacterEncoding("UTF-8");
		
		//posibles parametros		
		//-- necesarios para la insercción y actualización
		String nombre = null;
		String apellidos = null;
		String photo = null;
		
		//-- necesario para la eliminación y actualización
		String index = null;
		String action = null;
		
		
		//insertamos el usuario		
		try {
			
			action = request.getParameter("action");
			
			if(action != null) {
				if("A".equalsIgnoreCase(action.trim())) {
					
					nombre = request.getParameter("nombre");
					apellidos = request.getParameter("apellidos");
					photo = request.getParameter("photo");
					
					//insertamos el usuario
					Usuario objInsertado = modelUsuario.insert(new Usuario(nombre, apellidos, photo));
					
					System.out.println(objInsertado.toString());
					
					
				} else if("E".equalsIgnoreCase(action.trim())) {
					
					index = request.getParameter("index");
					
					
					modelUsuario.delete(Integer.valueOf(index));
										
					
				} else if("U".equalsIgnoreCase(action.trim())) {
					
					index = request.getParameter("index");
					nombre = request.getParameter("nombre");
					apellidos = request.getParameter("apellidos");
					photo = request.getParameter("photo");
					
					//actualizamos el usuario
					Usuario obj = modelUsuario.update(new Usuario(Integer.valueOf(index),nombre, apellidos, photo));
										
				} else if("GU".equalsIgnoreCase(action.trim())) {
					index = request.getParameter("index");
					Usuario obj = modelUsuario.getById(Integer.valueOf(index));
					lista.add(obj);
					
				}
			}
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		
		//obtenemos la lista de los usuario TODO: cambiar lógica
		
		if (action != null && "GU".equalsIgnoreCase(action.trim())) {			
			toRedirect = "update.jsp";
		} else {
			try {
				lista = modelUsuario.getAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				lista = null;
			}
			toRedirect = "listadoUsuarios.jsp";
		}
		
		
		request.setAttribute(Constantes.ATTR_LISTADO, lista);
		
		//redirigimos
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher(toRedirect);	    
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	

}
