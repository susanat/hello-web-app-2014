package com.ipartek.formacion.buscadorLinkedIn.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAccess {

    private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
    private static final String CON_URL = "jdbc:odbc:dataSourceTest";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

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
