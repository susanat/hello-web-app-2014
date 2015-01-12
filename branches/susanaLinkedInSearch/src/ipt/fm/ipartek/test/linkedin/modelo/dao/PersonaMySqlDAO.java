package ipt.fm.ipartek.test.linkedin.modelo.dao;

import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PersonaMySqlDAO implements IPersonaDAO {

    Connection con = null;
    private String  SQL_GET_ALL = "select * from persona"+ IPersonaDAO.TABLA;
    private String  SQL_GET_BY_ID = "select * from persona"+ IPersonaDAO.TABLA + "where"
	    + IPersonaDAO.COL_ID + "=?" ;
    
	@Override
	public ArrayList<Persona> getAll() {
	    
	    ArrayList<Persona> resul = new ArrayList<Persona>();
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    	    
	    	try{
        	    	//Obtener conexion
        		    con = (Connection) MySqlDAOFactory.getInstance().conectar();
        		    
        		//crear PrepsaredStatement
        		    pst = (PreparedStatement) con.prepareStatement(SQL_GET_ALL);
        		    
        		//executar statement y recoger Statement
        		    rs =pst.executeQuery();
		    
		//recorrer resultSet
        
        		    Persona p = null;
		while(rs.next()){
		    //mapear resultset a Persona
		   p=mapeo (rs, new Persona());

		    //insetar persona en ArrayList
		    resul.add(p);
		    p=null;
		    
		}
		   
		//cerrar resultset y statement
	    	}catch (Exception e){
	    	    e.printStackTrace();
	    	}finally{
	    	    //cerrar resultset y statement
	    	    if(pst !=null){
	    		try{
	    		    pst.close();
	    		}catch (SQLException e){
	    		    e.printStackTrace();
	    		}
	    	    }
	    	    
	    	 if(rs !=null){
	    		try{
	    		   rs.close();
	    		}catch (SQLException e){
	    		    e.printStackTrace();
	    		}
	    	    }
	    	    
	    	    //desconectar
	    	MySqlDAOFactory.getInstance().desconectar();
	    	}
		return resul;
	}
	
	//crear el stanments

	@Override
	public Persona getById(Persona p) {	
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    	    
	    	try{
        	    	//Obtener conexion
        		    con = (Connection) MySqlDAOFactory.getInstance().conectar();
        		    
        		//crear PrepsaredStatement
        		    pst = (PreparedStatement) con.prepareStatement(SQL_GET_BY_ID);
        		   pst.setInt(1, p.getId()); 
        		//executar statement y recoger Statement
        		    rs =pst.executeQuery();
		    
		//recorrer resultSet
        
		while(rs.next()){
		    //mapear resultset a Persona
		   p=mapeo (rs, new Persona());
		    
		}
		   
		//cerrar resultset y statement
	    	}catch (Exception e){
	    	    e.printStackTrace();
	    	}finally{
	    	    //cerrar resultset y statement
	    	    if(pst !=null){
	    		try{
	    		    pst.close();
	    		}catch (SQLException e){
	    		    e.printStackTrace();
	    		}
	    	    }
	    	    
	    	 if(rs !=null){
	    		try{
	    		   rs.close();
	    		}catch (SQLException e){
	    		    e.printStackTrace();
	    		}
	    	    }
	    	    
	    	    //desconectar
	    	MySqlDAOFactory.getInstance().desconectar();
	    	}
		return p;
	}

	@Override
	public Persona insert(Persona p) {
		// TODO implementar
		return null;
	}

	@Override
	public boolean delete(Persona p) {
		// TODO implementar
		return false;
	}

	@Override
	public Persona update(Persona p) {
		// TODO implementar
		return null;
	}
	
	/**
	 * Mapeamos un atupla de la tabla 'persona' a un bean Persona
	 * @param rs ResultSet resultados de la consulta
	 * @param p Persona donde se cargaran los datos de la BBDD
	 * @return persona cargada con los datos de la consulta
	 * @throws SQLException
	 */

	private Persona mapeo( ResultSet rs, Persona p) throws SQLException{
	   
	    p.setId(rs.getInt(IPersonaDAO.COL_ID));
	    p.setNombre(rs.getString(IPersonaDAO.COL_NOMBRE));
	    p.setApellidos(rs.getString(IPersonaDAO.COL_APELLIDOS));
	    p.setFoto(rs.getString(IPersonaDAO.COL_FOTO));
	    
	    return p;
	}
}
