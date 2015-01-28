package ipartek.formacion.ejemplos.hibernate;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/*
 * Clase que sirve para definir el ID de la tabla intermendia PersonaCurso
 * 
 * */

@Embeddable
public class PersonaCursoId implements java.io.Serializable{

	@ManyToOne
	private Persona persona;
	@ManyToOne
	private Curso curso;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
