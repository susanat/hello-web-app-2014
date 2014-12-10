package com.ipartek.formacion.helloweb.tag.util;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ipartek.formacion.helloweb.i18n.Idioma;

public class TagSelect extends TagSupport {

	ArrayList<Idioma> opValues = null;
	ArrayList<String> opTexts = null;

	public void setOpValues(ArrayList<Idioma> opValues) {
		this.opValues = opValues;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("<select>");
			for (int i = 0; i < opValues.size(); i++) {
				out.print("<option val=");
				opTexts.get(i);
				out.print(">");
				out.print(opValues.get(i));
				out.print("</option>");
			}
			out.print("</select>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;

	}

}
