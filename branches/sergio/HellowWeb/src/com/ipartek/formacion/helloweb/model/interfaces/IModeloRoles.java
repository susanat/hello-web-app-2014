package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.List;

import com.ipartek.formacion.helloweb.bean.Roles;



/**
 * Modelo para gestionar el bean <code>Roles</code>
 * @author Sergio Rubio Nieto
 *
 */
public interface IModeloRoles {
	
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
	 * Interface de eventos
	 * 
	 */
	public interface onModelRolesError {
		void onException(Roles obj, Exception ex);		
	}
		
	
	/**
	 * Retorna todas las Roless 
	 * @return List<Roles> Listado de <code>Roles</code>, si no existen null
	 */
	public List<Roles> getAll();
	
	/**
	 * Retorna Roles por id
	 * @return Roles Roles por id, si no existe null 
	 */
	public Roles getById(int id);
	
	/**
	 * Obtiene la Roles por el nombre
	 * @param username String nombre del usuario
	 * @return Roles objeto Roles con usuario o null si no existe
	 */
	public Roles getByName(String username);
	
	/**
	 * Inserta registro en base de datos
	 * 
	 * @param obj Roles a insertar
	 * @return integer con el id o -1 si no ha sido insertado -2 existe
	 */
	public Roles Insert ( Roles obj);
	
	/**
	 * Modifica registro en base de datos
	 * 
	 * @param obj Roles a modificar
	 * @return integer con el identificador de la Roles o -1 con error.
	 */
	public Roles update (int id, Roles obj);
	
	
	/**
	 * Eliminamos fisicamente <code>Roles</code> por su identificador
	 * @param id identificador de la Roles
	 * @param tipoBorrado tipo de borrado de la base de datos
	 * @return true si ha sido eliminado
	 */
	public boolean delete(int id, EBorrado tipoBorrado );
	
	/**
	 * Comprueba si existe un usuario con ese nombre
	 * @param username Nombre de usuario a comprobar
	 * @return true si existe y false si no existe
	 * @throws Exception 
	 */
	public boolean existUserName(String username) throws Exception;
	
	/**
	 * Comprueba si existe un usuario con ese nombre
	 * @param Roles Objeto Roles con el nombre a comprobar
	 * @return true si existe y false si no existe
	 * @throws Exception 
	 */
	public boolean existUserName(Roles Roles) throws Exception;
	


}
