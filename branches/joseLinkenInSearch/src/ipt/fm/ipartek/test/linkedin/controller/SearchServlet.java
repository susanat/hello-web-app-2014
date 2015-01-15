package ipt.fm.ipartek.test.linkedin.controller;

import ipt.fm.ipartek.test.linkedin.LinkedInParse;
import ipt.fm.ipartek.test.linkedin.bean.Persona;
import ipt.fm.ipartek.test.linkedin.bean.PersonaLinkedin;
import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPersonaDAO daoPersona = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}

	public IPersonaDAO personaDAO() {
		return daoPersona;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// TODO mirar tema de acentos y Ñ desde HTML en los JSPs
		request.setCharacterEncoding("UTF-8");

		// recoger parametros
		String first = request.getParameter("first");
		String last = request.getParameter("last");

		// buscar el linkedin
		LinkedInParse parse = new LinkedInParse(first, last);
		ArrayList<PersonaLinkedin> personas = parse.getHtml();

		// modificamos el fichero de resultado

		// pasar attributo resultado
		request.setAttribute("resulthtml", personas);

		// forwad a jsp de busqueda
		request.getRequestDispatcher("index.jsp").forward(request, response);


		// conectar BBDD
		// request.setAttribute("personas", conectar(first, last));

		// insertar una nueva persona
		// daoPersona.insert(new Persona(first, last));

		// modificar una persona (id=2)
		// Persona p = new Persona(first, last);
		// p.setId(2);
		// daoPersona.update(p);
		// p = null;

		/*
		 * // obtener el id de esa persona int indPersona =
		 * daoPersona.getByNombreApellidos(new Persona(first, last));
		 * 
		 * Persona p = new Persona(); p.setId(indPersona); daoPersona.delete(p);
		 * p = null;
		 * 
		 * // recuperar personas request.setAttribute("personas",
		 * daoPersona.getAll());
		 * 
		 * // buscar el linkedin LinkedInParse parse = new LinkedInParse(first,
		 * last); String htmlResult = parse.getHtml();
		 * 
		 * // pasar attributo resultado request.setAttribute("resulthtml",
		 * htmlResult);
		 * 
		 * // forwad a jsp de busqueda
		 * request.getRequestDispatcher("index.jsp").forward(request, response);
		 */

	}

	/*
	private String conectar(String first, String last) {
		String personas = "";

		Connection conexion = null;
		PreparedStatement st2 = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			/*
			 * //1.- cargar driver Class.forName("com.mysql.jdbc.Driver"); //2.-
			 * Establecer conexion conexion =
			 * DriverManager.getConnection("jdbc:mysql://localhost/test",
			 * "root", "");
			 */
/*
			// Cargar DataSource

			conexion = FactoriaMySql.conectar();

			// 3.- Crear Stament a traves de la conexion
			// insertar persona nueva
			String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES ( ?, ? ,? );";
			st2 = conexion.prepareStatement(sqlInsert);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			st2.setString(1, first);
			st2.setString(2, last);
			st2.setInt(3, 69);

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();

			// consultar tabla personas
			st = conexion.createStatement();
			// 5.- Recoger resultados
			rs = st.executeQuery("select * from persona");

			while (rs.next()) {

				personas += rs.getString("nombre");
				personas += rs.getString("apellido1");
				personas += rs.getInt("edad");
				personas += "<br>";
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			// cerrar ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar Statements
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (st2 != null) {
				try {
					st2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion
			/*
			 * if ( conexion != null ){ try{ conexion.close(); }catch (
			 * Exception e){ e.printStackTrace(); } }
			 */
/*
			FactoriaMySql.desconectar();

		}

		return personas;
	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
