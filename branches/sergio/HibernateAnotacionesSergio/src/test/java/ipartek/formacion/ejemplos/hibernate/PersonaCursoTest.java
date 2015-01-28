package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaCursoTest {
	
	static Session s = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		/*
		try {
			s = HibernateUtil.getSession();
			s.beginTransaction();

			// crear personas de prueba
			Persona p = new Persona();
			p.setNombre("dummy");
			p.setFechaNacimiento(new Date());
			p.setApellidos("foo bar");
			p.setEdad(18);
			s.save(p);

			p = new Persona();
			p.setNombre("dummy2");
			p.setFechaNacimiento(new Date());
			p.setApellidos("foo2 bar2");
			p.setEdad(20);
			s.save(p);

			s.getTransaction().commit();
			s.close();
		} catch (Exception ex) {

			s.getTransaction().rollback();
			s.clear();
			ex.printStackTrace();
		}
		*/
		
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
	public void testPersonaCurso() {
		
		
		try {
			
			//direcciones
			Direccion dir1 = new Direccion("Canarias 2", "28850");
			Direccion dir2 = new Direccion("Bilbao 3", "362020");
			Direccion dir3 = new Direccion("Salamanca 5", "921212");
						
			Persona p1 = new Persona("nombre 1", 30, "ape 1", new Date(), new Date(), new Date(), dir1);
			Persona p2 = new Persona("nombre 2", 20, "ape 2", new Date(), new Date(), new Date(), dir2);
			Persona p3 = new Persona("nombre 3", 20, "ape 3", new Date(), new Date(), new Date(), dir1);
			
			s = HibernateUtil.getSession();
			s.beginTransaction();
			
			//persisto las direcciones
			//s.persist(dir1);
			//s.persist(dir2);
			//s.persist(dir3);
						
			
			
			//salvo las personas
			s.save(p1);
			s.save(p2);
			s.getTransaction().commit();
			s.close();
			
			
			
			///Si eliminamos la persona 1 se tendría que eliminar la direccion 1
			//Sí, se elimina
			/*
			s.beginTransaction();
			s.delete(p2);
			s.getTransaction().commit();
			*/
			
			//¿Qué pasa si eliminamos la dirección 2 relacionada con la persona 2? - Que casca
			/*
			s.beginTransaction();
			s.delete(dir2);
			s.getTransaction().commit();
			*/
			
			
			
			s = HibernateUtil.getSession();
			s.beginTransaction();
			
			
			p2 = (Persona) s.get(Persona.class, p2.id);
			
			Direccion dir = p2.getDireccion();
			dir.setCalle("Nueva");
			p2.setDireccion(dir);			
			s.update(p2);
			s.getTransaction().commit();
			
			s.close();
			
			/*
			//crear curso
			Curso c = new Curso();
			c.setCodigo("IFCDXXXX");
			c.setNombre("Web");
			
			//salvar curso primero si no existe o se crea al vuelo
			s.persist(c);
			
			User u = new User("Admin");
			s.persist(u);
			
			//crear objeto tabla intermedia
			PersonaCurso pc = new PersonaCurso();
			pc.setPersona(p);
			pc.setCurso(c);
			pc.setFechaMatriculacion(new Date());
			pc.setUser(u);
			
			//asociar tabla intermedia a  la persona
			p.getPersonaCurso().add(pc);
			
			//modificar persona
			s.update(p);
			*/
			
		
			
		} catch(Exception ex) {
			
			s.getTransaction().rollback();
			s.clear();
			ex.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
}
