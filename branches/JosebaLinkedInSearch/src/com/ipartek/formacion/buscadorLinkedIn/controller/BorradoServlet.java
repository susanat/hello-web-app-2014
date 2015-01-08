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
 * Servlet implementation class BorradoServlet
 */
public class BorradoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String accion = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorradoServlet() {
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
	accion = request.getParameter("accion");
	Persona p1 = new Persona(request.getParameter("nombre"),
		request.getParameter("apellidos"));
	if ("borrar".equals(accion)) {
	    borrar(p1);
	} else {
	    // actualizar(p1);
	}

	request.setAttribute("personas", listar());
	request.getRequestDispatcher("listadoPersonas.jsp").forward(request,
		response);
    }

    private void actualizar(Persona p1) {
	Connection conexion = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    conexion = PersonaServlet.crearConexion();
	    st = conexion
		    .prepareStatement("UPDATE persona SET nombre = ? , apellidos = ? WHERE nombre= ? AND apellidos = ?");
	    st.setString(1, p1.getNombre());
	    st.setString(2, p1.getApellidos());
	    st.executeUpdate();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    PersonaServlet.cerrarConexion(conexion, st, rs);
	}

    }

    private void borrar(Persona p1) {
	Connection conexion = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    conexion = DriverManager.getConnection(
		    "jdbc:mysql://localhost/test", "root", "");
	    st = conexion
		    .prepareStatement("DELETE FROM persona WHERE nombre = ? AND apellidos = ?");
	    st.setString(1, p1.getNombre());
	    st.setString(2, p1.getApellidos());
	    st.executeUpdate();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
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

    }

    private String listar() {
	// conectar base de datos
	String personas = "";
	Connection conexion = null;
	Statement st = null;
	ResultSet rs = null;

	try {
	    conexion = PersonaServlet.crearConexion();

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
	    PersonaServlet.cerrarConexion(conexion, st, rs);

	}
	return personas;

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
