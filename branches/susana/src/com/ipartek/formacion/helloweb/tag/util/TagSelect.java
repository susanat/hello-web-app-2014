package com.ipartek.formacion.helloweb.tag.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagSelect extends TagSupport {

    String[] idiomasList = null;

    public void setIdiomasList(String[] idiomasList) {
	this.idiomasList = idiomasList;
    }

    @Override
    public int doEndTag() throws JspException {
	try {

	    JspWriter out = pageContext.getOut();
	    out.print(" <select>");
	    for (int i = 0; i < idiomasList.length; i++) {
		out.print(" <option>" + idiomasList[i] + "</option> ");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	// Cuando la JSP se esta complilando sigue ejecutandose el codigo
	// (evalizandose o compilandole) aunque este falle
	// habra que ponerle un mensaja de error

	return EVAL_PAGE;

    }
}