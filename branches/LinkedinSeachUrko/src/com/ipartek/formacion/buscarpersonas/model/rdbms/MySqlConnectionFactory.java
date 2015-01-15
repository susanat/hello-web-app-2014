package com.ipartek.formacion.buscarpersonas.model.rdbms;

import com.ipartek.formacion.buscarpersonas.exception.ModelException;
import com.ipartek.formacion.buscarpersonas.model.DAOFactory;
import com.ipartek.formacion.buscarpersonas.model.IConnection;
import com.ipartek.formacion.buscarpersonas.model.IConnectionFactory;
import com.ipartek.formacion.buscarpersonas.model.IPersonaDAO;

public class MySqlConnectionFactory extends DAOFactory implements
	IConnectionFactory {
    private static MySqlConnectionFactory INSTANCE = null;

    private MySqlConnectionFactory() {
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void createInstance() {
	if (INSTANCE == null) {
	    INSTANCE = new MySqlConnectionFactory();
	}
    }

    public static MySqlConnectionFactory getInstance() {
	if (INSTANCE == null) {
	    createInstance();
	}
	return INSTANCE;
    }

    @Override
    public IConnection getIConnection() throws ModelException {
	// MySqlConnection mysqlCon = MySqlConnection.getInstance();
	// mysqlCon.connect();
	return MySqlConnection.getInstance();
    }

    @Override
    public IPersonaDAO getIPersonaDAO(final int whichFactory) {
	// TODO Auto-generated method stub
	return new PersonaDAO(whichFactory);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
	throw new CloneNotSupportedException();
    }

}
