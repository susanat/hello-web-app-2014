package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Idioma;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.util.EIdioma;
import com.ipartek.formacion.helloweb.util.MensajesIdiomas;

/**
 * Servlet implementation class IdiomaServlet
 */
public class IdiomaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	HttpSession session = null;
	ResourceBundle messages = null;

	Mensaje msg = null;
	String pIdioma = EIdioma.INGLES.getLocale();
	int id = Idioma.ID_NULL;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void service(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		pIdioma = I18n.getBrowserLocale(request.getLocale());

		// Recoger parámetro identificador Idioma
		try {
			id = Integer.parseInt(request.getParameter(Constantes.FORM_IDIOMA_ID));
		} catch (final Exception e) {
			id = Idioma.ID_NULL;
		}

		super.service(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		session = request.getSession();
		messages = MensajesIdiomas.loadMessages(pIdioma, session);

		if (id == Idioma.ID_NULL) {
			getAll(request);
		} else {
			getById(request);
		}

		dispatcher.forward(request, response);
	}

	private void getById(final HttpServletRequest request) {

		final Idioma i = InitListener.modeloIdioma.getById(id);
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_IDIOMA, i);
		// forward a la vista del formulario
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_FORM);
	}

	private void getAll(final HttpServletRequest request) {

		final ArrayList<Idioma> idiomas = InitListener.modeloIdioma.getAll();
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_IDIOMAS, idiomas);
		// forward a la vista
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_LIST);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		switch (Integer.parseInt(request.getParameter(Constantes.OP_CRUD))) {

		case Constantes.OP_INSERT:
			insert(request);
			break;

		case Constantes.OP_UPDATE:
			update(request);
			break;

		case Constantes.OP_DELETE:
			delete(request);
			break;

		default:
			opNotSupported(request);
		}

		request.setAttribute(Constantes.MSG_KEY, msg);

		dispatcher.forward(request, response);
	}

	/**
	 * Actulizar los datos de una Idioma, foward a form.jsp
	 *
	 * @param request
	 */
	private void update(final HttpServletRequest request) {

		final Idioma i = getParametrosIdioma(request);
		if (i != null) {
			i.setId(id);
			InitListener.modeloIdioma.update(i);
			msg = new Mensaje(Constantes.MSG_REG_UPDATED, Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERROR_PARAMETERS, Mensaje.MSG_TYPE_DANGER);
		}

		request.setAttribute(Constantes.ATTR_PERSONA, i);

		// forward vista
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_FORM);

	}

	/**
	 * Recoger los parametros de la request y crear <code>Idioma</code>. Tambien
	 * gestiona los mensajes para el usuario
	 *
	 * @param request
	 * @return <code>Idioma</code> inicializada con los parametros de la
	 *         request, en caso de fallo null
	 */
	private Idioma getParametrosIdioma(final HttpServletRequest request) {
		Idioma i = null;
		try {
			i = new Idioma("");
			request.setCharacterEncoding("UTF-8");
			i.setId(Integer.parseInt(request.getParameter(Constantes.FORM_IDIOMA_ID)));
			i.setLenguaje(request.getParameter(Constantes.FORM_IDIOMA_LENGUAJE));
			i.setPais(request.getParameter(Constantes.FORM_IDIOMA_PAIS));
			i.setTexto(request.getParameter(Constantes.FORM_IDIOMA_TEXTO));
			i.setLocale(request.getParameter(Constantes.FORM_IDIOMA_LOCALE));
		} catch (final Exception e) {
			i = null;
			e.printStackTrace();
		}

		return i;
	}

	/**
	 * Elimina el Idioma por su ID y nos retorna a list.jsp
	 *
	 * @param request
	 */
	private void delete(final HttpServletRequest request) {

		// if (model.delete(id) ){
		if (InitListener.modeloIdioma.delete(id)) {
			msg = new Mensaje(Constantes.MSG_REG_DELETED, Mensaje.MSG_TYPE_WARNING);
		} else {
			msg = new Mensaje(Constantes.MSG_ERR_REG_DELETED, Mensaje.MSG_TYPE_DANGER);
		}
		getAll(request);

	}

	/**
	 * Si no existe la Operacion a realizar mensaje y forward al list.jsp
	 *
	 * @param request
	 */
	private void opNotSupported(final HttpServletRequest request) {
		getAll(request);
		msg = new Mensaje(Constantes.MSG_NOT_ALLOWED, Mensaje.MSG_TYPE_DANGER);
	}

	/**
	 * Crear un nuevo Idioma e insertarlo en la BBDD
	 *
	 * @param request
	 */
	private void insert(final HttpServletRequest request) {
		// recoger parametros y validar
		final Idioma i = getParametrosIdioma(request);

		if (i != null) {
			// insertarlo
			// TODO comprobar la inserccion
			// model.insert(p);
			InitListener.modeloIdioma.insert(i);
			// enviar atributos
			msg = new Mensaje(Constantes.MSG_REG_CREATED, Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERROR_PARAMETERS, Mensaje.MSG_TYPE_DANGER);
		}

		request.setAttribute(Constantes.ATT_IDIOMA, i);

		// forward vista
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_FORM);

	}
}
