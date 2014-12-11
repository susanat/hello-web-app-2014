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

	    // out.print("<select><option value=\"a\">1</option><option value=\"2\">2</option></select>");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return EVAL_PAGE;

    }
}
