package com.ipartek.formacion.pruebas.jquerymobile;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHome
 */
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	enum eDispositivo {
		movil,
		pc
	}
	
	public enum Strings {
	    MOBIL(".mobile.html"),
	    PC(".html")
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    private Strings(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
	}
	
    
	private eDispositivo dispositivo = eDispositivo.pc;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		RequestDispatcher dispatcher = null;
		
		//detectar el tipo de dispositivo
		dispositivo = detectarUserAgent(request);
		
		
		switch (dispositivo) {
		case pc:
			dispatcher = request.getRequestDispatcher("desktop/index.jsp");
			break;

		case movil:
			dispatcher = request.getRequestDispatcher("mobile/index.mobile.jsp");
			break;
		default:
			break;
		}
		
		
		dispatcher.forward(request, response);
		
	}
	
	/**
	 * Detecta el agente de usuario y nos dice si el mobil, pc, etc...
	 * @param request
	 * @return eDispositivo Tipo de dispositivo
	 */
	private eDispositivo detectarUserAgent (HttpServletRequest request) {
		
		eDispositivo result = this.dispositivo;
		
		
		
		 System.out.println("Request Headers:");
		    Enumeration names = request.getHeaderNames();
		    while (names.hasMoreElements()) {
		      String name = (String) names.nextElement();
		      Enumeration values = request.getHeaders(name); // support multiple values
		      if (values != null) {
		        while (values.hasMoreElements()) {
		          String value = (String) values.nextElement();
		          System.out.println(name + ": " + value);
		        }
		      }
		    }
		    
		if(request.getHeader("user-agent").toLowerCase().contains("mobi")) {
			result = eDispositivo.movil;
		} else {
			result = eDispositivo.pc;
		}
		   
		result = eDispositivo.movil;
		
		return result;
	}

}
