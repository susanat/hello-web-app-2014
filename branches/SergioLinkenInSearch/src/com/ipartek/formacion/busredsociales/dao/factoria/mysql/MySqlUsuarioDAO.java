package com.ipartek.formacion.busredsociales.dao.factoria.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.busredsociales.bean.Usuario;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

/**
 * Modelo de datos para la tabla Usuario creada en BD MySql.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public class MySqlUsuarioDAO implements IUsuarioDAO {
		
	public List<Usuario> getAll() throws DAOException, Exception{
		
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;
		List<Usuario> lstUsuario = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.getInstance().conectar();
		   
		   //Preparamos la consulta
		   s = conexion.createStatement();
		   rs = s.executeQuery (
				   "select " +	COL_NAME_ID +", "+ COL_NAME_USERNAME +", "+ 
					COL_NAME_APELLIDOS +", " + COL_NAME_PHOTO + 
					" from " + TABLENAME + ";");
		   
		   //Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
		   while (rs.next())
		   {
			   //TODO: modificar cuando sepamos si queremos devolver listado vacío o null si no hay datos
			   if(lstUsuario == null) {
				   lstUsuario = new ArrayList<Usuario>();
			   }
			   
			   lstUsuario.add(rsToUsuario(rs));			   	
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
			
			
			MysqlDAOFactory.getInstance().desconectar();
			
		}
		
		return lstUsuario;
				
	}
	
	private Usuario rsToUsuario( final ResultSet rs) throws SQLException {
		
		return new Usuario(
	   			rs.getInt(COL_NAME_ID), 
	   			rs.getString(COL_NAME_USERNAME),
	   			rs.getString(COL_NAME_APELLIDOS), 
	   			rs.getString(COL_NAME_PHOTO));
				
	}
	

	public Usuario getById(Usuario obj) throws DAOException, Exception {
		
		
		
		return getById(obj.getId());		
		
	}

	public Usuario getById(int id) throws DAOException, Exception {
		
		
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;
		Usuario obj = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.getInstance().conectar();
		   
		   //Preparamos la consulta
		   s = conexion.createStatement();
		   rs = s.executeQuery (
				   "select " +	COL_NAME_ID +", "+ COL_NAME_USERNAME +", "+ 
					COL_NAME_APELLIDOS +", " + COL_NAME_PHOTO + 
					" from " + TABLENAME + " where " + COL_NAME_ID + " = " + String.valueOf(id) + ";");
		   
		   
		   if(rs != null) {
		   
			   //Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			   while (rs.next())
			   {
				   //TODO: modificar cuando sepamos si queremos devolver listado vacío o null si no hay datos				  
				   obj = rsToUsuario(rs);			   	
			   }	
		   } else {
			   obj = null;
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
			
			
			MysqlDAOFactory.getInstance().desconectar();
			
		}
		
		
		return obj;
		
		
		
	}

	public Usuario insert(Usuario obj) throws DAOException, Exception {
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.getInstance().conectar();
		   
		   //INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`) VALUES (NULL, 'Antonio', 'Segundo Puesto', '', NULL, '1', NULL);					
			
		   //insertar persona nueva
		   //s = conexion.createStatement();
		   //String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad) VALUES ( '"+first+"', '"+last+"', 34);";
		   //String sqlInsert = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`) VALUES (NULL, '" + nombre + "', '" + apellidos + "', '', NULL, '1', NULL);";
		   
		   //sentencia sql para el prepare statement
		   String sqlInsert = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES (NULL, ?, ?, '', NULL, '1', NULL, ?);";
		   		   
		   //s = conexion.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		   pst = conexion.prepareStatement(sqlInsert, new String[]{"id"});
		   
		   
		   //añadimos los campos
		   pst.setString(1, obj.getUsername());
		   pst.setString(2, obj.getApellidos());
		   pst.setString(3, obj.getPhoto());
		   
		   
		   //realizamos la operación
		   int res = pst.executeUpdate();
		   
		   //obtenemos la/s última key insertada
		   if(res > 0) {
			  
			   //obtenemos el rs con las últimas claves insertadas
			   rs = pst.getGeneratedKeys();			  			  
			   rs.next();
			  
			   //recogemos el último id
			   int auto_id = rs.getInt(1);
			  
			   //System.out.println(auto_id);
			  
			  //devolvemos el usuario creado
			   return this.getById(auto_id);
			  
		   }	   
		   
		} catch (Exception e) {
			throw e;
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (pst!=null) {
				pst = null;
			}
			
			
			MysqlDAOFactory.getInstance().desconectar();
			
		}
		
		return null;
	}

	public Usuario update(Usuario obj) throws DAOException, Exception {
				
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.getInstance().conectar();
		  
		   //Preparamos la consulta
		   String sql = "UPDATE " + TABLENAME + " SET "  
				   + COL_NAME_USERNAME + " = ?,"
				   + COL_NAME_APELLIDOS+ " = ?,"
				   + COL_NAME_PHOTO + " = ? " 
				   + "WHERE "+ COL_NAME_ID + " = ?;";
		  
		  	  
		   		   
		   //s = conexion.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		   pst = conexion.prepareStatement(sql);
		   
		   
		   //añadimos los campos
		   pst.setString(1, obj.getUsername());
		   pst.setString(2, obj.getApellidos());
		   pst.setString(3, obj.getPhoto());
		   pst.setInt(4, obj.getId());
		   
		   
		   //realizamos la operación
		   int res = pst.executeUpdate();
		   
		   //obtenemos la/s última key insertada
		   if(res > 0) {			  
			  //devolvemos el usuario creado
			   return this.getById(obj.getId());
			  
		   }	   
		   
		} catch (Exception e) {
			throw e;
		} finally {
			
			if(rs != null) {
				rs = null;
			}
			
			
			if (pst!=null) {
				pst = null;
			}
			
			
			MysqlDAOFactory.getInstance().desconectar();
			
		}
		
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
		   conexion = MysqlDAOFactory.getInstance().conectar();
				   
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
			
			
			MysqlDAOFactory.getInstance().desconectar();
			
		}		   
		
		
		return false;
	}

}
