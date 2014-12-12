package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String identificador;
	private String clase;
	private ArrayList<String> valores;
	private ArrayList<String> texts;
	private String selected;

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("<select name=\"" + nombre + "\"");
			if (identificador != null) {
				out.print(" id=\"" + identificador + "\"");
			}
			if (clase != null) {
				out.print(" class=\"" + clase + "\"");
			}
			out.print(">");
			for (int i = 0; i < valores.size(); i++) {
				out.print("<option value=\"" + valores.get(i) + "\"");
				if (selected.equals(valores.get(i))) {
					out.print(" selected ");
				}
				out.print(">" + texts.get(i) + "</option>");
			}
			out.print("</select>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;

	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public void setValores(ArrayList<String> valores) {
		this.valores = valores;
	}

	public void setTexts(ArrayList<String> texts) {
		this.texts = texts;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

}
