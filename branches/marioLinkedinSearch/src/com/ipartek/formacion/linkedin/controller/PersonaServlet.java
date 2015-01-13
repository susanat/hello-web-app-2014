package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;
import com.ipartek.formacion.linkedin.modelo.dao.ModelException;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final int CERO = 0;

    public static final String OP_INSERTAR = "1";
    public static final String OP_ACTUALIZAR = "2";
    public static final String OP_BORRAR = "3";

    DAOFactory factoria = null;
    IPersonaDAO daoPersona = null;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	try {

	    if (factoria == null) {
		factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	    }

	    ArrayList<Persona> pers = daoPersona.getAll();

	    // conectar BBDD
	    // String resultado = consultarPersonas();

	    // pasar attributo resultado
	    request.setAttribute("personas", pers);
	    // forward a jsp de busqueda
	    request.getRequestDispatcher("listadoPersonas.jsp").forward(
		    request, response);
	} catch (ModelException e) {
	    request.getRequestDispatcher("errorModelo.jsp").forward(request,
		    response);
	} catch (Exception e) {
	    request.getRequestDispatcher("error.jsp")
	    .forward(request, response);
	}
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
	if (factoria == null) {
	    factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	    daoPersona = factoria.getPersonaDAO();
	}
	String op = request.getParameter("operacion");
	Persona p = null;

	if (op.equals(OP_INSERTAR)) {
	    try {
		p = new Persona(CERO, request.getParameter("nombre"),
			request.getParameter("apellidos"),
			Persona.EDAD_DEFAULT, request.getParameter("foto"));
		int idnuevo = daoPersona.insert(p);
		System.out.println(idnuevo);

	    } catch (ModelException e) {
		request.getRequestDispatcher("errorModelo.jsp").forward(
			request, response);
	    } catch (Exception e) {
		request.getRequestDispatcher("error.jsp").forward(request,
			response);
	    }

	} else if (op.equals(OP_ACTUALIZAR)) {

	    try {
		String edad = request.getParameter("edad");
		id = request.getParameter("id");

		p = new Persona(Integer.parseInt(id),
			request.getParameter("nombre"),
			request.getParameter("apellidos"),
			Integer.parseInt(edad), request.getParameter("foto"));

		daoPersona.update(p);

	    } catch (ModelException e) {
		request.getRequestDispatcher("errorModelo.jsp").forward(
			request, response);
	    } catch (Exception e) {
		request.getRequestDispatcher("error.jsp").forward(request,
			response);
	    }

	} else if (op.equals(OP_BORRAR)) {
	    try {
		id = request.getParameter("id");

		p = new Persona(Integer.parseInt(id));

		daoPersona.delete(p);

	    } catch (ModelException e) {
		request.getRequestDispatcher("errorModelo.jsp").forward(
			request, response);
	    } catch (Exception e) {
		request.getRequestDispatcher("error.jsp").forward(request,
			response);
	    }

	}

	// conectar BBDD

	doGet(request, response);
    }

}
