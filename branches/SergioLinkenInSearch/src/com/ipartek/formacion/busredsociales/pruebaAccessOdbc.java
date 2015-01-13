package com.ipartek.formacion.busredsociales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pruebaAccessOdbc {
	
	public static void main(String[] args)  {
		
		/*try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conexion = DriverManager
					.getConnection("jdbc:odbc:srncodesnippet_origen");
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while (rs.next()) {
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
			}
		} catch (Exception e) {
			System.out.println("Algun error en algun sitio");
			e.printStackTrace();
		}*/
		
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try{			
			
			//conectamos a base de datos (conexión directa)		 
			Class.forName("com.mysql.jdbc.Driver"); //Establecemos la conexión con la base de datos. 
			conexion = (Connection)	DriverManager.getConnection ("jdbc:mysql://localhost/test","root", "");
			
			conexion.setAutoCommit(false);
			
			
			String sql = "INSERT INTO `transacciones` (`id`, `cod_trans`, `fecha`) VALUES (NULL, ?, CURRENT_TIMESTAMP);";
			
			
			for (int i = 0; i < 10000; i++) {
				pst = conexion.prepareStatement(sql, new String[] { "id" });
				// añadimos los campos
				pst.setInt(1, i);
				
				if(i == 3000) {
					throw new Exception("Casco por que me da la gana");
				}
				
				//realizamos la operación
				   int res = pst.executeUpdate();
				   
				   //obtenemos la/s última key insertada
				   if(res > 0) {
					  
					   //obtenemos el rs con las últimas claves insertadas
					   rs = pst.getGeneratedKeys();			  			  
					   rs.next();
					  
					   //recogemos el último id
					   int auto_id = rs.getInt(1);
					  
					   System.out.println("Insertada fila (sin transacción) número: " + i + " con el id " + auto_id);
					  					  
				   }
				   
				   
			}
			
			conexion.commit();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally {
			if(rs != null) {
				rs = null;
			}
			
			
			if (pst!=null) {
				pst = null;
			}
			
			if (conexion != null) {				
				conexion = null;
			}
		}
		
		
		
		
		
		
		
		
		
		

	}

}
