import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransaccionNOatomica {

	static final int NUM_TRANS = 10000;
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String CON_URL = "jdbc:mysql://localhost:3306/transacciones";
	static final String CON_USER = "root";
	static final String CON_PASS = "";
	static final String SQL = "INSERT INTO `batch` (`cod_trans`) VALUES (?);";
	
	
	public static void main(String[] args) {
		
		System.out.println("Comenzamos procesp batch");
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			
			//cargar driver
			Class.forName(DRIVER);
			//obtener conexion
			con = DriverManager.getConnection(CON_URL,CON_USER,CON_PASS);
			
			//insertar transacciones
			for (int i=0; i < NUM_TRANS ; i++){
				
				
				if ( i == 3000 ){
					throw new Exception("Falla durante el proceso batch");
				}
				
				//preparar el statement
				pst = con.prepareStatement(SQL);
				pst.setInt(1, i);
				
				//realizar inserccion
				if ( 1 != pst.executeUpdate() ){
					throw new Exception("NO se ha realizado la inserccion de forma correcta");
				}
				
				
			}
			
			
		}catch ( Exception e){
			e.printStackTrace();
			
		}finally{
			if ( pst !=null ){
				try {
					pst.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
			
			if ( con != null ){
				try {
					con.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		System.out.println("Finalizamos proceso batch");

	}

}
