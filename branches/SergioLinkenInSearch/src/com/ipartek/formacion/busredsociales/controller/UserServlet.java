package com.ipartek.formacion.busredsociales.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ipartek.formacion.busredsociales.bean.Usuario;
import com.ipartek.formacion.busredsociales.comun.Constantes;



/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = new ArrayList<Usuario>();
		
		//TODO: Importante para la codificación de los caracteres
		request.setCharacterEncoding("UTF-8");
		
		//posibles parametros
		//obtenemos los datos
		
		//-- necesarios para la insercción y actualización
		String nombre = null;
		String apellidos = null;
		String photo = null;
		
		//-- necesario para la eliminación y actualización
		String index = null;
			
		
		
		//insertamos el usuario		
		try {
			
			String action = request.getParameter("action");
			
			if(action != null) {
				if("A".equalsIgnoreCase(action.trim())) {
					
					nombre = request.getParameter("nombre");
					apellidos = request.getParameter("apellidos");
					photo = request.getParameter("photo");
					
					//insertamos el usuario
					insertarUsuario(nombre, apellidos, photo);
					
				} else if("E".equalsIgnoreCase(action.trim())) {
					
					index = request.getParameter("index");
					
					//insertamos el usuario
					eliminarUsuario(index);
					
				}
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		
		//obtenemos la lista
		try {
			lista = getUsusarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lista = null;
		}
		
		
		request.setAttribute(Constantes.ATTR_LISTADO, lista);
		
		//redirigimos
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("listadoUsuarios.jsp");	    
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private Connection conectar(){
		Connection conexion = null;
		
		try
		{
			
			/* CONEXIÓN DIRECTA CON LA BASE DE DATOS
		   Class.forName("com.mysql.jdbc.Driver");
		   //Establecemos la conexión con la base de datos.
		   conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/srncodesnippet","root", "");
		   */
			
			//CONEXIÓN USANDO DATASOURCE (xml en META-INF, e información en web.xml)
			//Para obtener la conexión usando un pool de conexiones con datasource de Tomcat
			InitialContext ctx = new InitialContext();			
			//en el web.xml se configura el jdbc/MyConexion
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyConexion");
			conexion = ds.getConnection();
		   
			if(conexion == null) {
				throw new Exception("No se ha creado la conexión");
			}
			
		   return conexion;
		   
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	private void desconectar(Connection conexion) throws SQLException {
		if(conexion != null) {
			if(! conexion.isClosed()) 
			{
				conexion.close();
			}
			
			conexion = null;
		}
		
		
	}
	
	
	private void insertarUsuario(String nombre, String apellidos, String photo) throws SQLException {
		
		
		Connection conexion = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = conectar();
		   
		   //INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`) VALUES (NULL, 'Antonio', 'Segundo Puesto', '', NULL, '1', NULL);					
			
		   //insertar persona nueva
		   //s = conexion.createStatement();
		   //String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES ( '"+first+"', '"+last+"', 34);";
		   //String sqlInsert = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`) VALUES (NULL, '" + nombre + "', '" + apellidos + "', '', NULL, '1', NULL);";
		   
		   //sentencia sql para el prepare statement
		   String sqlInsert = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES (NULL, ?, ?, '', NULL, '1', NULL, ?);";
		   		   
		   s = conexion.prepareStatement(sqlInsert);
		   
		   
		   //añadimos los campos
		   s.setString(1, nombre);
		   s.setString(2, apellidos);
		   s.setString(3, photo);
		   
		   s.executeUpdate();
		   		
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (s!=null) {
				s = null;
			}
			
			
			desconectar(conexion);
			
		}		   
	}
	
	private void eliminarUsuario (String index) throws SQLException {
		
		
		Connection conexion = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = conectar();
				   
		   //sentencia sql para el prepare statement
		   String sqlInsert = "delete from `srncodesnippet`.`user` where `id` = ?;";
		   		   
		   s = conexion.prepareStatement(sqlInsert);
		   		   
		   //añadimos los campos
		   s.setInt(1, Integer.valueOf(index));		   
		   
		   s.executeUpdate();
		   
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (s!=null) {
				s = null;
			}
			
			
			desconectar(conexion);
			
		}		   
	}
	
	
	
	private List<Usuario> getUsusarios() throws SQLException {
		
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;
		List<Usuario> lstUsuario = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = conectar();
		   
		// Preparamos la consulta
		   s = conexion.createStatement();
		   rs = s.executeQuery ("select * from user");
		   
		// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
		   while (rs.next())
		   {
			   
			   if(lstUsuario == null) {
				   lstUsuario = new ArrayList<Usuario>();
			   }
			   
			   lstUsuario.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(8)));		       
			   	
		   }
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (s!=null) {
				s = null;
			}
			
			
			desconectar(conexion);
			
		}
		
		return lstUsuario;
	}

}
