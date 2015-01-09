package ipt.fm.ipartek.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		request.setCharacterEncoding("UTF-8");

		// recoger parámetros
		final String first = request.getParameter("first");
		final String last = request.getParameter("last");

		// buscar el linkedin
		final LinkedInParse parse = new LinkedInParse(first, last);
		final String htmlResult = parse.getHtml();

		// pasar atributo resultado
		request.setAttribute("resulthtml", htmlResult);

		// forwad a jsp de búsqueda
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
