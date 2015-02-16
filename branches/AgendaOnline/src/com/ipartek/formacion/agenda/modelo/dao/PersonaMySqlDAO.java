package com.ipartek.formacion.agenda.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.agenda.bean.Persona;

public class PersonaMySqlDAO implements IPersonaDAO {

	private Connection conexion = null;

	public final static String SQL_SELECT_ALL = "SELECT * FROM "
			+ IPersonaDAO.TABLA;
	public final static String SQL_SELECT_BYID = "SELECT * FROM "
			+ IPersonaDAO.TABLA + " WHERE idcontacto=?";

	public final static String SQL_INSERT = "INSERT INTO "
			+ IPersonaDAO.TABLA
			+ " (nombre, apellidos, telfmovil, telffijo, domicilio, poblacion, provincia, cp, anotaciones) VALUES ( ? , ? , ?, ?, ? , ? , ?, ?, ?)";

	public final static String SQL_DELETE = "DELETE FROM " + IPersonaDAO.TABLA
			+ " WHERE idcontacto=?";

	public final static String SQL_UPDATE = "UPDATE "
			+ IPersonaDAO.TABLA
			+ " SET nombre=?, apellidos=?, telfmovil=?, telffijo=?, domicilio=?, poblacion=?, provincia=?, cp=?, anotaciones=?, WHERE idcontacto=?";

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
						rs.getInt("telfmovil"), rs.getInt("telffijo"),
						rs.getString("domicilio"), rs.getString("poblacion"),
						rs.getString("provincia"), rs.getInt("cp"),
						rs.getString("anotaciones"));
				personas.add(p);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new ModelException(e.getMessage());

		} finally {

			// cerrar todos los objetos creados para el acceso de BBDD
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
			// cerrar conexion
			MySqlDAOFactory.getInstance().desconectar();
		}
		return personas;
	}

	@Override
	public synchronized Persona getById(Persona p) {
		Persona pers = new Persona();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conexion = MySqlDAOFactory.getInstance().conectar();

			st = conexion.prepareStatement(SQL_SELECT_BYID);
			st.setInt(1, p.getIdcontacto());

			rs = st.executeQuery();

			pers.setIdcontacto(rs.getInt("idcontacto"));
			pers.setNombre(rs.getString("nombre"));
			pers.setApellidos(rs.getString("apellidos"));
			pers.setTelMovil(rs.getInt("telfmovil"));
			pers.setTelFijo(rs.getInt("telffijo"));
			pers.setDireccion(rs.getString("domicilio"));
			pers.setPoblacion(rs.getString("poblacion"));
			pers.setProvincia(rs.getString("provincia"));
			pers.setCp(rs.getInt("cp"));
			pers.setAnotaciones(rs.getString("anotaciones"));

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// cerrar todos los objetos creados para el acceso de BBDD
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
			// cerrar conexion
			MySqlDAOFactory.getInstance().desconectar();
		}
		return pers;
	}

	@Override
	public synchronized int insert(Persona p) throws ModelException {
		int idNuevo = -1;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conexion = MySqlDAOFactory.getInstance().conectar();
			st = conexion.prepareStatement(SQL_INSERT,
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getNombre());
			st.setString(2, p.getApellidos());
			st.setInt(3, p.getTelMovil());
			st.setInt(4, p.getTelFijo());
			st.setString(5, p.getDireccion());
			st.setString(6, p.getPoblacion());
			st.setString(7, p.getProvincia());
			st.setInt(8, p.getCp());
			st.setString(9, p.getAnotaciones());

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
			e.printStackTrace();
			throw new ModelException(e.getMessage());

		} finally {

			// cerrar todos los objetos creados para el acceso de BBDD
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
			// cerrar conexion
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
			st.setInt(1, p.getIdcontacto());

			st.executeUpdate();
			correcto = true;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// cerrar todos los objetos creados para el acceso de BBDD
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
			// cerrar conexion
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
			st.setString(2, p.getApellidos());
			st.setInt(3, p.getTelMovil());
			st.setInt(4, p.getTelFijo());
			st.setString(5, p.getDireccion());
			st.setString(6, p.getPoblacion());
			st.setString(7, p.getProvincia());
			st.setInt(8, p.getCp());
			st.setString(9, p.getAnotaciones());

			st.executeUpdate();
			correcto = true;

		} catch (Exception e) {

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
			// cerrar conexion
			MySqlDAOFactory.getInstance().desconectar();
		}
		return correcto;
	}

}
