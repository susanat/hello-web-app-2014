package com.ipartek.formacion.buscarpersonas.model.rdbms;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ipartek.formacion.buscarpersonas.exception.ModelException;
import com.ipartek.formacion.buscarpersonas.model.IConnection;

public class MySqlConnection implements IConnection {

    // private static final String USER = "";
    // private static final String PASS = "";
    // private static final String URL = "jdbc:mysql://localhost/" + DB;
    private static Connection connection = null;
    private static MySqlConnection INSTANCE = null;
    private static final String DATA_SOURCE = "java:comp/env/jdbc/datasourceTest";

    // Private constructor suppresses
    private MySqlConnection() throws ModelException {
	if (connection == null) {
	    connect();
	}
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void createInstance() throws ModelException {
	if (connection == null) {
	    INSTANCE = new MySqlConnection();
	}
    }

    public static MySqlConnection getInstance() throws ModelException {
	if (connection == null) {
	    createInstance();
	}
	return INSTANCE;
    }

    @Override
    public void connect() throws ModelException {
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
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("LA CONEXIÓN A LA BD HA FALLADO");
	    throw new ModelException("LA CONEXIÓN A LA BD HA FALLADO");
	}
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
	throw new CloneNotSupportedException();
    }

    @Override
    public void disconnect() throws ModelException {
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
