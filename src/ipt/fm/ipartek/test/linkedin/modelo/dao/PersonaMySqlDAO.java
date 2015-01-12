package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonaMySqlDAO implements IPersonaDAO {
	Connection conexion = null;

	private String SQL_GET_ALL = "SELECT * FROM " + IPersonaDAO.TABLA;
	private String SQL_GET_BY_ID = "SELECT * FROM " + IPersonaDAO.TABLA
			+ " WHERE " + IPersonaDAO.COL_ID + " = ?";
	private String SQL_GET_BY_NOMBRE_APELLIDOS = "SELECT " + IPersonaDAO.COL_ID
			+ " FROM " + IPersonaDAO.TABLA + " WHERE " + IPersonaDAO.COL_NOMBRE
			+ " = ? AND " + IPersonaDAO.COL_APELLIDOS + " = ?";
	private String SQL_INSERT = "INSERT INTO " + IPersonaDAO.TABLA + " ("
			+ IPersonaDAO.COL_NOMBRE + ", " + IPersonaDAO.COL_APELLIDOS + ", "
			+ IPersonaDAO.COL_FOTO + ") VALUES (?, ?, ?)";
	private String SQL_UPDATE_BY_ID = "UPDATE " + IPersonaDAO.TABLA + " SET "
			+ IPersonaDAO.COL_NOMBRE + "=?, " + IPersonaDAO.COL_APELLIDOS
			+ "=?, " + IPersonaDAO.COL_FOTO + "=? WHERE " + IPersonaDAO.COL_ID
			+ "=?";
	private String SQL_DELETE_BY_ID = "DELETE FROM " + IPersonaDAO.TABLA
			+ " WHERE " + IPersonaDAO.COL_ID + "=?";

	@Override
	public ArrayList<Persona> getAll() {
		ArrayList<Persona> resul = new ArrayList<Persona>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// obtener conexion
			conexion = MySqlDAOFactory.getInstance().conectar();
			// crear PreparedStatement
			pst = conexion.prepareStatement(SQL_GET_ALL);
			// ejecutar Statement y recoger ResultSet
			rs = pst.executeQuery();
			// recorrer ResultSet
			Persona p = null;
			while (rs.next()) {
				// mapear ResultSet a Persona
				p = mapeo(rs, new Persona());
				// insertar persona en ArrayList
				resul.add(p);
				p = null;
			}
			// cerrar ResultSet y Statement

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			resul = null;
			e.printStackTrace();
		} finally {
			// cerrar ResultSet y Statement
			cerrarConexion(pst, rs);
		}
		return resul;
	}

	@Override
	public Persona getById(Persona p) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try{
			conexion = MySqlDAOFactory.getInstance().conectar();
			pst = conexion.prepareStatement(SQL_GET_BY_ID);
			pst.setInt(1, p.getId());

			rs = pst.executeQuery();
			if (rs.next()) {
				p = mapeo(rs, new Persona());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarConexion(pst, rs);
		}
		return p;
	}

	@Override
	public int getByNombreApellidos(Persona p) {
		int indPersona = -1;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conexion = MySqlDAOFactory.getInstance().conectar();
			pst = conexion.prepareStatement(SQL_GET_BY_NOMBRE_APELLIDOS);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellidos());

			rs = pst.executeQuery();
			if (rs.next()) {
				indPersona = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarConexion(pst, rs);
		}

		return indPersona;
	}

	@Override
	public int insert(Persona p) {
		// En caso de que se produzca un fallo
		int indPersona=-1;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conexion = MySqlDAOFactory.getInstance().conectar();
			// crear PreparedStatement y que retorne KEYS generadas
			pst = conexion.prepareStatement(SQL_INSERT,
					Statement.RETURN_GENERATED_KEYS);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellidos());
			pst.setString(3, p.getFoto());

			// realizar la insercion
			pst.executeUpdate();

			// obtener el ID generado
			rs = pst.getGeneratedKeys();
			// recorrer resultSet
			if (rs.next()) {
				indPersona = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarConexion(pst, rs);
		}

		// TODO Implementar
		return indPersona;
	}

	@Override
	public boolean delete(Persona p) {
		boolean bBorrado = false;
		PreparedStatement pst = null;

		try {
			conexion = MySqlDAOFactory.getInstance().conectar();
			pst = conexion.prepareStatement(SQL_DELETE_BY_ID);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			pst.setInt(1, p.getId());

			// 4.- Ejecutar la sentencia
			int numEliminados = pst.executeUpdate();
			bBorrado = (numEliminados == 0) ? false : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarConexion(pst, null);
		}

		return bBorrado;
	}

	@Override
	public boolean update(Persona p) {
		boolean bModificado = false;
		PreparedStatement pst = null;

		try {
			conexion = MySqlDAOFactory.getInstance().conectar();
			pst = conexion.prepareStatement(SQL_UPDATE_BY_ID);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellidos());
			pst.setString(3, p.getFoto());
			pst.setInt(4, p.getId());

			// 4.- Ejecutar la sentencia
			int nModificados = pst.executeUpdate();
			bModificado = (nModificados == 0) ? false : true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarConexion(pst, null);
		}
		return bModificado;
	}

	/**
	 * Mapeamos una tupla de la tabla 'persona' a un bean Persona
	 * 
	 * @param rs
	 *            ResultSet resultados de la consulta
	 * @param p
	 *            Persona donde se cargaran los datos de la BBDD
	 * @return persona cargada con los datos de la consulta
	 * @throws SQLException
	 */
	private Persona mapeo(ResultSet rs, Persona p) throws SQLException {
		p.setId(rs.getInt(IPersonaDAO.COL_ID));
		p.setNombre(rs.getString(IPersonaDAO.COL_NOMBRE));
		p.setApellidos(rs.getString(IPersonaDAO.COL_APELLIDOS));
		p.setFoto(rs.getString(IPersonaDAO.COL_FOTO));

		return p;
	}

	private void cerrarConexion(PreparedStatement pst, ResultSet rs) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		MySqlDAOFactory.getInstance().desconectar();
	}


}
