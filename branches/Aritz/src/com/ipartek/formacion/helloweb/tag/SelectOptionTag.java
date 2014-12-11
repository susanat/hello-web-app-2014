package com.ipartek.formacion.helloweb.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionTag extends TagSupport {

	ArrayList<String> opValues = null;
	ArrayList<String> opText = null;
	String selectedValue = null;
	String parameterName = null;
	String className = null;
	String idValue = null;

	public void setOpValues(ArrayList<String> opValues) {

		if (opValues != null) {
			this.opValues = opValues;
		} else {
			this.opValues = new ArrayList<String>();
		}

	}

	public void setOpText(ArrayList<String> opText) {
		if (opText != null) {
			this.opText = opText;
		} else {
			this.opText = new ArrayList<String>();
		}
	}

	public void setSelectedValue(String selectedValue) {

		this.selectedValue = selectedValue;
	}

	public void setParameterName(String parameterName) {

		this.parameterName = parameterName;
	}

	public void setClassName(String className) {

		this.idValue = className;
	}

	public void setIdValue(String idValue) {

		this.idValue = idValue;
	}

	@Override
	public int doEndTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();

			if ((opValues != null) && (opText != null)
					&& (opText.size() == opValues.size())) {
				out.print("<select ");
				out.print((parameterName != null) ? "name='" + parameterName
						+ "' " : "");
				out.print((idValue != null) ? "id='" + idValue + "' " : "");
				out.print((className != null) ? "class='" + className + "' "
						: "");
				out.print(">");
			}

			for (int i = 0; i < opValues.size(); i++) {

				if (opValues.get(i).equals(selectedValue)) {
					out.print("<option selected value=" + opValues.get(i) + ">");
				} else {
					out.print("<option value=" + opValues.get(i) + ">");
				}
				out.print(opText.get(i));
				out.print("</option>");
			}

			out.print("</select>");

		} catch (IOException e) {
			throw new JspException("Error: IOException" + e.getMessage());
		}
		return EVAL_PAGE;
	}

}
