package ipt.fm.ipartek.test.linkedin;

import ipt.fm.ipartek.test.bean.Persona;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		try {
			listPersonas(request);
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			insertPersona(new Persona(request.getParameter("first"), request.getParameter("last"), 30));
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	private void listPersonas(final HttpServletRequest request) throws NamingException, SQLException {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		final String sql = "SELECT nombre, apellido1, edad FROM persona";
		final ArrayList<Persona> personas = new ArrayList<Persona>();

		connection = openConnection();

		st = connection.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			personas.add(new Persona(rs.getString("nombre"), rs.getString("apellido1"), rs.getInt("edad")));
		}

		request.setAttribute("personas", personas);
	}

	private void insertPersona(final Persona persona) throws SQLException, NamingException {
		Connection connection = null;
		PreparedStatement st = null;
		final String sql = "INSERT INTO persona (nombre, apellido1, edad) VALUES (?, ?, ?)";

		connection = openConnection();

		st = connection.prepareStatement(sql);
		st.setString(1, persona.getNombre());
		st.setString(2, persona.getApellidos());
		st.setInt(3, 30);

		st.executeUpdate();

		closeConnection(connection);
	}

	private Connection openConnection() throws NamingException, SQLException {
		final InitialContext ctx = new InitialContext();
		final DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		return ds.getConnection();
	}

	private void closeConnection(final Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

}
