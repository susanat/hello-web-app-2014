package ipt.fm.ipartek.test.linkedin;

import ipt.fm.ipartek.test.linkedin.bean.PersonaLinkedin;

import java.io.IOException;
import java.util.ArrayList;

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

	/**
	 * Obtiene un array con los diferentes usuarios encontrados en la busqueda de Linkedin
	 * @return lista de usuarios de Linkedin
	 */
	public ArrayList<PersonaLinkedin> getHtml() {
		ArrayList<PersonaLinkedin> vPersonas = null;

		try {

			Document doc = Jsoup.connect(SEARCH_URL + getFirst() + getLast())
					.get();
			Element listaResultados = doc.getElementById("result-set");
			vPersonas=obtenerPersonasLinkedin(listaResultados);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return vPersonas;
	}

	private ArrayList<PersonaLinkedin> obtenerPersonasLinkedin(
			Element listaResultados) {
		ArrayList<PersonaLinkedin> vPersonas = null;
		
		if (listaResultados != null) {
			vPersonas = new ArrayList<PersonaLinkedin>();			
			String nombre = "";
			String apellidos = "";
			String foto = "";
			String basic = "";
			String expanded = "";
			PersonaLinkedin p = null;

			int cant = listaResultados.getElementsByClass("vcard").size();
			for (int i = 0; i < cant; i++) {
				nombre = listaResultados.getElementsByClass("given-name")
						.get(i).text();
				apellidos = listaResultados.getElementsByClass("family-name")
						.get(i).text();
				foto = listaResultados.getElementsByTag("img").get(i)
						.absUrl("src");
				nombre = listaResultados.getElementsByClass("given-name")
						.get(i).text();
				basic = listaResultados.getElementsByClass("vcard-basic")
						.get(i).html();
				expanded = listaResultados.getElementsByClass("vcard-expanded")
						.get(i).html();
				p = new PersonaLinkedin(nombre, apellidos, foto, basic,
						expanded);
				vPersonas.add(p);
			}
		}
		return vPersonas;
	}

}
