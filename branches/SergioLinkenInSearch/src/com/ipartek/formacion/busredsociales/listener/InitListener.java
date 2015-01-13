package com.ipartek.formacion.busredsociales.listener;

import java.net.MalformedURLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.jni.Global;

import com.ipartek.formacion.busredsociales.comun.Globales;
import com.ipartek.formacion.busredsociales.comun.Globales.ETypeCriticalError;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
		ServletContextAttributeListener {

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {

		boolean isErrorCritico = false;

		System.out.println("Iniciado el contexto de los servlet");

		// TODO: obtener y conectar los logs
		System.out
				.println("Iniciada la configuración del log4j de la aplicación");

		// TODO: obtener y conectar a base de datos
		if (!isErrorCritico) {
			System.out.println("Iniciada la conexión a base de datos");
			isErrorCritico = isFactoryInContext(sce.getServletContext()) == true ? false : true;
			
			//marcamos el error para el filtro
			if(isErrorCritico) {
				Globales.GLOBAL_IS_CRITICAL_ERROR = true;
				Globales.GLOBAL_TYPE_CRITICAL_ERROR = ETypeCriticalError.DATABASE;
			}
		}

		// TODO: carga de tablas auxiliares no modificables
		System.out
				.println("Carga de tablas auxiliares no modificables (tabla de nombres de roles, por ejemplo)");

		// TODO: preparación de objetos de estadísticas
		System.out.println("Preparación objetos de estadísticas");

	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		ServletContext context = scab.getServletContext();

		// System.out.println("Añadido atributo context: " + scab.getName() +
		// context.getAttribute(scab.getName()));
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		ServletContext context = scab.getServletContext();
		// System.out.println("Modificado atributo context: " + scab.getName() +
		// context.getAttribute(scab.getName()));
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		ServletContext context = scab.getServletContext();
		// System.out.println("Eliminado atributo context: " + scab.getName() +
		// context.getAttribute(scab.getName()));
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// System.out.println("Destruido el contexto de los servlet");

		// TODO cerrar conexión a base de datos
		// System.out.println("Cerrada la conexión a base de datos");

		// TODO liberar memoria y cerrar
	}

	private boolean isFactoryInContext(ServletContext context) {
		// TODO: Guardar la excepción por que puede que me interese
		try {

			// Obtenemos la factoria relativa al motor utilizado para el
			// almacenamiento de datos.
			DAOFactory factoria = DAOFactory
					.getDaoFactoriaAbstracta(Globales.GLOBAL_MOTOR);

			// obtenemos los modelos
			IUsuarioDAO modelUsuario = factoria.getUsuarioDAO();

			// Cargamos aquí todos los modelos que necesitemos, en el contexto
			// de los servlet
			context.setAttribute("modelUsuario", modelUsuario);

			// testeamos la conexión de todos los modelos
			factoria.checkConnection();

			return true;

		} catch (DAOException e) {
			e.printStackTrace();
			

		} catch (Exception e) {
			// crítico			
			e.printStackTrace();
			

		}

		return false;

	}

}
