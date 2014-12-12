package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Role;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Servlet implementation class RoleServlet
 */
public class RoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RequestDispatcher dispatcher = null;
    String msg = "";
    int id = Role.ID_NULL;

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

	// recoger parametros
	if (id == Role.ID_NULL) {
	    // quiere todos
	    ArrayList<Role> roles = InitListener.modelRole.getAll();
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

	request.setAttribute(Constantes.MSG_KEY, msg);
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

	// forward a la vista (formulario)

	dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request) {
	// recoger parametros, validarlos y crear persona
	Message mes = new Message();
	Role r = getParametros(request);
	if (r != null) {
	    // insertarlo
	    // TODO: Comprobar si se ha insertado correctamente
	    InitListener.modelRole.insert(r);
	    mes.setMsg(Constantes.MSG_REG_CREATED);
	    mes.setType(Constantes.ALERT_TYPE_SUCCESS);

	} else {
	    msg = Constantes.MSG_ERROR_PARAMETERS;
	    mes.setMsg(Constantes.MSG_ERROR_PARAMETERS);
	    mes.setType(Constantes.ALERT_TYPE_DANGER);
	}

	// enviar atributos
	ArrayList<Role> roles = InitListener.modelRole.getAll();
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

    private void update(HttpServletRequest request) {
	Message mes = new Message();
	Role r = getParametros(request);
	if (r != null) {
	    r.setId(id);
	    InitListener.modelRole.update(r);
	    msg = Constantes.MSG_REG_UPDATED;
	    mes.setMsg(Constantes.MSG_REG_UPDATED);
	    mes.setType(Constantes.ALERT_TYPE_SUCCESS);

	} else {
	    msg = Constantes.MSG_ERROR_PARAMETERS;
	    mes.setMsg(Constantes.MSG_NOT_UPDATED);
	    mes.setType(Constantes.ALERT_TYPE_DANGER);
	}
	ArrayList<Role> roles = InitListener.modelRole.getAll();
	request.setAttribute(Constantes.ATT_ROLES, roles);
	request.setAttribute(Constantes.ATT_ROLE, r);
	request.setAttribute(Constantes.ATT_MENSAJE, mes);
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);
    }

    private void delete(HttpServletRequest request) {
	id = Integer.parseInt(request.getParameter("id"));
	Message mes = new Message();
	if (InitListener.modelRole.delete(id)) {
	    // borrado correcto
	    msg = Constantes.MSG_REG_DELETED;
	    mes.setMsg(Constantes.MSG_REG_DELETED);
	    mes.setType(Constantes.ALERT_TYPE_SUCCESS);

	} else {
	    // borrado no realizado
	    msg = Constantes.MSG_REG_NOT_DELETED;
	    mes.setMsg(Constantes.MSG_REG_NOT_DELETED);
	    mes.setType(Constantes.ALERT_TYPE_DANGER);
	}
	ArrayList<Role> roles = InitListener.modelRole.getAll();
	request.setAttribute(Constantes.ATT_ROLES, roles);
	request.setAttribute(Constantes.ATT_MENSAJE, mes);
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);

    }

    private void opNotSupported(HttpServletRequest request) {
	// quiere todos
	// TODO: Meter todo hasta el request.setAttribute en una funcion
	ArrayList<Role> roles = InitListener.modelRole.getAll();
	request.setAttribute(Constantes.ATT_ROLES, roles);
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_ROLE_LIST);
	msg = Constantes.MSG_UNAUTHORIZED;

    }

}
