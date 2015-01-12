package com.ipartek.formacion.buscadorLinkedIn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.buscadorLinkedIn.bean.Persona;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.DAOFactory;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

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
	    request.setAttribute("personas", listarConDAO());// Estamos usando
	    // listar con DAO

	    request.getRequestDispatcher("listadoPersonas.jsp").forward(
		    request, response);
	} else {
	    String nombre = request.getParameter("nombre");
	    String apellidos = request.getParameter("apellido");
	    String urlImagen = request.getParameter("urlImagen");

	    Persona p1 = new Persona(nombre, apellidos);

	    // insertamos en BBDD
	    insertarConDAO(p1, urlImagen); // Estamos usando insertar con DAO
	    request.setAttribute("personas", listarConDAO());
	    request.getRequestDispatcher("listadoPersonas.jsp").forward(
		    request, response);
	}

    }

    private String listarConDAO() {
	String personas = "";
	ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

	DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
	IPersonaDAO DAOPersona = factoria.getPersonaDAO();
	listaPersonas = DAOPersona.getAll();

	for (int i = 0; i < listaPersonas.size(); i++) {
	    personas += "<div class='container'><img src='"
		    + listaPersonas.get(i).getUrlImagen()
		    + "' class='img-circle'><br>";
	    personas += listaPersonas.get(i).getNombre();
	    personas += "    ";
	    personas += listaPersonas.get(i).getApellidos();
	    personas += "     ";
	    personas += "<form method='post' action='BorradoServlet'>"
		    + "<input type='text' hidden name='accion' value='actualizar'> "
		    + "<input type='text' name='nombre' hidden value='"
		    + listaPersonas.get(i).getNombre()
		    + "'><input type='text' name='apellidos' hidden value='"
		    + listaPersonas.get(i).getApellidos()
		    + "'><input type=submit value='Actualizar' class='btn btn-primary'><br>"
		    + "</form>";
	    personas += "<form method='post' action='BorradoServlet'>"
		    + "<input type='text' hidden name='accion' value='borrar'> "
		    + "<input type='text' name='nombre' hidden value='"
		    + listaPersonas.get(i).getNombre()
		    + "'><input type='text' name='apellidos' hidden value='"
		    + listaPersonas.get(i).getApellidos()
		    + "'><input type=submit value='borrar' class='btn btn-danger'>"
		    + "</form></div>";
	    personas += "<br>";
	}

	return personas;

    }

    private void insertarConDAO(Persona p1, String urlImagen) {
	Persona p = new Persona(p1.getNombre(), p1.getApellidos(), urlImagen);
	DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
	IPersonaDAO DAOPersona = factoria.getPersonaDAO();
	DAOPersona.insert(p);

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
