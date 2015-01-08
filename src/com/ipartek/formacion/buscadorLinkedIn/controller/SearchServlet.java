package com.ipartek.formacion.buscadorLinkedIn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.buscadorLinkedIn.parse.LinkedInParse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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

	// recoger parametros

	String first = request.getParameter("first");
	String last = request.getParameter("last");

	// Conectar BBDD

	request.setAttribute("Personas", conectar());

	// buscar en linkedIn
	LinkedInParse parse = new LinkedInParse(first, last);
	String htmlresul = parse.getHtml();

	// pasar atributo resultado de vuelta al jsp
	request.setAttribute("resulhtml", htmlresul);

	// redireccionar a la jsp
	request.getRequestDispatcher("resultados.jsp").forward(request,
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

    private String conectar() {
	// conectar base de datos
	String personas = "";
	Connection conexion = null;
	Statement st = null;
	ResultSet rs = null;

	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    conexion = DriverManager.getConnection(
		    "jdbc:mysql://localhost/test", "root", "");

	    st = conexion.createStatement();
	    rs = st.executeQuery("SELECT * FROM persona");

	    while (rs.next()) {
		personas += rs.getString("nombre");
		personas += rs.getString("apellidos");
		personas += rs.getInt("edad");
		personas += "<br>";
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
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
	return personas;
    }

}
