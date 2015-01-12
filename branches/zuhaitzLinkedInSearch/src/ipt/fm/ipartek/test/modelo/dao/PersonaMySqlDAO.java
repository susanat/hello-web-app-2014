package ipt.fm.ipartek.test.modelo.dao;

import ipt.fm.ipartek.test.bean.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonaMySqlDAO implements IPersonaDAO {

	private static Connection connection = null;

	@Override
	public ArrayList<Persona> getAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		final String sql = "SELECT " + IPersonaDAO.COL_ID + ", " + IPersonaDAO.COL_NOMBRE + ", "
				+ IPersonaDAO.COL_APELLIDOS + ", " + IPersonaDAO.COL_FOTO + " FROM " + IPersonaDAO.TABLE;
		final ArrayList<Persona> personas = new ArrayList<Persona>();

		try {
			connection = MySqlDAOFactory.getInstance().openConnection();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			Persona p = null;

			while (rs.next()) {
				p = new Persona();
				personas.add(mapeoPersona(rs, p));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().closeConnection();
		}

		return personas;
	}

	@Override
	public Persona getById(final Persona p) {
		Persona pRes = new Persona();
		PreparedStatement pst = null;
		ResultSet rs = null;
		final String sql = "SELECT " + IPersonaDAO.COL_ID + ", " + IPersonaDAO.COL_NOMBRE + ", "
				+ IPersonaDAO.COL_APELLIDOS + ", " + IPersonaDAO.COL_FOTO + " FROM " + IPersonaDAO.TABLE + " WHERE "
				+ IPersonaDAO.COL_ID + " = ?";

		try {
			connection = MySqlDAOFactory.getInstance().openConnection();
			pst = connection.prepareStatement(sql);

			pst.setInt(1, p.getId());
			rs = pst.executeQuery();

			while (rs.next()) {
				pRes = mapeoPersona(rs, p);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().closeConnection();
		}

		return pRes;
	}

	@Override
	public Persona getById(final int id) {
		Persona pRes = new Persona();
		PreparedStatement pst = null;
		ResultSet rs = null;
		final String sql = "SELECT " + IPersonaDAO.COL_ID + ", " + IPersonaDAO.COL_NOMBRE + ", "
				+ IPersonaDAO.COL_APELLIDOS + ", " + IPersonaDAO.COL_FOTO + " FROM " + IPersonaDAO.TABLE + " WHERE "
				+ IPersonaDAO.COL_ID + " = ?";

		try {
			connection = MySqlDAOFactory.getInstance().openConnection();
			pst = connection.prepareStatement(sql);

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				pRes = mapeoPersona(rs, new Persona());
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().closeConnection();
		}

		return pRes;
	}

	@Override
	public int insert(final Persona p) {
		PreparedStatement pst = null;
		final Statement st = null;
		ResultSet rs = null;
		int idEncontrado = -1;
		final String sql = "INSERT INTO " + IPersonaDAO.TABLE + " (" + IPersonaDAO.COL_NOMBRE + ", "
				+ IPersonaDAO.COL_APELLIDOS + ", " + IPersonaDAO.COL_FOTO + ") VALUES (?, ?, ?)";

		try {
			connection = MySqlDAOFactory.getInstance().openConnection();
			pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellidos());
			pst.setString(3, p.getFoto());

			pst.executeUpdate();

			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				idEncontrado = rs.getInt(1);
			}

		} catch (final SQLException e1) {
			e1.printStackTrace();
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().closeConnection();
		}
		return idEncontrado;
	}

	@Override
	public boolean delete(final Persona p) {
		boolean res = false;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "DELETE FROM " + IPersonaDAO.TABLE + " WHERE + " + IPersonaDAO.COL_ID + "=?";

		try {
			connection = MySqlDAOFactory.getInstance().openConnection();

			pst = connection.prepareStatement(sql);
			pst.setInt(1, p.getId());
			pst.executeUpdate();

			sql = "SELECT MAX(" + IPersonaDAO.COL_ID + ") AS " + IPersonaDAO.COL_ID + " FROM " + IPersonaDAO.TABLE;
			st = connection.createStatement();
			rs = st.executeQuery(sql);

			if (rs != null) {
				res = false;
			} else {
				res = true;
			}
		} catch (final SQLException e1) {
			e1.printStackTrace();
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().closeConnection();
		}
		return res;
	}

	@Override
	public Persona update(final Persona p) {
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		int idEncontrado = -1;
		String sql = "UPDATE " + IPersonaDAO.TABLE + " SET (" + IPersonaDAO.COL_NOMBRE + "=?,"
				+ IPersonaDAO.COL_APELLIDOS + "=?," + IPersonaDAO.COL_FOTO + "=?)" + " WHERE " + IPersonaDAO.COL_ID
				+ "=?";

		try {
			connection = MySqlDAOFactory.getInstance().openConnection();
			pst = connection.prepareStatement(sql);

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellidos());
			pst.setString(3, p.getFoto());

			if (pst.executeUpdate() == 1) {
				sql = "SELECT MAX(" + IPersonaDAO.COL_ID + ") AS " + IPersonaDAO.COL_ID + " FROM " + IPersonaDAO.TABLE;
				st = connection.createStatement();
				rs = st.executeQuery(sql);

				if (rs != null) {
					while (rs.next()) {
						idEncontrado = rs.getInt(IPersonaDAO.COL_ID);
					}
				} else {
					idEncontrado = -1;
				}
			}
		} catch (final SQLException e1) {
			e1.printStackTrace();
		} finally {

			if (pst != null) {
				try {
					pst.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().closeConnection();
		}
		return p;
	}

	private Persona mapeoPersona(final ResultSet rs, final Persona p) throws SQLException {
		p.setId(rs.getInt(IPersonaDAO.COL_ID));
		p.setNombre(rs.getString(IPersonaDAO.COL_NOMBRE));
		p.setApellidos(rs.getString(IPersonaDAO.COL_APELLIDOS));
		p.setFoto(rs.getString(IPersonaDAO.COL_FOTO));
		return p;
	}

}
