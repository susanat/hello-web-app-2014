package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class PersonaMySqlDAO implements IPersonaDAO {

	public static final int COD_ERROR = -1;
	private Connection conexion = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String selectSQL_All = "SELECT * FROM " + IPersonaDAO.TABLA;
	private String selectSQL_BY_ID = "SELECT * FROM " + IPersonaDAO.TABLA
			+ " WHERE " + IPersonaDAO.COL_ID + "= ?";
	private String sqlInsert = "INSERT INTO " + IPersonaDAO.TABLA + " ( "
			+ IPersonaDAO.COL_NOMBRE + ", " + IPersonaDAO.COL_APELLIDOS + ","
			+ IPersonaDAO.COL_FOTO + ") VALUES (?, ?, ?)";
	private String selectSQL_Pers_ID = "SELECT " + IPersonaDAO.COL_ID
			+ " FROM " + IPersonaDAO.TABLA + " WHERE " + IPersonaDAO.COL_NOMBRE
			+ "= ?" + "AND " + IPersonaDAO.COL_APELLIDOS + "= ?";
	private String deleteSQL = "DELETE FROM " + IPersonaDAO.TABLA + " WHERE "
			+ IPersonaDAO.COL_ID + " = ?";
	private String updateTableSQL = "UPDATE " + IPersonaDAO.TABLA + " SET "
			+ IPersonaDAO.COL_NOMBRE + " = ? , " + IPersonaDAO.COL_APELLIDOS
			+ " = ? , " + IPersonaDAO.COL_FOTO + "=? WHERE "
			+ IPersonaDAO.COL_ID + " = ?";
	private String selectSQL_ID_PERS = "SELECT " + IPersonaDAO.COL_ID
			+ " FROM " + IPersonaDAO.TABLA + " WHERE " + IPersonaDAO.COL_NOMBRE
			+ " = ? AND " + IPersonaDAO.COL_APELLIDOS + " = ?";

	@Override
	public ArrayList<Persona> getAll() {
		Persona persAuxi = new Persona();
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		try {

			conexion = MySqlDAOFactory.getInstance().conectar();

			pst = conexion.prepareStatement(selectSQL_All);

			rs = pst.executeQuery(selectSQL_All);

			while (rs.next()) {
				persAuxi = mapeo(rs, persAuxi);
				listaPersona.add(persAuxi);
			}
		}

		catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			// cerrar ResultSet

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar Statements

			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.getInstance().desconectar();

		}
		return listaPersona;
	}

	@Override
	public Persona getbyId(Persona p) {
		Persona persAuxi = new Persona();

		try {

			conexion = MySqlDAOFactory.getInstance().conectar();

			pst = conexion.prepareStatement(selectSQL_BY_ID);
			pst.setInt(1, p.getId());
			rs = pst.executeQuery(selectSQL_BY_ID);
			while (rs.next()) {
				persAuxi = mapeo(rs, persAuxi);
			}
		}

		catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			// cerrar ResultSet

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar Statements

			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.getInstance().desconectar();

		}
		return persAuxi;
	}

	@Override
	public int insert(Persona p) {

		int id = COD_ERROR;

		try {

			// conectar
			conexion = MySqlDAOFactory.getInstance().conectar();

			// crear PreparesStatment y que retorne KEYS generadas
			pst = conexion.prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);

			// sustituir ? por valores de la sentencia SQL del prpeareStatment

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido1());
			pst.setString(3, p.getFoto());

			// Ejecutar la insercion
			pst.executeUpdate();

			// seleccionar el id
			/*
			 * pst = conexion.prepareStatement(selectSQL_Pers_ID);
			 * pst.setString(1, p.getNombre()); pst.setString(2,
			 * p.getApellido1()); rs = pst.executeQuery(selectSQL_Pers_ID);
			 */

			rs = pst.getGeneratedKeys();
			// recorrer ResultSet
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally { // cerrar todos los objetos creados para el acceso a BBDD

			// cerrar ResultSet

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar Statements

			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.getInstance().desconectar();

		}

		return id;
	}

	@Override
	public boolean delete(Persona p) {

		boolean rdo = false;
		try {

			conexion = MySqlDAOFactory.getInstance().conectar();

			/*
			 * pst = conexion.prepareStatement(selectSQL_ID_PERS);
			 * pst.setString(1, p.getNombre()); pst.setString(2,
			 * p.getApellido1()); // pst.setString(3, p.getFoto()); rs =
			 * pst.executeQuery(); while (rs.next()) { id = rs.getInt(1); }
			 */
			int id = buscarID_Persona(p, conexion);
			pst = conexion.prepareStatement(deleteSQL);
			pst.setInt(1, id);
			pst.executeUpdate();

			if (id != COD_ERROR) {
				rdo = true;
			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			// cerrar Statements

			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.getInstance().desconectar();

		}
		return rdo;
	}

	@Override
	public boolean update(Persona p) {
		boolean rdo = false;
		try {

			conexion = MySqlDAOFactory.getInstance().conectar();

			pst = conexion.prepareStatement(updateTableSQL);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido1());
			pst.setString(3, p.getFoto());
			pst.setInt(4, p.getId());
			pst.executeUpdate();

			rdo = true;

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			// cerrar Statements

			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.getInstance().desconectar();

		}
		return rdo;
	}

	/**
	 * Mapeamos la tupla de la tabla 'persona' a un bean Persona
	 * 
	 * @param rs
	 *            ResultSet resultados de la consulta
	 * @param persAuxi
	 *            Persona donde se cargaran los datos de la BBDD
	 * @return Persona caragada con los datos de la consulta
	 * @throws SQLException
	 */
	private Persona mapeo(ResultSet rs, Persona persAuxi) throws SQLException {
		persAuxi.setId(rs.getInt(IPersonaDAO.COL_ID));
		persAuxi.setNombre(rs.getString(IPersonaDAO.COL_NOMBRE));
		persAuxi.setApellido1(rs.getString(IPersonaDAO.COL_APELLIDOS));
		persAuxi.setFoto(rs.getString(IPersonaDAO.COL_FOTO));

		return persAuxi;

	}

	private int buscarID_Persona(Persona p, Connection conexion) {
		int id = COD_ERROR;

		try {

			pst = conexion.prepareStatement(selectSQL_ID_PERS);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido1());
			// pst.setString(3, p.getFoto());
			rs = pst.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		}

		catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			// cerrar ResultSet

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar Statements

			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return id;
	}

}
