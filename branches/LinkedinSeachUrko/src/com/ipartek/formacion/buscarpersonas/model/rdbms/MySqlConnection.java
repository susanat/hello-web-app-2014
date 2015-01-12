package com.ipartek.formacion.buscarpersonas.model.rdbms;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.buscarpersonas.model.IConnection;

public class MySqlConnection implements IConnection {

    // private static final String USER = "";
    // private static final String PASS = "";
    // private static final String URL = "jdbc:mysql://localhost/" + DB;
    private static Connection connection = null;
    private static MySqlConnection INSTANCE = null;
    private static final String DATA_SOURCE = "java:comp/env/jdbc/datasourceTest";

    // Private constructor suppresses
    private MySqlConnection() {
	if (connection == null) {
	    connect();
	}
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void createInstance() {
	if (connection == null) {
	    INSTANCE = new MySqlConnection();
	}
    }

    public static MySqlConnection getInstance() {
	if (connection == null) {
	    createInstance();
	}
	return INSTANCE;
    }

    @Override
    public void connect() {
	// final String DRIVER = "com.mysql.jdbc.Driver";
	// System.out.println("Connecting to MySQL...");

	try {
	    // Class.forName(DRIVER);
	    if (connection == null) {
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
		connection = ds.getConnection();
		// connection = DriverManager.getConnection(URL, USER, PASS);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (NamingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
	throw new CloneNotSupportedException();
    }

    @Override
    public void disconnect() {
	if (connection != null) {
	    try {
		connection.close();
		connection = null;
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    @Override
    public Connection getConnection() {
	return MySqlConnection.connection;
    }
}
