package ipt.fm.ipartek.test.linkedin.modelo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class TestFactoriaMySQL {

	@Test
	public void testGetByID() throws Exception {
		
		
		  // Create initial context
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
            "org.apache.naming.java.javaURLContextFactory");
        System.setProperty(Context.URL_PKG_PREFIXES, 
            "org.apache.naming");            
        InitialContext ic = new InitialContext();

        ic.createSubcontext("java:");
        ic.createSubcontext("java:/comp");
        ic.createSubcontext("java:/comp/env");
        ic.createSubcontext("java:/comp/env/jdbc/TestDB");
       
        // Construct DataSource
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL("jdbc:mysql://localhost:3306/test");
        ds.setUser("root");
        ds.setPassword("");
        
        ic.bind("java:/comp/env/jdbc/TestDB", ds);
		
		
			
		DAOFactory factoria =  DAOFactory.getDAOFactory(DAOFactory.MYSQL );		
		IPersonaDAO daoPersona = factoria.getPersonaDAO();
		
		Persona p = new Persona(-1,"pepe", "Gorriti",-1,"");
		int id = daoPersona.insert(p);
		
		assertTrue(" ID inserccion negativo ", id > 0 );
		
		p = daoPersona.getById(p);
		
		assertEquals("pepe", p.getNombre());
		assertEquals("Gorriti", p.getApellido() );
		
		
	 
	}
}
