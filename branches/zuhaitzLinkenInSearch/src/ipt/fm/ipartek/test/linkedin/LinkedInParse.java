package ipt.fm.ipartek.test.linkedin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

	public void setFirst(final String first) {
		try {
			this.first = URLEncoder.encode("first=" + first + "&", "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void setLast(final String last) {
		try {
			this.last = URLEncoder.encode("last=" + last + "&search=Buscar", "UTF-8");
		} catch (final UnsupportedEncodingException e) {
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
			final Document doc = Jsoup.connect(SEARCH_URL + getFirst() + getLast()).get();
			final Element listaResultados = doc.getElementById("result-set");
			if (listaResultados != null) {
				resul = listaResultados.html();
			} else {
				resul = "<h1> 0 resultados </h1>";
			}
		} catch (final IOException e) {
			resul = e.getMessage();
			e.printStackTrace();
		}

		return resul;
	}

}
