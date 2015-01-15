package com.ipartek.formacion.buscarpersonas.controller;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.ipartek.formacion.buscarpersonas.bean.Persona;

public class LinkedInParse {

    private static String SEARCH_URL = "https://es.linkedin.com/pub/dir/?";
    private String first;
    private String last;

    public LinkedInParse(final String first, final String last) {
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

    public void setFirst(final String first) {
	this.first = "first=" + first + "&";
    }

    public void setLast(final String last) {
	this.last = "last=" + last + "&search=Buscar";
    }

    public ArrayList<Persona> getHtml() {
	ArrayList<Persona> personas = null;
	try {
	    Document doc = Jsoup.connect(SEARCH_URL + getFirst() + getLast())
		    .get();
	    Element listaResultados = doc.getElementById("result-set");
	    if (listaResultados != null) {
		personas = new ArrayList<Persona>();
		String nombre = "";
		String apellidos = "";
		String foto = "";
		String basic = "";
		String expanded = "";
		Persona p = null;
		int cant = listaResultados.getElementsByClass("vcard").size();
		for (int i = 0; i < cant; i++) {
		    nombre = listaResultados.getElementsByClass("given-name")
			    .get(i).text();
		    apellidos = listaResultados
			    .getElementsByClass("family-name").get(i).text();
		    foto = listaResultados.getElementsByTag("img").get(i)
			    .absUrl("src");
		    nombre = listaResultados.getElementsByClass("given-name")
			    .get(i).text();
		    basic = listaResultados.getElementsByClass("vcard-basic")
			    .get(i).html();
		    expanded = listaResultados
			    .getElementsByClass("vcard-expanded").get(i).html();
		    p = new Persona(0, nombre, apellidos, 18, foto, basic,
			    expanded);
		    personas.add(p);

		}

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return personas;
    }
}
