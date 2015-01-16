package com.ipartek.formacion.linkedin.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.linkedin.FactoriaMySql;
import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;
import com.ipartek.formacion.linkedin.modelo.dao.ModelException;
import com.ipartek.formacion.linkedin.modelo.dao.MySqlDAOFactory;

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
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {
			factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
			daoPersona = factoria.getPersonaDAO();
			ArrayList<Persona> pers = daoPersona.getAll();

			request.setAttribute("personas", pers);

			// forwad a jsp de resultados
			request.getRequestDispatcher("ListadoPersonas.jsp").forward(
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
				factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
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

			// conectar BBDD

			doGet(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String listar() {

		String personas = "";

		Statement st = null;
		ResultSet rs = null;

		try {

			// consultar tabla personas
			st = MySqlDAOFactory.getInstance().conectar().createStatement();
			// 5.- Recoger resultados
			rs = st.executeQuery("select * from persona");

			while (rs.next()) {

				personas += rs.getString("nombre");
				personas += rs.getString("apellido1");
				personas += rs.getInt("edad");
				personas += "<br>";
			}

			/*
			 * } catch (ClassNotFoundException e) { e.printStackTrace();
			 */
		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			FactoriaMySql.desconectar();
		}

		return personas;
	}

	private String crear() {

		String personas = "";

		PreparedStatement st2 = null;

		try {

			// 3.- Crear Stament a traves de la conexion
			// insertar persona nueva
			String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES (?,?,?);";
			st2 = FactoriaMySql.conectar().prepareStatement(sqlInsert);

			// sustituir ? por valoresen la sentencia sql del prepareStatement
			st2.setString(1, "ddd");
			st2.setString(2, "ddd");
			st2.setInt(3, 45);

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			FactoriaMySql.desconectar();
		}

		return personas;
	}

	private String modificar() {

		String personas = "";

		PreparedStatement st2 = null;

		try {

			// 3.- Crear Stament a traves de la conexion
			// modificar persona
			String sqlInsert = "update persona set nombre='alberto', apellido1='perez', edad='23'where nombre='ddd'";

			st2 = FactoriaMySql.conectar().prepareStatement(sqlInsert);

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			FactoriaMySql.desconectar();
		}

		return personas;
	}

	private String borrar() {

		String personas = "";

		PreparedStatement st2 = null;

		try {

			// 3.- Crear Stament a traves de la conexion
			// borrar persona
			String sqlInsert = "DELETE from persona	where nombre='ddd'";

			st2 = FactoriaMySql.conectar().prepareStatement(sqlInsert);

			// 4.- Ejecutar la sentencia
			st2.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			FactoriaMySql.desconectar();
		}

		return personas;
	}

}
