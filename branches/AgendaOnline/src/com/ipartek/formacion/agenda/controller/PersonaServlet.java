package com.ipartek.formacion.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.agenda.Constantes;
import com.ipartek.formacion.agenda.bean.Persona;
import com.ipartek.formacion.agenda.modelo.dao.DAOFactory;
import com.ipartek.formacion.agenda.modelo.dao.IPersonaDAO;
import com.ipartek.formacion.agenda.modelo.dao.ModelException;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int CERO = 0;

	// public static final String OP_INSERTAR = "1";
	// public static final String OP_ACTUALIZAR = "2";
	// public static final String OP_BORRAR = "3";

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
			if (request.getParameter("id") == null) {
				ArrayList<Persona> pers = daoPersona.getAll();

				request.setAttribute(Constantes.ATT_PERSONAS, pers);
				// forward a jsp de busqueda
				request.getRequestDispatcher(Constantes.JSP_LISTADO).forward(
						request, response);

			} else {
				Persona p = new Persona();
				p.setIdcontacto(Integer.parseInt(request.getParameter("id")));
				Persona pers = daoPersona.getById(p);

				request.setAttribute(Constantes.ATT_PERSONAS, pers);
				// forward a jsp de busqueda
				request.getRequestDispatcher(Constantes.JSP_DETALLE).forward(
						request, response);
			}

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
			String idcontacto = "";
			if (factoria == null) {
				factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				daoPersona = factoria.getPersonaDAO();
			}
			String op = request.getParameter("acc");
			Persona p = null;

			if (op.equals(Constantes.OP_CREAR)) {

				p = new Persona(CERO, request.getParameter("nombre"),
						request.getParameter("apellidos"),
						Integer.parseInt(request.getParameter("telfmovil")),
						Integer.parseInt(request.getParameter("telffijo")),
						request.getParameter("domicilio"),
						request.getParameter("poblacion"),
						request.getParameter("provincia"),
						Integer.parseInt(request.getParameter("cp")),
						request.getParameter("anotaciones"));

				int idnuevo = daoPersona.insert(p);

				if (idnuevo >= CERO) {
					System.out.println(idnuevo);
					System.out.println("bien insertada");
				} else {
					System.out.println("mal insertada");
				}

				request.setAttribute(Constantes.ATT_PERSONA, p);

			} else if (op.equals(Constantes.OP_ACTUALIZAR)) {
				idcontacto = request.getParameter("idcontacto");

				p = requestToPersona(request);

				if (daoPersona.update(p)) {
					System.out.println("bien actualizado");
				} else {
					System.out.println("mal actualizado");
				}

				request.setAttribute(Constantes.ATT_PERSONA, p);

			} else if (op.equals(Constantes.OP_ELIMINAR)) {
				idcontacto = request.getParameter("idEliminar");

				String[] idEliminar = idcontacto.split(";");

				Persona pEliminar = new Persona();
				for (int i = 0; i < idEliminar.length; i++) {

					pEliminar.setIdcontacto(Integer.parseInt(idEliminar[i]));

					if (daoPersona.delete(pEliminar)) {
						System.out.println("bien borrado");
					} else {
						System.out.println("mal borrado");
					}
				}

				// Listar todas las personas
				// doGet(request, response);
				// request.getRequestDispatcher(Constantes.JSP_LISTADO).forward(
				// request, response);
			}
			doGet(request, response);
		} catch (ModelException e) {
			request.getRequestDispatcher("errorModelo.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}

	}

	/**
	 * Recoger los parametros de la request y crear <code>Persona</code>.
	 * Tambien gestiona los mensajes para el usuario
	 *
	 * @param request
	 * @return <code>Persona</code> inicializada con los parametros de la
	 *         request, en caso de fallo null
	 */
	Persona requestToPersona(HttpServletRequest request) {
		Persona p = new Persona();

		// TODO alternativa para el constructor de insertar nuevo o
		// eliminar/editar
		try {

			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			int telMovil = Integer.parseInt(request.getParameter("telfmovil"));
			int telFijo = Integer.parseInt(request.getParameter("telffijo"));
			String direccion = request.getParameter("direccion");
			String poblacion = request.getParameter("poblacion");
			String provincia = request.getParameter("provincia");
			int cp = Integer.parseInt(request.getParameter("cp"));

			p.setNombre(nombre);
			p.setApellidos(apellidos);
			p.setTelMovil(telMovil);
			p.setTelFijo(telFijo);
			p.setDireccion(direccion);
			p.setPoblacion(poblacion);
			p.setProvincia(provincia);
			p.setCp(cp);
		} catch (Exception e) {
			p = null;
			e.printStackTrace();
		}
		return p;
	}

}
