package ipt.fm.ipartek.test.controller;

import ipt.fm.ipartek.test.bean.Persona;
import ipt.fm.ipartek.test.util.Constantes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int personaId = Constantes.ID_NULL;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		try {
			// if personaId > Constantes.ID_NULL que vaya al form con los datos
			// del id
			personaId = Integer.parseInt(request.getParameter("id"));

			listPersonas(request);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} catch (final Exception e) {
			personaId = Constantes.ID_NULL;
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
			insertPersona(getParameters(request));
			doGet(request, response);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	private Persona getParameters(final HttpServletRequest request) {
		final Persona persona = new Persona(request.getParameter("nombre"), request.getParameter("apellidos"),
				Integer.parseInt(request.getParameter("edad")));
		return persona;
	}

	private void listPersonas(final HttpServletRequest request) throws NamingException, SQLException {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		final String sql = "SELECT nombre, apellido1, edad FROM persona";
		final ArrayList<Persona> personas = new ArrayList<Persona>();

		connection = FactoriaMySql.openConnection();

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

		connection = FactoriaMySql.openConnection();

		st = connection.prepareStatement(sql);
		st.setString(1, persona.getNombre());
		st.setString(2, persona.getApellidos());
		st.setInt(3, 30);

		st.executeUpdate();

		if (st != null) {
			try {
				st.close();
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		FactoriaMySql.closeConnection();
	}

}
