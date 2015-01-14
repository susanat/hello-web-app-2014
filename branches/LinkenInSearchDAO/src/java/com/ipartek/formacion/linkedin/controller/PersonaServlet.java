package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			daoPersona = factoria.getPersonaDAO();
			ArrayList<Persona> pers = daoPersona.getAll();

			request.setAttribute("personas", pers);
			// forward a jsp de busqueda
			request.getRequestDispatcher("listadoPersonas.jsp").forward(
					request, response);
		} catch (ModelException e) {
			request.getRequestDispatcher("errorModelo.jsp").forward(request,
					response);

		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			String id = "";
			if (factoria == null) {
				factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				daoPersona = factoria.getPersonaDAO();
			}
			String op = request.getParameter("operacion");
			Persona p = null;

			if (op.equals(OP_INSERTAR)) {

				p = new Persona(CERO, request.getParameter("nombre"),
						request.getParameter("apellidos"),
						Persona.EDAD_DEFAULT, request.getParameter("foto"));
				int idnuevo = daoPersona.insert(p);
				if (idnuevo >= CERO) {
					System.out.println(idnuevo);
					System.out.println("bien insertada");
				} else {
					System.out.println("mal insertada");
				}

			} else if (op.equals(OP_ACTUALIZAR)) {
				String edad = request.getParameter("edad");
				id = request.getParameter("id");

				p = new Persona(Integer.parseInt(id),
						request.getParameter("nombre"),
						request.getParameter("apellidos"),
						Integer.parseInt(edad), request.getParameter("foto"));

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

			

			doGet(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
