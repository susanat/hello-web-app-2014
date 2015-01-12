package com.ipartek.formacion.buscadorLinkedIn.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.buscadorLinkedIn.bean.Persona;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.DAOFactory;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

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
	    borrarConDAO(p1);
	} else {
	    actualizarConDAO(p1);
	}

	request.setAttribute("personas", listarConDAO());
	request.getRequestDispatcher("listadoPersonas.jsp").forward(request,
		response);
    }

    private void actualizarConDAO(Persona p1) {
	DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
	IPersonaDAO DAOPersona = factoria.getPersonaDAO();
	DAOPersona.update(p1); // returns boolean so we can check if operation
	// was sucessful
    }

    private void borrarConDAO(Persona p1) {
	DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
	IPersonaDAO DAOPersona = factoria.getPersonaDAO();
	DAOPersona.delete(p1); // returns boolean so we can check if operation
	// was sucessful
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
