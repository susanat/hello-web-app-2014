package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello2 extends TagSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1622325344462950064L;

	private String nombre;

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			final JspWriter out = pageContext.getOut();
			if (nombre == null) {
				out.print("saluda anónimo");
			} else {
				out.print("saluda " + nombre);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
