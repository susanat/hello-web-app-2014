package com.ipartek.formacion.buscadorLinkedIn.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.buscadorLinkedIn.bean.Persona;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

public class PersonaMySqlDAO implements IPersonaDAO {

    private Connection conexion = null;
    private Statement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Persona> getAll() {

	ArrayList<Persona> lista = new ArrayList<Persona>();

	try {
	    conexion = MYSQLDAOFactory.conectarDriver();
	    st = conexion.createStatement();
	    rs = st.executeQuery("SELECT * FROM persona");
	    while (rs.next()) {
		lista.add(new Persona(rs.getString("nombre"), rs
			.getString("apellidos"), rs.getString("URLImagen")));
	    }

	} catch (SQLException e) {

	    e.printStackTrace();
	} finally {
	    MYSQLDAOFactory.cerrarConexion(conexion, st, rs);
	}

	return lista;
    }

    @Override
    public Persona getByID(Persona p) {

	return new Persona("Pepe", "Gorriti");
    }

    @Override
    public Persona insert(Persona p) {
	PreparedStatement st = null;
	Persona persona1 = null;
	try {
	    // Abrimos conexion
	    conexion = MYSQLDAOFactory.conectarDriver();
	    st = conexion
		    .prepareStatement("INSERT INTO persona(nombre, apellidos, URLImagen) VALUES(?,?,?)");
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellidos());
	    st.setString(3, p.getUrlImagen());
	    st.executeUpdate();
	} catch (Exception ex) {
	    ex.printStackTrace();

	} finally {
	    MYSQLDAOFactory.cerrarConexion(conexion, st, rs);
	}

	return null;
    }

    @Override
    public boolean delete(Persona p) {
	boolean resul = false;
	PreparedStatement st = null;
	try {
	    conexion = MYSQLDAOFactory.conectarDriver();
	    st = conexion
		    .prepareStatement("DELETE FROM persona WHERE nombre = ? AND apellidos = ?");
	    st.setString(1, p.getNombre());
	    st.setString(2, p.getApellidos());
	    st.executeUpdate();
	    resul = true;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    resul = false;
	} finally {
	    MYSQLDAOFactory.cerrarConexion(conexion, st, rs);
	}
	return resul;
    }

    @Override
    public Persona update(Persona p) {
	// TODO Auto-generated method stub
	return null;
    }

}
