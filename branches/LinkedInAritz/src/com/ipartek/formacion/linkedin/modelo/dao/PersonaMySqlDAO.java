package com.ipartek.formacion.linkedin.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

public class PersonaMySqlDAO implements IPersonaDAO {

	Connection con = null;

	private String SQL_GET_ALL = "select * from " + IPersonaDAO.TABLA;
	private String SQL_GET_BY_ID = "select * from " + IPersonaDAO.TABLA
			+ "where " + IPersonaDAO.COL_ID + " = ?";
	private String SQL_INSERT = "INSERT INTO " + IPersonaDAO.TABLA + " ( "
			+ IPersonaDAO.COL_NOMBRE + ", " + IPersonaDAO.COL_APELLIDOS + ", "
			+ IPersonaDAO.COL_FOTO + ") VALUES (?,?,?)";
	private String SQL_DELETE = "DELETE from " + IPersonaDAO.TABLA + " where "
			+ IPersonaDAO.COL_ID + " = ?";
	private String SQL_UPDATE = "update " + IPersonaDAO.TABLA + " set "
			+ IPersonaDAO.COL_NOMBRE + " = 'pepito', "
			+ IPersonaDAO.COL_APELLIDOS + "= 'try', " + IPersonaDAO.COL_FOTO
			+ " = 'ert' where " + IPersonaDAO.COL_NOMBRE + " = ?";

	@Override
	public ArrayList<Persona> getAll() throws ModelException {

		ArrayList<Persona> resul = new ArrayList<Persona>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			// obtener conexion
			con = MySqlDAOFactory.getInstance().conectar();

			// crear prepareStatement
			pst = con.prepareStatement(SQL_GET_ALL);

			// ejecutar statement y recoger resultset
			rs = pst.executeQuery();

			// recorrer resultset
			Persona p = null;
			while (rs.next()) {

				// mapear resultset a persona
				p = mapeo(rs, new Persona());
				// insertar persona en arraylist
				resul.add(p);
				p = null;
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new ModelException(e.getMessage());

		} finally {

			// cerrar resultset y statement en orden inverso de creacion
			// cerrar Statement
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// cerrar ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().desconectar();
		}

		return resul;

	}

	@Override
	public Persona getById(Persona p) {

		// Persona p = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			// obtener conexion
			con = MySqlDAOFactory.getInstance().conectar();

			// crear prepareStatement
			pst = con.prepareStatement(SQL_GET_BY_ID);
			pst.setInt(1, p.getId());

			// ejecutar statement y recoger resultset
			rs = pst.executeQuery();

			// recorrer resultset

			while (rs.next()) {

				// mapear resultset a persona
				p = mapeo(rs, new Persona());

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// cerrar resultset y statement en orden inverso de creacion
			// cerrar Statement
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// cerrar ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().desconectar();
		}

		return p;

	}

	@Override
	public synchronized int insert(Persona p) {

		int resul = -1;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			// obtener conexion
			con = MySqlDAOFactory.getInstance().conectar();

			// crear prepareStatement y q retorne key generadas
			pst = con.prepareStatement(SQL_INSERT,
					Statement.RETURN_GENERATED_KEYS);

			// sustituir ? por valores en la sentencia sql del prepareStatement
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido());
			pst.setString(3, p.getUrl_foto());

			// ejecutar statement y recoger resultset
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(
						"Fallo al crear el usuario, ninguna fila affecteda.");
			}

			// obtener el id generado
			try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					resul = generatedKeys.getInt(1);
				} else {
					throw new SQLException(
							"Fallo al crear el usuario, ningun ID obtenido.");
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// cerrar resultset y statement en orden inverso de creacion
			// cerrar Statement
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// cerrar ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().desconectar();
		}

		return resul;

	}

	@Override
	public synchronized boolean delete(Persona p) {

		boolean resul = false;

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			// obtener conexion
			con = MySqlDAOFactory.getInstance().conectar();

			// crear prepareStatement
			pst = con.prepareStatement(SQL_DELETE);
			pst.setInt(1, p.getId());

			// ejecutar statement y recoger resultset
			pst.executeUpdate();
			resul = true;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// cerrar resultset y statement en orden inverso de creacion
			// cerrar Statement
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// cerrar ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().desconectar();
		}

		return resul;
	}

	@Override
	public synchronized boolean update(Persona p) {

		boolean resul = false;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			// obtener conexion
			con = MySqlDAOFactory.getInstance().conectar();

			// crear prepareStatement
			pst = con.prepareStatement(SQL_UPDATE);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido());
			pst.setInt(3, p.getEdad());
			pst.setInt(4, p.getId());

			// ejecutar statement y recoger resultset
			pst.executeUpdate();
			resul = true;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// cerrar resultset y statement en orden inverso de creacion
			// cerrar Statement
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// cerrar ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			MySqlDAOFactory.getInstance().desconectar();
		}

		return resul;
	}

	/**
	 * mapeamos una tabla de la tabla persona a u n bean persona
	 *
	 * @param rs
	 *            resultset resultado de la consulta
	 * @param p
	 *            persona donde se cargaran los datos de la bbdd
	 * @return persona cargada en los datos de la consulta
	 * @throws SQLException
	 */
	private Persona mapeo(ResultSet rs, Persona p) throws SQLException {

		p.setId(rs.getInt(COL_ID));
		p.setNombre(rs.getString(COL_NOMBRE));
		p.setApellido(rs.getString(COL_APELLIDOS));
		p.setUrl_foto(rs.getString(COL_FOTO));

		return p;

	}

}
