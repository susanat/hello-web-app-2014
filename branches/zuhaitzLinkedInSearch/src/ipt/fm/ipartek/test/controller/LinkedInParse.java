package ipt.fm.ipartek.test.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedInParse {

	private static String SEARCH_URL = "https://es.linkedin.com/pub/dir/?";
	private String first;
	private String last;
	private String foto;

	public LinkedInParse(final String first, final String last) {
		super();
		setFirst(first);
		setLast(last);

	}

	public void setFirst(final String first) {
		try {
			this.first = "first=" + URLEncoder.encode(first, "UTF-8") + "&";
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void setLast(final String last) {
		try {
			this.last = "last=" + URLEncoder.encode(last, "UTF-8") + "&search=Buscar";
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param foto
	 *            the foto to set
	 */
	public void setFoto(final String foto) {
		this.foto = foto;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	public String getHtml() {
		String res = "";

		try {
			final Document doc = Jsoup.connect(SEARCH_URL + getFirst() + getLast()).get();
			final Element listaResultados = doc.getElementById("result-set");
			final Element resultado = doc.getElementById("top-card");
			Elements el = null;

			if (listaResultados != null) {
				res = listaResultados.html();
			} else if (resultado != null) {
				el = resultado.getElementsByClass("profile-picture");
				res = el.html();

				el = resultado.select("[id^=member]");
				res += el.html();

				el.select("[src]");
				// el = el.getElementsByAttributeStarting("src");
				setFoto(el.html());
			} else {
				res = "<h1>0 resultados</h1>";
			}
		} catch (final IOException e) {
			res = e.getMessage();
			e.printStackTrace();
		}

		return res;
	}
}
