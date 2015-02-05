package com.ipartek.formacion;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import ipartek.formacion.ejemplos.hibernate.HibernateUtil;
import ipartek.formacion.ejemplos.hibernate.Persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/persona")
public class PersonaController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonaController.class);
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json", headers="Accept=*/*")
	public @ResponseBody JsonGenericResponse obtenerPersonas( HttpServletResponse res ) {
		
		JsonGenericResponse jsr = new JsonGenericResponse();
		List<?> personas = null; 
		
		try {
			Session s = ipartek.formacion.ejemplos.hibernate.HibernateUtil.getSession();            
	        personas = s.createQuery("from Persona order by id asc").list();
	        
		} catch (PropertyValueException ex) {			
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);			
			jsr.setException(ex);			
			//throw ex;
		} catch (Exception ex) {			
			//throw ex;	
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			jsr.setException(ex);			
		}
        
        jsr.setObjeto(personas);
        
		return jsr;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody JsonGenericResponse obtenerPersona(@PathVariable("id") long id, HttpServletResponse res) {
		JsonGenericResponse jsr = new JsonGenericResponse();
				
		Persona devuelta = null;
		
		try {
			
			Session s = ipartek.formacion.ejemplos.hibernate.HibernateUtil.getSession();
			devuelta = (Persona) s.get(Persona.class, id );
					
			
		} catch (PropertyValueException ex) {			
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);			
			jsr.setException(ex);			
			//throw ex;
		} catch (Exception ex) {			
			//throw ex;	
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			jsr.setException(ex);			
		}
		
		jsr.setObjeto(devuelta);
		
		return jsr;
	}

	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", headers="Accept=*/*")
	public @ResponseBody JsonGenericResponse crearPersona(@RequestBody final  Persona persona, HttpServletResponse res) //throws Exception  
	{
		
		JsonGenericResponse jsr = new JsonGenericResponse();
		
		//TODO recoger parametros
		System.out.println(persona.toString()); 
		
		//Insertar en BBDD
		Persona devuelta = null;
		
		try {
			devuelta = Insert(persona);		
			
		} catch (PropertyValueException ex) {			
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);			
			jsr.setException(ex);			
			//throw ex;
		} catch (Exception ex) {			
			//throw ex;	
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			jsr.setException(ex);			
		}
		
		jsr.setObjeto(devuelta);
		
		return jsr;
		
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody JsonGenericResponse borrarPersona(@PathVariable("id") long id, HttpServletResponse res) {		
		
		JsonGenericResponse jsr = new JsonGenericResponse();
		
		
		try {
			jsr.setObjeto(this.Delete(id));	
			
		} catch (PropertyValueException ex) {			
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);			
			jsr.setException(ex);			
			//throw ex;
		} catch (Exception ex) {			
			//throw ex;	
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			jsr.setException(ex);			
		}
			
		
		return jsr;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json", headers="Accept=*/*")
	public @ResponseBody JsonGenericResponse modificarPersona(@RequestBody final  Persona persona, HttpServletResponse res) 
	{
		JsonGenericResponse jsr = new JsonGenericResponse();
		
		//TODO recoger parametros
		System.out.println(persona.toString()); 
		
		//Insertar en BBDD
		Persona devuelta = null;
		
		try {
			devuelta = update(persona);		
			if(devuelta == null) {
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				jsr.setException(new Exception("Persona not found."));			
			}
			
		} catch (PropertyValueException ex) {			
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);			
			jsr.setException(ex);			
			//throw ex;
		} catch (Exception ex) {			
			//throw ex;	
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			jsr.setException(ex);			
		}
		
		jsr.setObjeto(devuelta);
		
		return jsr;
		
	}

	
	public Persona Insert(Persona p) throws Exception {
		Session s = null;
		
		
		try {
			
			s = HibernateUtil.getSession();
	        
			
			
			s.beginTransaction();
	        
	        // Se salva en base de datos
	        s.save(p);
	        
	        s.getTransaction().commit();
	               
	        
	        System.out.println("El id del testInsert = " + p.getId());
	        
	        return p;
			
		} catch (Exception ex) {
			s.getTransaction().rollback();
			s.clear();
			ex.printStackTrace();
			throw ex;
			
		}		
		


	}
	
	public Boolean Delete(long id){
		
		
				
		//insertamos
		Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        
        try {
        	            
            Persona p = (Persona) s.get(Persona.class, id);                        //borramos    		
            s.beginTransaction();        
            s.delete(p);            
            //realizamos el commit
            s.getTransaction().commit();
            
            
            
            //comprobamos que sea null            
            return true;
            
            
        } catch (Exception ex) {
        	
        	s.getTransaction().rollback();        	        	
        	System.out.print("Ha saltado el rollback del delete.");
        	ex.printStackTrace();
        	
        	
        	
        	
       }
                
        return false;
		
	}
	
	public Persona update(Persona p) {
		
		Session s = HibernateUtil.getSession();
      
		try {
        	 //Lo obtenemos de bd y lo modificamos
             s.beginTransaction();
             Persona pModificada = (Persona) s.get(Persona.class, p.getId() );
             
             if(pModificada != null) { 
            	 pModificada.setNombre("personaModificada");
            	 s.update(pModificada);                 
                 //lo volvemos a obtener de bd para comprobar
                 Persona pRecuperada = (Persona) s.get(Persona.class, pModificada.getId() );                 
                 s.getTransaction().commit();                 
                 return pRecuperada;
             } else {
            	 return null;
             }
             
             
        } catch (Exception ex) {
        	
        	s.getTransaction().rollback();        	        	
        	System.out.print("Ha saltado el rollback del update.");
        	ex.printStackTrace();
        	
        	assertTrue(false);
        }
        
		return null;
        
       
	}
	

}