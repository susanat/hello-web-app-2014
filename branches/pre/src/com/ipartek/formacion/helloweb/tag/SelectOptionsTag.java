package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Libreria de Tags para implemntar un combo de html SELECT OPTIONS
 * 
 * @author ur00
 *
 */
public class SelectOptionsTag extends TagSupport {

    // parametros del TLD
    ArrayList<String> opValues = null;
    ArrayList<String> opTexts = null;
    String selectedValue = null;
    String parameterName = null;
    String className = null;
    String idValue = null;

    // setters para los parametros
    public void setOpValues(ArrayList<String> opValues) {
	if (opValues != null) {
	    this.opValues = opValues;
	} else {
	    this.opValues = new ArrayList<String>();
	}
    }

    public void setOpTexts(ArrayList<String> opTexts) {
	if (opTexts != null) {
	    this.opTexts = opTexts;
	} else {
	    this.opTexts = new ArrayList<String>();
	}
    }

    public void setClassName(String className) {
	this.className = className;
    }

    public void setSelectedValue(String selectedValue) {
	this.selectedValue = selectedValue;
    }

    public void setParameterName(String parameterName) {
	this.parameterName = parameterName;
    }

    public void setIdValue(String idValue) {
	this.idValue = idValue;
    }

    // Implementacion cuando se cierra la etiqueta
    @Override
    public int doEndTag() throws JspException {
	try {
	    JspWriter out = pageContext.getOut();
	    if ((opValues != null) && (opTexts != null)
		    && (opTexts.size() == opValues.size())) {
		// start Tag
		out.print("<select ");
		out.print((parameterName != null) ? " name='" + parameterName
			+ "'" : "");
		out.print((idValue != null) ? " id='" + idValue + "'" : "");
		out.print((className != null) ? " class='" + className + "'"
			: "");
		out.print(">");

		// options
		for (int i = 0; i < opValues.size(); i++) {
		    if (opValues.get(i).equals(selectedValue)) {
			out.print("<option selected value=" + opValues.get(i)
				+ ">");
		    } else {
			out.print("<option value=" + opValues.get(i) + ">");
		    }
		    out.print(opTexts.get(i));
		    out.print("</option>");
		}
		// end tag
		out.print("</select>");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return EVAL_PAGE;

    }

}
