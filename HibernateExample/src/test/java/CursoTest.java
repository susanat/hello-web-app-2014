import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import ipartek.formacion.ejemplos.hibernate.Curso;
import ipartek.formacion.ejemplos.hibernate.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;


public class CursoTest {

	private static int cantidad = 10;
	
	private static List<Curso> lstCurso = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lstCurso = new ArrayList<Curso>();
		
		Session s = HibernateUtil.getSession();
		
		
        //s.beginTransaction();
		
		for(int i = 0; i< cantidad; i++) {
			
			Curso p = new Curso();
	        p.setNombre("testCurso " + i);
	        p.setCodigo("Codigo " + i);
	        p.setfInicio( new Date());	        
	        p.setfFin( addDays(new Date(), 2) );
	        
	        lstCurso.add(p);
		}
		
		for(Curso p : lstCurso) {
        	s.save(p);        	
        }
        
		//s.getTransaction().commit();
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testInsert() throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		
		Session s = HibernateUtil.getSession();
        s.beginTransaction();

        // Se instancia la clase Flight y se rellenan sus datos
        
        
        Curso p = new Curso();
        p.setNombre("testCurso");
        p.setCodigo("A1452265");
        p.setfInicio(dateFormat.parse("25-12-2014"));	        
        p.setfFin( addDays(new Date(), 2) );
        
        
        // Se salva en base de datos
        s.save(p);
        
        
        s.getTransaction().commit();
        
        //s.getTransaction().rollback();
                      
       // assertTrue( cantidad + 1 ==  p.getId() );
        assertTrue( "testCurso" ==  p.getNombre() );
	}

	
	@Test
	public void testGetAll() {
		
		Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        //List<Curso> Cursos = s.createQuery("from Curso").list();
        
        List<?> Cursos = null;        
        Cursos = s.createQuery("from Curso order by id asc").list();
                        
        assertTrue( cantidad <=  Cursos.size() );
        
        //comprobamos que ha ordenado correctamente
        Curso p = (Curso) Cursos.get(0);
        assertTrue(p.getId() == 1);
        
        
        s.getTransaction().commit();
	}
	
	@Test
	public void testUpdate() {
		
		Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        Curso pNueva = new Curso();
        pNueva.setNombre("CursoNueva");
        s.save(pNueva);
        
        Curso pModificada = (Curso) s.load(Curso.class, pNueva.getId() );
        pModificada.setNombre("CursoModificada");
        s.save(pModificada);
          
        Curso pRecuperada = (Curso) s.load(Curso.class, pModificada.getId() );
        assertTrue( "CursoModificada" ==  pRecuperada.getNombre() );
        
        s.getTransaction().commit();
	}
	
	@Test
	public void testDelete(){
		
		Long id = 0l;
		
		//insertamos
		Session s = HibernateUtil.getSession();
        s.beginTransaction();
                
        Curso p = new Curso();        
        p.setNombre("testCurso para borrar");
        p.setCodigo("Codigo para borrar");
        p.setfInicio( new Date());	        
        p.setfFin( addDays(new Date(), 2) );               
        
        s.save(p);        
        s.getTransaction().commit();
        
        id = p.getId();
		
        
        //borramos        	
		s = HibernateUtil.getSession();
        s.beginTransaction();        
        s.delete(p);        
        s.getTransaction().commit();
        
        
        
        //comprobamos
        s  = HibernateUtil.getSession();
        p = (Curso) s.get(Curso.class, id);
        assertNull(p);
		
	}
	
	
	
	public static Date addDays(Date date, int days)
	{
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, days); //minus number would decrement the days
	    return cal.getTime();
	}
	
}
