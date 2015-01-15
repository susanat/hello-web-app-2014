package ipt.fm.ipartek.test.linkedin.bean;

/**
 * Mensaje de comunicación con el usuario
 * 
 * @author Fran
 *
 */
public class Mensaje {
	private String msg;
	private MsgType type;

	public Mensaje(String msg, MsgType type) {
		super();
		this.msg = msg;
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MsgType getType() {
		return type;
	}

	public void setType(MsgType type) {
		this.type = type;
	}

	/**
	 * Enumeración para los tipos de mensaje. ERR: Mensaje de tipo ERROR. INF:
	 * Mensaje de tipo INFORMATIVO.
	 * 
	 * @author Fran
	 *
	 */
	public enum MsgType {
		ERR, INF;
	}
}
