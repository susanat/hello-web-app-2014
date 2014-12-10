package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {

	String [] opValues = null;
	
	
	
	public void setOpValues(String[] opValues) {
		this.opValues = opValues;
	}



	@Override
	public int doEndTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.print("<select>");
			   for (int i=0; i < opValues.length ; i++){ 
				out.print("<option val=\"4\">");					
					out.print(opValues[i]);
				out.print("</option>");
			   }
			out.print("</select>");
		}catch( Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}
	
}
