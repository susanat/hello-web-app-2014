package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.linkedin.bean.LinkedInParse;

/**
 * Servlet implementation class BuscarServlet
 */
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	// recoger parametros
	String first = request.getParameter("first");
	String last = request.getParameter("last");

	// buscar el linkedin

	LinkedInParse parse = new LinkedInParse(first, last);
	String htmlResult = parse.getHtml();

	// pasar attributo resultado
	request.setAttribute("resulthtml", htmlResult);
	// forward a jsp de busqueda
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

}
