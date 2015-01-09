package ipt.fm.ipartek.test.linkedin.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

public class PersonaMySqlDAO implements IPersonaDAO {
	
	Connection conn;

	@Override
	public ArrayList<Persona> getAll() {
		ArrayList<Persona> personas = null;
		
		conn = MySqlDAOFactory.conectar();
		Statement st = null;
		ResultSet rs = null;
	
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlSelect = "SELECT * FROM persona;";
		
		try {
			rs = st.executeQuery( sqlSelect );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		personas = new ArrayList<Persona>();
		
		
		try {
			String nombre;
			String apellido;
			String foto;
			int id;
			
			while(rs.next()){
				id = rs.getInt("id");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido1");
				foto = rs.getString("foto");
				personas.add(new Persona(id, nombre, apellido, foto));
				
			}

			return personas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getById(Persona p) {
		// TODO Auto-generated method stub
		//return null;
		
		conn = MySqlDAOFactory.conectar();
		Statement st = null;
		ResultSet rs = null;
	
		int id = -1;
		String nombre = null;
		String apellido = null;
		String foto = null;
		
		id = p.getId();
		
		String sqlSelect = "SELECT * FROM persona WHERE id="+id;
		
		
		try {
			rs = st.executeQuery(sqlSelect);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		try {
			if(rs.next()){
				return new Persona(rs.getInt("id"), 
						rs.getString("nombre"),
						rs.getString("apellido1"),
						rs.getString("foto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public Persona insert(Persona p) {
		// TODO Auto-generated method stub
		conn = MySqlDAOFactory.conectar();
		Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nombre = p.getNombre();
		String apellido = p.getApellido();
		String foto = p.getFoto();
		
		
		String sqlInsert = "INSERT INTO persona ( nombre, apellido1, edad, foto) VALUES ( '"+nombre+"', '"+apellido+"',0,'"+foto+"');";
		
		try {
			st.executeUpdate( sqlInsert );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlSelect = "SELECT max(id) FROM persona";
		
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sqlSelect);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		try {
			if(rs.next()){
				p.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean delete(Persona p) {
		// TODO Auto-generated method stub
		conn = MySqlDAOFactory.conectar();
		Statement st = null;
		int id = p.getId();
		
		if(id!=-1){
		
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String sqlDelete = "DELETE FROM persona WHERE id="+id+";";
		
			try {
				st.executeUpdate( sqlDelete );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public Persona update(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}

}
