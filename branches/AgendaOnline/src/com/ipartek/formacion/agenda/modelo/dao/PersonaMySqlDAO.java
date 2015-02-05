package com.ipartek.formacion.agenda.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.agenda.bean.Persona;

public class PersonaMySqlDAO implements IPersonaDAO {

	private Connection conexion = null;

	public final static String SQL_SELECT_ALL = "SELECT * FROM "
			+ IPersonaDAO.TABLA;
	public final static String SQL_SELECT_BYID = "SELECT * FROM "
			+ IPersonaDAO.TABLA + " WHERE idcontacto=?" + IPersonaDAO.TABLA;

	public final static String SQL_INSERT = "INSERT INTO "
			+ IPersonaDAO.TABLA
			+ " (nombre,apellidos, telFijo, telMovil, direccion, poblacion, provincia, cp) VALUES ( ? , ? , ?, ?)";

	public final static String SQL_DELETE = "DELETE FROM " + IPersonaDAO.TABLA
			+ " WHERE idcontacto=?";

	public final static String SQL_UPDATE = "UPDATE "
			+ IPersonaDAO.TABLA
			+ " SET nombre=?,apellidos=?, telFijo=?, telMovil=?, direccion=?, poblacion=?, provincia=?, cp=?, WHERE idcontacto=?";

	@Override
	public ArrayList<Persona> getAll() throws ModelException {
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
				p = new Persona(rs.getInt("idcontacto"),
						rs.getString("nombre"), rs.getString("apellidos"),
						rs.getInt("telFijo"), rs.getInt("telMovil"),
						rs.getString("poblacion"), rs.getString("direccion"),
						rs.getString("provincia"), rs.getInt("cp"));
				personas.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ModelException(e.getMessage());

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
	public Persona getById(Persona p) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Persona p) throws ModelException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Persona p) throws ModelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Persona p) throws ModelException {
		// TODO Auto-generated method stub
		return false;
	}

}
