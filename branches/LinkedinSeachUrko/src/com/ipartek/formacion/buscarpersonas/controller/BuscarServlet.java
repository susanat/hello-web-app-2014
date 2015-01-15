package com.ipartek.formacion.buscarpersonas.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.buscarpersonas.bean.Persona;

/**
 * Servlet implementation class BuscarServlet
 */
public class BuscarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	request.setCharacterEncoding("UTF-8");
	// recoger parametros
	String first = request.getParameter("first");
	String last = request.getParameter("last");

	// buscar el linkedin

	LinkedInParse parse = new LinkedInParse(first, last);
	ArrayList<Persona> personas = parse.getHtml();

	// pasar attributo resultado
	request.setAttribute("personas", personas);
	// forward a jsp de busqueda
	request.getRequestDispatcher("resultados.jsp").forward(request,
		response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	doGet(request, response);
    }

}
