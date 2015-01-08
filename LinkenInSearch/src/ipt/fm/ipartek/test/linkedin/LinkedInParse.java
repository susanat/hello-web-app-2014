package ipt.fm.ipartek.test.linkedin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ipartek.formacion.linkedin.bean.Persona;

public class LinkedInParse {

	private static String SEARCH_URL = "https://es.linkedin.com/pub/dir/?";
	private String first;
	private String last;
	
	private ArrayList<Persona> personas = null;
	
	public LinkedInParse(String first, String last) {
		super();
		setFirst(first);
		setLast(last);
	}

	public void setFirst(String first) {
		this.first = "first=" + first + "&";
	}

	public void setLast(String last) {
		this.last = "last="+last+"&search=Buscar";
	}
	
	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public ArrayList<Persona> getHtml() {
		String resul  = "";
		
		personas = new ArrayList<Persona>();
		
		
		try {
			
			Document doc = Jsoup.connect( SEARCH_URL+getFirst()+getLast() ).get();
			Element listaResultados = doc.getElementById("result-set");
			
			if ( listaResultados != null ){
				
				resul = listaResultados.html();
				Elements personas2 = doc.getElementsByTag("h2");
				Elements fotos = doc.getElementsByClass("profile-photo");
				Iterator<Element> it = fotos.iterator();
				
				for (Element p:personas2){
					System.out.println(p.html());
					Elements nombre = p.getElementsByClass("given-name");
					Elements apellidos = p.getElementsByClass("family-name");
					String foto = null;
					if(it.hasNext()){
						foto = ((Element)it.next()).getElementsByTag("img").first().attr("src");
					}
					
					System.out.println(nombre.html()+' '+apellidos.html());
					personas.add(new Persona(0,nombre.html(), apellidos.html(), foto));
					
				}
			}else{
				return null;
				//resul = "<h1> 0 resultados </h1>";
			}
			
			
			
		} catch (IOException e) {
			resul = e.getMessage();		
			e.printStackTrace();
		}

		
		
		//return resul;
		return personas;
	}
	
	
	
	
	

}
