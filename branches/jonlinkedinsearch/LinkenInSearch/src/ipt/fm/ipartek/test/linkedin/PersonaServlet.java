package ipt.fm.ipartek.test.linkedin;

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
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataSource ds = null;
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/   
		
		if(command.equalsIgnoreCase("insert")){
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			System.out.println("insert "+nombre+' '+apellido);
			
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES ( '"+nombre+"', '"+apellido+"',0);";
			
			try {
				st.executeUpdate( sqlInsert );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			urlforward = "index.jsp";
			
		}
		
		if(command.equalsIgnoreCase("list")){
			
			   
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sqlSelect = "SELECT * FROM persona;";
			
			try {
				rs = st.executeQuery( sqlSelect );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList<Persona> personas = null;
			personas = new ArrayList<Persona>();
			
			
			try {
				String nombre;
				String apellido;
				int id;
				
				while(rs.next()){
					id = rs.getInt("id");
					nombre = rs.getString("nombre");
					apellido = rs.getString("apellido1");
					personas.add(new Persona(id, nombre, apellido));
					
				}
				request.setAttribute("personas",personas);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			urlforward = "listadoPersonas.jsp";
		}
		
		if(command.equalsIgnoreCase("delete")){
			String id = request.getParameter("id");
			
			//String nombre = request.getParameter("nombre");
			//String apellido = request.getParameter("apellido");
			//System.out.println("insert "+nombre+' '+apellido);
			
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sqlDelete = "DELETE FROM persona WHERE id="+id+";";
			
			try {
				st.executeUpdate( sqlDelete );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
