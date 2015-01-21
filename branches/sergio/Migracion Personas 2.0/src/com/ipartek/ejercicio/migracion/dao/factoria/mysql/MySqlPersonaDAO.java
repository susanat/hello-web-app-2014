package com.ipartek.ejercicio.migracion.dao.factoria.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.ejercicio.migracion.dao.factoria.DAOException;
import com.ipartek.ejercicio.migracion.dao.interfaz.IPersonaDAO;
import com.ipartek.ejercicio.migracion.object.Persona;

/**
 * Modelo de datos para la tabla Persona creada en BD MySql.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public class MySqlPersonaDAO implements IPersonaDAO {
    
    public  Connection conexion = null;
    
    private boolean isTransaccion = false;
        
    
    
    public void conectarForTransaction() throws Exception {
	conexion = MysqlDAOFactory.getInstance().conectar();
	conexion.setAutoCommit(false);
	isTransaccion = true;
    }
    
    public void setCommit() throws SQLException {
	if(conexion != null) {
	    conexion.commit();
	    conexion = null;
	    isTransaccion = false;
	}	
    }
    
    public void setRollback() throws SQLException {
	if(conexion != null) {
	    conexion.rollback();
	    conexion = null;
	    isTransaccion = false;
	}	
    }
    
    
    
    
    public boolean insert(Persona obj) throws DAOException, Exception {
	
	PreparedStatement pst = null;
	ResultSet rs = null;

	try {

	    // Establecemos la conexión con la base de datos.
	    if (!isTransaccion) {
		conexion = MysqlDAOFactory.getInstance().conectar();
	    }
	
	    StringBuilder sql = new StringBuilder();
	    
	    sql.append("INSERT INTO  `migracion`.`persona` (");	    
	    sql.append("`nombre` ,");
	    sql.append("`apellido1` ,");
	    sql.append("`poblacion` ,");
	    sql.append("`edad` ,");
	    sql.append("`email` ,");
	    sql.append("`dni` ,");
	    sql.append("`cargo`");
	    sql.append(")");
	    sql.append("VALUES (");
	    sql.append("?,  ?,  ?,  ?,  ?,  ?, ?");
	    sql.append(");");

	    // insertar persona nueva
	   

	    // sentencia sql para el prepare statement
	    //String sqlInsert = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES (NULL, ?, ?, '', NULL, '1', NULL, ?);";

	    // s = conexion.prepareStatement(sqlInsert,
	    // Statement.RETURN_GENERATED_KEYS);
	    pst = conexion.prepareStatement(sql.toString());

	    //TODO: Arreglar chapuza de restar uno
	    // añadimos los campos
	    pst.setString(COL_NOMBRE - 1, obj.getNombre());
	    pst.setString(COL_APELLIDOS - 1, obj.getApellido1());
	    pst.setString(COL_POBLACION - 1, obj.getPoblacion());
	    pst.setInt(COL_EDAD - 1, obj.getEdad());
	    pst.setString(COL_EMAIL - 1, obj.getEmail());
	    pst.setString(COL_DNI - 1, obj.getDni());
	    pst.setString(COL_CARGO - 1, obj.getCargo());

	    // realizamos la operación
	    int res = pst.executeUpdate();

	    // No necesitamos el registro, devolvemos true
	    return true;

	    

	} catch (Exception e) {
	    throw e;
	} finally {

	    if (rs != null) {
		rs = null;
	    }

	    if (pst != null) {
		pst = null;
	    }

	    if(!isTransaccion) {
		MysqlDAOFactory.getInstance().desconectar();
	    }

	}

	
    }

    @Override
    public boolean createTable() throws DAOException, Exception {
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;

	try {

	    // Establecemos la conexión con la base de datos.
	    if(!isTransaccion) {
		conexion = MysqlDAOFactory.getInstance().conectar();
	    }

	    // sentencia sql para el prepare statement
	    //String sql = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES (NULL, ?, ?, '', NULL, '1', NULL, ?);";

	    //TODO: si hay tiempo, se saca de fichero la sentencia de 
	    //creación de tabla
	    StringBuilder sql = new StringBuilder();
	    
	    sql.append("CREATE TABLE `persona` (");
	    sql.append("    `id` int(11) NOT NULL AUTO_INCREMENT,");
	    sql.append("`nombre` varchar(250) COLLATE latin1_spanish_ci NOT NULL,");
	    sql.append("`apellido1` varchar(250) COLLATE latin1_spanish_ci NOT NULL,");
	    sql.append("	    `poblacion` varchar(250) COLLATE latin1_spanish_ci NOT NULL,");
	    sql.append("`edad` int(11) NOT NULL COMMENT 'Edad',");
	    sql.append("`email` varchar(250) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Email del trabajador',");
	    sql.append("`dni` varchar(50) COLLATE latin1_spanish_ci NOT NULL COMMENT 'DNI o NIF o CIF',");
	    sql.append("`cargo` varchar(250) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Cargo del trabajador',");
	    sql.append("PRIMARY KEY (`id`),");
	    sql.append("UNIQUE KEY `id` (`id`)");
	    sql.append(") ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Tabla relativa a la información de los empleados' AUTO_INCREMENT=1 ;");
	    
	    	    
	    // s = conexion.prepareStatement(sqlInsert,
	    // Statement.RETURN_GENERATED_KEYS);
	    pst = conexion.prepareStatement(sql.toString());

	    // realizamos la operación
	    int res = pst.executeUpdate();

	    //tabla creada correctamente
	    return true;

	    

	} catch (Exception e) {
	    throw e;
	} finally {

	    if (rs != null) {
		rs = null;
	    }

	    if (pst != null) {
		pst = null;
	    }

	    if(!isTransaccion) {
		MysqlDAOFactory.getInstance().desconectar();
	    }

	}
	
	
    }

    @Override
    public boolean dropTable() throws DAOException, Exception {
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;

	try {

	    // Establecemos la conexión con la base de datos.
	    if (!isTransaccion) {
		conexion = MysqlDAOFactory.getInstance().conectar();
	    }

	    // sentencia sql para el prepare statement
	    //String sql = "INSERT INTO `srncodesnippet`.`user` (`id`, `username`, `apellidos`, `password`, `email`, `status`, `timezone`, `photo`) VALUES (NULL, ?, ?, '', NULL, '1', NULL, ?);";

	    //TODO: si hay tiempo, se saca de fichero la sentencia de 
	    //creación de tabla
	    StringBuilder sql = new StringBuilder();
	    
	    sql.append("DROP TABLE IF EXISTS `persona`");
	    
	    // s = conexion.prepareStatement(sqlInsert,
	    // Statement.RETURN_GENERATED_KEYS);
	    pst = conexion.prepareStatement(sql.toString());

	    // realizamos la operación
	    int res = pst.executeUpdate();

	    //tabla creada correctamente
	    return true;

	    

	} catch (Exception e) {
	    throw e;
	} finally {

	    if (rs != null) {
		rs = null;
	    }

	    if (pst != null) {
		pst = null;
	    }

	    if (!isTransaccion) {
		MysqlDAOFactory.getInstance().desconectar();
	    }

	}
	
	
    }

}
