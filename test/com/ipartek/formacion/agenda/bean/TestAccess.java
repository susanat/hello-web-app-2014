package com.ipartek.formacion.agenda.bean;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.ipartek.formacion.agenda.modelo.dao.IPersonaDAO;

public class TestAccess {

	private static Connection conn = null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String CON_URL = "jdbc:mysql://localhost:3306/agenda";
	private static final String CON_USER = "root";
	private static final String CON_PASS = "";
	private static final String SQL_SELECT = "select * from "
			+ IPersonaDAO.TABLA;

	@Test
	public void test() {

		try {
			// cargar Driver
			Class.forName(DRIVER);
			// obtener conexion con DriverManager
			conn = DriverManager.getConnection(CON_URL, CON_USER, CON_PASS);

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT);

			while (rs.next()) {
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
			}

			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Excepcion concetnado a la BBDD");
		}

	}

}
