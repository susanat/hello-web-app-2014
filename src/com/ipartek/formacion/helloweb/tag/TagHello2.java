package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHello2 extends TagSupport {

	private String nombre;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			if ( nombre == null ){
				out.print("saluda desconocido");
			}else{
				out.print("saluda " + nombre );
			}	
		}catch( Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}
	
}

