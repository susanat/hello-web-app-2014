package com.ipartek.formacion.buscadorLinkedIn.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.buscadorLinkedIn.bean.Message;
import com.ipartek.formacion.buscadorLinkedIn.bean.Persona;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

public class PersonaAccessDAO implements IPersonaDAO {

    private Connection conexion = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    private String SELECT_ALL = "SELECT * FROM " + IPersonaDAO.TABLA;

    private String SELECT_BY_ID = "SELECT " + IPersonaDAO.NOMBRE + " , "
	    + IPersonaDAO.APELLIDOS + " , " + IPersonaDAO.LINK_FOTO + " FROM "
	    + IPersonaDAO.TABLA + " WHERE " + IPersonaDAO.COL_ID + " = ?";

    private String INSERT_INTO = "INSERT INTO " + IPersonaDAO.TABLA + " ("
	    + IPersonaDAO.NOMBRE + "," + IPersonaDAO.APELLIDOS + ","
	    + IPersonaDAO.LINK_FOTO + ") VALUES (?,?,?)";

    private String DELETE_FROM = "DELETE FROM " + IPersonaDAO.TABLA + " WHERE "
	    + IPersonaDAO.NOMBRE + "= ? AND " + IPersonaDAO.APELLIDOS + " = ?";

    private String UPDATE_TABLE = "UPDATE " + IPersonaDAO.TABLA + " SET "
	    + IPersonaDAO.NOMBRE + "= ? , " + IPersonaDAO.APELLIDOS
	    + "= ? WHERE " + IPersonaDAO.COL_ID + "= ?";

    @Override
    public ArrayList<Persona> getAll() {

	ArrayList<Persona> lista = new ArrayList<Persona>();

	try {
	    conexion = AccessDAOFactory.getInstance().conectarDriver();
	    st = conexion.prepareStatement(SELECT_ALL);
	    rs = st.executeQuery();
	    while (rs.next()) {
		lista.add(new Persona(rs.getString("nombre"), rs
			.getString("apellidos"), rs.getString("URLImagen"), rs
			.getInt("id")));
	    }

	} catch (SQLException e) {

	    e.printStackTrace();
	} finally {
	    AccessDAOFactory.getInstance().cerrarConexion(conexion, st, rs);

	}

	return lista;
    }

    @Override
    public Persona getByID(int id) {
	PreparedStatement st = null;
	Persona p = new Persona();
	try {
	    conexion = AccessDAOFactory.getInstance().conectarDriver();
	    st = conexion.prepareStatement(SELECT_BY_ID);
	    st.setInt(1, id);
	    rs = st.executeQuery();
	    // comprobamos si ha devuelto algo
	    if (!rs.next()) {
		p.setNombre("");
		p.setApellidos("");
		p.setUrlImagen("");

	    } else {
		while (rs.next()) {
		    p.setNombre(rs.getString(1));
		    p.setApellidos(rs.getString(2));
		    p.setUrlImagen(rs.getString(3));
		}
	    }

	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {
	    AccessDAOFactory.getInstance().cerrarConexion(conexion, st, rs);
	}
	return p;
    }

    @Override
    public int insert(Persona p) {
	PreparedStatement st = null;
	int id = -1;
	try {
	    // Abrimos conexion
	    conexion = AccessDAOFactory.getInstance().conectarDriver();
	    st = conexion.prepareStatement(INSERT_INTO);
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellidos());
	    st.setString(3, p.getUrlImagen());
	    st.executeUpdate();

	    // Cogemos la key para usarla en otras operaciones (es recomendado)
	    rs = st.getGeneratedKeys();

	    // TODO recorrer el resultSet, guardar el id para devolverlo luego
	    while (rs.next()) {
		id = rs.getInt(1);
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {
	    AccessDAOFactory.getInstance().cerrarConexion(conexion, st, rs);
	}

	return id;
    }

    @Override
    public boolean delete(Persona p) {
	boolean resul = false;
	PreparedStatement st = null;
	try {
	    conexion = AccessDAOFactory.getInstance().conectarDriver();
	    st = conexion.prepareStatement(DELETE_FROM);
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellidos());
	    st.executeUpdate();
	    resul = true;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    resul = false;
	} finally {
	    AccessDAOFactory.getInstance().cerrarConexion(conexion, st, rs);
	}
	return resul;
    }

    @Override
    public Message update(Persona p) {
	PreparedStatement st = null;
	try {

	    conexion = AccessDAOFactory.getInstance().conectarDriver();
	    st = conexion.prepareStatement(UPDATE_TABLE);
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellidos());
	    // TODO Necesitamos crear un metodo que devuelva el id de una
	    // persona seleccionada y pasarselo a la query aqui
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    AccessDAOFactory.getInstance().cerrarConexion(conexion, st, rs);
	}
	return null;
    }

}
