package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {

	private String nameSelect;
	private String idSelect;
	private String classSelect;
	private ArrayList<String> valuesOptions;
	private String[] textosOptions;
	private int indSeleccionOption;

	public void setNameSelect(String nameSelect) {
		this.nameSelect = nameSelect;
	}

	public void setIdSelect(String idSelect) {
		this.idSelect = idSelect;
	}

	public void setClassSelect(String classSelect) {
		this.classSelect = classSelect;
	}

	public void setValuesOptions(ArrayList<String> valuesOptions) {
		this.valuesOptions = valuesOptions;
	}

	public void setTextosOptions(String[] textosOptions) {
		this.textosOptions = textosOptions;
	}

	public void setIndSeleccionOption(int indSeleccionOption) {
		this.indSeleccionOption = indSeleccionOption;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			StringBuffer sBuffer = new StringBuffer("<select name='"
					+ nameSelect + "'>");
			Iterator<String> iOptions = valuesOptions.iterator();
			while(iOptions.hasNext()){
				sBuffer.append("<option value'" + iOptions.next() + "'>"
						+ iOptions.next()+ "</option>");
				
			}
			sBuffer.append("</select>");
			out.print(sBuffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
