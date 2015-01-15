package com.ipartek.formacion.linkedin.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

public class PersonaMySqlDAO implements IPersonaDAO {
	private Connection connection = null;

	public final static String SQL_SELECT_ALL = "SELECT * FROM " + IPersonaDAO.TABLA;
	public final static String SQL_SELECT_BYID = "SELECT * FROM " + IPersonaDAO.TABLA + " WHERE " + IPersonaDAO.COL_ID
			+ " = ? ";

	public final static String SQL_INSERT = "INSERT INTO " + IPersonaDAO.TABLA + "(" + IPersonaDAO.COL_NOMBRE + ", "
			+ IPersonaDAO.COL_APELLIDOS + ", " + IPersonaDAO.COL_FOTO + ") VALUES (?, ?, ?) ";

	public final static String SQL_DELETE = "DELETE FROM " + IPersonaDAO.TABLA + " WHERE id = ? ";

	public final static String SQL_UPDATE = "UPDATE " + IPersonaDAO.TABLA + " SET " + IPersonaDAO.COL_NOMBRE + " = ?, "
			+ IPersonaDAO.COL_APELLIDOS + " = ? WHERE " + IPersonaDAO.COL_ID + " = ? ";

	@Override
	public synchronized ArrayList<Persona> getAll() throws ModelException {
		ArrayList<Persona> personas = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			connection = MySqlDAOFactory.getInstance().conectar();

			personas = new ArrayList<Persona>();
			st = connection.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL);
			Persona p = null;

			while (rs.next()) {
				p = new Persona(rs.getInt(IPersonaDAO.COL_ID), rs.getString(IPersonaDAO.COL_NOMBRE),
						rs.getString(IPersonaDAO.COL_APELLIDOS), rs.getString(IPersonaDAO.COL_FOTO));
				personas.add(p);
			}
		} catch (final Exception e) {
			e.printStackTrace();
			throw new ModelException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}
			MySqlDAOFactory.getInstance().desconectar();
		}
		return personas;
	}

	@Override
	public synchronized Persona getById(final Persona p) {
		Persona pers = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			connection = MySqlDAOFactory.getInstance().conectar();

			st = connection.prepareStatement(SQL_SELECT_BYID);
			st.setInt(1, p.getId());

			rs = st.executeQuery();

			pers = new Persona(rs.getInt(IPersonaDAO.COL_ID), rs.getString(IPersonaDAO.COL_NOMBRE),
					rs.getString(IPersonaDAO.COL_APELLIDOS), rs.getString(IPersonaDAO.COL_FOTO));

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}
			MySqlDAOFactory.getInstance().desconectar();

		}

		return pers;
	}

	@Override
	public synchronized int insert(final Persona p) throws ModelException {
		int idNuevo = -1;
		PreparedStatement st = null;
		final ResultSet rs = null;

		try {
			connection = MySqlDAOFactory.getInstance().conectar();

			st = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getNombre());
			st.setString(2, p.getApellido());
			st.setString(3, p.getUrl_foto());

			final int affectedRows = st.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = st.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					idNuevo = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
			throw new ModelException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}
			MySqlDAOFactory.getInstance().desconectar();
		}
		return idNuevo;
	}

	@Override
	public synchronized boolean delete(final Persona p) {
		boolean correcto = false;

		PreparedStatement st = null;
		final ResultSet rs = null;
		try {
			connection = MySqlDAOFactory.getInstance().conectar();

			st = connection.prepareStatement(SQL_DELETE);
			st.setInt(1, p.getId());

			st.executeUpdate();
			correcto = true;
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}
			MySqlDAOFactory.getInstance().desconectar();
		}
		return correcto;
	}

	@Override
	public synchronized boolean update(final Persona p) {
		boolean correcto = false;
		PreparedStatement st = null;
		final ResultSet rs = null;

		try {
			connection = MySqlDAOFactory.getInstance().conectar();

			st = connection.prepareStatement(SQL_UPDATE);
			st.setString(1, p.getNombre());
			st.setString(2, p.getApellido());
			st.setInt(3, p.getId());

			st.executeUpdate();
			correcto = true;
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e2) {
					e2.printStackTrace();
				}
			}
			MySqlDAOFactory.getInstance().desconectar();
		}
		return correcto;
	}
}
