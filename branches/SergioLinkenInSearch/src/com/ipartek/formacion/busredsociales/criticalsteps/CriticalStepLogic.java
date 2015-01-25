package com.ipartek.formacion.busredsociales.criticalsteps;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;


public final class CriticalStepLogic {

	private static List<CriticalStepFactory> lstComprobaciones = null;
	
	
	/**
	 * Tipo errores críticos de arranque del programa
	 */	
	public static enum ETypeCriticalError {
		LOG,
		DATABASE,
		AUXILIAR_TABLES,
		STADISTICS
	}
	
	private static boolean criticalError;
	public static boolean getCriticalError() {
		return criticalError;
	}
	
	public static void setCriticalError(boolean criticalError) {
		CriticalStepLogic.criticalError = criticalError;
	}
	
	
	
	public static ETypeCriticalError GLOBAL_TYPE_CRITICAL_ERROR = null;
	
	
	
	private CriticalStepLogic() {
		
	}
	
	static {
		loadListSteps();
		CriticalStepLogic.setCriticalError(true);
	}
	
	
	/**
	 * Carga los pasos que se realizarán
	 */
	private static void loadListSteps() {
		
		if(lstComprobaciones == null) {
		
			//instanciamos el listado
			lstComprobaciones = new ArrayList<CriticalStepFactory>();		
			
			//Le añadimos los pasos
			
			//Paso de comprobación para la base de datos
			lstComprobaciones.add(new CriticalStepBD());
		}
	}
	
	
	public static void configureAllSteps(ServletContext contexto) {
		// cargamos la lista de pasos críticos
		boolean isErrorCritico = false;

		int i = 0;
		
		//variable para cada paso
		CriticalStepFactory step = null;

		while (!isErrorCritico && i < lstComprobaciones.size()) {

			// obtenemos el paso
			step = lstComprobaciones.get(i);

			try {
				// en este caso asignamos la configuración
				step.setConfiguration(contexto);

				// en este caso comprobamos la configuración
				step.checkConfiguration(contexto);
				
				CriticalStepLogic.setCriticalError(false);

			} catch (Exception e) {
				// marcamos como error crítico
				isErrorCritico = true;
				CriticalStepLogic.setCriticalError(true);

				//obtenemos el tipo de error crítico
				CriticalStepLogic.GLOBAL_TYPE_CRITICAL_ERROR = step.getTypeError();
			}

			i++;
			step = null;			
		}
		
	}
	
	
	public static void checkAllSteps(ServletContext contexto) {
		// cargamos la lista de pasos críticos
		boolean isErrorCritico = false;

		int i = 0;
		
		//variable para cada paso
		CriticalStepFactory step = null;

		while (!isErrorCritico && i < lstComprobaciones.size()) {

			// obtenemos el paso
			step = lstComprobaciones.get(i);

			try {				
				// Solo comprobamos la configuración
				step.checkConfiguration(contexto);
				
				CriticalStepLogic.setCriticalError(false);

			} catch (Exception e) {
				// marcamos como error crítico
				isErrorCritico = true;
				CriticalStepLogic.setCriticalError(true);

				//obtenemos el tipo de error crítico
				CriticalStepLogic.GLOBAL_TYPE_CRITICAL_ERROR = step.getTypeError();
			}

			i++;
			step = null;			
		}
	}
	

}
