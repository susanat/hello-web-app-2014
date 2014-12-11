/**
 * 
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Roles;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles;


/**
 * Implementación para la Persistencia de los roles
 *  
 * @author Sergio Rubio Nieto
 *
 */
public class ModeloRoles implements IModeloRoles {

	//TODO: implementar base BBDD

	
	/**
	 * Array de listeners
	 *
	 * @version 30.09.2013
	 */
	private List<onModelRolesError> onIError = new ArrayList<onModelRolesError>();

	/**
	 * Funci�n para a�adir el listener
	 * 
	 * @param listener
	 *            listener a a�adir
	 */
	public void setOnIError(onModelRolesError listener) {
		onIError.add(listener);
	}

	/**
	 * Funci�n para remover el l�stener
	 * 
	 * @param listener
	 *            listener a remover
	 */
	public void removeOnIError(onModelRolesError listener) {
		onIError.remove(listener);
	}

	/**
	 * Funci�n que recorre el array de listener y los ejecuta
	 * 
	 * @param chk
	 *            checkBox del item
	 */
	private void onError(Roles obj, Exception ex) {
		for (onModelRolesError listener : onIError)
			listener.onException(obj, ex);;
	}

	

	// ////FIN LOGICA DE LOS EVENTOS
	
	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#getAll()
	 */
	public List<Roles> getAll() {
		
		List<Roles> lstTemp = null;
		
		if(CargasTemporales.roles != null && CargasTemporales.roles.size() > 0) {
			lstTemp = new ArrayList<Roles>(CargasTemporales.roles);
		}
		
		
		return lstTemp;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#getById(int)
	 */
	public Roles getById(int id) {
		Roles objTemp = null;
		
		if (id < 0) {
			onError(null, new Exception("GetById: Identificador no válido (ha de ser mayor que 0): " + id));
		} else {
			if (CargasTemporales.roles != null) {
				
				int contador = 0;
				while ( CargasTemporales.roles.size() >  contador ) {
			          if (CargasTemporales.roles.get(contador).getId() == id ) {
			        	  objTemp = CargasTemporales.roles.get(contador);
			        	  
			        	  contador = CargasTemporales.roles.size();
			          }	
			          contador ++;
			    }
			}
		}		
		
		return objTemp;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#Insert(com.ipartek.formacion.helloweb.bean.Roles)
	 */
	public Roles Insert(Roles obj) {
		
		Roles res = null;		
		
		
		if(obj == null) {
			onError(obj, new Exception("Insertar: El objeto pasado no puede ser null"));
		} else {
			if(CargasTemporales.roles == null) {
				CargasTemporales.roles = new ArrayList<Roles>();
			}
				
			obj.setId(getLastId());			
			CargasTemporales.roles.add(obj);
			
			res = obj;
		}				
		
		return res;	
		
	}
	
	private int getLastId() 
	{
		int lastIndex = 0;
		
		TreeSet<Integer> sortId = new TreeSet<Integer>(); 
		
		if(CargasTemporales.roles != null) {
			for (Roles Roles : CargasTemporales.roles) {
				sortId.add(Roles.getId());
			}
			
			if(sortId.size() > 0) {
				lastIndex = sortId.last();
			}
		}
		
		return lastIndex + 1;
	}

	
	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#delete(int, com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles.EBorrado)
	 */
	public boolean delete(int id, EBorrado tipoBorrado) {
		
		Boolean res = false;
		
		if (id < 0) {
			onError(null, new Exception("Delete: Identificador no válido (ha de ser mayor que 0): "  + id));
		} else {
			//obtenemos la Roles
			Roles p = this.getById(id);			
			
			if (p != null) {
				CargasTemporales.roles.remove(p);
				res = true;
			}			
		}
				
		return res;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#update(int, com.ipartek.formacion.helloweb.bean.Roles)
	 */
	public Roles update(int id, Roles obj) {
		Roles res = null;
		
		if (id < 0) {
			onError(null, new Exception("Update: Identificador no válido (ha de ser mayor que 0)"  + id));
		} else {
			//obtenemos la Roles
			Roles p = this.getById(id);			
			
			if (p != null) {
				CargasTemporales.roles.remove(p);
				
				CargasTemporales.roles.add(obj);
				
				res = obj;
			}			
		}
		
		if (res == null) {
			onError(null, new Exception("Update: No ha encontrado el objeto a actualizar con id " + id));
		}
		
		return res;
	}
	
	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#existUserName(string username)
	 */
	public boolean existUserName(String username) throws Exception {
		boolean existe = false; 
		
		try {	
		
			if (CargasTemporales.roles != null) {
				
				int contador = 0;
				while ( CargasTemporales.roles.size() >  contador ) {
				//comparamos ignorando may�sculas y min�sculas
		          if (CargasTemporales.roles.get(contador).getNombre().equalsIgnoreCase(username)) {
		        	  existe = true;
		        	  
		        	  //salimos del bucle
		        	  contador = CargasTemporales.roles.size();
		          }	
		          contador ++;
			    }
			}
		} catch (Exception ex) {
			onError(null, ex);
			throw ex;
		}
		
		return existe;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#existUserName(Roles Roles)
	 */
	public boolean existUserName(Roles Roles) throws Exception {
		try {		
			if(Roles == null) {
				onError(null, new Exception("existUserName: El objeto Roles no puede estar a null"));
			}			
			return this.existUserName(Roles.getNombre());
		} catch (Exception ex) {
			onError(null, ex);
			throw ex;
		}					
	}
	
	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloRoles#getByName(string username)
	 */
	public Roles getByName(String username) {
		Roles res = null;
		
		if (CargasTemporales.roles != null) {			
			int contador = 0;
			while ( CargasTemporales.roles.size() >  contador ) {
			//comparamos ignorando may�sculas y min�sculas
	          if (CargasTemporales.roles.get(contador).getNombre().equalsIgnoreCase(username)) {
	        	  res = CargasTemporales.roles.get(contador);
	        	  
	        	  //salimos del bucle
	        	  contador = CargasTemporales.roles.size();
	          }	
	          contador ++;
		    }
		}		
		
		//no ha encontrado el objeto
		if(res == null) {
			onError(null, new Exception("No se ha encontrado el usuario"));
		}
		
		
		return res;
	}

}
