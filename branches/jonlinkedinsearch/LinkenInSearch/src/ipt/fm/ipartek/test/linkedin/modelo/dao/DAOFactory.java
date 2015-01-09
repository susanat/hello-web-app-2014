package ipt.fm.ipartek.test.linkedin.modelo.dao;

	// Abstract class DAO Factory
public abstract class DAOFactory {

	  // List of DAO types supported by the factory
	  public static final int ACCESS = 1;
	  public static final int MYSQL = 2;
	
	  // There will be a method for each DAO that can be 
	  // created. The concrete factories will have to 
	  // implement these methods.
	  public abstract IPersonaDAO getPersonaDAO();
	
	  public static DAOFactory getDAOFactory(
	      int whichFactory) {
	  
	    switch (whichFactory) {
	    /*  case ACCESS: 
	          return new AccessDAOFactory();
	     */
	      case MYSQL: 
	          return new MySqlDAOFactory();      
	      default           : 
	          return null;
	    }
	  }
	}



