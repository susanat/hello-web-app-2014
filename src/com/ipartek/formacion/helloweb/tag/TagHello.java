package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("Hello TAG");
			// out.print("<select><option value=\"a\">1</option><option value=\"2\">2</option></select>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

}
