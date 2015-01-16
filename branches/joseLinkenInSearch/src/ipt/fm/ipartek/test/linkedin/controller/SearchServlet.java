package ipt.fm.ipartek.test.linkedin.controller;

import ipt.fm.ipartek.test.linkedin.Constantes;
import ipt.fm.ipartek.test.linkedin.LinkedInParse;
import ipt.fm.ipartek.test.linkedin.bean.Persona;
import ipt.fm.ipartek.test.linkedin.bean.PersonaLinkedin;
import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPersonaDAO daoPersona = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}

	public IPersonaDAO personaDAO() {
		return daoPersona;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// TODO mirar tema de acentos y Ñ desde HTML en los JSPs
		request.setCharacterEncoding("UTF-8");

		// recoger parametros
		String first = request.getParameter("first");
		String last = request.getParameter("last");

		if (first != null && last != null) {
			// buscar el linkedin
			LinkedInParse parse = new LinkedInParse(first, last);
			ArrayList<PersonaLinkedin> personas = parse.getHtml();

			// modificamos el fichero de resultado

			// pasar attributo resultado
			request.setAttribute("resulthtml", personas);
			request.setAttribute("nomApes", first+" "+last);
		}

			// forwad a jsp de busqueda
			request.getRequestDispatcher(Constantes.CTE_INDEX).forward(request,
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
