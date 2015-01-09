package com.ipartek.formacion.busredsociales.comun;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public final class FactoriaMysql_b {

	private static final String STR_LOOKUP = "java:comp/env/jdbc/MyConexion";
	
	
	private static Connection conexion = null;

	/**
	 * Constructor privado
	 */
	private FactoriaMysql_b() {

	}

	public static Connection conectar() throws Exception {
			if (conexion == null) {
				/*
				 * CONEXIÓN DIRECTA CON LA BASE DE DATOS
				 * Class.forName("com.mysql.jdbc.Driver"); //Establecemos la
				 * conexión con la base de datos. conexion = (Connection)
				 * DriverManager.getConnection
				 * ("jdbc:mysql://localhost/srncodesnippet","root", "");
				 */

				// CONEXIÓN USANDO DATASOURCE (xml en META-INF, e información en
				// web.xml)
				// Para obtener la conexión usando un pool de conexiones con
				// datasource de Tomcat
				InitialContext ctx = new InitialContext();
				// en el web.xml se configura el jdbc/MyConexion
				DataSource ds = (DataSource) ctx
						.lookup("java:comp/env/jdbc/MyConexion");
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

}
