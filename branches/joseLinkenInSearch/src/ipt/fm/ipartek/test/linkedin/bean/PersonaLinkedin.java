package ipt.fm.ipartek.test.linkedin.bean;

/**
 * Clase PersonaLinkedin que contiene la informacion de la Persona en Linkedin
 * Extiende de la clase Persona
 * 
 * @author Jose
 *
 */
public class PersonaLinkedin extends Persona {
	private String basic;
	private String expanded;

	
	public PersonaLinkedin() {
		super();
	}

	/**
	 * Constructor de una Persona de Linkedin
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param foto
	 * @param basic
	 * @param expanded
	 */
	public PersonaLinkedin(String nombre, String apellidos, String foto,
			String basic, String expanded) {
		super(nombre, apellidos, foto);
		this.basic = basic;
		this.expanded = expanded;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getExpanded() {
		return expanded;
	}

	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}

}
