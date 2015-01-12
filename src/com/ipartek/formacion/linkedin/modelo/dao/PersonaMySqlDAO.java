package com.ipartek.formacion.linkedin.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

public class PersonaMySqlDAO implements IPersonaDAO {
    private Connection conexion = null;
    public final static String SQL_SELECT_ALL = "SELECT * FROM "
	    + IPersonaDAO.TABLA;
    public final static String SQL_SELECT_BYID = "SELECT * FROM "
	    + IPersonaDAO.TABLA + " WHERE id=?" + IPersonaDAO.TABLA;

    public final static String SQL_INSERT = "INSERT INTO " + IPersonaDAO.TABLA
	    + " (nombre,apellidos,edad, url_foto) VALUES ( ? , ? , ?, ?)";

    public final static String SQL_DELETE = "DELETE FROM " + IPersonaDAO.TABLA
	    + " WHERE id=?";

    public final static String SQL_UPDATE = "UPDATE " + IPersonaDAO.TABLA
	    + " SET nombre=?,apellidos=?,edad=? WHERE id=?";

    @Override
    public synchronized ArrayList<Persona> getAll() {
	ArrayList<Persona> personas = null;
	Statement st = null;
	ResultSet rs = null;

	try {
	    conexion = MySqlDAOFactory.getInstance().conectar();

	    personas = new ArrayList<Persona>();
	    st = conexion.createStatement();
	    rs = st.executeQuery(SQL_SELECT_ALL);
	    Persona p = null;
	    while (rs.next()) {
		p = new Persona(rs.getInt("id"), rs.getString("nombre"),
			rs.getString("apellidos"), rs.getInt("edad"),
			rs.getString("url_foto"));
		personas.add(p);
	    }

	} catch (Exception e) {
	    // cerrar conexion

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    MySqlDAOFactory.getInstance().desconectar();

	}

	return personas;

    }

    @Override
    public synchronized Persona getById(Persona p) {
	Persona pers = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    conexion = MySqlDAOFactory.getInstance().conectar();

	    st = conexion.prepareStatement(SQL_SELECT_BYID);
	    st.setInt(1, p.getId());

	    rs = st.executeQuery();

	    pers = new Persona(rs.getInt("id"), rs.getString("nombre"),
		    rs.getString("apellidos"), rs.getInt("edad"),
		    rs.getString("url_foto"));

	} catch (Exception e) {
	    // cerrar conexion

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    MySqlDAOFactory.getInstance().desconectar();

	}

	return pers;
    }

    @Override
    public synchronized int insert(Persona p) {
	int idNuevo = -1;

	PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    conexion = MySqlDAOFactory.getInstance().conectar();
	    st = conexion.prepareStatement(SQL_INSERT,
		    Statement.RETURN_GENERATED_KEYS);
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellido());
	    st.setInt(3, p.getEdad());
	    st.setString(4, p.getUrl_foto());

	    int affectedRows = st.executeUpdate();
	    if (affectedRows == 0) {
		throw new SQLException(
			"Creating user failed, no rows affected.");
	    }

	    try (ResultSet generatedKeys = st.getGeneratedKeys()) {
		if (generatedKeys.next()) {
		    idNuevo = generatedKeys.getInt(1);
		} else {
		    throw new SQLException(
			    "Creating user failed, no ID obtained.");
		}
	    }

	} catch (Exception e) {
	    // cerrar conexion

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    MySqlDAOFactory.getInstance().desconectar();

	}

	return idNuevo;
    }

    @Override
    public synchronized boolean delete(Persona p) {
	boolean correcto = false;

	PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    conexion = MySqlDAOFactory.getInstance().conectar();

	    st = conexion.prepareStatement(SQL_DELETE);
	    st.setInt(1, p.getId());

	    st.executeUpdate();
	    correcto = true;

	} catch (Exception e) {

	    e.printStackTrace();
	    // cerrar conexion

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    MySqlDAOFactory.getInstance().desconectar();

	}

	return correcto;
    }

    @Override
    public synchronized boolean update(Persona p) {
	boolean correcto = false;
	PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    conexion = MySqlDAOFactory.getInstance().conectar();

	    st = conexion.prepareStatement(SQL_UPDATE);
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellido());
	    st.setInt(3, p.getEdad());
	    st.setInt(4, p.getId());

	    st.executeUpdate();
	    correcto = true;

	} catch (Exception e) {
	    // cerrar conexion

	    e.printStackTrace();

	} finally { // cerrar todos los objetos creados para el acceso de BBDD
	    // cerrar ResultSet
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    // cerrar statements
	    if (st != null) {
		try {
		    st.close();
		} catch (Exception e2) {
		    e2.printStackTrace();
		}
	    }
	    MySqlDAOFactory.getInstance().desconectar();

	}

	return correcto;
    }

}
