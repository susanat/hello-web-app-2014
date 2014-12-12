package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.ipartek.formacion.helloweb.bean.Role;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloRol;


/**
 * Modelo relativo a los roles.
 * 
 * @author Fila-2
 *
 */
public class ModeloRol implements IModeloRol {

	/**
	 * Primer identificador de la lista de objetos - 1.
	 */
	private static final int CONT_FIRST_GET_ID = 0;
	
	/**
	 * Declara como es null la lista sin objetos borrados físicamente.
	 */
	private static final int LIST_LOGICAL_NULL = 0;
	
	/**
	 * Texto excepción para los updates.
	 */
	private static final String ROLE_EXC_UPDATE = "Update: ";
	
	/**
	 * Texto excepción para los inserts.
	 */
	private static final String ROLE_EXC_INSERT = "Insert: ";
	
	/**
	 * Texto excepción para los delete.
	 */
	private static final String ROLE_EXC_DELETE = "Delete: ";
	
	
	/**
	 * Texto excepción para identificador incorrecto.
	 */
	private static final String ROLE_EXC_ID_INCORRECT 
		= "Identificador incorrecto %d";
	
	/**
	 * Texto excepción para parámetro a null.
	 */
	private static final String ROLE_EXC_OBJ_NULL 
		= "El objeto pasado no puede ser null";
	
	/**
	 * Texto excepción para objeto no encontrado.
	 */
	private static final String ROLE_EXC_OBJ_NOT_FOUND 
		= "No se ha encontrado el objeto %d";
	
	/**
	 * Lista de roles.
	 */
	private static List<Role> roles;
	
	/**
	 * Obtiene la lista de almacenaje de roles.
	 * @return List<Role> lista de almacenaje de roles
	 */
	public static List<Role> getListRoles() {
		return roles;
	}

	/**
	 * Crea la tabla de roles.
	 */
	public static void createTable() {
		
		roles = new ArrayList<Role>();
		
		Role obj = new Role("Usuario");		
		obj.setDescripcion("Usuarios normales");
		obj.setId(1);
		roles.add(obj);

		obj = new Role("Administrador");		
		obj.setDescripcion("Acceso total al site");
		obj.setId(2);
		roles.add(obj);
		
		obj = new Role("El Borrado");		
		obj.setDescripcion("Uno de prueba ");
		obj.setBorrado(true);
		obj.setId(3);
		roles.add(obj);
	}

	/**
	 * Vacía la tabla de roles.
	 */
	public static void truncateTable() {
		roles = null;
	}

	
	
	
	/**
	 * Devuelve una lista de roles.
	 * @return Lista de roles activos o null si no se encuentran
	 */
	public List<Role> getAll() {
		
		List<Role> lstObj = null;
		
		
		if (ModeloRol.roles != null) {
			//construimos la nueva lista
			lstObj = new ArrayList<Role>();
			
			//buscamos los registros activos
			for (final Role rol : ModeloRol.roles) {
				if (!rol.isBorrado()) {
					lstObj.add(rol);
				}
			}	
			
			//no hemos encontrado registros activos
			if (lstObj.size() == LIST_LOGICAL_NULL) {
				lstObj = null;
			}
		}		
		
		return lstObj;		
	}	
	
	/**
	 * Obtenemos un role por su identificador.
	 * @param id Integer identificador del objeto
	 * @return Role con los datos del objeto o null si no lo ha encontrado
	 * @throws Exception 
	 */
	public Role getByID(final int identi) throws Exception {
		
		Role resul = null;
		int cont = LIST_LOGICAL_NULL; //contador para el while
		final List<Role> lstRole = ModeloRol.getListRoles();
		
		//control del parámetro de entrada
		if (identi <= Role.ID_NULL) {
			throw new Exception(ROLE_EXC_UPDATE 
					+ String.format(ROLE_EXC_ID_INCORRECT, identi));
		}		
		
		//si está a null la lista, no encontraremos fijo el que buscamos
		if (ModeloRol.roles != null) {	
			
			//recorremos por index hasta encontrar el que buscamos
			while (cont < lstRole.size()) { 				
			
				if (lstRole.get(cont).getId() == identi) {
					resul = lstRole.get(cont);
					
					//salimos del bucle
					cont = lstRole.size();
				}				
				
				cont++;
			}
		}
		
		return resul;
	}

	
	/**
	 * Inserta un role.
	 * @param obj Objeto Role
	 * @return Null si no ha sido insertado o el objeto si ha sido insertado
	 */
	public Role insert(final Role obj) throws Exception {
		Role res = null;		
		
		
		if (obj == null) {
			throw new Exception(ROLE_EXC_INSERT + ROLE_EXC_OBJ_NULL);			
		} else {
			if (ModeloRol.roles == null) {
				ModeloRol.roles = new ArrayList<Role>();
			}
				
			obj.setId(getLastId());			
			ModeloRol.getListRoles().add(obj);
			
			res = obj;
		}				
		
		return res;	
	}
	
	/**
	 * Obtiene el último identificador.
	 * @return Integer mayor que 0
	 */
	private int getLastId() {
		int lastIndex = CONT_FIRST_GET_ID;
		
		final TreeSet<Integer> sortId = new TreeSet<Integer>(); 
		
		if (ModeloRol.roles != null) {
			for (final Role obj : ModeloRol.roles) {
				sortId.add(obj.getId());
			}
			
			if (sortId.size() > LIST_LOGICAL_NULL) {
				lastIndex = sortId.last();
			}
		}
		
		return lastIndex + 1;
	}

	
	/**
	 * Actualiza un objeto Role.
	 * @param obj Objeto a actualizar
	 * @return Objeto actualizado o null si ha habido algún error
	 */
	public Role update(final Role obj) throws Exception {
		
		Role roleTemp = null;		
		
		//controles
		if (roles == null) {
			throw new Exception(ROLE_EXC_UPDATE + ROLE_EXC_OBJ_NULL);
		} 
		
		if (obj.getId() <= Role.ID_NULL) {
			throw new Exception(ROLE_EXC_UPDATE +  ROLE_EXC_ID_INCORRECT);
		}
		
		//Realizamos el update
		//1- Obtenemos el existente
		roleTemp = this.getByID(obj.getId());
		if (roleTemp == null) {
			throw new Exception(ROLE_EXC_UPDATE 
					+ String.format(ROLE_EXC_OBJ_NOT_FOUND, obj.getId()));
		}
		
		roles.remove(roleTemp);		
		roles.add(obj);
		
		return obj;
	}
	
	


	/**
	 * Función que elimina un elemento.
	 * @param id Identificador del objeto a borrar
	 * @return true si ha sido borrado o false si no ha sido borrado
	 */
	public boolean delete(final int identi) throws Exception {
		boolean res = true;
				
		Role newRole = null;
		Role roleTemp = null;
				
		//controles
		if (identi <= Role.ID_NULL) {
			throw new Exception(ROLE_EXC_DELETE 
					+ String.format(ROLE_EXC_ID_INCORRECT, identi));
		}
		
		//1- Obtenemos el existente
		roleTemp = this.getByID(identi);
		if (roleTemp == null) {
			throw new Exception(ROLE_EXC_DELETE 
					+ String.format(ROLE_EXC_OBJ_NOT_FOUND, identi));
		}
		
		//clonamos
		newRole = roleTemp;
		
		newRole.setBorrado(true);
		
		//eliminamos el viejo y añadimos el nuevo a la lista
		roles.remove(roleTemp);		
		roles.add(newRole);
				
		
		return res;
		
	}
	
	

}
