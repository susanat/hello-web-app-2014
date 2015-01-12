package ipt.fm.ipartek.test.modelo.dao;

/**
 * Factoría abstracta.
 *
 * @author Curso
 *
 */
public abstract class DAOFactory {

	// List of DAO types supported by the factory
	public final static int ACCESS = 1;
	public final static int MYSQL = 2;

	// There will be a method for each DAO that can be created.
	// The concrete factories will have to implement these methods.
	public abstract IPersonaDAO getIPersonaDAO();

	public static DAOFactory getFactoriaDAO(final int tipo) {
		switch (tipo) {
		case MYSQL:
			return MySqlDAOFactory.getInstance();
			// case ACCESS:
			// return new FactoriaAccess();
		default:
			return null;
		}
	}

}
