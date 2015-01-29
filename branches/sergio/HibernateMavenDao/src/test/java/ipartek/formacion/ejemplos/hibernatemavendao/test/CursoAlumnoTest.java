package ipartek.formacion.ejemplos.hibernatemavendao.test;

import static org.junit.Assert.assertNotNull;
import ipartek.formacion.ejemplos.hibernatemavendao.entity.Alumno;
import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;
import ipartek.formacion.ejemplos.hibernatemavendao.service.AlumnoService;
import ipartek.formacion.ejemplos.hibernatemavendao.service.CursoService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CursoAlumnoTest {

	private static CursoService cService;
	private static AlumnoService aService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		cService = new CursoService();
		aService = new AlumnoService();		
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

	
	
	
	/**
	 * Crea los alumnos con un curso no existente. 
	 */
	@Test
	public void crearAlumnosConCurso() {
		
		//Creamos alumnos
		Alumno a1 = new Alumno("Sergio");
		Alumno a2 = new Alumno("Pedro");
		Alumno a3 = new Alumno("Maria");
		
		
		Curso c1 = new Curso("Patatas bravas: la cocina");
		
		
		//añadimos a la persona el curso
		a1.getCursos().add(c1);
		a2.getCursos().add(c1);
		a3.getCursos().add(c1);
		
		//guardamos los alumnos
		aService.GuardarAlumno(a1);
		aService.GuardarAlumno(a2);
		aService.GuardarAlumno(a3);
		
		//comprobamos que el alumno existe
		Alumno obj = aService.BuscarAlumno(a1.getId()); 
		
		assertNotNull(obj);
		
		
		//comprobamos que el curso existe
		Curso cObj = cService.BuscarCurso(a1.getCursos().get(0).getId());
		
		assertNotNull(cObj);		
		
	}
	
	/**
	 * Crea curso con Alumnos no existentes. 
	 */
	@Test
	public void crearCursoConAlumnos() {
		
		//Creamos alumnos
		Alumno a1 = new Alumno("Sergio desde curso");
		Alumno a2 = new Alumno("Pedro desde curso");
		Alumno a3 = new Alumno("Maria desde curso");
		
		
		Curso c1 = new Curso("¿Llamarias escroto a tu hij@?");
		
		
		//añadimos los alumnos al curso
		c1.setAlumno(a1);
		c1.setAlumno(a2);
		c1.setAlumno(a3);
		
		//guardamos el curso
		cService.GuardarCurso(c1);
		
		//comprobamos que el curso existe
		Curso cObj = cService.BuscarCurso(c1.getId());
		assertNotNull(cObj);	
		
		//comprobamos que el alumno existe
		Alumno obj = aService.BuscarAlumno(c1.getAlumnos().get(0).getId());		
		assertNotNull(obj);		
	}
	
	/**
	 * Crea los alumnos con un curso no existente. 
	 */
	@Test
	public void eliminarAlumnosConCurso() {
		
		//Creamos alumnos
		Alumno a1 = new Alumno("Sergio con curso A");
		Alumno a2 = new Alumno("Pedro con curso A");
		Alumno a3 = new Alumno("Maria con curso A");
				
		Curso c1 = new Curso("La A ¿La primera o una infiltrada?");
				
		//añadimos a la persona el curso
		a1.getCursos().add(c1);
		a2.getCursos().add(c1);
		a3.getCursos().add(c1);
		
		//guardamos los alumnos
		aService.GuardarAlumno(a1);
		aService.GuardarAlumno(a2);
		aService.GuardarAlumno(a3);
		
		//añadimos los alumnos al curso
		c1.setAlumno(a1);
		c1.setAlumno(a2);
		c1.setAlumno(a3);
		
		//guardamos el curso
		cService.GuardarCurso(c1);
				
		//comprobamos que el alumno existe
		Alumno obj = aService.BuscarAlumno(a1.getId()); 		
		assertNotNull(obj);
				
		//comprobamos que el curso existe
		Curso cObj = cService.BuscarCurso(a1.getCursos().get(0).getId());		
		assertNotNull(cObj);	
		
		
		
		
		cService.EliminarCurso(c1);
		
	}
		

}
