package ipt.fm.ipartek.test.linkedin;

import ipt.fm.ipartek.test.linkedin.bean.Persona;
import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPersonaDAO daoPersona = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// recoger parametros
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		Persona p = new Persona(first, last);

		// daoPersona.insert(p);
		daoPersona.delete(p);

		// conectar BBDD
		request.setAttribute("personas", daoPersona.getAll());

		// buscar el linkedin
		LinkedInParse parse = new LinkedInParse(first, last);
		String htmlResult = parse.getHtml();

		// pasar attributo resultado
		request.setAttribute("resulthtml", htmlResult);

		// forwad a jsp de busqueda
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

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

			// Cargar DataSource

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/TestDB");
			conexion = ds.getConnection();

			// 3.- Crear Stament a traves de la conexion
			// insertar persona nueva

			String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES ( ?, ?, ?);";
			st2 = conexion.prepareStatement(sqlInsert);

			// sustituir ? por valores de la sentencia SQL del prpeareStatment
			st2.setString(1, first);
			st2.setString(2, last);
			st2.setInt(3, 36);

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
			if (conexion != null) {
				try {
					conexion.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return personas;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
