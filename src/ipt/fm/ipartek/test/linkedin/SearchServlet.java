package ipt.fm.ipartek.test.linkedin;

import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IPersonaDAO daoPersona = null;   

	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//TODO mirar tema de acentos y Ñ desde HTML en los JSPs
		request.setCharacterEncoding("UTF-8");
		
		//recoger parametros
		String first  = request.getParameter("first");
		String last  = request.getParameter("last");
		
		
		
		//conectar BBDD
		request.setAttribute("personas",  daoPersona.getAll() );
		
		
		//buscar el linkedin
		LinkedInParse parse = new LinkedInParse(first, last);
		String htmlResult = parse.getHtml ();
		
		//pasar attributo resultado
		request.setAttribute("resulthtml", htmlResult );
		
		//forwad a jsp de busqueda
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
