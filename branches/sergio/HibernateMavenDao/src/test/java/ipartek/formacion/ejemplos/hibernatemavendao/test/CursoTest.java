package ipartek.formacion.ejemplos.hibernatemavendao.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;
import ipartek.formacion.ejemplos.hibernatemavendao.service.CursoService;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CursoTest {

	static Session s = null;

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
	public void testListAll() {
		CursoService objdao=new CursoService();
		
		
		Curso obj = new Curso();		
		obj.setNombre("Curso a insertar y dejar 2");
		objdao.GuardarCurso(obj);
		
		Curso obj2 = new Curso();		
		obj.setNombre("Curso a insertar y dejar 3");
		objdao.GuardarCurso(obj2);
		
		List<Curso> cursos = objdao.ListarCursos();
		
		assertTrue(cursos.size() > 0);		
			
	}
	
	@Test
	public void testInsert() {
		
		try {
			CursoService objdao=new CursoService();
			
			Curso obj = new Curso();		
			obj.setNombre("Curso a insertar y dejar");
			objdao.GuardarCurso(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El curso tiene que existir						
			assertNotNull(objdao.BuscarCurso(id));
								
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
	}
	
	@Test
	public void testUpdate() {
		
		try {
			CursoService objdao=new CursoService();
			
			Curso obj = new Curso();		
			obj.setNombre("Curso a actualizar");
			objdao.GuardarCurso(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El curso tiene que existir						
			Curso obj2 =  objdao.BuscarCurso(id);			
			obj2.setNombre("Modificado");
			objdao.ActualizarCurso(obj2);
			
			obj2 = null;
			
			
			obj2 = objdao.BuscarCurso(id);
			assertTrue("Modificado".equals(obj2.getNombre()));
			
			
								
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
	}
	
	
	@Test
	public void testDelete() {
		
		try {
			CursoService objdao=new CursoService();
			
			Curso obj = new Curso();		
			obj.setNombre("Curso a borrar");
			objdao.GuardarCurso(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El curso tiene que existir						
			assertNotNull(objdao.BuscarCurso(id));
				
			//Entonces, lo elimino
			objdao.EliminarCurso(obj);		
			
			//el curso no tiene que existir
			Curso obj2 = objdao.BuscarCurso(id); 
			
			assertNull(obj2);
					
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
		
	}

}
