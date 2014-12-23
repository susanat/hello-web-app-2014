package ipt.fm.ipartek.test.linkedin;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class LinkedInParse {

	private static String SEARCH_URL = "https://es.linkedin.com/pub/dir/?";
	private String first;
	private String last;
	
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

	public String getHtml() {
		String resul  = "";
		
		try {
			
			Document doc = Jsoup.connect( SEARCH_URL+getFirst()+getLast() ).get();
			Element listaResultados = doc.getElementById("result-set");
			if ( listaResultados != null ){
				
				resul = listaResultados.html();
				
			}else{
				resul = "<h1> 0 resultados </h1>";
			}
			
			
			
		} catch (IOException e) {
			resul = e.getMessage();		
			e.printStackTrace();
		}

		
		
		return resul;
	}
	
	
	
	
	

}
