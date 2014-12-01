/**
 * 
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;


/**
 * Implementación para la Persistencia de las Personas
 *  
 * @author Sergio Rubio Nieto
 *
 */
public class ModeloPersona implements IModeloPersona {

	//TODO: implementar base BBDD

	
	/**
	 * Array de listeners
	 *
	 * @version 30.09.2013
	 */
	private List<onModelPersonaError> onIError = new ArrayList<onModelPersonaError>();

	/**
	 * Funci�n para a�adir el listener
	 * 
	 * @param listener
	 *            listener a a�adir
	 */
	public void setOnIError(onModelPersonaError listener) {
		onIError.add(listener);
	}

	/**
	 * Funci�n para remover el l�stener
	 * 
	 * @param listener
	 *            listener a remover
	 */
	public void removeOnIError(onModelPersonaError listener) {
		onIError.remove(listener);
	}

	/**
	 * Funci�n que recorre el array de listener y los ejecuta
	 * 
	 * @param chk
	 *            checkBox del item
	 */
	private void onError(Persona obj, Exception ex) {
		for (onModelPersonaError listener : onIError)
			listener.onException(obj, ex);;
	}

	

	// ////FIN LOGICA DE LOS EVENTOS

	
	
	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getAll()
	 */
	public List<Persona> getAll() {
		
		List<Persona> lstTemp = null;
		
		if(CargasTemporales.personas != null && CargasTemporales.personas.size() > 0) {
			lstTemp = new ArrayList<Persona>(CargasTemporales.personas);
		}
		
		
		return lstTemp;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#getById(int)
	 */
	public Persona getById(int id) {
		Persona perTemp = null;
		
		if (id < 0) {
			onError(null, new Exception("GetById: Identificador no válido (ha de ser mayor que 0): " + id));
		} else {
			if (CargasTemporales.personas != null) {
				
				int contador = 0;
				while ( CargasTemporales.personas.size() >  contador ) {
			          if (CargasTemporales.personas.get(contador).getId() == id ) {
			        	  perTemp = CargasTemporales.personas.get(contador);
			        	  
			        	  contador = CargasTemporales.personas.size();
			          }	
			          contador ++;
			    }
			}
		}		
		
		return perTemp;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#Insert(com.ipartek.formacion.helloweb.bean.Persona)
	 */
	public Persona Insert(Persona obj) {
		
		Persona res = null;		
		
		
		if(obj == null) {
			onError(obj, new Exception("Insertar: El objeto pasado no puede ser null"));
		} else {
			if(CargasTemporales.personas == null) {
				CargasTemporales.personas = new ArrayList<Persona>();
			}
				
			obj.setId(getLastId());			
			CargasTemporales.personas.add(obj);
			
			res = obj;
		}		
		
		
		return res;
		
		
	}
	
	private int getLastId() 
	{
		int lastIndex = 0;
		
		TreeSet<Integer> sortId = new TreeSet<Integer>(); 
		
		if(CargasTemporales.personas != null) {
			for (Persona persona : CargasTemporales.personas) {
				sortId.add(persona.getId());
			}
			
			if(sortId.size() > 0) {
				lastIndex = sortId.last();
			}
		}
		
		return lastIndex + 1;
	}

	
	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#delete(int, com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.EBorrado)
	 */
	public boolean delete(int id, EBorrado tipoBorrado) {
		
		Boolean res = false;
		
		if (id < 0) {
			onError(null, new Exception("Delete: Identificador no válido (ha de ser mayor que 0): "  + id));
		} else {
			//obtenemos la persona
			Persona p = this.getById(id);			
			
			if (p != null) {
				CargasTemporales.personas.remove(p);
				res = true;
			}			
		}
				
		return res;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona#update(int, com.ipartek.formacion.helloweb.bean.Persona)
	 */
	public Persona update(int id, Persona obj) {
		Persona res = null;
		
		if (id < 0) {
			onError(null, new Exception("Update: Identificador no válido (ha de ser mayor que 0)"  + id));
		} else {
			//obtenemos la persona
			Persona p = this.getById(id);			
			
			if (p != null) {
				CargasTemporales.personas.remove(p);
				
				CargasTemporales.personas.add(obj);
				
				res = obj;
			}			
		}
		
		if (res == null) {
			onError(null, new Exception("Update: No ha encontrado el objeto a actualizar con id " + id));
		}
		
		return res;
	}

}
