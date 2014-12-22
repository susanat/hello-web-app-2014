package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EjemploParameterValueServlet
 */
public class EjemploParameterValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		PrintWriter out = null;
		String mime = request.getParameter("tipoRespuesta");
		response.setContentType(mime);
		if ("text/html".equalsIgnoreCase(mime)) {
			out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Tus gustos</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Tus gustos</h1>");
			out.println("</body>");
			out.println("<ol>");
			if (request.getParameterValues("pasa") != null) {
				String gustos[] = request.getParameterValues("pasa");
				for (int i = 0; i < gustos.length; i++) {
					out.println("<li>" + gustos[i] + "</li>");
				}
			} else {
				out.println("<li>Sin gustos</li>");
			}
			out.println("</ol>");
			out.println("</html>");
		} else if ("application/json".equalsIgnoreCase(mime)) {
			out = response.getWriter();
			Gson gson = new Gson();
			String respuestaJson = "";
			if (request.getParameterValues("pasa") != null) {
				respuestaJson = gson.toJson(request.getParameterValues("pasa"));
			}
			out.print(respuestaJson);
			out.flush();
		} else {
			throw new ServletException("Formato de salida no soportado " + mime);
		}

	}

}
