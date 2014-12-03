package com.ipartek.formacion.helloweb.util;

public class Mensaje {

	private String type;
	private String msg;

	/**
	 * @param type
	 * @param msg
	 */
	public Mensaje(final String type, final String msg) {
		super();
		this.type = type;
		this.msg = msg;
	}

	/**
	 * @return the type
	 */
	public String geType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(final String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}
}
