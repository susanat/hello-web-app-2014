import ipartek.formacion.ejemplos.hibernate.Categoria;
import ipartek.formacion.ejemplos.hibernate.Curso;
import ipartek.formacion.ejemplos.hibernate.Direccion;
import ipartek.formacion.ejemplos.hibernate.HibernateUtil;
import ipartek.formacion.ejemplos.hibernate.Persona;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CategoriaTest {

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
		
		Curso cur1 = new Curso("Como programar.","Cur3265", new Date(), addDays(new Date(), 10));
				
		Curso cur2 = new Curso("Eres una mala hierva.","JAR3698", new Date(), addDays(new Date(), 10));
		Curso cur3 = new Curso("Margaritas, no, por favor.","JAR8547", new Date(), addDays(new Date(), 10));
		Curso cur4 = new Curso("Cardo borriquedo, su historia","JAR6666", new Date(), addDays(new Date(), 10));
		
        
        Categoria cat1 = new Categoria("Informatica", "inf1");
        Categoria cat2 = new Categoria("Politica", "pol1");
        Categoria cat3 = new Categoria("jardineria", "jar1");
        
        
        cat1.getCursos().add(cur1);
        cat2.getCursos().add(cur2);
        cat2.getCursos().add(cur3);
        cat2.getCursos().add(cur4);
        
			
		Session s = null;
		
		try{
			
			s = HibernateUtil.getSession();
			
			s.beginTransaction();

			s.save(cat1);
			s.save(cat2);
			s.save(cat3);
			
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
