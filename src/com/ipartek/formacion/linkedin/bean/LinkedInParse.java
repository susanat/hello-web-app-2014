package com.ipartek.formacion.linkedin.bean;

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

    public String getFirst() {
	return first;
    }

    public String getLast() {
	return last;
    }

    public void setFirst(String first) {
	this.first = "first=" + first + "&";
    }

    public void setLast(String last) {
	this.last = "last=" + last + "&search=Buscar";
    }

    public String getHtml() {
	String resul = "";
	String form = "";
	try {
	    Document doc = Jsoup.connect(SEARCH_URL + getFirst() + getLast())
		    .get();
	    Element listaResultados = doc.getElementById("result-set");
	    if (listaResultados != null) {
		String nombre = "";
		String apellidos = "";
		String foto = "";
		int cant = listaResultados.getElementsByClass("vcard").size();
		for (int i = 0; i < cant; i++) {
		    nombre = listaResultados.getElementsByClass("given-name")
			    .get(i).text();
		    apellidos = listaResultados
			    .getElementsByClass("family-name").get(i).text();
		    foto = listaResultados.getElementsByTag("img").get(i)
			    .absUrl("src");

		    form = "<form action='persona' method='post'>";
		    form += "<input type='hidden' name='nombre' value='"
			    + nombre + "'>";
		    form += "<input type='hidden' name='apellidos' value='"
			    + apellidos + "'>";
		    form += "<input type='hidden' name='foto' value='" + foto
			    + "'>";
		    form += "<input type='hidden' name='operacion' value='1'>";

		    form += "<input type='submit' value='Añadir'></form>";
		    listaResultados.getElementsByClass("vcard").get(i)
			    .append(form);
		}

		resul = listaResultados.html();

	    } else {
		resul = "<h1> 0 resultados</h1>";

	    }

	} catch (Exception e) {
	    resul = e.getMessage();
	    e.printStackTrace();
	}

	return resul;
    }
}
