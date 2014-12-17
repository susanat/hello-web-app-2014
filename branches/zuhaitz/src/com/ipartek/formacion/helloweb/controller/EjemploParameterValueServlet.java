package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class EjemploParameterValueServlet
 */
public class EjemploParameterValueServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String mime = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		// Recoger tipo MIME o respuesta
		mime = request.getParameter("tipoRespuesta");
		// Recoger múltiples parámetros
		final String hobbies[] = request.getParameterValues("pasa");

		if ("text/html".equalsIgnoreCase(mime)) {
			responseHtml(response, hobbies);
		} else if ("application/json".equalsIgnoreCase(mime)) {
			responseJson(response, hobbies);
		} else {
			throw new ServletException("Formato de salida no soportado " + mime);
		}
	}

	private void responseJson(final HttpServletResponse response, final String[] hobbies) throws IOException {
		response.setContentType(mime);
		response.setCharacterEncoding("utf-8");

		final PrintWriter out = response.getWriter();
		// final Gson gson = new Gson();
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();

		out.println(gson.toJson(hobbies));
		out.flush();
	}

	private void responseHtml(final HttpServletResponse response, final String[] hobbies) throws IOException {
		response.setContentType("text/html");
		final PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Tus hobbies</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Tus hobbies</h1>");
		out.println("<ol>");

		if (hobbies != null) {
			for (final String hobby : hobbies) {
				out.println("<li>" + hobby + "</li>");
			}
		} else {
			out.println("<li>Eres un soso</li>");
		}

		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
}
