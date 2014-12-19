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
	String mime = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// recoger tipo mime o respuesta

		mime = request.getParameter("tipoRespuesta");

		// html

		if ("text/html".equalsIgnoreCase(mime)) {
			responseHTML(request, response);
			// json
		} else if ("application/json".equalsIgnoreCase(mime)) {
			responseJSON(request, response);
		} else {
			throw new ServletException("Formato de salida no soportado" + mime);

		}

	}

	private void responseHTML(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setContentType(mime);
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Tus gustos</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Tus gustos</h1>");
		out.println("<ol>");
		// recoger parametros request
		String[] gustos = request.getParameterValues("pasa");
		if (gustos != null) {
			for (int i = 0; i < gustos.length; i++) {
				out.println("<li>" + gustos[i] + "</li>");
			}
		} else {
			out.println("Eres un soso!");
		}

		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");

	}

	private void responseJSON(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setContentType(mime);
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		Gson jSonGustos = new Gson();

		// rellenar el objeto con los gustos del usuario
		String[] gustos = request.getParameterValues("pasa");
		String responseJson = jSonGustos.toJson(gustos);

		// pintar salida
		out.println(responseJson);
		out.flush();

	}
}
