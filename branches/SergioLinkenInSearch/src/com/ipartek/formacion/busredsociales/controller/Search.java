package com.ipartek.formacion.busredsociales.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ipartek.formacion.busredsociales.bean.Usuario;
import com.ipartek.formacion.busredsociales.comun.Constantes;




/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		URL url = null;
				
		try {
			
			url = getBuildLinkedInUrl(request);
						
			
			if(url !=null) {
				//lista.add( url.toString());
			} else {
				lista = null;
			}
			
			
			//lista = null;
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			//lista.add(e.getMessage());
			lista = null;
		}
	
		
		try {
			//paso uno realizado
			//Paso 2: búsqueda
			if(url != null) {
				
				Document doc = Jsoup.connect(url.toString()).get();
				
				Elements elements = doc.getElementsByClass("vcard");
					
				
				Iterator<Element> it = elements.iterator();
	            while (it.hasNext() ) {
	                Element el = it.next();
	                
	                //obtengo el nombre y apellidos
	                String nombre = el.getElementsByClass("given-name").text();
	                String apellidos = el.getElementsByClass("family-name").text();
	               	                
	                lista.add(new Usuario(nombre, apellidos));
	            }
			}
		} catch (Exception ex) {
			//lista.add(ex.getMessage());
			ex.printStackTrace();
		}
						
		request.setAttribute(Constantes.ATTR_LISTADO, lista);
				
		//redirigimos
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("resultados.jsp");	    
		dispatcher.forward(request, response);	
	}
	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	/**
	 * Construye la url de busqueda para LinkedIn
	 * 
	 * @param request Petición
	 * @return String con la url o vacío si ha ocurrido algún error o faltan los parámetros necesarios
	 * @throws URISyntaxException 
	 * @throws MalformedURLException 
	 */
	private URL getBuildLinkedInUrl(HttpServletRequest request) throws URISyntaxException, MalformedURLException {
				
		//https://es.linkedin.com/pub/dir/?first=Sergio&last=Rubio&search=Search&searchType=fps		
		String urlBusquedaPre = "//es.linkedin.com/pub/dir/?";
		String urlBusquedaPost = "&search=Search&searchType=fps";
		String urlBusquedaMed = "";
		
		
		URI uri = null;
		URL url = null;
			
		//obtengo los parámetros
		Object nombre = request.getParameter("txtnombre");
		Object apellidos = request.getParameter("txtapellidos");
		
		
		
		if (nombre != null && nombre.toString().trim() != "") {
			urlBusquedaMed += "first=" + nombre.toString();
		}
		
		
		if (apellidos != null && apellidos.toString().trim() != "") {
			//concatenamos el & si existe el primer parámetro
			if(nombre!= null && nombre.toString().trim() != "") {
				urlBusquedaMed += "&";
			}							
			
			urlBusquedaMed += "last=" + apellidos.toString();
		}
		
		if(urlBusquedaMed.trim() == "" ) {
			//no hay parámetros de entrada
			urlBusquedaPre = "";		
		} else {
			
			urlBusquedaPre += urlBusquedaMed + urlBusquedaPost;
			uri = new URI("https", urlBusquedaPre, null);
		}
		
		
		if (uri != null) {
			url = uri.toURL();
		}
		
		
		return url;		
	}
	
	

}
