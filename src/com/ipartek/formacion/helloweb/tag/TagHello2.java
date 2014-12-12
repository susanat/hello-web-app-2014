package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello2 extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String nombre;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			if (nombre != null) {
				out.print("Hello " + nombre);
			} else {
				out.print("Hello");
			}

			// out.print("<select><option value=\"a\">1</option><option value=\"2\">2</option></select>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;

	}

}