package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello extends TagSupport {

    @Override
    public int doEndTag() throws JspException {
	try {
	    JspWriter out = pageContext.getOut();
	    out.print("Hello");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	// Cuando la JSP se esta complilando sigue ejecutandose el codigo
	// (evalizandose o compilandole) aunque este falle
	// habra que ponerle un mensaja de error

	return EVAL_PAGE;

    }

}