package com.ipartek.formacion.busredsociales.dao.factoria.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.busredsociales.bean.Usuario;
import com.ipartek.formacion.busredsociales.comun.Globales;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

/**
 * Modelo de datos para la tabla Usuario creada en BD MySql.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public class MySqlUsuarioDAO implements IUsuarioDAO {

	//conexión a la base de datos
	private Connection conn = null;
	
	private final static int ID = 1;
	private final static int USERNAME = 2;
	private final static int APELLIDOS = 3;	
	private final static int PHOTO = 4;
	

	
	public List<Usuario> getAll() throws DAOException, Exception{
		
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;
		List<Usuario> lstUsuario = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.conectar();
		   
		   //Preparamos la consulta
		   s = conexion.createStatement();
		   rs = s.executeQuery ("select id, username, apellidos, photo from user");
		   
		   //Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
		   while (rs.next())
		   {
			   //TODO: modificar cuando sepamos si queremos devolver listado vacío o null si no hay datos
			   if(lstUsuario == null) {
				   lstUsuario = new ArrayList<Usuario>();
			   }
			   
			   lstUsuario.add(
					   	new Usuario(
					   			rs.getInt(ID), 
					   			rs.getString(USERNAME),
					   			rs.getString(APELLIDOS), 
					   			rs.getString(PHOTO)
					   				)
					   		);			   	
		   }		   
		} catch (Exception e) {
			throw e;
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (s!=null) {
				s = null;
			}
			
			
			MysqlDAOFactory.desconectar();
			
		}
		
		return lstUsuario;
				
	}

	public Usuario getById(Usuario obj) throws DAOException, Exception {
		
		
		
		return getById(obj.getId());		
		
	}

	public Usuario getById(int id) throws DAOException, Exception {
		
		
		return new Usuario("Ana Rosa","Rubio");				
		
	}

	public Usuario insert(Usuario obj) throws DAOException, Exception {
		Connection conexion = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.conectar();
		   
		   //INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`) VALUES (NULL, 'Antonio', 'Segundo Puesto', '', NULL, '1', NULL);					
			
		   //insertar persona nueva
		   //s = conexion.createStatement();
		   //String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES ( '"+first+"', '"+last+"', 34);";
		   //String sqlInsert = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`) VALUES (NULL, '" + nombre + "', '" + apellidos + "', '', NULL, '1', NULL);";
		   
		   //sentencia sql para el prepare statement
		   String sqlInsert = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES (NULL, ?, ?, '', NULL, '1', NULL, ?);";
		   		   
		   s = conexion.prepareStatement(sqlInsert);
		   
		   
		   //añadimos los campos
		   s.setString(1, obj.getUsername());
		   s.setString(2, obj.getApellidos());
		   s.setString(3, obj.getPhoto());
		   
		   s.executeUpdate();
		   		
		   
		} catch (Exception e) {
			throw e;
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (s!=null) {
				s = null;
			}
			
			
			MysqlDAOFactory.desconectar();
			
		}
		return null;
	}

	public Usuario update(Usuario obj) throws DAOException, Exception {
		
		return null;
	}

	public boolean delete(Usuario obj) throws DAOException, Exception {

		return delete(obj.getId());
	}

	public boolean delete(int id) throws DAOException, Exception {
		
		Connection conexion = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.conectar();
				   
		   //sentencia sql para el prepare statement
		   String sqlInsert = "delete from `srncodesnippet`.`user` where `id` = ?;";
		   		   
		   s = conexion.prepareStatement(sqlInsert);
		   		   
		   //añadimos los campos
		   s.setInt(1, Integer.valueOf(id));		   
		   
		   s.executeUpdate();
		   
		   
		} catch (Exception e) {			
			throw e;		   
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (s!=null) {
				s = null;
			}
			
			
			MysqlDAOFactory.desconectar();
			
		}		   
		
		
		return false;
	}

}
