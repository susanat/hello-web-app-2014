package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Librería de tags para implementar un combo de html Select Options.
 *
 * @author Curso
 *
 */
public class SelectOptionsTag extends TagSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = -1334726726464432254L;

	private String tagName;
	private String tagId;
	private String tagClass;
	ArrayList<String> opValues = null;
	ArrayList<String> opTextos = null;
	private String selectedValue;

	/**
	 * @param tagName
	 *            the tagName to set
	 */
	public void setTagName(final String tagName) {
		this.tagName = tagName;
	}

	/**
	 * @param tagId
	 *            the tagId to set
	 */
	public void setTagId(final String tagId) {
		this.tagId = tagId;
	}

	/**
	 * @param tagClass
	 *            the tagClass to set
	 */
	public void setTagClass(final String tagClass) {
		this.tagClass = tagClass;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setOpValues(final ArrayList<String> opValues) {
		if (opValues != null && opValues.size() > 0) {
			this.opValues = opValues;
		} else {
			this.opValues = new ArrayList<String>();
		}
	}

	/**
	 * @param opTexts
	 *            the opTexts to set
	 */
	public void setOpTextos(final ArrayList<String> opTextos) {
		if (opTextos != null && opTextos.size() > 0) {
			this.opTextos = opTextos;
		} else {
			this.opTextos = new ArrayList<String>();
		}
	}

	/**
	 * @param selectedValue
	 *            the selectedValue to set
	 */
	public void setSelectedValue(final String selectedValue) {
		this.selectedValue = selectedValue;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			if ((opValues != null) && (opTextos != null) && (opTextos.size() == opValues.size())) {
				final JspWriter out = pageContext.getOut();
				out.print("<select ");
				out.print((tagName != null) ? " name='" + tagName + "'" : "");
				out.print((tagId != null) ? " id='" + tagId + "'" : "");
				out.print((tagClass != null) ? " class='" + tagClass + "'" : "");
				out.print(">");

				for (int i = 0; i < opValues.size(); i++) {
					if (opValues.get(i).equals(selectedValue)) {
						out.print("<option selected value=" + opValues.get(i) + ">");
					} else {
						out.print("<option value=" + opValues.get(i) + ">");
					}
					out.print(opTextos.get(i));
					out.print("</option>");
				}

				out.print("</select>");
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
