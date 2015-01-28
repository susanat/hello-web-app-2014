package ipartek.formacion.ejemplos.hibernate;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

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
            // Log exception!
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


