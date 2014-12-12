package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.ipartek.formacion.helloweb.bean.Role;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloRol;

public class ModeloRol implements IModeloRol {

	public static List<Role> roles = null;

	public static void createTable() {
		
		roles = new ArrayList<Role>();
		
		Role r = new Role("Usuario");		
		r.setDescripcion("Usuarios normales");
		r.setId(1);
		roles.add(r);

		r = new Role("Administrador");		
		r.setDescripcion("Acceso total al site");
		r.setId(2);
		roles.add(r);
		
		r = new Role("El Borrado");		
		r.setDescripcion("Uno de prueba ");
		r.setBorrado(true);
		r.setId(3);
		roles.add(r);
	}

	public static void truncateTable() {
		roles = null;
	}

	
	
	/**
	 * Devuelve una lista de roles
	 * @return Lista de roles activos o null si no se encuentran
	 */
	public List<Role> getAll() {
		List<Role> lstObj = null;
		
		
		if(ModeloRol.roles != null) {
			//construimos la nueva lista
			lstObj = new ArrayList<Role>();
			
			//buscamos los registros activos
			for(Role rol : ModeloRol.roles) {
				if(!rol.isBorrado()) {
					lstObj.add(rol);
				}
			}	
			
			//no hemos encontrado registros activos
			if(lstObj.size() == 0) {
				lstObj = null;
			}
		}		
		
		return lstObj;
		
	}

	/**
	 * Obtenemos un role por su identificador
	 * @throws Exception 
	 */
	public Role getByID(int id) throws Exception {
		
		Role resul = null;
		int cont = 0; //contador para el while
		
		//control del parámetro de entrada
		if(id <= Role.ID_NULL ) {
			throw new Exception ("Update: Identificador incorrecto");
		}		
		
		//si está a null la lista, no encontraremos fijo el que buscamos
		if (ModeloRol.roles != null) {	
			
			//recorremos por index hasta encontrar el que buscamos
			while (cont < ModeloRol.roles.size()) { 				
			
				if(ModeloRol.roles.get(cont).getId() == id) {
					resul = ModeloRol.roles.get(cont);
					
					//salimos del bucle
					cont = ModeloRol.roles.size();
				}				
				
				cont++;
			}
		}
		
		return resul;
	}

	
	/**
	 * Inserta un role 
	 */
	public Role insert(Role obj) throws Exception {
		Role res = null;		
		
		
		if(obj == null) {
			throw new Exception ("Insertar: El objeto pasado no puede ser null");			
		} else {
			if(ModeloRol.roles == null) {
				ModeloRol.roles = new ArrayList<Role>();
			}
				
			obj.setId(getLastId());			
			ModeloRol.roles.add(obj);
			
			res = obj;
		}				
		
		return res;	
	}
	
	/**
	 * Obtiene el último identificador
	 * @return
	 */
	private int getLastId() 
	{
		int lastIndex = 0;
		
		TreeSet<Integer> sortId = new TreeSet<Integer>(); 
		
		if(ModeloRol.roles != null) {
			for (Role Roles : ModeloRol.roles) {
				sortId.add(Roles.getId());
			}
			
			if(sortId.size() > 0) {
				lastIndex = sortId.last();
			}
		}
		
		return lastIndex + 1;
	}

	public Role update(Role r) throws Exception {
		
		int identificador = Role.ID_NULL;
		
		//controles
		if(roles == null) {
			throw new Exception ("Update: No se ha encontrado ningún registro");
		} 
		
		if(r.getId() <= Role.ID_NULL ) {
			throw new Exception ("Update: Identificador incorrecto");
		}
		
		//Realizamos el update
		//1- Obtenemos el existente
		Role roleTemp = this.getByID(r.getId());
		if(roleTemp == null) {
			throw new Exception ("Error en la obtención del objeto a actualizar");
		}
		
		roles.remove(roleTemp);
		
		roles.add(r);
		
		return r;
	}

	public boolean delete(int id) throws Exception {
		boolean res = true;
		
		
		Role newRole = null;
		Role roleTemp = null;
				
		//controles
		if(id <= Role.ID_NULL ) {
			throw new Exception ("Eliminar objeto: Identificador incorrecto");
		}
		
		//1- Obtenemos el existente
		roleTemp = this.getByID(id);
		if(roleTemp == null) {
			throw new Exception ("Error en la obtención del objeto a eliminar");
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
