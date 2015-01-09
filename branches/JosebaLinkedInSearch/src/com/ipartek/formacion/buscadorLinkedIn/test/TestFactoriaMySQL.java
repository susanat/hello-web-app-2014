package com.ipartek.formacion.buscadorLinkedIn.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.buscadorLinkedIn.bean.Persona;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.DAOFactory;
import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

public class TestFactoriaMySQL {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetByID() {
	DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);
	IPersonaDAO DAOPersona = factoria.getPersonaDAO();
	Persona p = new Persona("", "");
	p = DAOPersona.getByID(p);

	assertEquals("Pepe", p.getNombre());
	assertEquals("Gorriti", p.getApellidos());

    }

}
