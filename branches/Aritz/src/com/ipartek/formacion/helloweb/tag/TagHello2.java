package com.ipartek.formacion.helloweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello2 extends TagSupport {

	private String nombre;

	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print("Saluda desconocido");
			if (nombre != null) {
				pageContext.getOut().print("saluda " + nombre + "!");
			}
		} catch (IOException e) {
			throw new JspException("Error: IOException" + e.getMessage());
		}
		return SKIP_BODY;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
