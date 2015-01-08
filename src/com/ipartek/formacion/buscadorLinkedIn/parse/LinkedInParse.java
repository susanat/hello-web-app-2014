package com.ipartek.formacion.buscadorLinkedIn.parse;

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
	this.last = "last=" + last + "&search=Buscar";
    }

    public String getFirst() {
	return first;
    }

    public String getLast() {
	return last;
    }

    public String getHtml() {
	String result = "";
	String formulario = "";
	String boton = "<button type='submit' form='formboton'>Insertar en BBDD</button>";
	String nombre = "";
	String apellido = "";
	try {
	    Document doc = Jsoup.connect(SEARCH_URL + getFirst() + getLast())
		    .get();
	    Element listaResultados = doc.getElementById("result-set");
	    if (listaResultados != null) {

		for (int i = 0; i < listaResultados.getElementsByClass(
			"given-name").size(); i++) {
		    // iteramos sobre los resultados y construimos el formulario

		    nombre = listaResultados.getElementsByClass("given-name")
			    .get(i).text();
		    apellido = listaResultados
			    .getElementsByClass("family-name").get(i).text();

		    formulario = "<form method='post' action='PersonaServlet'>"
			    + "<input type='text' hidden value='"
			    + nombre
			    + "' name='nombre'> <input type='text' hidden value='"
			    + apellido
			    + "' name='apellido'> <input type='submit' value='Añadir'>"
			    + "</form>";

		    listaResultados.getElementsByClass("family-name").get(i)
			    .after(formulario);

		}

		result = listaResultados.html();

	    } else {
		result = "<h1>0 resultados</h1>";
	    }

	} catch (IOException e) {
	    result = e.getMessage();

	}
	return result;
    }
}
