package com.ipartek.formacion.busredsociales.criticalsteps;

import javax.servlet.ServletContext;

import com.ipartek.formacion.busredsociales.comun.Globales;
import com.ipartek.formacion.busredsociales.criticalsteps.CriticalStepLogic.ETypeCriticalError;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

public class CriticalStepBD extends CriticalStepFactory {

	DAOFactory factoria = null;
	
	
	public CriticalStepBD() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setConfiguration(ServletContext context) throws Exception {
		// TODO: Guardar la excepción por que puede que me interese
				try {

					// Obtenemos la factoria relativa al motor utilizado para el
					// almacenamiento de datos.
					factoria = DAOFactory
							.getDaoFactoriaAbstracta(Globales.GLOBAL_MOTOR);

					// obtenemos los modelos
					IUsuarioDAO modelUsuario = factoria.getUsuarioDAO();

					// Cargamos aquí todos los modelos que necesitemos, en el contexto
					// de los servlet
					context.setAttribute("modelUsuario", modelUsuario);

					// testeamos la conexión de todos los modelos
					factoria.checkConnection();

				} catch (DAOException e) {
					throw e;
					

				} catch (Exception e) {
					throw e;
				}

	}

	@Override
	public boolean checkConfiguration(ServletContext context) throws Exception {
		
		try {
			if(factoria == null) {
				//mal, cambiamos el estatus
				this.setStatus(false);
				throw new NullPointerException();
			}
			
			factoria.checkConnection();
			
		} catch (Exception ex) {
			//mal, cambiamos el estatus
			this.setStatus(false);
			throw ex;
		}
		
		//todo bien, actualizamos el estado
		this.setStatus(true);
		
		
		return getStatus();
	}

	@Override
	public ETypeCriticalError getTypeError() {
		return CriticalStepLogic.ETypeCriticalError.DATABASE;
		
	}

}
