package com.ipartek.formacion.busredsociales.criticalsteps;

import javax.servlet.ServletContext;

import com.ipartek.formacion.busredsociales.comun.Globales;
import com.ipartek.formacion.busredsociales.criticalsteps.CriticalStepLogic.ETypeCriticalError;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;
import com.ipartek.formacion.busredsociales.dao.factoria.mysql.MysqlDAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

public class CriticalStepBD extends CriticalStepFactory {

	//patrón singleton para esta clase @see: http://es.wikipedia.org/wiki/Singleton	
	private static CriticalStepBD INSTANCE = null;
		
	private CriticalStepBD() {}
	
	private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized(CriticalStepBD.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCE == null) { 
                    INSTANCE = new CriticalStepBD();
                }
            }
        }
    }
	
	public static CriticalStepBD getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
	
	

	private DAOFactory factoriaDao = null;

	@Override
	public void setConfiguration(ServletContext context) throws Exception {
		// TODO: Guardar la excepción por que puede que me interese
				try {

					// Obtenemos la factoria relativa al motor utilizado para el
					// almacenamiento de datos.
					factoriaDao = DAOFactory
							.getDaoFactoriaAbstracta(Globales.GLOBAL_MOTOR);

					// obtenemos los modelos
					IUsuarioDAO modelUsuario = factoriaDao.getUsuarioDAO();

					// Cargamos aquí todos los modelos que necesitemos, en el contexto
					// de los servlet
					context.setAttribute("modelUsuario", modelUsuario);

					// testeamos la conexión de todos los modelos
					factoriaDao.checkConnection();

				} catch (DAOException e) {
					throw e;
					

				} catch (Exception e) {
					throw e;
				}

	}

	@Override
	public boolean checkConfiguration(ServletContext context) throws Exception {
		
		try {
			if(factoriaDao == null) {
				//mal, cambiamos el estatus
				this.setStatus(false);
				throw new NullPointerException();
			}
			
			factoriaDao.checkConnection();
			
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
