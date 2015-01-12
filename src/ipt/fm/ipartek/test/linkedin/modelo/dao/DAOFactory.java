package ipt.fm.ipartek.test.linkedin.modelo.dao;

public abstract class DAOFactory {

	// DAOs.
	public abstract IPersonaDAO getPersonaDAO();

	// Tipos de bases de datos.
	public final static int ACCESS = 1;
	public final static int MYSQL = 2;

	public static DAOFactory getFactoryDAO(int tipo) {
		switch (tipo) {
		case MYSQL:
			return MySqlDAOFactory.getInstance();
			/*
			 * case ACCESS: return new FactoriaAccess();
			 */
		}
		return null;
	}
}
