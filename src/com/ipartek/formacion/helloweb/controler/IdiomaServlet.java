package com.ipartek.formacion.helloweb.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.bean.Languaje;

/**
 * Servlet implementation class ServletIdioma
 */
public class IdiomaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    RequestDispatcher dispatcher;
    String msg = "";
    int id;
    Languaje i = null;
    ArrayList<Languaje> idiomas = null;
    int action;

    /**
    *
    */
    @Override
    public void init(final ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
	id = Languaje.ID_NULL;
	// model = new ModeloPersona();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	// TODO Auto-generated method stub
    }

}
