package com.ipartek.formacion.buscadorLinkedIn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.buscadorLinkedIn.bean.Persona;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// recogemos atributos y creamos persona
	request.setCharacterEncoding("UTF-8");

	if (request.getParameter("nombre") == null) {
	    // venimos desde el enlace de listar, no hay que crear o recoger
	    // nada
	    request.setAttribute("personas", listar());
	    request.getRequestDispatcher("listadoPersonas.jsp").forward(
		    request, response);
	} else {
	    String nombre = request.getParameter("nombre");
	    String apellidos = request.getParameter("apellido");
	    String urlImagen = request.getParameter("urlImagen");

	    Persona p1 = new Persona(nombre, apellidos);

	    // insertamos en BBDD
	    insertar(p1, urlImagen);
	    request.setAttribute("personas", listar());
	    request.getRequestDispatcher("listadoPersonas.jsp").forward(
		    request, response);
	}

    }

    private String listar() {
	// conectar base de datos
	String personas = "";
	Connection conexion = null;
	Statement st = null;
	ResultSet rs = null;

	try {
	    conexion = crearConexion();

	    st = conexion.createStatement();
	    rs = st.executeQuery("SELECT nombre,apellidos, URLImagen FROM persona");

	    while (rs.next()) {
		personas += "<img src='" + rs.getString("URLImagen") + "'><br>";
		personas += rs.getString("nombre");
		personas += "    ";
		personas += rs.getString("apellidos");
		personas += "     ";
		personas += "<form method='post' action='BorradoServlet'>"
			+ "<input type='text' hidden name='accion' value='actualizar'> "
			+ "<input type='text' name='nombre' hidden value='"
			+ rs.getString("nombre")
			+ "'><input type='text' name='apellidos' hidden value='"
			+ rs.getString("apellidos")
			+ "'><input type=submit value='Actualizar'>"
			+ "</form>";
		personas += "<form method='post' action='BorradoServlet'>"
			+ "<input type='text' hidden name='accion' value='borrar'> "
			+ "<input type='text' name='nombre' hidden value='"
			+ rs.getString("nombre")
			+ "'><input type='text' name='apellidos' hidden value='"
			+ rs.getString("apellidos")
			+ "'><input type=submit value='borrar'>" + "</form>";
		personas += "<br>";
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    cerrarConexion(conexion, st, rs);

	}
	return personas;

    }

    private void insertar(Persona p1, String urlImagen) {

	Connection conexion = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    conexion = crearConexion();
	    st = conexion
		    .prepareStatement("INSERT INTO persona(nombre, apellidos, URLImagen) VALUES(?,?,?)");
	    st.setString(1, p1.getNombre());
	    st.setString(2, p1.getApellidos());
	    st.setString(3, urlImagen);
	    st.executeUpdate();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    cerrarConexion(conexion, st, rs);
	}

    }

    public static Connection crearConexion() {
	Connection conexion = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");

	    conexion = DriverManager.getConnection(
		    "jdbc:mysql://localhost/test", "root", "");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return conexion;
    }

    public static void cerrarConexion(Connection conexion, Statement st,
	    ResultSet rs) {
	if (rs != null) {
	    try {
		rs.close();
	    } catch (Exception e) {

		e.printStackTrace();
	    }
	}

	if (st != null) {
	    try {
		st.close();
	    } catch (Exception e) {

		e.printStackTrace();
	    }
	}

	if (conexion != null) {
	    try {
		conexion.close();
	    } catch (Exception e) {

		e.printStackTrace();
	    }
	}
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

}
