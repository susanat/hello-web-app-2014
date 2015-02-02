package com.ipartek.formacion.pruebas.jquerymobile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHome
 */
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean isMobil = false;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//detectar el tipo de dispositivo
		isMobil = detectarUserAgentMobile(request);
		
		if ( !isMobil){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{		
			request.getRequestDispatcher("index.mobile.jsp").forward(request, response);;
		}	
		
	}
	
	
	/**
	 * Detecta el agente de usuario y nos dice si es mobil o no
	 * 
	 * @param request peticion del usuario
	 * @return true si es un mobil; false en caso contrario
	 */
	private boolean detectarUserAgentMobile ( HttpServletRequest request ){
		boolean resul = true; 
		
		return resul;
	}
	
	

}
