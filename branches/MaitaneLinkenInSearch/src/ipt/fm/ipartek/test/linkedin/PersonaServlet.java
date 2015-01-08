package ipt.fm.ipartek.test.linkedin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SearchServlet
 */

public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conexion = null;
	String personas = "";

	PreparedStatement st2 = null;
	Statement st = null;
	ResultSet rs = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonaServlet() {
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

		// conectar BBDD
		request.setAttribute("personas", seleccionarLista());

		// forwad a jsp de busqueda
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void insertar(String first, String last) {

		Connection conexion = null;
		PreparedStatement st2 = null;

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

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			// cerrar ResultSet

			// cerrar Statements

			if (st2 != null) {
				try {
					st2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			cerrarConexion(conexion);

		}

	}

	private void eliminar(String first, String last) {

		Connection conexion = null;
		PreparedStatement st2 = null;

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

			String sqlEliminar = "DELETE FROM persona WHERE nombre = first AND apellido1= last;";
			st2 = conexion.prepareStatement(sqlEliminar);

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			// cerrar ResultSet

			// cerrar Statements

			if (st2 != null) {
				try {
					st2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			cerrarConexion(conexion);

		}

	}

	private String seleccionarLista() {
		String personas = "";

		try {

			abrirConexion();

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

			// cerrar Statements

			if (st2 != null) {
				try {
					st2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			cerrarConexion(conexion);

		}
		return personas;

	}

	private void seleccionar() {

		try {

			abrirConexion();

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

			// cerrar Statements

			if (st2 != null) {
				try {
					st2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			cerrarConexion(conexion);

		}

	}

	private void modificar(String first, String last) {

		Connection conexion = null;
		PreparedStatement st2 = null;

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

			String sqlInsert = "UPDATE `persona` SET `nombre`=first,`apellido1`=last WHERE 1;";
			st2 = conexion.prepareStatement(sqlInsert);

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			// cerrar ResultSet

			// cerrar Statements

			if (st2 != null) {
				try {
					st2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			cerrarConexion(conexion);

		}

	}

	private void cerrarConexion(Connection conexion) {

		if (conexion != null) {
			try {
				conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void abrirConexion() throws NamingException, SQLException {

		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		conexion = ds.getConnection();

	}

}
