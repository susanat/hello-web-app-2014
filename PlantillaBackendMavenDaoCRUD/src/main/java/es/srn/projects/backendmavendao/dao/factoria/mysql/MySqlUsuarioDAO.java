package es.srn.projects.backendmavendao.dao.factoria.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.srn.projects.backendmavendao.bean.Usuario;
import es.srn.projects.backendmavendao.dao.factoria.interfaz.IUsuarioDAO;


/**
 * Modelo de datos para la tabla Usuario creada en BD MySql.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public class MySqlUsuarioDAO implements IUsuarioDAO {
		
	
	private Connection session;
	
	
	@Override
	public void beginTrans() throws Exception {
		
		try {
			//recuperamos la sesión
			this.session = MysqlDAOFactory.getInstance().beginTrans();
		} catch (SQLException ex) {			
			//un intento más
			if(ex.getErrorCode() == 1049) {				
				createDatabase();					
			} else {
				throw ex;
			}
		} catch (Exception ex) {
			throw ex;
		}		
				
	}

	@Override
	public void commit() throws Exception {
		MysqlDAOFactory.getInstance().commit();
		
	}

	@Override
	public void rollback() throws Exception {
		MysqlDAOFactory.getInstance().rollback();
		
	}
	
	/**
	 * Función que inicializa a null los objetos pasador y 
	 * desconecta de la base de datos.
	 * @param param Array de objeto a pasar a null.
	 * @throws SQLException
	 */
	private void desconectar(Object ... param) throws SQLException {
		
		for(Object obj : param) {
			obj = null;
		}
		
		MysqlDAOFactory.getInstance().desconectar();
	}
	
	/**
	 * Obtiene todos los elementos de la base de datos.
	 */
	public List<Usuario> getAll() throws Exception{		
		
		Statement s = null;
		ResultSet rs = null;
		List<Usuario> lstUsuario = null;
		
		
		try {
			//recuperamos la sesión
			session = MysqlDAOFactory.getInstance().conectar();
		} catch (SQLException ex) {			
			//intenta crear una vez la base de datos más si da error mysql 1049.
			if(ex.getErrorCode() == 1049) {				
				createDatabase();				
			} else {
				throw ex;
			}
		} catch (Exception ex) {
			throw ex;
		}		
		
		
		try
		{		   
		   //Preparamos la consulta
		   s = session.createStatement();
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
			desconectar(rs,s);												
		}
		
		return lstUsuario;				
	}
	
	private void cerrarObjetos(Object...param) {
		
	}
	
	private Usuario rsToUsuario( final ResultSet rs) throws SQLException {
		
		return new Usuario(
	   			rs.getInt(COL_NAME_ID), 
	   			rs.getString(COL_NAME_USERNAME),
	   			rs.getString(COL_NAME_APELLIDOS), 
	   			rs.getString(COL_NAME_PHOTO));
				
	}
	
	public Usuario getById(Usuario obj) throws Exception {
		
		
		
		return getById(obj.getId());		
		
	}

	public Usuario getById(int id) throws Exception {
		
		
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

	public Usuario insert(Usuario obj) throws Exception {
		
		Connection session = null;
		PreparedStatement pst = null;
		ResultSet rs = null;		
		
		try {
			//recuperamos la conexión con la base de datos.
			session = MysqlDAOFactory.getInstance().conectar();
		} catch (SQLException ex) {			
			//intenta crear una vez la base de datos más si da error mysql 1049.
			if(ex.getErrorCode() == MysqlDAOFactory.MYSQL_CODE_DB_NOT_FOUND) {				
				createDatabase();				
			} else {
				throw ex;
			}
		} catch (Exception ex) {
			throw ex;
		}		
		
		try
		{		  
		   //sentencia sql para el prepare statement
		
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO ");
			sql.append("`").append(TABLENAME).append("`");
			sql.append("(");
				//sql.append("`").append(COL_NAME_ID).append("`").append(",");
				sql.append("`").append(COL_NAME_USERNAME).append("`").append(",");
				sql.append("`").append(COL_NAME_APELLIDOS).append("`").append(",");
				sql.append("`").append(COL_NAME_PHOTO).append("`").append(",");
				sql.append("`").append(COL_NAME_PASSWORD).append("`").append(",");
				sql.append("`").append(COL_NAME_EMAIL).append("`").append(",");
				sql.append("`").append(COL_NAME_STATUS).append("`").append(",");
				sql.append("`").append(COL_NAME_TIMEZONE).append("`");
			sql.append(")");
			//sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?); ");
			sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?); ");
			
			/*
		   String sqlInsert = "INSERT INTO `" + TABLENAME + 
				   "` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES (NULL, ?, ?, '', NULL, '1', NULL, ?);";
		   */
		   		   
		   //s = conexion.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		   pst = session.prepareStatement(sql.toString(), new String[]{COL_NAME_ID});
		   		   
		   //añadimos los campos
		   pst.setString(1, obj.getUsername());
		   pst.setString(2, obj.getApellidos());		   
		   pst.setString(3, obj.getPhoto());
		   pst.setString(4, obj.getPassword());
		   pst.setString(5, obj.geteMail());
		   pst.setString(6, obj.getStatus());
		   pst.setString(7, obj.getTimezone());
		   		   
		   //realizamos la operación
		   int res = pst.executeUpdate();
		   
		   //obtenemos la/s última key insertada
		   if(res > 0) {			  
			   //obtenemos el rs con las últimas claves insertadas
			   rs = pst.getGeneratedKeys();			  			  
			   rs.next();
			  
			   //recogemos el último id
			   int auto_id = rs.getInt(1);			  			   
			  
			  //devolvemos el usuario creado
			   return this.getById(auto_id);			  
		   }	   
		   
		} catch (SQLException e) {
			if(e.getErrorCode() == 1146) {
				createTable();
			}			
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {			
			desconectar(rs,pst);
		}
		
		return null;
	}

	public Usuario update(Usuario obj) throws Exception {
				
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.getInstance().conectar();
		   
		   StringBuilder sql = new StringBuilder();
		   sql.append("UPDATE " );
		   sql.append(TABLENAME);
		   sql.append(" SET ");
		   sql.append(COL_NAME_USERNAME).append(" = ? ").append(", ");
		   sql.append(COL_NAME_APELLIDOS).append(" = ? ").append(", ");
		   sql.append(COL_NAME_PHOTO).append(" = ? ").append(", ");
		   sql.append(COL_NAME_PASSWORD).append(" = ? ").append(", ");
		   sql.append(COL_NAME_EMAIL).append(" = ? ").append(", ");
		   sql.append(COL_NAME_STATUS).append(" = ? ").append(", ");
		   sql.append(COL_NAME_TIMEZONE ).append(" = ? ");
		   sql.append(" WHERE ").append(COL_NAME_ID).append(" = ?;");
			   		  
		   //Preparamos la consulta
		   /*
		   String sql = "UPDATE " 
				   + TABLENAME 
				   + " SET "  
				   + COL_NAME_USERNAME + " = ?,"
				   + COL_NAME_APELLIDOS+ " = ?,"
				   + COL_NAME_PHOTO + " = ?, " 
				   + COL_NAME_PASSWORD + " = ?,"
				   + COL_NAME_EMAIL+ " = ?,"
				   + COL_NAME_STATUS + " = ?, " 
				   + COL_NAME_TIMEZONE + " = ? "				   
				   + "WHERE "+ COL_NAME_ID + " = ?;";
		 */
		  
		   //s = conexion.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		   pst = conexion.prepareStatement(sql.toString());
		   
		   
		   //añadimos los campos		 
		   pst.setString(1, obj.getUsername());
		   pst.setString(2, obj.getApellidos());		   
		   pst.setString(3, obj.getPhoto());
		   pst.setString(4, obj.getPassword());
		   pst.setString(5, obj.geteMail());
		   pst.setString(6, obj.getStatus());
		   pst.setString(7, obj.getTimezone());
		   pst.setInt(8, obj.getId());
		   
		   
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
			this.desconectar(rs, pst);
		}
		
		return null;
	}

	public boolean delete(Usuario obj) throws Exception {

		
		
		
		return delete(obj.getId());
	}

	public boolean delete(int id) throws Exception {
		
		Connection conexion = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		
		try
		{		   
		   //Establecemos la conexión con la base de datos.
		   conexion = MysqlDAOFactory.getInstance().conectar();
				   
		   //sentencia sql para el prepare statement
		   String sqlInsert = "delete from `" + TABLENAME+ "` where `" + COL_NAME_ID + "` = ?;";
		   		   
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



	@Override
	public void createTable() throws Exception {
		StringBuilder sql = new StringBuilder();
		
		/*
		sql.append("CREATE TABLE IF NOT EXISTS");
		sql.append("`").append(TABLENAME).append("`");
		sql.append("( `id` int(11) NOT NULL AUTO_INCREMENT,");
		sql.append("`username` varchar(255) NOT NULL,");
		sql.append("`apellidos` varchar(255) DEFAULT NULL,");
		sql.append("`photo` varchar(255) DEFAULT NULL,");
		sql.append("`password` varchar(255) DEFAULT NULL,");
		sql.append("`email` varchar(255) DEFAULT NULL,");
		sql.append("`status` varchar(255) DEFAULT NULL,");
		sql.append("`timezone` varchar(255) DEFAULT NULL,");
		sql.append("PRIMARY KEY (`id`)");
		sql.append(") ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		*/
				
		
		sql.append(" CREATE TABLE IF NOT EXISTS");
		sql.append(" `").append(TABLENAME).append("`");
		sql.append(" (`").append(COL_NAME_ID).append("` int(11) NOT NULL AUTO_INCREMENT,");
		sql.append(" `").append(COL_NAME_USERNAME).append("` varchar(255) NOT NULL,");
		sql.append(" `").append(COL_NAME_APELLIDOS).append("` varchar(255) DEFAULT NULL,");
		sql.append(" `").append(COL_NAME_PHOTO).append("` varchar(255) DEFAULT NULL,");
		sql.append(" `").append(COL_NAME_PASSWORD).append("` varchar(255) DEFAULT NULL,");
		sql.append(" `").append(COL_NAME_EMAIL).append("` varchar(255) DEFAULT NULL,");
		sql.append(" `").append(COL_NAME_STATUS).append("` varchar(255) DEFAULT NULL,");
		sql.append(" `").append(COL_NAME_TIMEZONE).append("` varchar(255) DEFAULT NULL,");
		sql.append(" PRIMARY KEY (`").append(COL_NAME_ID).append("`)");
		sql.append(" ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		
		MysqlDAOFactory.getInstance().createTable(sql.toString());
	}

	@Override
	public void createDatabase() throws Exception {
		
		//creamos la base de datos
		MysqlDAOFactory.getInstance().createDataBase();
		
		//reintentamos conectar
		session = MysqlDAOFactory.getInstance().conectar();
	}


	@Override
	public boolean deleteTable() throws Exception {
		//creamos la base de datos
		return MysqlDAOFactory.getInstance().deleteTable(TABLENAME);
	}

	

	

	
	
	
	

}
