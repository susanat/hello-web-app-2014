package com.ipartek.formacion.helloweb.tag;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.ipartek.formacion.helloweb.i18n.Idioma;
import com.ipartek.formacion.helloweb.util.Rol;

public class SelectOptionsTag extends BodyTagSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = -1334726726464432254L;

	private String tagName;
	private String tagId;
	private String tagClass;
	private ArrayList<Object> opValues;
	private String selectedValue;

	/**
	 * @param tagName
	 *            the tagName to set
	 */
	public void setTagName(final String tagName) {
		if (tagName != null) {
			this.tagName = tagName;
		} else {
			this.tagName = "";
		}
	}

	/**
	 * @param tagId
	 *            the tagId to set
	 */
	public void setTagId(final String tagId) {
		if (tagId != null) {
			this.tagId = tagId;
		} else {
			this.tagId = "";
		}
	}

	/**
	 * @param tagClass
	 *            the tagClass to set
	 */
	public void setTagClass(final String tagClass) {
		if (tagClass != null) {
			this.tagClass = tagClass;
		} else {
			this.tagClass = "";
		}
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setOpValues(final ArrayList<Object> opValues) {
		if (opValues != null && opValues.size() > 0) {
			this.opValues = opValues;
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
			final JspWriter out = pageContext.getOut();
			out.print("<select name = '" + tagName + "' id = '" + tagId + "' class= '" + tagClass + "'>");

			for (final Object opValue : opValues) {
				if (opValue instanceof Idioma) {
					out.print("<option value = '" + ((Idioma) opValue).getLocale() + "'>" + opValue + "</option>");
				} else if (opValue instanceof Rol) {
					out.print("<option value = '" + opValue + "'>" + opValue + "</option>");
				}
			}

			out.print("</select>");
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
