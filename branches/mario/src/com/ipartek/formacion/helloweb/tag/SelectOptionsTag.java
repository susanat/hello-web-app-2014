package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ipartek.formacion.helloweb.Constantes;

public class SelectOptionsTag extends TagSupport {
    private ArrayList<String> valor;
    private ArrayList<String> texts;
    private String selectedvalue = null;

    public void setValor(ArrayList<String> valor) {
	if (valor != null) {
	    this.valor = valor;
	} else {
	    valor = new ArrayList<String>();
	}

    }

    public void setTexts(ArrayList<String> texts) {
	if (texts != null) {
	    this.texts = texts;
	} else {
	    texts = new ArrayList<String>();
	}
    }

    public void setSelectedvalue(String selectedvalue) {
	if (selectedvalue != null) {
	    this.selectedvalue = selectedvalue;
	} else {
	    this.selectedvalue = "";
	}

    }

    @Override
    public int doEndTag() throws JspException {
	try {
	    JspWriter out = pageContext.getOut();
	    out.print("<select name='" + Constantes.PARAMETRO_IDIOMA
		    + "' class='form-control'>");
	    for (int i = 0; i < valor.size(); i++) {

		if (valor.get(i).equals(selectedvalue)) {
		    out.print("<option value=" + valor.get(i) + " selected>");
		} else {
		    out.print("<option value=" + valor.get(i) + ">");
		}

		out.print(texts.get(i));
		out.print("</option>");
	    }
	    out.print("</select>");

	    // out.print("<select><option value=\"a\">1</option><option value=\"2\">2</option></select>");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return EVAL_PAGE;

    }
}
