package ipt.fm.ipartek.test.linkedin;

import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ipartek.formacion.linkedin.bean.Persona;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String command = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String urlforward = "index.jsp";
		command = request.getParameter("cmd");
	
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		IPersonaDAO personaDAO = factory.getPersonaDAO();
		
		if(command.equalsIgnoreCase("insert")){
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String foto = request.getParameter("foto");
			System.out.println("insert "+nombre+' '+apellido);
			
			personaDAO.insert(new Persona(-1,nombre,apellido,foto));
					
			urlforward = "index.jsp";
		}
		
		if(command.equalsIgnoreCase("list")){
			ArrayList<Persona> personas = null;
			
			personas = personaDAO.getAll();
			request.setAttribute("personas", personas);
			
			urlforward = "listadoPersonas.jsp";
		}
		
		if(command.equalsIgnoreCase("delete")){
			String id = request.getParameter("id");
			
			personaDAO.delete(new Persona(Integer.parseInt(id), "", "", ""));
			
			urlforward = "index.jsp";
		}
		
		if(command.equalsIgnoreCase("update")){
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String foto = request.getParameter("foto");
			
			personaDAO.update(new Persona(Integer.parseInt(id), nombre, apellido, foto));
			
			urlforward = "index.jsp";
			
		}
				
		request.getRequestDispatcher(urlforward).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
