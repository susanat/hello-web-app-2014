import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransaccionAtomica {

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
			
			//marcar coneexion como NO autocomitable
			con.setAutoCommit(false);
			
			//insertar transacciones
			for (int i=0; i < NUM_TRANS ; i++){
				
				
				if ( i == 3000 ){
					throw new Exception("Falla durante el proceso batch");
				}
				
				
				//preparar el statement
				pst = con.prepareStatement(SQL);
				pst.setInt(1, i);
				
				System.out.println("    procesando " + i);
				//realizar inserccion
				if ( 1 != pst.executeUpdate() ){
					throw new Exception("NO se ha realizado la inserccion de forma correcta");
				}
				
				
			}//end: for
			
			//comito todas las sentencias DML
			con.commit();
			System.out.println("Guardamos TODO en BBDD");
			
		}catch ( Exception e){
			try {				
				con.rollback();
				System.out.println(" No guardamos nada en BBDD");
			} catch (SQLException e1) {
				System.out.println("*** Exception ROLLBACK");
				e1.printStackTrace();
			}
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
