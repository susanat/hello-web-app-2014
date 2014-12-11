package com.ipartek.formacion.helloweb.tag.util;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Libreria de Tags para implementar un combo select
 * 
 * @author Maitane Casado
 *
 */
public class TagSelect extends TagSupport {

	// parametros TLD
	ArrayList<String> opValues = null;
	ArrayList<String> opTexts = null;
	String selectedValue = null;
	String className = null;
	String idValue = null;
	String parameterName = null;

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

	public void setSelectedValue(String selectedValue) {
		if (selectedValue != null) {
			this.selectedValue = selectedValue;
		} else {
			this.selectedValue = "";
		}

	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			if ((opValues != null) && (opTexts != null)
					&& (opTexts.size() == opValues.size())) {
				// empieza Tag
				out.print("<select ");
				out.print((parameterName != null) ? " name='" + parameterName
						+ "'" : "");
				out.print((idValue != null) ? " id='" + idValue + "'" : "");
				out.print((className != null) ? " class='" + className + "'"
						: "");
				out.print(">");

				// options
				for (int i = 0; i < opValues.size(); i++) {
					if (opValues.get(i).equals(selectedValue.toUpperCase())) {
						out.print("<option selected value=" + opValues.get(i)
								+ ">");
					} else {
						out.print("<option value=" + opValues.get(i) + ">");
					}
					out.print(opTexts.get(i));
					out.print("</option>");
				}
				// end Tag
				out.print("</select>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;

	}

}
