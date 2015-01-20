package com.ipartek.ejercicio.migracion.dao.interfaz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ipartek.ejercicio.migracion.dao.factoria.DAOException;
import com.ipartek.ejercicio.migracion.object.Persona;


/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la BBDD.
 * 
 * Tendremos que implementar segun el motor que utilicemos para almacenar los datos.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public interface IPersonaDAO {
	
	public final static String COL_NAME_ID = "id";
	public final static String COL_NAME_NOMBRE = "nombre";
	public final static String COL_NAME_APELLIDOS = "apellido1";	
	public final static String COL_NAME_POBLACION = "poblacion";
	public final static String COL_NAME_EDAD = "edad";
	public final static String COL_NAME_EMAIL = "email";
	public final static String COL_NAME_DNI = "dni";
	public final static String COL_NAME_CARGO = "cargo";
	
	
	public final static int COL_ID = 1;
	public final static int COL_NOMBRE = 2;
	public final static int COL_APELLIDOS = 3;	
	public final static int COL_POBLACION = 4;
	public final static int COL_EDAD = 5;
	public final static int COL_EMAIL = 6;
	public final static int COL_DNI = 7;
	public final static int COL_CARGO = 8;
	
	public final static String TABLENAME = "persona";
	
	public Connection conexion = null;
	    	    
        public void conectarForTransaction() throws Exception;
    
        public void setCommit() throws SQLException;
    
        public void setRollback() throws SQLException;
	
	public boolean insert(Persona obj) throws DAOException, Exception;
	
	public boolean createTable() throws DAOException, Exception;
	
	public boolean dropTable() throws DAOException, Exception;
		

}
