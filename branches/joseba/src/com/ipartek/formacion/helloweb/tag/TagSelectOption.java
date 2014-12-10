package com.ipartek.formacion.helloweb.tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagSelectOption extends TagSupport {

    private String name;
    private String id;
    private String clase;
    private List<String> opvalues;
    private List<String> texts;
    private String selectedvalue;

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public void setId(String id) {
	this.id = id;
    }

    public void setClase(String clase) {
	this.clase = clase;
    }

    public void setOpvalues(List<String> opvalues) {
	this.opvalues = opvalues;
    }

    public void setTexts(List<String> texts) {
	this.texts = texts;
    }

    public void setSelectedvalue(String selectedValue) {
	this.selectedvalue = selectedValue;
    }

    @Override
    public int doEndTag() throws JspException {
	try {
	    JspWriter out = pageContext.getOut();
	    out.print("<select name=' " + name + "' id='" + id + " class='"
		    + clase + "'>");
	    for (int i = 0; i < opvalues.size(); i++) {
		if (opvalues.get(i).equals(selectedvalue)) {
		    out.print("<option value= '" + opvalues.get(i)
			    + "' selected>" + texts.get(i) + "</option>");
		} else {
		    out.print("<option value= '" + opvalues.get(i) + "'>"
			    + texts.get(i) + "</option>");
		}
	    }
	    out.print("</select>");
	    // out.print("<select><option value=\"a\">1</option><option value=\"2\">2</option></select>");
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return EVAL_PAGE;

    }
}
