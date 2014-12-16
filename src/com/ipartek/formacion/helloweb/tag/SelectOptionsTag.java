package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {
    private ArrayList<String> valor;
    private ArrayList<String> texts;
    private String selectedvalue = null;
    String parameterName = null;
    String className = null;
    String idValue = null;

    public void setValor(ArrayList<String> valor) {
	if (valor != null) {
	    this.valor = valor;
	} else {
	    valor = new ArrayList<String>();
	}

    }

    public void setTexts(ArrayList<String> texts) {
	if (texts != null) {
	    this.texts = texts;
	} else {
	    texts = new ArrayList<String>();
	}
    }

    public void setSelectedvalue(String selectedvalue) {
	if (selectedvalue != null) {
	    this.selectedvalue = selectedvalue;
	} else {
	    this.selectedvalue = "";
	}

    }

    public void setParameterName(String parameterName) {
	this.parameterName = parameterName;
    }

    public void setIdValue(String idValue) {
	this.idValue = idValue;
    }

    public void setClassName(String className) {
	this.className = className;
    }

    @Override
    public int doEndTag() throws JspException {
	try {
	    JspWriter out = pageContext.getOut();
	    if ((valor != null) && (texts != null)
		    && (texts.size() == valor.size())) {
		// start Tag
		out.print("<select ");
		out.print((parameterName != null) ? " name='" + parameterName
			+ "'" : "");
		out.print((idValue != null) ? " id='" + idValue + "'" : "");
		out.print((className != null) ? " class='" + className + "'"
			: "");
		out.print(">");

		for (int i = 0; i < valor.size(); i++) {

		    if (valor.get(i).equals(selectedvalue)) {
			out.print("<option value=" + valor.get(i)
				+ " selected>");
		    } else {
			out.print("<option value=" + valor.get(i) + ">");
		    }

		    out.print(texts.get(i));
		    out.print("</option>");
		}
		out.print("</select>");
	    }
	    // out.print("<select><option value=\"a\">1</option><option value=\"2\">2</option></select>");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return EVAL_PAGE;

    }
}
