package com.ipartek.formacion.helloweb.tag;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello2 extends TagSupport {
    private String nombre;

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    @Override
    public int doEndTag() throws JspException {
	try {
	    JspWriter out = pageContext.getOut();
	    if (nombre != null) {
		out.print("Saluda" + nombre);
	    } else {
		out.print("Saluda unknown");
	    }
	} catch (Exception e) {
	    // Logger.getLogger(e)
	    Logger logger = Logger.getAnonymousLogger();
	    logger.log(Level.SEVERE, "an exception was thrown", e);
	}
	return EVAL_PAGE;
    }
}
