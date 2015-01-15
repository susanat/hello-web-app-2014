package com.ipartek.formacion.busredsociales.dao.factoria;

import java.sql.SQLException;

/**
 * Exception thrown when something goes wrong in the DAO/ORM layer.
 *
 * @author Markus
 *
 */
public class DAOException extends SQLException {
	private static final long serialVersionUID = -5877937327907457779L;

	public DAOException() {
	}

	public DAOException(String error) {
		super(error);
	}

	public DAOException(String error, Throwable cause) {
		super(error);
		safeInitCause(cause);
	}

	public DAOException(Throwable th) {
		safeInitCause(th);
	}

	protected void safeInitCause(Throwable cause) {
		try {
			initCause(cause);
		} catch (Throwable e) {
			
			e.printStackTrace();
			
			//DaoLog.e("Could not set initial cause", e);
			//DaoLog.e("Initial cause is:", cause);
		}
	}
}