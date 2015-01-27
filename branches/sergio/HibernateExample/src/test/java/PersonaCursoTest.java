import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ipartek.formacion.ejemplos.hibernate.Curso;
import ipartek.formacion.ejemplos.hibernate.HibernateUtil;
import ipartek.formacion.ejemplos.hibernate.Persona;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersonaCursoTest {

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
	public void test() {
		
		Persona Persona1 = new Persona("Isabel", "Fuertes", 12, new Date());
		Persona Persona2 = new Persona("Jose", "Valenciano", 25 ,new Date());
		Persona Persona3 = new Persona("Pollo", "Extremeño", 30 ,new Date());

		Curso Curso1 = new Curso("Sistemas Operativos en Red", "A1325", new Date(), addDays(new Date(), 10) );
		Curso Curso2 = new Curso("Entornos de desarrollo", "B965587", new Date(), addDays(new Date(), 10) );
		Curso Curso3 = new Curso("Sistemas Informáticos", "D3568", new Date(), addDays(new Date(), 10) );
		Curso Curso4 = new Curso("Peluqueria para pulgas", "C22365", new Date(), addDays(new Date(), 10) );
		Curso Curso5 = new Curso("Critico de telenovelas", "A597855", new Date(), addDays(new Date(), 10) );

		Persona1.getCursos().add(Curso1);
		Persona1.getCursos().add(Curso2);
		Persona2.getCursos().add(Curso3);

		Curso1.getPersonas().add(Persona1);
		Curso2.getPersonas().add(Persona1);
		Curso3.getPersonas().add(Persona2);

		Session s = null;
		
		try{
			
			s = HibernateUtil.getSession();
			
			s.beginTransaction();

			s.save(Persona1);
			s.save(Persona2);
			s.save(Curso4);
			
			//asigno el curso de BD a una persona ya creada en BD
			Persona2.getCursos().add(Curso4);
			s.save(Persona2);
					
			//asigno un curso no en BD a una persona ya creada en BD
			Persona1.getCursos().add(Curso5);
			s.save(Persona1);
			
			//Asigno una persona no en BD a un curso ya creado en BD
			Curso1.getPersonas().add(Persona3);
			s.save(Curso1);
			//NO CREA RELACION PERO CREA LA PERSONA
			
			s.getTransaction().commit();
		} catch (Exception ex)
		{
			s.getTransaction().rollback();
			s.clear();
			ex.printStackTrace();
			
		}
		
		
		System.out.println("*****Cursos****************" + nl);
		List<Curso> cursos = s.createQuery("from Curso order by id asc").list();		
		for(Curso c : cursos) {
			System.out.println(c.toString());
		}
		System.out.println("***************************" + nl);
		
		System.out.println("*****Personas**************");
		List<Persona> personas = s.createQuery("from Persona order by id asc").list();		
		for(Persona p : personas) {
			System.out.println(p.toString());
		}
		System.out.println("***************************" + nl);
		
		s.close();
	}
	
	public static Date addDays(Date date, int days)
	{
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, days); //minus number would decrement the days
	    return cal.getTime();
	}
	
	public static String nl = System.getProperty("line.separator");

}
