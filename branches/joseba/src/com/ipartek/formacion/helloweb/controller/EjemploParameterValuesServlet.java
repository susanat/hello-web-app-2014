package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EjemploParameterValuesServlet
 */
public class EjemploParameterValuesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String tiporespuesta = null;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// Recoger tipo de respuesta
	tiporespuesta = request.getParameter("tipoRespuesta");
	if ("text/html".equalsIgnoreCase(tiporespuesta)) {
	    responseHTML(request, response);
	} else if ("application/json".equalsIgnoreCase(tiporespuesta)) {
	    responseJSON(request, response);
	} else {
	    throw new ServletException("Formato de salida no soportado "
		    + tiporespuesta);
	}
    }

    private void responseJSON(HttpServletRequest request,
	    HttpServletResponse response) throws IOException {
	response.setContentType(tiporespuesta);
	response.setCharacterEncoding("utf-8");
	PrintWriter out = response.getWriter();
	Gson gustosJson = new Gson();
	// montar el objeto Gson con los gustos del usuario
	String responseJson = gustosJson.toJson(request
		.getParameterValues("pasa"));
	out.print(responseJson);
	out.flush();
    }

    private void responseHTML(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	response.setContentType(tiporespuesta);
	response.setCharacterEncoding("utf-8");
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Tus gustos </title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1>Tus gustos</h1>");
	out.println("<ol>");
	String gustos[] = request.getParameterValues("pasa");

	if (gustos != null) {

	    for (int i = 0; i < gustos.length; i++) {
		out.println("<li>" + gustos[i] + "</li>");
	    }
	} else {
	    out.println("<li> Eres un soso </li>");
	}

	out.println("<ol>");
	out.println("</body>");
	out.println("</html>");

    }

}
