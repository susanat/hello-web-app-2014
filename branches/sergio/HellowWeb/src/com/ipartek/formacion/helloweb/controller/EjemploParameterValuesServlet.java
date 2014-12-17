package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class EjemploParameterValuesServlet
 */
public class EjemploParameterValuesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploParameterValuesServlet() {
        super();
        
    }

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
		
		String opciones = request.getParameter("opciones");
		String[] gustos = request.getParameterValues("checkboxEnLinea");
		
		PrintWriter out = response.getWriter();
		
		if("text/html".equalsIgnoreCase(opciones)) {
			response.setContentType(opciones);
			
			out.print("<html>");
				out.print("<head>");
					out.print("<title>Tus gustos</title>");		
				out.print("</head>");
				out.print("<body>");
					out.print("<ol>");
					
					
					
					
					if(gustos != null) {
						for(String gusto : gustos) {
							out.print("<li>" + gusto + "</li>");
						}	
					} else {
						out.print("<li> No ha seleccionado ningún elemento </li>");
					}
					
					
					//out.print("<li>" + "tu gusto x" + "</li>");
					out.print("</ol>");
				out.print("</body>");		
			out.print("</html>");	
			
						
		} else if ("application/json".equalsIgnoreCase(opciones)) {
			//http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=GsonJavaJSON
			
			response.setContentType(opciones);
			response.setCharacterEncoding("UTF-8");
						
			String res = "";			
			Gson obj = new Gson();			
			if(gustos != null) {
				res = obj.toJson(gustos);				
			} else {
				res = obj.toJson("No se han escogido gustos");				
			}			
			out.print(res);
			
			
			
			
			
			
			/*
				JSONObject obj = new JSONObject();
				obj.put("Error", "false");
				
				JSONArray objArray = new JSONArray();
				if(gustos != null) {
					for(String gusto : gustos) {
						objArray.add(gusto);
					}	
				} 
				
				obj.put("mensaje", objArray.toJSONString());
				
				out.print(obj.toJSONString());
			*/
			
		}
		
		if(out != null)
		{
			out.flush();
			out.close();
		}
		
		
		
		
	}

}
