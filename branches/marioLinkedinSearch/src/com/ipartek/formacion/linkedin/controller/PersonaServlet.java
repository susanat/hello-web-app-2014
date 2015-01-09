package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;

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
	DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	IPersonaDAO daoPersona = factoria.getPersonaDAO();
	ArrayList<Persona> pers = daoPersona.getAll();

	// conectar BBDD
	// String resultado = consultarPersonas();

	// pasar attributo resultado
	request.setAttribute("personas", pers);
	// forward a jsp de busqueda
	request.getRequestDispatcher("listadoPersonas.jsp").forward(request,
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
	String id = "";
	String op = request.getParameter("operacion");
	DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	IPersonaDAO daoPersona = factoria.getPersonaDAO();
	Persona p = null;

	if (op.equals("1")) {

	    p = new Persona(0, request.getParameter("nombre"),
		    request.getParameter("apellidos"), 18,
		    request.getParameter("foto"));

	    if (daoPersona.insert(p) != 0) {
		System.out.println("bien insertada");
	    } else {
		System.out.println("mal insertada");
	    }

	} else if (op.equals("2")) {
	    String edad = request.getParameter("edad");
	    id = request.getParameter("id");

	    p = new Persona(Integer.parseInt(id),
		    request.getParameter("nombre"),
		    request.getParameter("apellidos"), Integer.parseInt(edad),
		    request.getParameter("foto"));

	    if (daoPersona.update(p)) {
		System.out.println("bien actualizado");
	    } else {
		System.out.println("mal actualizado");
	    }

	} else if (op.equals("3")) {
	    String edad = request.getParameter("edad");
	    id = request.getParameter("id");

	    p = new Persona(Integer.parseInt(id),
		    request.getParameter("nombre"),
		    request.getParameter("apellidos"), Integer.parseInt(edad),
		    request.getParameter("foto"));

	    if (daoPersona.delete(p)) {
		System.out.println("bien borrado");
	    } else {
		System.out.println("mal borrado");
	    }
	}

	// conectar BBDD

	doGet(request, response);

    }

    /**
     * Crea la conexion con la BD
     *
     * @return conexion - La conexion
     */
    private Connection conectar() {

	Connection conexion = null;

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
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return conexion;
    }

    /**
     * Cierra la conexion
     *
     * @param conexion
     */
    private void cerrarConexion(Connection conexion) {
	// cerrar conexion
	if (conexion != null) {
	    try {
		conexion.close();
	    } catch (Exception e2) {
		e2.printStackTrace();
	    }
	}

    }

    /**
     * Consulta a la BD todas las personas que estén almacenadas
     *
     * @return personas - un string con todas las personas
     */
    private String consultarPersonas() {
	String personas = "";
	Statement st = null;
	ResultSet rs = null;
	Connection conexion = conectar();
	try {

	    st = conexion.createStatement();
	    rs = st.executeQuery("SELECT * FROM persona");

	    while (rs.next()) {
		personas += "<div class='container'>";
		personas += "<form action='persona' method='post'>";
		personas += "<img alt='foto de perfil' src='"
			+ rs.getString("url_foto")
			+ "' class='pull-left margin-right' height='60' width='60'>";

		personas += "<input type='hidden' name='id' value='"
			+ rs.getInt("id") + "'>";

		personas += "<input type='text' name='nombre' value='"
			+ rs.getString("nombre") + "'>";

		personas += "<input type='text' name='apellidos' value='"
			+ rs.getString("apellidos") + "'>";

		personas += "<input type='text' name='edad' value='"
			+ rs.getInt("edad") + "'>";

		personas += "<input type='hidden' name='operacion' value='2'>";
		personas += "<br>";
		personas += "<input type='submit' value='Actualizar' class='btn btn-primary btn-xs pull-left margin'>";

		personas += "</form>";

		personas += "<form action='persona' method='post' >";
		personas += "<input type='hidden' name='id' value='"
			+ rs.getInt("id") + "'>";
		personas += "<input type='hidden' name='operacion' value='3'>";
		personas += "<input type='submit' value='Eliminar' class='btn btn-danger btn-xs margin'>";
		personas += "</form>";
		personas += "</div>";
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
	    cerrarConexion(conexion);
	}

	return personas;

    }

    /**
     * Borrar de la BD la tupla indicada por el id
     *
     * @param id
     *            - identificador
     * @return TRUE si ha borrado correctamente, false en caso contrario
     */
    private boolean borrar(int id) {
	boolean correcto = false;
	Connection conexion = conectar();
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {
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
	    cerrarConexion(conexion);
	}

	return correcto;
    }

    /**
     * Actualiza un registro en la BD
     *
     * @param id
     *            - identificador
     * @param nombre
     * @param apellidos
     * @param edad
     * @return TRUE si ha borrado correctamente, false en caso contrario
     */
    private boolean actualizar(int id, String nombre, String apellidos, int edad) {
	boolean correcto = false;
	Connection conexion = conectar();
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {

	    String sqlInsert = "UPDATE persona SET nombre=?,apellidos=?,edad=? WHERE id=?";

	    st = conexion.prepareStatement(sqlInsert);
	    st.setString(1, nombre);
	    st.setString(2, apellidos);
	    st.setInt(3, edad);
	    st.setInt(4, id);

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
	    cerrarConexion(conexion);
	}

	return correcto;
    }

    /**
     * Inserta un registro en la BD
     *
     * @param pNombre
     * @param pApellidos
     * @return TRUE si ha borrado correctamente, false en caso contrario
     */
    private boolean insertar(String pNombre, String pApellidos, String pFoto) {
	boolean correcto = false;
	Connection conexion = conectar();
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    String sqlInsert = "INSERT INTO persona (nombre,apellidos,edad, url_foto) VALUES ( ? , ? , ?, ?)";

	    st = conexion.prepareStatement(sqlInsert);
	    st.setString(1, pNombre);
	    st.setString(2, pApellidos);
	    st.setInt(3, 18);
	    st.setString(4, pFoto);
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
	    cerrarConexion(conexion);
	}

	return correcto;

    }

}
