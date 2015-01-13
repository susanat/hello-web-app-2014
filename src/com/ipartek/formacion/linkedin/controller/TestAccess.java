package com.ipartek.formacion.linkedin.controller;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class TestAccess {

    private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
    private static final String CON_URL = "jdbc:odbc:dataSourceTest";

    @Test
    public void test() {

	try {
	    Class.forName(DRIVER);
	    Connection conexion = DriverManager.getConnection(CON_URL);
	    Statement st = conexion.createStatement();
	    ResultSet rs = st.executeQuery("select * from persona");
	    while (rs.next()) {
		System.out.println(rs.getObject(1));
		System.out.println(rs.getObject(2));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    fail("Excepcion conectando a la BBDD");
	}

    }

}
