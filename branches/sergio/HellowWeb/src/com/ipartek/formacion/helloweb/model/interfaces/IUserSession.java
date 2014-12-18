package com.ipartek.formacion.helloweb.model.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.Roles;
import com.ipartek.formacion.helloweb.bean.estadisticas.UserSession;

public interface IUserSession {
		
	
	/**
	 * Interface de eventos
	 * 
	 */
	public interface onModelUserSessionError {
		void onException(Roles obj, Exception ex);		
	}
		
	
	/**
	 * Añade una nueva sesion
	 * @param request
	 * @return
	 */
	public boolean add(HttpServletRequest request);
		
	/**
	 * Marca como finalizada una sesión añadíendole la fecha final
	 * siempre que no esté ya finalizada.
	 * @param idSession Identificador de la sesion
	 * @return true si ha eliminado correctamente, false si no
	 */
	public boolean terminate(String idSession);
	
	/**
	 * Elimina sesiones activas o inactivas por sesion
	 * @param idSession Identificador de la sesion
	 * @return true si ha eliminado correctamente, false si no
	 */
	public boolean delete(String idSession);

}
