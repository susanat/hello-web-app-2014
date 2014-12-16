package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Role;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Servlet implementation class RoleServlet
 */
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher = null;
	private int id = Role.ID_NULL;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		super.destroy();
	}

	/**
	 *
	 */

	@Override
	protected void service(final HttpServletRequest request, final HttpServletResponse resp) throws ServletException,
			IOException {

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (final Exception e) {
			// TODO log de la traza
			id = Role.ID_NULL;
		}
		// TODO comprobar autorizacion del usuario

		super.service(request, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {

		Mensaje msg = null;

		try {
			// recoger parametros
			if (id == Role.ID_NULL) {
				// quiere todos
				final List<Role> roles = InitListener.modeloRole.getAll();
				request.setAttribute(Constantes.ATT_ROLES, roles);
				dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);
			} else {
				// quiere uno
				final Role r = InitListener.modeloRole.getByID(id);
				request.setAttribute(Constantes.ATT_ROLE, r);
				request.setAttribute("accion", request.getAttribute("accion"));
				dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_FORM);
			}

		} catch (final Exception ex) {
			msg = new Mensaje(ex.getMessage(), Constantes.ALERT_TYPE_DANGER);
			request.setAttribute(Constantes.ATT_MENSAJE, msg);
		}

		// forward a la vista correspondiente
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msg = null;

		try {

			if (request.getParameter(Constantes.OP_CRUD).equals(Constantes.OP_DELETE)) {
				// queremos borrar
				delete(request);
			} else if (request.getParameter(Constantes.OP_CRUD).equals(Constantes.OP_UPDATE)) {
				// queremos actualizar
				update(request);
			} else if (request.getParameter(Constantes.OP_CRUD).equals(Constantes.OP_INSERT)) {
				// queremos crear
				create(request);

			} else {
				// operacion no valida
				opNotSupported(request);
			}
		} catch (final Exception ex) {
			msg = new Mensaje(ex.getMessage(), Constantes.ALERT_TYPE_DANGER);
			request.setAttribute(Constantes.ATT_MENSAJE, msg);
		}

		// forward a la vista (formulario)
		dispatcher.forward(request, response);
	}

	private void create(final HttpServletRequest request) throws Exception {
		// recoger parametros, validarlos y crear persona
		Mensaje msg = null;
		final Role r = getParametros(request);
		if (r != null) {
			// insertarlo
			// TODO: Comprobar si se ha insertado correctamente
			InitListener.modeloRole.insert(r);
			msg = new Mensaje(Constantes.MSG_REG_CREATED, Constantes.ALERT_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERROR_PARAMETERS, Constantes.ALERT_TYPE_DANGER);
		}

		// enviar atributos
		final List<Role> roles = InitListener.modeloRole.getAll();

		request.setAttribute("accion", Constantes.LETRERO_DETALLE);
		request.setAttribute(Constantes.ATT_MENSAJE, msg);
		request.setAttribute(Constantes.ATT_ROLE, r);
		request.setAttribute(Constantes.ATT_ROLES, roles);

		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);

	}

	private Role getParametros(final HttpServletRequest request) {
		Role r = null;

		try {
			r = new Role("");
			r.setNombre(request.getParameter("name"));
			r.setDescripcion(request.getParameter("descripcion"));

		} catch (final Exception e) {
			r = null;

			e.printStackTrace();
		}
		return r;
	}

	private void update(final HttpServletRequest request) throws Exception {
		Mensaje msg = null;
		final Role r = getParametros(request);
		if (r != null) {
			r.setId(id);
			InitListener.modeloRole.update(r);
			msg = new Mensaje(Constantes.MSG_REG_UPDATED, Constantes.ALERT_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_NOT_UPDATED, Constantes.ALERT_TYPE_DANGER);
		}
		final List<Role> roles = InitListener.modeloRole.getAll();
		request.setAttribute(Constantes.ATT_MENSAJE, msg);
		request.setAttribute(Constantes.ATT_ROLE, r);
		request.setAttribute(Constantes.ATT_ROLES, roles);

		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);
	}

	private void delete(final HttpServletRequest request) throws Exception {
		id = Integer.parseInt(request.getParameter("id"));
		Mensaje mes = null;
		if (InitListener.modeloRole.delete(id)) {
			// borrado correcto
			mes = new Mensaje(Constantes.MSG_REG_DELETED, Constantes.ALERT_TYPE_SUCCESS);
		} else {
			// borrado no realizado
			mes = new Mensaje(Constantes.MSG_REG_NOT_DELETED, Constantes.ALERT_TYPE_DANGER);
		}
		final List<Role> roles = InitListener.modeloRole.getAll();
		request.setAttribute(Constantes.ATT_ROLES, roles);
		request.setAttribute(Constantes.ATT_MENSAJE, mes);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);

	}

	private void opNotSupported(final HttpServletRequest request) {
		// quiere todos
		// TODO: Meter todo hasta el request.setAttribute en una funcion
		final List<Role> roles = InitListener.modeloRole.getAll();
		request.setAttribute(Constantes.ATT_ROLES, roles);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);

		final Mensaje msg = new Mensaje(Constantes.ALERT_TYPE_DANGER, Constantes.MSG_UNAUTHORIZED);
		request.setAttribute(Constantes.ATT_MENSAJE, msg);

	}

}
