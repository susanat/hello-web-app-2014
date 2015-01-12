package com.ipartek.formacion.buscarpersonas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.buscarpersonas.bean.Persona;
import com.ipartek.formacion.buscarpersonas.model.DAOFactory;
import com.ipartek.formacion.buscarpersonas.model.IPersonaDAO;
import com.ipartek.formacion.buscarpersonas.util.Constantes;

/**
 * Servlet implementation class BuscarServlet
 */
public class BuscarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // private ServletConfig config = null;
    private String name = null;
    private String surname = null;
    private RequestDispatcher dispatcher = null;
    IPersonaDAO daoPersona = null;

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
	super.init(config);
	DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
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
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	cargarParametros(request);
	// LinkedInParse parse = new LinkedinParse();
	Persona p = null;
	if (name != null) {

	    p = new Persona(name, surname);
	    ArrayList<Persona> personas = LinkedInParse.getHtml(p);
	    String htmltext = generateList(personas);
	    request.setAttribute(Constantes.ATT_SEACH_DATA, htmltext);
	}

	request.setAttribute(Constantes.ATT_LISTA_PERSONAS,
		generateList(daoPersona.getAll()));
	dispatcher.forward(request, response);
    }

    private String generateList(final List<Persona> personas) {
	String text = null;
	if (personas != null && personas.size() > 0) {
	    text += "<ol>";
	    for (Persona p : personas) {
		text += "<li>" + p.getHTML() + "</li>"
			+ "<a href='/persona?op=" + Constantes.CREATE
			+ "&nombre=" + p.getNombre() + "&apellido="
			+ p.getApellidos() + "&foto=" + p.getFoto()
			+ "'>Insertar</a>";
	    }
	    text += "</ol>";
	}
	return text;
    }

    private void cargarParametros(final HttpServletRequest request) {
	if (request.getParameter(Constantes.PARAM_NAME) != null
		&& request.getParameter(Constantes.PARAM_SURNAME) != null) {
	    name = request.getParameter(Constantes.PARAM_NAME);
	    surname = request.getParameter(Constantes.PARAM_SURNAME);
	    // dispatcher = request.getRequestDispatcher(Constantes.SEARCH_JSP);
	}
	dispatcher = request.getRequestDispatcher(Constantes.SEARCH_JSP);
    }
}
