package ipt.fm.ipartek.test.linkedin;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;

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
		try {
			this.first = "first=" + URLEncoder.encode(first, "UTF-8") + "&";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLast(String last) {
		try {
			this.last = "last=" + URLEncoder.encode(last, "UTF-8")
					+ "&search=Buscar";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getHtml() {
		String resul = "";

		try {

			Document doc = Jsoup.connect(SEARCH_URL + getFirst() + getLast())
					.get();
			Element listaResultados = doc.getElementById("result-set");
			if (listaResultados != null) {

				Iterator<Element> perfiles = listaResultados.select("li.vcard")
						.iterator();

				String nombre = "";
				String apellidos = "";
				String foto = "";
				String boton = "";
				Element perfilActual = null;
				while (perfiles.hasNext()) {
					perfilActual = perfiles.next();
					perfilActual.select("ul").remove();
					nombre = perfilActual.select("span.given-name").text();
					apellidos = perfilActual.select("span.family-name").text();
					foto = perfilActual.select("img").attr("src");
					boton = "<form action=\"persona\" method=\"post\">"
							+ "<input type=\"hidden\" name=\"nombre\" value="
							+ nombre
							+ ">"
							+ "<input type=\"hidden\" name=\"apellidos\" value="
							+ apellidos
							+ ">"
							+ "<input type=\"hidden\" name=\"foto\" value="
							+ foto
							+ ">"
							+ "<input type=\"hidden\" name=\"operacion\" value=\"2\">"
							+ "<input type=\"submit\" value=\"Añadir\">"
							+ "</form>";
					perfilActual.append(boton);
				}

				resul = listaResultados.html();

			} else {
				resul = "<h1> 0 resultados </h1>";
			}

		} catch (IOException e) {
			resul = e.getMessage();
			e.printStackTrace();
		}

		return resul;
	}

}
