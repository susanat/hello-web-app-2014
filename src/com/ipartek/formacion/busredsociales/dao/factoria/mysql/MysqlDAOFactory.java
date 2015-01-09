package com.ipartek.formacion.busredsociales.dao.factoria.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;



import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

public class MysqlDAOFactory extends DAOFactory {

	private static final String STR_LOOKUP = "java:comp/env/jdbc/MyConexion";

	private static Connection conexion = null;

	public static Connection conectar() throws Exception {

		if (conexion == null) {
			
			InitialContext ctx = new InitialContext();
			// en el web.xml se configura el jdbc/MyConexion
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyConexion");
			conexion = ds.getConnection();

			if (conexion == null) {
				throw new Exception("No se ha creado la conexión");
			}
		}

		return conexion;

	}

	
	
	public static void desconectar() throws SQLException {
		if (conexion != null) {
			if (!conexion.isClosed()) {
				conexion.close();
			}
			conexion = null;
		}
	}
	

	@Override
	public IUsuarioDAO getUsuarioDAO() throws DAOException, Exception {
		return new MySqlUsuarioDAO();
	}

}
