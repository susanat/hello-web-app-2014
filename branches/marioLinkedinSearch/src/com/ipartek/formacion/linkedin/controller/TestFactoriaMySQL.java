package com.ipartek.formacion.linkedin.controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;

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

	DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	IPersonaDAO daoPersona = factoria.getPersonaDAO();

	Persona p = new Persona(0, "", "", 18, "");

	p = daoPersona.getById(p);

	assertEquals("Pepe", p.getNombre());
	assertEquals("Gorriti", p.getApellido());

    }
}
