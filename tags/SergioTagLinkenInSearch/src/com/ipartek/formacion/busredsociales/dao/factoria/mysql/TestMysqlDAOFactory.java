package com.ipartek.formacion.busredsociales.dao.factoria.mysql;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.busredsociales.bean.Usuario;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

public class TestMysqlDAOFactory {

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
	public void testGetByiD() throws Exception {
		
		int id = 27;
		
		try {
			DAOFactory factoria = DAOFactory.getDaoFactoriaAbstracta(DAOFactory.MYSQL);
			
			IUsuarioDAO usuarioDao = factoria.getUsuarioDAO();
			
			Usuario user = usuarioDao.getById(id);
			
			System.out.println(user.toString());
			
			assertEquals("Ana Rosa", user.getUsername());
		}catch (Exception ex) {
			ex.printStackTrace();
			
			throw ex;
		}
		
		
		
	}

}
