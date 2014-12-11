package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectOptionsTag extends TagSupport {

	ArrayList<String> opValues = null;
	ArrayList<String> opTexts = null;
	String selectedValue = null;
	String parameterName = null;
	String className = null;
	String idValue = null;
	
	
	public void setOpValues(ArrayList<String>  opValues) {
		this.opValues = opValues;
	}
	
	public void setOpTexts(ArrayList<String>  opTexts) {
		this.opTexts = opTexts;
	}

	public void setSelectedValue(String selectedValue) {
		if ( selectedValue != null ){
			this.selectedValue = selectedValue;
		}else{
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
		try{
			JspWriter out = pageContext.getOut();
			//start Tag
			out.print("<select ");			
				out.print( ( parameterName!=null)?" name='"+ parameterName + "'":"" );
				out.print( (idValue!=null)?" id='"+ idValue + "'":"" );
				out.print( (className!=null)?" class='"+ className + "'":"" );			
			out.print(">");
			
			//options
			   for ( int i=0; i < opValues.size(); i++){ 
				   if ( opValues.get(i).equals(selectedValue)){
					   out.print("<option selected value="+ opValues.get(i)+">");
				   }else{
					   out.print("<option value="+ opValues.get(i)+">");
				   }   
					out.print( opTexts.get(i));
				out.print("</option>");
			   }
			//end tag   
			out.print("</select>");
		}catch( Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}
	
}
