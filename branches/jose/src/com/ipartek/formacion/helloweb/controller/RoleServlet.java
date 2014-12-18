package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
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
	protected void service(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Mensaje mes = new Mensaje();
		
		try {
			// recoger parametros
			if (id == Role.ID_NULL) {
				// quiere todos
				List<Role> roles = InitListener.modelRole.getAll();
				request.setAttribute(Constantes.ATT_ROLES, roles);
				dispatcher = request
						.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);
			} else {
				// quiere uno
				Role r = InitListener.modelRole.getByID(id);
				request.setAttribute(Constantes.ATT_ROLE, r);
				request.setAttribute("accion", request.getAttribute("accion"));
				dispatcher = request
						.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_FORM);
			}
			
			
			
			
		} catch (Exception ex) {			
			mes.setMsg(ex.getMessage());
			mes.setType(Constantes.ALERT_TYPE_DANGER);
			request.setAttribute(Constantes.ATT_MENSAJE, mes);
		}
		

		
		
		// forward a la vista correspondiente
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Mensaje mes = new Mensaje();
		
		try {
		
			if (request.getParameter(Constantes.OP_KEY)
					.equals(Constantes.OP_DELETE)) {
				// queremos borrar
				delete(request);
			} else if (request.getParameter(Constantes.OP_KEY).equals(
					Constantes.OP_UPDATE)) {
				// queremos actualizar
				update(request);
			} else if (request.getParameter(Constantes.OP_KEY).equals(
					Constantes.OP_CREATE)) {
				// queremos crear
				create(request);
	
			} else {
				// operacion no valida
				opNotSupported(request);
			}
		} catch (Exception ex) {
			mes.setMsg(ex.getMessage());
			mes.setType(Constantes.ALERT_TYPE_DANGER);
			request.setAttribute(Constantes.ATT_MENSAJE, mes);
		}

		
		
		// forward a la vista (formulario)
		dispatcher.forward(request, response);
	}

	private void create(HttpServletRequest request) throws Exception {
		// recoger parametros, validarlos y crear persona
		Mensaje mes = new Mensaje();
		Role r = getParametros(request);
		if (r != null) {
			// insertarlo
			// TODO: Comprobar si se ha insertado correctamente
			InitListener.modelRole.insert(r);
			mes.setMsg(Constantes.MSG_REG_CREATED);
			mes.setType(Constantes.ALERT_TYPE_SUCCESS);

		} else {
			
			mes.setMsg(Constantes.MSG_ERROR_PARAMETERS);
			mes.setType(Constantes.ALERT_TYPE_DANGER);
		}

		// enviar atributos
		List<Role> roles = InitListener.modelRole.getAll();
		
		request.setAttribute("accion", Constantes.LETRERO_DETALLE);
		request.setAttribute(Constantes.ATT_MENSAJE, mes);
		request.setAttribute(Constantes.ATT_ROLE, r);
		request.setAttribute(Constantes.ATT_ROLES, roles);
		
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);

	}

	private Role getParametros(HttpServletRequest request) {
		Role r = null;

		try {
			r = new Role("");
			r.setNombre(request.getParameter("name"));
			r.setDescripcion(request.getParameter("descripcion"));

		} catch (Exception e) {
			r = null;

			e.printStackTrace();
		}
		return r;
	}

	private void update(HttpServletRequest request) throws Exception {
		Mensaje mes = new Mensaje();
		Role r = getParametros(request);
		if (r != null) {
			r.setId(id);
			InitListener.modelRole.update(r);
			
			mes.setMsg(Constantes.MSG_REG_UPDATED);
			mes.setType(Constantes.ALERT_TYPE_SUCCESS);

		} else {
			
			mes.setMsg(Constantes.MSG_NOT_UPDATED);
			mes.setType(Constantes.ALERT_TYPE_DANGER);
		}
		List<Role> roles = InitListener.modelRole.getAll();
		request.setAttribute(Constantes.ATT_MENSAJE, mes);	
		request.setAttribute(Constantes.ATT_ROLE, r);
		request.setAttribute(Constantes.ATT_ROLES, roles);

		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);
	}

	private void delete(HttpServletRequest request) throws Exception {
		id = Integer.parseInt(request.getParameter("id"));
		Mensaje mes = new Mensaje();
		if (InitListener.modelRole.delete(id)) {
			// borrado correcto
			
			mes.setMsg(Constantes.MSG_REG_DELETED);
			mes.setType(Constantes.ALERT_TYPE_SUCCESS);

		} else {
			// borrado no realizado
			
			mes.setMsg(Constantes.MSG_REG_NOT_DELETED);
			mes.setType(Constantes.ALERT_TYPE_DANGER);
		}
		List<Role> roles = InitListener.modelRole.getAll();
		request.setAttribute(Constantes.ATT_ROLES, roles);
		request.setAttribute(Constantes.ATT_MENSAJE, mes);
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);

	}

	private void opNotSupported(HttpServletRequest request) {
		// quiere todos
		// TODO: Meter todo hasta el request.setAttribute en una funcion
		List<Role> roles = InitListener.modelRole.getAll();
		request.setAttribute(Constantes.ATT_ROLES, roles);
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);
		
		Mensaje mes = new Mensaje();		
		mes.setMsg(Constantes.MSG_UNAUTHORIZED);
		mes.setType(Constantes.ALERT_TYPE_DANGER);
		request.setAttribute(Constantes.ATT_MENSAJE, mes);

	}

}
