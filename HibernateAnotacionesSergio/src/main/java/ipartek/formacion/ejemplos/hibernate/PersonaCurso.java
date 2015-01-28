package ipartek.formacion.ejemplos.hibernate;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;




/*
 * Clase para reprsentar la tabla intermedia 
 */

@Entity
@Table(name = "Persona_curso")
@AssociationOverrides({
		@AssociationOverride(name = "pk.persona", joinColumns = @JoinColumn(name = "persona_id")),
		@AssociationOverride(name = "pk.curso", joinColumns = @JoinColumn(name = "curso_id")) })
public class PersonaCurso {

	//@AssociationOverride son los nombre de las columnas que aparecen en PersonaCurso
	
	
	//************* Configuración de las relaciones	
	//Clave Primaria
	@EmbeddedId
	private PersonaCursoId pk = new PersonaCursoId();
		
	public PersonaCursoId getPk() {
		return pk;
	}

	public void setPk(PersonaCursoId pk) {
		this.pk = pk;
	}
	
	
	/*
	 * Getterr y setter para clase PersonaCursoId ( clave primaria )
	 * 
	 */	
	@Transient
	Persona getPersona(){
		return pk.getPersona();
	}
	
	void setPersona(Persona persona ){
		this.pk.setPersona(persona);
	}
	
	@Transient
	Curso getCurso(){
		return pk.getCurso();
	}
	
	void setCurso(Curso curso ){
		this.pk.setCurso(curso);
	}

	/*
	 * END: Getterr y setter para clase PersonaCursoId ( clave primaria )
	 * 
	 */
	
	//********************** Campos de la tabla intermedia
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "f_matricula", nullable = false, length = 10)
	private Date fechaMatriculacion;
	
	public Date getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}
	
	
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
