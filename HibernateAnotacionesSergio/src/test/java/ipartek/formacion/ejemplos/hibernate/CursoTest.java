package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

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
		s = HibernateUtil.getSession();
		s.beginTransaction();

		// crear curso de pruebas
		Curso c = new Curso();		
		c.setNombre("Desarrolo App Web");
		c.setCodigo("IFCD0210");

		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
		String sInicio = "11-09-2014";
		String sFin    = "12-02-2015";
		
		c.setFechaInicio( sdfFecha.parse(sInicio) );
		c.setFechaFin( sdfFecha.parse(sFin) );
		
		s.save(c);

		s.getTransaction().commit();
		s.close();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s = HibernateUtil.getSession();
		s.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {

		s.getTransaction().commit();
		s.close();

	}
	
	@Test
	public void testCursoPersonas() {
		
		//recuperar el curso con id == 1
		Curso c = (Curso)s.get(Curso.class, (long)3);
		
		//crear una persona y añadir a la coleccion
		Set<Persona> personas = new HashSet<Persona>();
		
		Persona p = (Persona)s.get(Persona.class, (long)1);;		
		
		personas.add(p);		
		
		//insertar personas en curso
		c.setPersonas(personas);		
		
		//persistir el curso
		s.update(c);
			
	}

}
