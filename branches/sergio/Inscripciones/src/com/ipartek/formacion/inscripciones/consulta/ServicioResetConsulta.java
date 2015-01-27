package com.ipartek.formacion.inscripciones.consulta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServicioResetConsulta
 */
public class ServicioResetConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String sAno = null;
		String sMes = null;
		
		
		String jSonRespuesta = "";

		try {

			// obtengo el argumento
			sAno = request.getParameter("ano");
			sMes = request.getParameter("mes");

			if (sAno == null) {
				jSonRespuesta = "{\"response\":\"200\", \"msg\":\"Sin argumento\"}";
			} else {
				if (sAno.trim().length() != 4) {
					jSonRespuesta = "{\"response\":\"0\", \"msg\":\"Argumento incorrecto\"}";
				} else {

					String jsonlist =  getJsonList(sAno, sMes );
					String jsonlistByMonth =  getJsonListByMonth(sAno);
					
					
					if(jsonlist == null || "null".equalsIgnoreCase(jsonlist)) {
						jSonRespuesta = "{\"response\":\"201\", \"msg\":\" No se han encontrado registros.\"}";
					} else {						
						jSonRespuesta = "{\"response\":\"0\",\"data\":" + jsonlist + ",\"group\":" + jsonlistByMonth + "}";						
					}					
					
					//jSonRespuesta = "{\"data\":" + getJsonList(sAno) + "}";

				}
			}

		} catch (Exception e) {
			jSonRespuesta = "{\"response\": \"500\", \"msg\":\"" + e.getMessage() + "\"}";
		}

		out.print(jSonRespuesta);
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String getJsonList(String sAno, String sMes) throws Exception {

		String res = "";
		Gson obj = new Gson();

		conectar();
		
		List<Matricula> lst = null;
		
		if(sMes == null || "".equals(sMes.trim())) {
			lst = getAll(Integer.valueOf(sAno));
		} else {
			lst = getAll(Integer.valueOf(sAno), Integer.valueOf(sMes));
		}
		
		 
		
		
		
		desconectar();

		res = obj.toJson(lst);

		return res;

	}
	
	private String getJsonListByMonth(String sAno) throws Exception {

		String res = "";
		Gson obj = new Gson();

		conectar();
		List<Mes> lst = getAllByMonth(Integer.valueOf(sAno));
		desconectar();

		res = obj.toJson(lst);

		return res;

	}

	private static final String STR_LOOKUP = "java:comp/env/jdbc/MyConexion";

	private static Connection conexion = null;

	public Connection conectar() throws Exception {

		try {

			if (conexion == null) {

				InitialContext ctx = new InitialContext();
				// en el web.xml se configura el jdbc/MyConexion
				DataSource ds = (DataSource) ctx
						.lookup("java:comp/env/jdbc/MyConexion");
				conexion = ds.getConnection();

			}

		} catch (Exception ex) {
			throw ex;
		}

		if (conexion == null) {
			throw new Exception(
					"Error indeterminado. No se ha creado la conexión");
		}

		return conexion;

	}

	public void desconectar() throws SQLException {
		if (conexion != null) {
			if (!conexion.isClosed()) {
				conexion.close();
			}
			conexion = null;
		}
	}
	
	
	public LinkedList<Mes> getAllByMonth(int ano) throws Exception {
		
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;
		LinkedList<Mes> lst = null;

		try {

			// Establecemos la conexión con la base de datos.
			conexion = conectar();

			// Preparamos la consulta
			s = conexion.createStatement();

			/*
			 * rs = s.executeQuery ( "select * from user;" );
			 */

			StringBuilder select = new StringBuilder();
			
			
			select.append(" select ");
			select.append(" count(*) cont, "); 
			select.append(" FROM_UNIXTIME(firstaccess,'%m') as mes "); 
			select.append(" from user ");
			select.append(" where FROM_UNIXTIME(firstaccess,'%Y') = "+ ano);
			select.append(" group by mes order by mes");
			
			rs = s.executeQuery(select.toString());

			int i = 0;
			System.out.println("Lanzando select: " + select.toString());
			
			// Recorremos el resultado, mientras haya registros para leer, y
			// escribimos el resultado en pantalla.
			while (rs.next()) {
				i++;
				
				// TODO: modificar cuando sepamos si queremos devolver listado
				// vacío o null si no hay datos
				if (lst == null) {
					lst = new LinkedList<Mes>();
				}

				lst.add(rsToMes(rs));
				
			}
			
			System.out.println("Total registros: " + i);
		} catch (Exception e) {
			throw e;
		} finally {

			if (rs != null) {
				rs = null;
			}

			if (s != null) {
				s = null;
			}

			desconectar();

		}

		return lst;

		
		
		
		
		
	}
	
	public List<Matricula> getAll(int ano) throws Exception {
		return getAll(ano, 0);
	}
	

	public List<Matricula> getAll(int ano, int mes) throws Exception {

		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;
		List<Matricula> lst = null;

		try {

			// Establecemos la conexión con la base de datos.
			conexion = conectar();

			// Preparamos la consulta
			s = conexion.createStatement();

			/*
			 * rs = s.executeQuery ( "select * from user;" );
			 */

			StringBuilder select = new StringBuilder();
			select.append(" select ");
			select.append(" id, ");
			select.append(" firstaccess, ");
			select.append(" firstname, ");
			select.append(" lastname, ");
			select.append(" email, ");
			select.append(" lastaccess, ");
			select.append(" lastlogin, ");
			select.append(" FROM_UNIXTIME(firstaccess,'%m') as mes ");			
			select.append(" from ");
			select.append(" user ");
			select.append(" where ");
			select.append(" FROM_UNIXTIME(firstaccess,'%Y') = ");
			select.append(ano);
			
			if(mes != 0) {
				select.append(" and FROM_UNIXTIME(firstaccess,'%m') = ");
				select.append(mes);
			}
			
			
			
			select.append(" order by firstaccess; ");
					
			rs = s.executeQuery(select.toString());

			int i = 0;
			System.out.println("Lanzando select: " + select.toString());
			
			// Recorremos el resultado, mientras haya registros para leer, y
			// escribimos el resultado en pantalla.
			while (rs.next()) {
				i++;
				
				// TODO: modificar cuando sepamos si queremos devolver listado
				// vacío o null si no hay datos
				if (lst == null) {
					lst = new ArrayList<Matricula>();
				}

				lst.add(rsToUsuario(rs));
				
			}
			
			System.out.println("Total registros: " + i);
		} catch (Exception e) {
			throw e;
		} finally {

			if (rs != null) {
				rs = null;
			}

			if (s != null) {
				s = null;
			}

			desconectar();

		}

		return lst;

	}

	private Matricula rsToUsuario(final ResultSet rs) throws SQLException {

		return new Matricula(rs.getInt("id"), rs.getLong("firstaccess"),
				rs.getString("firstname"), rs.getString("lastname"),
				rs.getString("email"), rs.getLong("lastaccess"),
				rs.getLong("lastlogin"));

	}
	
	private Mes rsToMes(final ResultSet rs) throws SQLException {
		return new Mes(rs.getString("cont"), rs.getString("mes"));
	}

}
