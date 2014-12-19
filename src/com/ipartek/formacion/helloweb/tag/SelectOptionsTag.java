package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {
    /**
     *
     */
    private static final long serialVersionUID = -9020784013052104549L;
    private String parameterName, idName, className, selectedValue;
    private ArrayList<String> opValues, opTexts;

    public void setParameterName(final String parameterName) {
	// this.cname = cname != null ? cname : "";
	this.parameterName = parameterName;
    }

    public void setIdName(final String idName) {
	// this.cid = cid != null ? cid : "";
	this.idName = idName;
    }

    public void setClassName(final String clase) {
	// this.cclase = clase != null ? clase : "";
	this.className = clase;
    }

    public void setOpValues(final ArrayList<String> valores) {
	if (valores != null) {
	    this.opValues = valores;
	} else {
	    this.opValues = new ArrayList<String>();
	}
    }

    public void setOpTexts(final ArrayList<String> text) {
	if (text != null) {
	    this.opTexts = text;
	} else {
	    this.opTexts = new ArrayList<String>();
	}
    }

    public void setSelectedValue(final String selectedValue) {
	this.selectedValue = selectedValue != null ? selectedValue : "";
    }

    @Override
    public int doEndTag() throws JspException {
	// String cadena = "<select ";
	StringBuffer text = new StringBuffer();
	text.append("<select ");
	try {// <select name='xxx' id='zzz' class='vvv'></select>
	    if (parameterName != null) {
		text.append("name='" + parameterName + "'");
	    }
	    if (idName != null) {
		text.append("id='" + idName + "'");
	    }
	    if (className != null) {
		text.append("class='" + className + "'");
	    }

	    text.append(" >");
	    if (opTexts != null && opValues != null) {
		text.append(cargarValores());
	    }
	    text.append("</select>");
	    JspWriter out = pageContext.getOut();
	    out.print(text);

	} catch (Exception e) {
	    // Logger.getLogger(e)
	    Logger logger = Logger.getAnonymousLogger();
	    logger.log(Level.SEVERE, "an exception was thrown", e);
	}
	return EVAL_PAGE;
    }

    private String cargarValores() {
	StringBuffer cadena = new StringBuffer();

	int len = opValues.size();

	for (int i = 0; i < len; i++) {
	    // System.out.println(opValues.get(i) + "- valor - " +
	    // selectedValue);
	    if (opValues.get(i).equalsIgnoreCase(selectedValue)) {
		// System.out.println("cogido");
		cadena.append("<option selected='selected' value='"
			+ opValues.get(i) + "'>" + opTexts.get(i) + "</option>");
	    } else {
		cadena.append("<option value='" + opValues.get(i) + "'>"
			+ opTexts.get(i) + "</option>");
	    }
	}
	/*
	 * for (Map.Entry<String, String> valor : valores.entrySet()) { key =
	 * valor.getKey(); val = valor.getValue(); cadena += "<option value='" +
	 * key + "'>" + val + "</option>"; }
	 */
	return cadena.toString();
    }
}
