package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.List;

import com.ipartek.formacion.helloweb.bean.Persona;



/**
 * Modelo para gestionar el bean <code>Persona</code>
 * @author Sergio Rubio Nieto
 *
 */
public interface IModeloPersona {
	
	/**
	 * Numeración para forma de borrado de registros
	 * 
	 * @author Sergio Rubio Nieto
	 *
	 */
	public enum EBorrado{	    
		/**
		 * Borra físicamente de base de datos
		 */
		LOGICA(1), 	       
		/**
		 * Modifica el flag de borrado pero no borra el registro
		 */
		FISICA(2);
	       
	       private int value;
	      
	       private EBorrado(int value) {
	            this.value = value;
	       }
	       public int getValue(){
	        return value;
	       }
	   }

	
	/**
	 * Interface de eventos del list view
	 * 
	 * @author baskito 2013/09/30
	 *
	 */
	public interface onModelPersonaError {
		void onException(Persona obj, Exception ex);		
	}
		
	
	/**
	 * Retorna todas las personas 
	 * @return List<Persona> Listado de <code>Persona</code>, si no existen null
	 */
	public List<Persona> getAll();
	
	/**
	 * Retorna persona por id
	 * @return Persona persona por id, si no existe null 
	 */
	public Persona getById(int id);
	
	
	/**
	 * Inserta registro en base de datos
	 * 
	 * @param obj Persona a insertar
	 * @return integer con el id o -1 si no ha sido insertado -2 existe
	 */
	public Persona Insert ( Persona obj);
	
	/**
	 * Modifica registro en base de datos
	 * 
	 * @param obj Persona a modificar
	 * @return integer con el identificador de la persona o -1 con error.
	 */
	public Persona update (int id, Persona obj);
	
	
	/**
	 * Eliminamos fisicamente <code>Persona</code> por su identificador
	 * @param id identificador de la persona
	 * @param tipoBorrado tipo de borrado de la base de datos
	 * @return true si ha sido eliminado
	 */
	public boolean delete(int id, EBorrado tipoBorrado );
	

}
