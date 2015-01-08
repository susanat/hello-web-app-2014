package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
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
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	// conectar BBDD
	String resultado = conectar();

	// pasar attributo resultado
	request.setAttribute("personas", resultado);
	// forward a jsp de busqueda
	request.getRequestDispatcher("listadoPersonas.jsp").forward(request,
		response);
    }

    private String conectar() {
	String personas = "";
	Connection conexion = null;
	Statement st = null;
	ResultSet rs = null;
	try {
	    /*
	     * Class.forName("com.mysql.jdbc.Driver"); conexion =
	     * DriverManager.getConnection( "jdbc:mysql://localhost/test",
	     * "root", "");
	     */
	    InitialContext ctx = new InitialContext();
	    DataSource ds = (DataSource) ctx
		    .lookup("java:comp/env/jdbc/TestDB");
	    conexion = ds.getConnection();

	    st = conexion.createStatement();
	    rs = st.executeQuery("SELECT * FROM persona");

	    while (rs.next()) {
		personas += "<form action='persona' method='post'>";
		personas += "<input type='hidden' name='id' value='"
			+ rs.getInt("id") + "'>";
		personas += "<input type='text' name='nombre' value='"
			+ rs.getString("nombre") + "'>";
		personas += "<input type='text' name='apellidos' value='"
			+ rs.getString("apellidos") + "'>";
		personas += "<input type='text' name='edad' value='"
			+ rs.getInt("edad") + "'>";
		personas += "<input type='hidden' name='operacion' value='2'>";
		personas += "<input type='submit' value='Eliminar'>";
		personas += "</form>";

		personas += rs.getInt("edad");
		personas += "<form action='persona' method='post'>";
		personas += "<input type='hidden' name='id' value='"
			+ rs.getInt("id") + "'>";
		personas += "<input type='hidden' name='operacion' value='3'>";
		personas += "<input type='submit' value='Eliminar'>";
		personas += "</form>";

		personas += "<br>";
	    }

	} catch (Exception e) {

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar conexion
	    if (conexion != null) {
		try {
		    conexion.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
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
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String nombre = "";
	String apellidos = "";
	String id = "";
	String op = request.getParameter("operacion");

	if (op.equals("1")) {
	    nombre = request.getParameter("nombre");
	    apellidos = request.getParameter("apellidos");
	    if (insertar(nombre, apellidos)) {
		System.out.println("bien insertada");
	    } else {
		System.out.println("mal insertada");
	    }
	} else if (op.equals("2")) {
	    nombre = request.getParameter("nombre");
	    apellidos = request.getParameter("apellidos");
	    id = request.getParameter("id");

	    if (actualizar(Integer.parseInt(id), nombre, apellidos)) {
		System.out.println("bien actualizado");
	    } else {
		System.out.println("mal actualizado");
	    }
	} else if (op.equals("3")) {
	    id = request.getParameter("id");

	    if (borrar(Integer.parseInt(id))) {
		System.out.println("bien borrado");
	    } else {
		System.out.println("mal borrado");
	    }
	}

	// conectar BBDD

	doGet(request, response);

    }

    private boolean borrar(int id) {
	boolean correcto = false;
	Connection conexion = null;
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    InitialContext ctx = new InitialContext();
	    DataSource ds = (DataSource) ctx
		    .lookup("java:comp/env/jdbc/TestDB");
	    conexion = ds.getConnection();

	    String sqlInsert = "DELETE FROM persona WHERE id=?";

	    st = conexion.prepareStatement(sqlInsert);
	    st.setInt(1, id);

	    st.executeUpdate();
	    correcto = true;

	} catch (Exception e) {

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar conexion
	    if (conexion != null) {
		try {
		    conexion.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	}

	return correcto;
    }

    private boolean actualizar(int id, String nombre, String apellidos) {
	boolean correcto = false;
	Connection conexion = null;
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    InitialContext ctx = new InitialContext();
	    DataSource ds = (DataSource) ctx
		    .lookup("java:comp/env/jdbc/TestDB");
	    conexion = ds.getConnection();

	    String sqlInsert = "UPDATE persona SET (nombre,apellidos,edad) VALUES ( ? , ? , ?)";

	    st = conexion.prepareStatement(sqlInsert);
	    st.setString(1, nombre);
	    st.setString(2, apellidos);
	    st.setInt(3, 18);

	    st.executeUpdate();
	    correcto = true;

	} catch (Exception e) {

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar conexion
	    if (conexion != null) {
		try {
		    conexion.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	}

	return correcto;
    }

    private boolean insertar(String pNombre, String pApellidos) {
	boolean correcto = false;
	Connection conexion = null;
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    InitialContext ctx = new InitialContext();
	    DataSource ds = (DataSource) ctx
		    .lookup("java:comp/env/jdbc/TestDB");
	    conexion = ds.getConnection();

	    String sqlInsert = "INSERT INTO persona (nombre,apellidos,edad) VALUES ( ? , ? , ?)";

	    st = conexion.prepareStatement(sqlInsert);
	    st.setString(1, pNombre);
	    st.setString(2, pApellidos);
	    st.setInt(3, 18);

	    st.executeUpdate();
	    correcto = true;

	} catch (Exception e) {

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar conexion
	    if (conexion != null) {
		try {
		    conexion.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	}

	return correcto;

    }

}
