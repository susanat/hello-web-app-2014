package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;

/**
 * Servlet implementation class BuscarServlet
 */
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPersonaDAO daoPersona = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// recoger parametros
		String first = request.getParameter("first");
		String last = request.getParameter("last");

		// buscar el linkedin
		LinkedInParse parse = new LinkedInParse(first, last);
		ArrayList<Persona> htmlResult = parse.getHtml();

		// pasar attributo resultado
		request.setAttribute("personas", htmlResult);

		// forwad a jsp de resultados
		request.getRequestDispatcher("Resultados.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String conectar(String first, String last) {
		String personas = "";

		Connection conexion = null;
		PreparedStatement st2 = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			/*
			 * // 1.- cargar driver Class.forName("com.mysql.jdbc.Driver"); //
			 * 2.- Establecer conexion conexion = DriverManager.getConnection(
			 * "jdbc:mysql://localhost/test", "root", "");
			 */

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/TestDB");
			conexion = ds.getConnection();

			// 3.- Crear Stament a traves de la conexion
			// insertar persona nueva
			String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES (?,?,?);";
			st2 = conexion.prepareStatement(sqlInsert);

			// sustituir ? por valoresen la sentencia sql del prepareStatement
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

			/*
			 * } catch (ClassNotFoundException e) { e.printStackTrace();
			 */
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

}
