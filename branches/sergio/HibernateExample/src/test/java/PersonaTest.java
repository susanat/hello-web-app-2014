import static org.junit.Assert.*;
import ipartek.formacion.ejemplos.hibernate.HibernateUtil;
import ipartek.formacion.ejemplos.hibernate.Persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.annotations.common.AssertionFailure;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersonaTest {

	private static int cantidad = 5;
	
	private static List<Persona> lstPersona = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lstPersona = new ArrayList<Persona>();
		
		Session s = HibernateUtil.getSession();
		
		
        s.beginTransaction();
		
        try {
		
        	for(int i = 0; i< cantidad; i++) {
    			
    			Persona p = new Persona();
    	        p.setNombre("testpersona " + i);
    	        p.setApellidos("Apellido " + i);
    	        p.setEdad(i);	        
    	        p.setFechaNacimiento( new Date() );
    	        
    	        lstPersona.add(p);
    		}
    		
    		for(Persona p : lstPersona) {
            	s.save(p);        	
            }
    		
    		s.getTransaction().commit();
    		
		} catch (Exception ex) {
			ex.printStackTrace();
			
			s.getTransaction().rollback();
			System.out.print("Ha saltado el rollback de la carga inicial.");
		}
        
		
        
		
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testInsert() {
		Session s = HibernateUtil.getSession();
        s.beginTransaction();

        // Se instancia la clase Flight y se rellenan sus datos
        
        
        Persona p = new Persona();
        p.setNombre("testpersona");
        p.setApellidos("Ap1 ap2");
        //p.setEdad(15);        
        p.setFechaNacimiento( new Date() );
        
        
        // Se salva en base de datos
        s.save(p);
        
        
        s.getTransaction().commit();
        
        //s.getTransaction().rollback();
        
        
        System.out.println("El id del testInsert = " + p.getId());
              
        //assertTrue( cantidad + 2 ==  p.getId() );
        assertTrue( "testpersona" ==  p.getNombre() );
	}

	
	@Test
	public void testGetAll() {
		
		Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        //List<Persona> personas = s.createQuery("from Persona").list();
        
        List<?> personas = null;        
        personas = s.createQuery("from Persona order by id asc").list();
                        
        assertTrue( cantidad <=  personas.size() );
        
        //comprobamos que ha ordenado correctamente
        Persona p = (Persona) personas.get(0);
        assertTrue(p.getId() == 1);
        
        
        s.getTransaction().commit();
	}
	
	@Test
	public void testInsertNulls() {
		
		Session s = HibernateUtil.getSession();
                
        //comprobamos crear nueva persona que salte el error null
        try {        	
        	//iniciamos transaccion
        	s.beginTransaction();
        	
        	//persona nueva con solo nombre para que falle
       	 	Persona pNueva = new Persona();
            pNueva.setNombre("personaNueva");
            s.save(pNueva);           
            
            s.getTransaction().commit();
       } catch (PropertyValueException a) {
    	   s.getTransaction().rollback();
    	   s.clear();
    	   
    	   System.out.println(a);
    	   
    	   assertTrue(true);
    	   
    	   
       } catch (Exception ex) {
	       	
    	   //realizamos el rollback
    	   s.getTransaction().rollback(); 
    	   s.clear();
    	   
	       	System.out.print("Ha saltado el rollback del update.");
	       	ex.printStackTrace();	       	
	       	assertTrue(false);
       }
	}
	
	@Test
	public void testUpdate() {
		
		Session s = HibernateUtil.getSession();
      
		try {
        	
        	//Añadimos uno nuevo para modificar
        	 s.beginTransaction();
        	 Persona pNueva = new Persona();
             pNueva.setNombre("personaNueva");
             pNueva.setApellidos("Nueva de verdad");
             pNueva.setFechaNacimiento(new Date());
             s.save(pNueva);
             s.getTransaction().commit();
             
             //Lo obtenemos de bd y lo modificamos
             s.beginTransaction();
             Persona pModificada = (Persona) s.load(Persona.class, pNueva.getId() );
             pModificada.setNombre("personaModificada");
             s.update(pModificada);
               
             //lo volvemos a obtener de bd para comprobar
             Persona pRecuperada = (Persona) s.load(Persona.class, pModificada.getId() );
             assertTrue( "personaModificada" ==  pRecuperada.getNombre() );
             
             s.getTransaction().commit();
        } catch (Exception ex) {
        	
        	s.getTransaction().rollback();        	        	
        	System.out.print("Ha saltado el rollback del update.");
        	ex.printStackTrace();
        	
        	assertTrue(false);
        }
        
        
       
	}
	
	@Test
	public void testDelete(){
		
		Long id = 0l;
				
		//insertamos
		Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        try {
        	Persona p = new Persona();
            p.setNombre("Para borrar");
            p.setApellidos("Ap125 ap2s");
            //p.setEdad(15);        
            p.setFechaNacimiento( new Date() );            
            s.save(p);        
            s.getTransaction().commit();
            
            id = p.getId();    		
            //comprobamos que se ha creado
            
            
            //comprobamos que sea null
            
            p = (Persona) s.get(Persona.class, id);
            assertTrue(null != p);
                        
            
            
            //borramos    		
            s.beginTransaction();        
            s.delete(p);            
            //realizamos el commit
            s.getTransaction().commit();
            
            
            
            //comprobamos que sea null            
            p = (Persona) s.get(Persona.class, id);
            assertNull(p);
            
        } catch (Exception ex) {
        	
        	s.getTransaction().rollback();        	        	
        	System.out.print("Ha saltado el rollback del delete.");
        	ex.printStackTrace();
        	
        	assertTrue(false);
        	
        	
       }
                
        
		
	}
	
	
	
	
	
	
}
