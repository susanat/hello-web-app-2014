package ipt.fm.ipartek.test.modelo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ipt.fm.ipartek.test.bean.Persona;

import org.junit.Test;

public class TestMySqlDAOFactory {

	@Test
	public void testGetById() {
		final DAOFactory factory = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
		final IPersonaDAO daoPersona = factory.getIPersonaDAO();

		Persona p = new Persona("", "");
		p = daoPersona.getById(p);

		assertEquals("Pepe", p.getNombre());
		assertEquals("Gorriti", p.getApellidos());

		assertTrue(daoPersona.insert(p) > 0);
	}

}
