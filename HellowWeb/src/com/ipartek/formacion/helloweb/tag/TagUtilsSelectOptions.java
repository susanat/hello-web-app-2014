package com.ipartek.formacion.helloweb.tag;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ipartek.formacion.helloweb.comun.Utils;

public class TagUtilsSelectOptions extends TagSupport {
	
	private List<String> valores = null;
	private List<String> texts = null;
	private String selectedValue = "";
		
	
	public void setvalores(List<String> valores) {
		this.valores = valores;
	}


	public void setTexts(List<String> texts) {
		this.texts = texts;
	}
	
	public List<String> getvalores() {
		return valores;
	}


	public List<String> getTexts() {
		return texts;
	}


	public String getselectedValue() {
		return selectedValue;
	}


	public void setselectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}


	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();		
		StringBuilder salida = new StringBuilder();
		
		
		if(valores == null) {
			 throw new JspException("El listado de valores no puede ser null");
		}
		
		if(texts == null) {
			 throw new JspException("El listado de textos no puede ser null");
		}
		
		
		try{
			
			
			salida.append("<select class='form-control' id='language' name='language' onchange='submit()'>");
			
			for(int i = 0; i<valores.size(); i++ ) {
				salida.append("<option value='"); 
					salida.append(valores.get(i));
				salida.append("'");
					
					if(valores.get(i).equals(selectedValue)) {
						salida.append(" required  ");
					}									
					
				salida.append(">"); 				
						salida.append(texts.get(i)); 
				salida.append("</option>");				
			}
			
			
			salida.append("</select>");
		
			
			out.print(salida);
			
			
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
