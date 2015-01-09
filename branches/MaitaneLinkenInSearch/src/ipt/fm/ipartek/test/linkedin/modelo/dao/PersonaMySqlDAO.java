package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class PersonaMySqlDAO implements IPersonaDAO {

	public static final int COD_ERROR = -1;
	private Connection conexion = null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;

	@Override
	public ArrayList<Persona> getAll() {
		Persona persAuxi = new Persona();
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		try {

			conexion = MySqlDAOFactory.conectar();
			String selectSQL = "SELECT * FROM persona";
			pst = conexion.prepareStatement(selectSQL);

			rs = pst.executeQuery(selectSQL);

			while (rs.next()) {

				persAuxi.setId(rs.getInt("id"));
				persAuxi.setNombre(rs.getString("nombre"));
				persAuxi.setApellido1(rs.getString("apellido1"));
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

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.desconectar();

		}
		return listaPersona;
	}

	@Override
	public Persona getbyId(Persona p) {
		Persona persAuxi = new Persona();

		try {

			conexion = MySqlDAOFactory.conectar();

			String selectSQL = "SELECT * FROM persona WHERE id= ?";
			pst = conexion.prepareStatement(selectSQL);
			pst.setInt(1, p.getId());
			rs = pst.executeQuery(selectSQL);
			while (rs.next()) {
				persAuxi.setId(rs.getInt("id"));
				persAuxi.setNombre(rs.getString("nombre"));
				persAuxi.setApellido1(rs.getString("apellido1"));
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

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.desconectar();

		}
		return persAuxi;
	}

	@Override
	public int insert(Persona p) {

		int id = COD_ERROR;

		try {

			// conectar
			conexion = MySqlDAOFactory.conectar();

			String sqlInsert = "INSERT INTO persona ( nombre, apellido1) VALUES ( ?, ?);";
			pst = conexion.prepareStatement(sqlInsert);

			// sustituir ? por valores de la sentencia SQL del prpeareStatment
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido1());

			// Ejecutar la sentencia
			pst.executeUpdate();

			// seleccionar el id

			String selectSQL = "SELECT id FROM persona WHERE nombre= ? AND apellido1=?";
			pst = conexion.prepareStatement(selectSQL);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido1());
			rs = pst.executeQuery(selectSQL);

			id = rs.getInt("id");

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

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// cerrar conexion

			MySqlDAOFactory.desconectar();

		}

		return id;
	}

	@Override
	public boolean delete(Persona p) {

		boolean rdo = false;
		try {

			conexion = MySqlDAOFactory.conectar();

			String deleteSQL = "DELETE FROM `persona` WHERE id= ?";
			pst = conexion.prepareStatement(deleteSQL);
			pst.setInt(1, p.getId());
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

			MySqlDAOFactory.desconectar();

		}
		return rdo;
	}

	@Override
	public boolean update(Persona p) {
		boolean rdo = false;
		try {

			conexion = MySqlDAOFactory.conectar();

			String updateTableSQL = "UPDATE persona SET nombre = ? , apellido1=?WHERE id = ?";
			pst = conexion.prepareStatement(updateTableSQL);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido1());
			pst.setInt(3, p.getId());
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

			MySqlDAOFactory.desconectar();

		}
		return rdo;
	}

}
