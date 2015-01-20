package com.ipartek.formacion.inscripciones.consulta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;
import com.ipartek.formacion.inscripciones.consulta.bean.Matricula;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ServicioRestConsulta
 */
public class ServicioRestConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sAno = null;
	boolean error = true;
	String sError = "Fallo del servidor";
	PrintWriter out = null;

	private static final String DATA_SOURCE = "java:comp/env/jdbc/ipartekMoodle";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		try {
			out = response.getWriter();
			// recoger parametro
			getParmeters(request);

			ArrayList<Matricula> matriculas = null;
			// consultar insercciones por año
			try {
				matriculas = consultaBaseDatos();
			} catch (Exception e) {
				e.printStackTrace();
				sError = e.getMessage();
				error = true;
			}

			Gson gson = new Gson();
			String jsonMatriculas = gson.toJson(matriculas, ArrayList.class);

			if (error) {
				out.print("{\"response\":500, \"msg\": \"" + sError + "\"}");
			} else {
				out.print("{\"response\":200, \"matriculas\":" + jsonMatriculas
						+ "}");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"response\":500, \"msg\": \"" + sError + " \"}");

		} finally {
			out.flush();
		}

	}

	private ArrayList<Matricula> consultaBaseDatos() throws Exception {
		ArrayList<Matricula> lista = new ArrayList<Matricula>();
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
		Connection con = (Connection) ds.getConnection();

		PreparedStatement pst = (PreparedStatement) con
				.prepareStatement("SELECT * FROM `user` WHERE FROM_UNIXTIME( `firstaccess`, '%Y' ) = ?");
		pst.setInt(1, Integer.valueOf(sAno));
		ResultSet rs = pst.executeQuery();
		Matricula matricula = null;
		while (rs.next()) {
			matricula = new Matricula();

			matricula.setId(rs.getInt("id"));
			matricula.setNombre(rs.getString("firstname"));
			matricula.setApellido(rs.getString("lastname"));
			matricula.setfInscripcion(rs.getLong("firstaccess"));
			matricula.setfUltimoAcceso(rs.getLong("lastaccess"));
			matricula.setfUltimoLogin(rs.getLong("lastlogin"));

			lista.add(matricula);
			matricula = null;
		}
		return lista;

	}

	private void getParmeters(HttpServletRequest request) {
		sAno = request.getParameter("ano");
		// validar parametro
		if (sAno != null) {
			if (sAno.trim().length() == 4) {
				error = false;
			} else {
				sError = "[" + sAno + "] parametro ilegal";
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
