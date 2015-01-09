package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.FactoriaMySql;
import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaMySqlDAO implements IPersonaDAO {

	@Override
	public ArrayList<Persona> getAll() {
		ArrayList<Persona> vPersonas = null;

		String sqlTxt = "SELECT * FROM persona;";
		try {
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st = conexion.prepareStatement(sqlTxt);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int nId = rs.getInt(1);
				Persona persona = new Persona(rs.getString(2), rs.getString(3));
				persona.setId(nId);
				vPersonas.add(persona);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			vPersonas = null;
			e.printStackTrace();
		}
		return vPersonas;
	}

	@Override
	public Persona getById(Persona p) {
		Persona persona=null;
		
		String sqlTxt="SELECT * FROM persona where nombre=? OR apellidos=?;";
		try{
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st=conexion.prepareStatement(sqlTxt);
			st.setString(1, p.getNombre());
			st.setString(2, p.getApellidos());

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int nId = rs.getInt(1);
				persona = new Persona(rs.getString(2), rs.getString(3));
				persona.setId(nId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persona;
	}

	@Override
	public int insert(Persona p) {
		int indPersona=-1;

		String sqlTxt = "INSERT INTO persona (nombre, apellidos) VALUES (?, ?);";
		try {
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st = conexion.prepareStatement(sqlTxt);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			st.setString(1, p.getNombre());
			st.setString(2, p.getApellidos());

			// 4.- Ejecutar la sentencia
			indPersona=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Implementar
		return indPersona;
	}

	@Override
	public boolean delete(Persona p) {
		boolean bBorrado = false;

		String sqlTxt = "DELETE FROM personas WHERE id=?;";
		try {
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st = conexion.prepareStatement(sqlTxt);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			st.setInt(1, p.getId());

			// 4.- Ejecutar la sentencia
			int numEliminados = st.executeUpdate();
			bBorrado = (numEliminados == 0) ? false : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bBorrado;
	}

	@Override
	public boolean update(Persona p) {
		boolean bModificado = false;

		String sqlTxt = "UPDATE persona SET nombre=?, apellidos=? where id=?;";
		try {
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st = conexion.prepareStatement(sqlTxt);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			st.setString(1, p.getNombre());
			st.setString(2, p.getApellidos());
			st.setInt(3, p.getId());

			// 4.- Ejecutar la sentencia
			int nModificados = st.executeUpdate();
			bModificado = (nModificados == 0) ? false : true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bModificado;
	}

}
