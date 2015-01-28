package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void testSession() {

		Session sesion = HibernateUtil.getSession();		
		sesion.close();
		assertTrue("No se ha podido obtener session de Hibernate",true);
		
	}

}
