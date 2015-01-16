

import static org.junit.Assert.assertEquals;
import ipt.fm.ipartek.test.linkedin.bean.Persona;

import org.junit.Test;

public class TestFactoriaMySQL {


	@Test
	public void testInsertar() {
		DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IPersonaDAO daoPersona = factoria.getPersonaDAO();
		int nIndice = 1;
		
		Persona p=new Persona("aitor", "bermudez");
		assertEquals(nIndice++, daoPersona.insert(p));

		Persona p2=new Persona("borja", "carlington");
		assertEquals(nIndice++, daoPersona.insert(p2));
		
	}

}
