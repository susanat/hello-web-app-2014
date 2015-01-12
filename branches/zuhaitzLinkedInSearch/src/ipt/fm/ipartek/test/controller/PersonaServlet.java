package ipt.fm.ipartek.test.controller;

import ipt.fm.ipartek.test.bean.Persona;
import ipt.fm.ipartek.test.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.modelo.dao.IPersonaDAO;
import ipt.fm.ipartek.test.util.Constantes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {

	IPersonaDAO daoPersona = null;

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		final DAOFactory factory = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
		daoPersona = factory.getIPersonaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		// TODO repasar esto, ahora el id va siempre con los forms si la persona
		// lo tiene
		if (request.getParameter("idList") != null) {
			final Persona p = daoPersona.getById(Integer.parseInt(request.getParameter("idList")));
			request.setAttribute(Constantes.ATT_PERSONA, p);
			request.getRequestDispatcher(Constantes.JSP_FORM_PERSONA).forward(request, response);
		} else {
			request.setAttribute(Constantes.ATT_PERSONAS, daoPersona.getAll());
			request.getRequestDispatcher(Constantes.JSP_LIST_PERSONA).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		switch (Integer.parseInt(request.getParameter(Constantes.CRUD_OP))) {

		case Constantes.CRUD_INSERT:
			final int idPersonaInsertada = daoPersona.insert(getParameters(request));
			break;

		case Constantes.CRUD_UPDATE:
			final Persona p = daoPersona.update(getParameters(request));
			break;

		case Constantes.CRUD_DELETE:
			if (daoPersona.delete(getParameters(request))) {
				request.setAttribute(Constantes.ATT_PERSONA, null);
				doGet(request, response);
			}
			break;
		}

		doGet(request, response);
	}

	private Persona getParameters(final HttpServletRequest request) {
		final Persona persona = new Persona(Integer.parseInt(request.getParameter(IPersonaDAO.COL_ID)),
				request.getParameter(IPersonaDAO.COL_NOMBRE), request.getParameter(IPersonaDAO.COL_APELLIDOS),
				request.getParameter(IPersonaDAO.COL_FOTO));
		return persona;
	}

}
