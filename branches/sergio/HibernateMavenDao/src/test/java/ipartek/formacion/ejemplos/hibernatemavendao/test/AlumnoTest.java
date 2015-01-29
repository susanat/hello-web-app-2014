package ipartek.formacion.ejemplos.hibernatemavendao.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Alumno;
import ipartek.formacion.ejemplos.hibernatemavendao.service.AlumnoService;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AlumnoTest {

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
		AlumnoService objdao=new AlumnoService();
		
		
		Alumno obj = new Alumno();		
		obj.setNombre("Alumno a insertar y dejar 2");
		objdao.GuardarAlumno(obj);
		
		Alumno obj2 = new Alumno();		
		obj.setNombre("Alumno a insertar y dejar 3");
		objdao.GuardarAlumno(obj2);
		
		List<Alumno> Alumnos = objdao.ListarAlumnos();
		
		assertTrue(Alumnos.size() > 0);		
			
	}
	
	@Test
	public void testInsert() {
		
		try {
			AlumnoService objdao=new AlumnoService();
			
			Alumno obj = new Alumno();		
			obj.setNombre("Alumno a insertar y dejar");
			objdao.GuardarAlumno(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El Alumno tiene que existir						
			assertNotNull(objdao.BuscarAlumno(id));
								
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
	}
	
	@Test
	public void testUpdate() {
		
		try {
			AlumnoService objdao=new AlumnoService();
			
			Alumno obj = new Alumno();		
			obj.setNombre("Alumno a actualizar");
			objdao.GuardarAlumno(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El Alumno tiene que existir						
			Alumno obj2 =  objdao.BuscarAlumno(id);			
			obj2.setNombre("Modificado");
			objdao.ActualizarAlumno(obj2);
			
			obj2 = null;
			
			
			obj2 = objdao.BuscarAlumno(id);
			assertTrue("Modificado".equals(obj2.getNombre()));
			
			
								
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
	}
	
	
	@Test
	public void testDelete() {
		
		try {
			AlumnoService objdao=new AlumnoService();
			
			Alumno obj = new Alumno();		
			obj.setNombre("Alumno a borrar");
			objdao.GuardarAlumno(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El Alumno tiene que existir						
			assertNotNull(objdao.BuscarAlumno(id));
				
			//Entonces, lo elimino
			objdao.EliminarAlumno(obj);		
			
			//el Alumno no tiene que existir
			Alumno obj2 = objdao.BuscarAlumno(id); 
			
			assertNull(obj2);
					
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
		
	}

}
