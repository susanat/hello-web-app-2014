package com.ipartek.formacion.buscarpersonas.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.buscarpersonas.bean.Persona;
import com.ipartek.formacion.buscarpersonas.exception.ModelException;
import com.ipartek.formacion.buscarpersonas.model.DAOFactory;
import com.ipartek.formacion.buscarpersonas.model.IPersonaDAO;
import com.ipartek.formacion.buscarpersonas.util.Constantes;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DAOFactory factoria = null;
    IPersonaDAO daoPersona = null;

    @Override
    public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	daoPersona = factoria.getIPersonaDAO(DAOFactory.MYSQL);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	request.setCharacterEncoding("UTF-8");
	try {
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
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	request.setCharacterEncoding("UTF-8");
	try {

	    int op = Integer.parseInt(request
		    .getParameter(Constantes.PARAM_OPTION));
	    Persona p = null;
	    switch (op) {
	    case Constantes.CREATE: {
		p = new Persona(request.getParameter(Constantes.PARAM_NAME),
			request.getParameter(Constantes.PARAM_SURNAME),
			request.getParameter(Constantes.PARAM_FOTO));
		int id = daoPersona.insert(p);
		System.out.println("Se ha creado un nuevo registro nuevo: "
			+ id);
	    }
		break;
	    case Constantes.READ: {

	    }
		break;
	    case Constantes.UPDATE: {
		int edad = Integer.parseInt(request
			.getParameter(Constantes.PARAM_EDAD));
		int id = Integer.parseInt(request
			.getParameter(Constantes.PARAM_CODIGO));

		p = new Persona(id,
			request.getParameter(Constantes.PARAM_NAME),
			request.getParameter(Constantes.PARAM_SURNAME), edad,
			request.getParameter(Constantes.PARAM_FOTO));

		daoPersona.update(p);
	    }
		break;
	    case Constantes.DELETE: {
		int id = Integer.parseInt(request
			.getParameter(Constantes.PARAM_CODIGO));

		p = new Persona(id);

		daoPersona.delete(p);
	    }
		break;
	    default:
		break;
	    }

	    doGet(request, response);

	} catch (ModelException e) {
	    request.getRequestDispatcher("errorModelo.jsp").forward(request,
		    response);

	} catch (Exception e) {
	    request.getRequestDispatcher("error.jsp")
		    .forward(request, response);
	}
    }
}
