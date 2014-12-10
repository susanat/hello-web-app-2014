package com.ipartek.formacion.helloweb.tag;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {
    private String cname, cid, cclase;

    public void setCname(final String cname) {
	this.cname = cname;
    }

    public void setCid(final String cid) {
	this.cid = cid;
    }

    public void setCclase(final String cclase) {
	this.cclase = cclase;
    }

    @Override
    public int doEndTag() throws JspException {
	String cadena = "<select ";
	try {// <select name='xxx' id='zzz' class='vvv'></select>
	    if (cname != null) {
		cadena += "name='" + cname + "'";
	    }
	    if (cid != null) {
		cadena += "id='" + cid + "'";
	    }
	    if (cclase != null) {
		cadena += "class='" + cclase + "'";
	    }
	    cadena += "</select>";
	    JspWriter out = pageContext.getOut();
	    out.print(cadena);

	} catch (Exception e) {
	    // Logger.getLogger(e)
	    Logger logger = Logger.getAnonymousLogger();
	    logger.log(Level.SEVERE, "an exception was thrown", e);
	}
	return EVAL_PAGE;
    }
}
