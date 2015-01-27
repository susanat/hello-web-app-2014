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


public class DireccionTest {

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
		
		Persona persona1 = new Persona("Isabel", "Fuertes", 12, new Date());
		Direccion dir1 = new Direccion("Canarias", "2", 28850);
		
		persona1.setDireccion(dir1);
					
		Session s = null;
		
		try{
			
			s = HibernateUtil.getSession();
			
			s.beginTransaction();

			s.save(dir1);
			s.save(persona1);
			
			s.getTransaction().commit();
		} catch (Exception ex)
		{
			s.getTransaction().rollback();
			s.clear();
			ex.printStackTrace();
			
		}
		
		
		System.out.println("*****Direcciones****************" + nl);
		List<Direccion> direcciones = s.createQuery("from Direccion order by id asc").list();		
		for(Direccion d : direcciones) {
			System.out.println(d.toString());
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
