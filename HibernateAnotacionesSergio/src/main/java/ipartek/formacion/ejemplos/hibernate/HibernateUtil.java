package ipartek.formacion.ejemplos.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Clase de utilidad para obtener la sesion de hibernate.
 *
 * @author documentacion hibernate
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
           // Si no ponemos fichero, intenta cargar "/hibernate.cfg.xml" de  src/main/resources   
          sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
                      
            
        } catch (Throwable ex) {
            // Log exception! Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
    
    
    public static void shutdown() {
        // Close caches and connection pools
    	sessionFactory.close();       
    }
    
}


