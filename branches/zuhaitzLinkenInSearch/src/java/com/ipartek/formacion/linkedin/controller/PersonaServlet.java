package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;
import com.ipartek.formacion.linkedin.modelo.dao.ModelException;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int CERO = 0;

	public static final String OP_INSERTAR = "1";
	public static final String OP_ACTUALIZAR = "2";
	public static final String OP_BORRAR = "3";

	DAOFactory factoria = null;
	IPersonaDAO daoPersona = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			daoPersona = factoria.getPersonaDAO();

			final ArrayList<Persona> pers = daoPersona.getAll();
			request.setAttribute("personas", pers);

			request.getRequestDispatcher("listadoPersonas.jsp").forward(request, response);
		} catch (final ModelException e) {
			request.getRequestDispatcher("errorModelo.jsp").forward(request, response);

		} catch (final Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			String id = "";
			final String op = request.getParameter("operacion");
			Persona p = null;

			if (factoria == null) {
				factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				daoPersona = factoria.getPersonaDAO();
			}

			if (op.equals(OP_INSERTAR)) {
				p = new Persona(CERO, request.getParameter("nombre"), request.getParameter("apellidos"),
						request.getParameter("foto"));
				final int idnuevo = daoPersona.insert(p);
				
				if (idnuevo >= CERO) {
					System.out.println(idnuevo);
					System.out.println("bien insertada");
				} else {
					System.out.println("mal insertada");
				}
			} else if (op.equals(OP_ACTUALIZAR)) {
				id = request.getParameter("id");
				p = new Persona(Integer.parseInt(id), request.getParameter("nombre"),
						request.getParameter("apellidos"), request.getParameter("foto"));

				if (daoPersona.update(p)) {
					System.out.println("bien actualizado");
				} else {
					System.out.println("mal actualizado");
				}
			} else if (op.equals(OP_BORRAR)) {
				id = request.getParameter("id");

				p = new Persona(Integer.parseInt(id));

				if (daoPersona.delete(p)) {
					System.out.println("bien borrado");
				} else {
					System.out.println("mal borrado");
				}
			}

			// Listar todas las personas
			doGet(request, response);

		} catch (final ModelException e) {
			request.getRequestDispatcher("errorModelo.jsp").forward(request, response);
		} catch (final Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
