package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {

	private String parameterName;
	private String idValue;
	private String className;
	private ArrayList<String> opValues;
	private ArrayList<String> opTextos;
	private String selectedValue;

	public void setParameterName(String nameSelect) {
		this.parameterName = nameSelect;
	}

	public void setIdValue(String idSelect) {
		this.idValue = idSelect;
	}

	public void setClassName(String classSelect) {
		this.className = classSelect;
	}

	public void setOpValues(ArrayList<String> valuesOptions) {
		this.opValues = valuesOptions;
	}

	public void setOpTextos(ArrayList<String> textosOptions) {
		this.opTextos = textosOptions;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			String opcion = null;
			String texto = null;
			String parametros = null;
			JspWriter out = pageContext.getOut();
			StringBuffer sBuffer = new StringBuffer("<select name='"
					+ parameterName + "'");
			parametros = (idValue != null ? " id='" + idValue + "'" : "");
			sBuffer.append(parametros);
			parametros = (className != null ? " class='" + className + "'" : "");
			sBuffer.append(parametros);
			sBuffer.append(">");
			if (opValues.size() == opTextos.size()) {
				Iterator<String> iOpValues = opValues.iterator();
				Iterator<String> iOpTextos = opTextos.iterator();
				while (iOpValues.hasNext()) {
					opcion = iOpValues.next();
					texto = iOpTextos.next();
					if (opcion.equalsIgnoreCase(selectedValue)) {
						sBuffer.append("<option value='" + opcion
								+ "' selected>" + texto + "</option>");
					} else {
						sBuffer.append("<option value='" + opcion + "'>"
								+ texto + "</option>");
					}

				}
			}
			sBuffer.append("</select>");
			out.print(sBuffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
