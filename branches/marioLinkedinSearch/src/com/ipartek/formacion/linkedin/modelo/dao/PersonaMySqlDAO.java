package com.ipartek.formacion.linkedin.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

public class PersonaMySqlDAO implements IPersonaDAO {

    @Override
    public ArrayList<Persona> getAll() {
	ArrayList<Persona> personas = null;
	Statement st = null;
	ResultSet rs = null;
	Connection conexion = MySqlDAOFactory.conectar();
	try {
	    personas = new ArrayList<Persona>();
	    st = conexion.createStatement();
	    rs = st.executeQuery("SELECT * FROM persona");
	    Persona p = null;
	    while (rs.next()) {
		p = new Persona(rs.getInt("id"), rs.getString("nombre"),
			rs.getString("apellidos"), rs.getInt("edad"),
			rs.getString("url_foto"));
		personas.add(p);
	    }

	} catch (Exception e) {
	    // cerrar conexion
	    MySqlDAOFactory.desconectar();
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

	}

	return personas;

    }

    @Override
    public Persona getById(Persona p) {
	Persona pers = null;
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	Connection conexion = MySqlDAOFactory.conectar();
	try {

	    String sqlInsert = "SELECT * FROM persona WHERE id=?";
	    st = conexion.prepareStatement(sqlInsert);
	    st.setInt(1, p.getId());

	    rs = st.executeQuery();

	    pers = new Persona(rs.getInt("id"), rs.getString("nombre"),
		    rs.getString("apellidos"), rs.getInt("edad"),
		    rs.getString("url_foto"));

	} catch (Exception e) {
	    // cerrar conexion
	    MySqlDAOFactory.desconectar();
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

	}

	return pers;
    }

    @Override
    public int insert(Persona p) {
	int idNuevo = 0;
	Connection conexion = MySqlDAOFactory.conectar();
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    String sqlInsert = "INSERT INTO persona (nombre,apellidos,edad, url_foto) VALUES ( ? , ? , ?, ?)";

	    st = conexion.prepareStatement(sqlInsert,
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
		    idNuevo = (int) generatedKeys.getLong(1);
		} else {
		    throw new SQLException(
			    "Creating user failed, no ID obtained.");
		}
	    }

	} catch (Exception e) {
	    // cerrar conexion
	    MySqlDAOFactory.desconectar();
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

	}

	return idNuevo;
    }

    @Override
    public boolean delete(Persona p) {
	boolean correcto = false;
	Connection conexion = MySqlDAOFactory.conectar();
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    String sqlInsert = "DELETE FROM persona WHERE id=?";
	    st = conexion.prepareStatement(sqlInsert);
	    st.setInt(1, p.getId());

	    st.executeUpdate();
	    correcto = true;

	} catch (Exception e) {

	    e.printStackTrace();
	    // cerrar conexion
	    MySqlDAOFactory.desconectar();

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

	}

	return correcto;
    }

    @Override
    public boolean update(Persona p) {
	boolean correcto = false;
	Connection conexion = MySqlDAOFactory.conectar();
	java.sql.PreparedStatement st = null;
	ResultSet rs = null;
	try {

	    String sqlInsert = "UPDATE persona SET nombre=?,apellidos=?,edad=?,url_foto=? WHERE id=?";

	    st = conexion.prepareStatement(sqlInsert);
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellido());
	    st.setInt(3, p.getEdad());
	    st.setString(4, p.getUrl_foto());
	    st.setInt(5, p.getId());

	    st.executeUpdate();
	    correcto = true;

	} catch (Exception e) {
	    // cerrar conexion
	    MySqlDAOFactory.desconectar();
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

	}

	return correcto;
    }

}
