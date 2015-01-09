package ipt.fm.ipartek.test.linkedin.modelo.dao;

import static org.junit.Assert.*;
import ipt.fm.ipartek.test.linkedin.bean.Persona;

import org.junit.Test;

public class TestFactoriaMySQL {

	@Test
	public void testGetByID() {
		
		DAOFactory factoria =  DAOFactory.getFactoriaDAO( DAOFactory.MYSQL );		
		IPersonaDAO daoPersona = factoria.getPersonaDAO();
		
		Persona p = new Persona("", "");
		
		p = daoPersona.getById(p);
		
		assertEquals("pepe", p.getNombre());
		assertEquals("Gorriti", p.getApellidos() );
		
		
	 
	}
}
