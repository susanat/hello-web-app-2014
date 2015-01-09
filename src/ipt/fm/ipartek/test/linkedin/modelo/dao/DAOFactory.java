package ipt.fm.ipartek.test.linkedin.modelo.dao;

public abstract class DAOFactory {
	public abstract IPersonaDAO getPersonaDAO();

	public static final int ACCESS = 1;
	public static final int MYSQL = 2;

	public static DAOFactory getDAOFactory(int tipo) {

		switch (tipo) {
		case MYSQL:
			return new MySqlDAOFactory();
		default:
			return null;
		}
	}
}
