package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello2 extends TagSupport {

	private String nombre;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			if (nombre == null) {
				out.print("Saluda desconocido");
			} else {
				out.print("Saluda " + nombre);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// indica que siga ejecutando la pagina aunque se haya producido un
		// ERROR
		return EVAL_PAGE;

	}

}
