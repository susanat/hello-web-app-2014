package ipt.fm.ipartek.test.linkedin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		request.setCharacterEncoding("UTF-8");

		// recoger parámetros
		final String first = request.getParameter("first");
		final String last = request.getParameter("last");

		// conectar BBDD
		request.setAttribute("personasLinkedin", conectar(first, last));

		// buscar el linkedin
		final LinkedInParse parse = new LinkedInParse(first, last);
		final String htmlResult = parse.getHtml();

		// pasar atributo resultado
		request.setAttribute("resulthtml", htmlResult);

		// forwad a jsp de búsqueda
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private String conectar(final String first, final String last) {
		String personas = "";
		Connection connection = null;
		PreparedStatement st2 = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			/*
			 * // cargar driver Class.forName("com.mysql.jdbc.Driver"); //
			 * establecer conexión conexion =
			 * DriverManager.getConnection("jdbc:mysql://localhost/test",
			 * "root", "");
			 */

			// cargar DataSource, para usar un pool de conexiones
			final InitialContext ctx = new InitialContext();
			final DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			connection = ds.getConnection();

			// preparar Statement
			final String sqlInsert = "INSERT INTO persona (nombre, apellido1, edad) VALUES (?, ?, ?)";
			st2 = connection.prepareStatement(sqlInsert);
			st2.setString(1, first);
			st2.setString(2, last);
			st2.setInt(3, 30);

			// ejecutar Statement
			st2.executeUpdate();

			// consultar tabla personas
			st = connection.createStatement();
			// recoger resultados
			rs = st.executeQuery("select * from persona");

			while (rs.next()) {
				personas += rs.getString("nombre");
				personas += rs.getString("apellido1");
				personas += rs.getInt("edad");
				personas += "<br>";
			}

		} catch (final Exception e) {
			e.printStackTrace();
		} finally { // cerrar todos los objetos creados para el acceso a BBDD
			// cerrar ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar Statements
			if (st != null) {
				try {
					st.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			if (st2 != null) {
				try {
					st2.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion
			if (connection != null) {
				try {
					connection.close();
				} catch (final Exception e) {
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
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
