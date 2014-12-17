package com.ipartek.formacion.helloweb.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EjemploParameterServlet
 */
public class EjemploParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
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
	String tipo = request.getParameter("tipoRespuesta");
	if ("html".equalsIgnoreCase(tipo)) {
	    responseHTML(request, response);

	} else {
	    if ("json".equalsIgnoreCase(tipo)) {
		responseJSON(request, response);
	    } else {
		throw new ServletException();
	    }
	}

    }

    private void responseJSON(final HttpServletRequest request,
	    final HttpServletResponse response) throws IOException {
	response.setContentType("aplication/json");
	response.setCharacterEncoding("utf-8");
	PrintWriter out = response.getWriter();
	Gson gson = new Gson();
	// rellenar con gusto del ususario
	String gustos[] = request.getParameterValues("pasa[]");
	String textJson = gson.toJson(gustos);
	out.print(textJson);

	out.flush();

    }

    private void responseHTML(final HttpServletRequest request,
	    final HttpServletResponse response) throws IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	out.println("<html>");
	out.println("<head>");
	out.println("<title>Tus Gustos</title>");
	out.println("</head>");
	out.println("<body bgcolor=\"white\">");
	out.println("<h1>Tus gustos</h1>");
	String gustos[] = request.getParameterValues("pasa[]");

	if (gustos != null) {
	    out.println("<ol>");
	    for (String g : gustos) {
		out.println("<li>");

		out.println(g);
		out.println("</li>");
	    }
	    out.println("</li>");
	    out.println("</ol>");
	} else {
	    out.println("eres un soso");
	}

	out.println("</body>");
	out.println("</html>");

    }
}
