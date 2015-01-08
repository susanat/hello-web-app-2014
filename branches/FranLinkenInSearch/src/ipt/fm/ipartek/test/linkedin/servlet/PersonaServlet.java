package ipt.fm.ipartek.test.linkedin.servlet;

import ipt.fm.ipartek.test.linkedin.FactoriaMySql;
import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("nombre") != null) {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");

			if (!nombre.equals("") && !apellidos.equals("")) {
				Persona p = new Persona(nombre, apellidos, 0);
				insertar(p);
			}
		}

		request.setAttribute("personas", listar());
		request.getRequestDispatcher("listadosPersonas.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		if ("0".equals(request.getParameter("operacion"))) {
			// Actualizar
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			Persona p = new Persona(nombre, apellidos, Integer.parseInt(id));
			actualizar(p);
		} else if ("1".equals(request.getParameter("operacion"))) {
			// Borrar
			borrar(id);
		}

		request.setAttribute("personas", listar());
		request.getRequestDispatcher("listadosPersonas.jsp").forward(request,
				response);
	}

	/*
	 * private Connection conectar() { Connection conexion = null;
	 * 
	 * try { // 1.- cargar driver // Class.forName("com.mysql.jdbc.Driver"); //
	 * 2.- Establecer conexion // conexion = DriverManager.getConnection( //
	 * "jdbc:mysql://localhost/test", "root", "");
	 * 
	 * InitialContext ctx = new InitialContext(); DataSource ds = (DataSource)
	 * ctx .lookup("java:comp/env/jdbc/TestDB"); conexion = ds.getConnection();
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } return conexion; }
	 */

	private void cerrarObjetos(Statement st, ResultSet rs) {
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
	}

	private String listar() {
		StringBuilder personas = new StringBuilder();

		Connection conexion = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// 1.- cargar driver
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.- Establecer conexion
			// conexion = DriverManager.getConnection(
			// "jdbc:mysql://localhost/test", "root", "");
			conexion = FactoriaMySql.conectar();

			// consultar tabla personas
			st = conexion.createStatement();
			// 5.- Recoger resultados
			rs = st.executeQuery("select * from persona");

			while (rs.next()) {
				personas.append(rs.getString("nombre") + ",");
				personas.append(rs.getString("apellido1") + ",");
				personas.append(rs.getInt("id") + ";");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // cerrar todos los objetos creados para el acceso a BBDD
			cerrarObjetos(st, rs);
			FactoriaMySql.desconectar();
		}

		return personas.toString();
	}

	private void insertar(Persona p) {

		Connection conexion = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;

		try {
			// 1.- cargar driver
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.- Establecer conexion
			// conexion = DriverManager.getConnection(
			// "jdbc:mysql://localhost/test", "root", "");
			conexion = FactoriaMySql.conectar();

			// 3.- Crear Stament a traves de la conexion
			// insertar persona nueva
			String sqlInsert = "INSERT INTO persona ( nombre, apellido1) VALUES (?,?)";
			st2 = conexion.prepareStatement(sqlInsert);
			st2.setString(1, p.getNombre());
			st2.setString(2, p.getApellidos());

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // cerrar todos los objetos creados para el acceso a BBDD
			cerrarObjetos(st2, rs);
			FactoriaMySql.desconectar();
		}

	}

	private void actualizar(Persona p) {

		Connection conexion = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;

		try {
			// 1.- cargar driver
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.- Establecer conexion
			// conexion = DriverManager.getConnection(
			// "jdbc:mysql://localhost/test", "root", "");
			conexion = FactoriaMySql.conectar();

			// 3.- Crear Stament a traves de la conexion
			// insertar persona nueva
			String sqlInsert = "UPDATE persona SET nombre=?, apellido1=? WHERE id=?";
			st2 = conexion.prepareStatement(sqlInsert);
			st2.setString(1, p.getNombre());
			st2.setString(2, p.getApellidos());
			st2.setInt(3, p.getId());

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // cerrar todos los objetos creados para el acceso a BBDD
			cerrarObjetos(st2, rs);
			FactoriaMySql.desconectar();
		}

	}

	private void borrar(String id) {

		Connection conexion = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;

		try {
			// 1.- cargar driver
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.- Establecer conexion
			// conexion = DriverManager.getConnection(
			// "jdbc:mysql://localhost/test", "root", "");
			conexion = FactoriaMySql.conectar();

			// 3.- Crear Stament a traves de la conexion
			// insertar persona nueva
			String sqlInsert = "DELETE FROM persona WHERE id=?";
			st2 = conexion.prepareStatement(sqlInsert);
			st2.setString(1, id);

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // cerrar todos los objetos creados para el acceso a BBDD
			cerrarObjetos(st2, rs);
			FactoriaMySql.desconectar();
		}

	}

}
