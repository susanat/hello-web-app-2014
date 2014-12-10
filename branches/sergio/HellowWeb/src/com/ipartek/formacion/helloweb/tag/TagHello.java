package com.ipartek.formacion.helloweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



public class TagHello extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 466327867002930511L;

	
	private String nombre;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int doStartTag() throws JspException {
		try{
			
			if (nombre == null) {
				nombre = "Anonimo";
			}

			
			JspWriter out = pageContext.getOut();			
			out.print("Este es el custom tld " + nombre);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return SKIP_BODY;
	}


	@Override
	public int doEndTag() throws JspException {
				
		//EVAL_PAGE permite continuar con el proceso de carga de página
		return EVAL_PAGE;
	}

}
