package com.ipartek.formacion.linkedin.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
		this.first = first;
	}

	public void setLast(final String last) {
		this.last = last;
	}

	public ArrayList<Persona> getHtml() {
		ArrayList<Persona> personas = null;
		String nombre = "";
		String apellidos = "";
		String foto = "";
		String basic = "";
		String expanded = "";
		Persona p = null;

		try {
			final Document doc = Jsoup.connect(
					SEARCH_URL + "first=" + URLEncoder.encode(getFirst(), "UTF-8") + "&" + "last="
							+ URLEncoder.encode(getLast(), "UTF-8") + "&search=Buscar").get();
			final Element listaResultados = doc.getElementById("result-set");
			final Element resultado = doc.getElementById("top-card");

			if (listaResultados != null) {
				personas = new ArrayList<Persona>();
				final int cant = listaResultados.getElementsByClass("vcard").size();

				for (int i = 0; i < cant; i++) {
					nombre = listaResultados.getElementsByClass("given-name").get(i).text();
					apellidos = listaResultados.getElementsByClass("family-name").get(i).text();
					foto = listaResultados.getElementsByTag("img").get(i).absUrl("src");
					basic = listaResultados.getElementsByClass("vcard-basic").get(i).html();
					expanded = listaResultados.getElementsByClass("vcard-expanded").get(i).html();

					p = new Persona(0, nombre, apellidos, foto, basic, expanded);
					personas.add(p);
				}

			} else if (resultado != null) {
				personas = new ArrayList<Persona>();

				nombre = getFirst();
				apellidos = getLast();
				foto = doc.getElementById("bg-blur-profile-picture").absUrl("src");
				resultado.getElementById("").remove(); // quitar el id que
														// contiene el nombre
				basic = resultado.select("[id^=member]").html();
				expanded = " ";

				p = new Persona(0, nombre, apellidos, foto, basic, expanded);
				personas.add(p);
			}
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return personas;
	}
}
