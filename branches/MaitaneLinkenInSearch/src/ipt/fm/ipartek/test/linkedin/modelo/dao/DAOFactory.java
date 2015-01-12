package ipt.fm.ipartek.test.linkedin.modelo.dao;

/**
 * Factoria abstracta
 * 
 * @author Maitane Casado
 *
 */

public abstract class DAOFactory {

	// DAOs
	public abstract IPersonaDAO getPersonaDAO();

	// Tipo de BBDD
	public final static int ACCESS = 1;
	public final static int MYSQL = 2;

	public static DAOFactory getFactoriaDAO(int tipo) {
		switch (tipo) {
		case MYSQL:
			return MySqlDAOFactory.getInstance();
			/*
			 * case ACCESS: return new FactoriaAccess();
			 */

		default:
			return null;
		}
	}

}