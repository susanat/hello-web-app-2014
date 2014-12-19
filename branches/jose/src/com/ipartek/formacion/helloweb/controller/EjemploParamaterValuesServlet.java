package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EjemploParamaterValuesServlet
 */
public class EjemploParamaterValuesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String mime = null;   
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//recoger tipo MIME o respuesta
		mime  = request.getParameter("tipoRespuesta");
		
		//HTML
		if ( "text/html".equalsIgnoreCase(mime)){
			responseHTML( request, response );	     
	     //JSON   
		}else if( "application/json".equalsIgnoreCase(mime)){
			responseJSON(request, response);
		//formato no soportado	
		}else{
			throw new ServletException("Formato de salida no soportado " + mime );
		}    
		
	}
	
	
	

	private void responseJSON(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		response.setContentType(mime);		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Gson jsonGustos = new Gson();
		
		//rellenar el objeto con los gustos del usuario
		String gustos[] = request.getParameterValues("pasa");
		String responseJson = jsonGustos.toJson(gustos); 
		
		//pintar salida
		out.print(responseJson);
		out.flush();
		
	}

	private void responseHTML(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType(mime);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Tus Gustos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Tus Gustos</h1>");
        	out.println("<ol>");	        		
        		//recoger paramtros multiples
        		String gustos[] = request.getParameterValues("pasa");
        		if ( gustos != null ){
	        		for (int i = 0; i < gustos.length; i++) {
	        			out.println("<li>" + gustos[i] + "</li>");	
					}
        		}else{
        			out.println("<li> eres un soso </li>");
        		}		        	
        		
        	out.println("</ol>");
        out.println("</body>");
        out.println("</html>");
		
	}
	
	

}
