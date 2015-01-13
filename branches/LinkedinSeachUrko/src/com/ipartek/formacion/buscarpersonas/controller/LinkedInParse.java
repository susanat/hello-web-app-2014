package com.ipartek.formacion.buscarpersonas.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ipartek.formacion.buscarpersonas.bean.Persona;

public class LinkedInParse {

    // LINKEDIN TAGS
    public static final String PARAM_LINKEDIN_NAME = "first";
    public static final String PARAM_LINKEDIN_SURNAME = "last";
    public static final String PARAM_LINKEDIN_SEARCH = "search=Search";
    public static final String LINKEDIN_URL = "https://es.linkedin.com/pub/dir/?";
    public static final String LINKEDIN_ID = "result-set";

    public static ArrayList<Persona> getHtml(final Persona p) {
	ArrayList<Persona> result = null;
	String url = composeUrl(p);

	// resultados = getData(url);
	result = getData(url);
	return result;
    }

    private static ArrayList<Persona> getData(final String url) {
	Element data = null;
	Elements li = null;
	Document doc = null;
	Persona p = null;
	ArrayList<Persona> personas = null;
	try {
	    doc = Jsoup.connect(url).get();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	data = doc.getElementById(LINKEDIN_ID);
	li = data.select("li");
	personas = new ArrayList<Persona>();
	for (Element x : li) {
	    p = new Persona();
	    p.setNombre(x.select(".given-name").text());
	    p.setApellidos(x.select(".family-name").text());
	    p.setFoto(x.select(".photo").attr("abs:src"));
	    personas.add(p);
	}
	// System.out.println(p.getNombre());

	return personas;
    }

    private static String composeUrl(final Persona p) {
	String urlStr = LINKEDIN_URL + PARAM_LINKEDIN_NAME + "="
		+ p.getNombre() + "&" + PARAM_LINKEDIN_SURNAME + "="
		+ p.getApellidos() + "&" + PARAM_LINKEDIN_SEARCH;

	URL url = null;
	try {
	    url = new URL(urlStr);
	} catch (MalformedURLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	URI uri = null;
	try {
	    uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(),
		    url.getPort(), url.getPath(), url.getQuery(), url.getRef());
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	try {
	    url = uri.toURL();
	} catch (MalformedURLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return url.toString();
    }
}
