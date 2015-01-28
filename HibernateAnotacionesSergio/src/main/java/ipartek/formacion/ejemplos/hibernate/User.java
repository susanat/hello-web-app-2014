package ipartek.formacion.ejemplos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
    @GeneratedValue
    Long id;
    
	/* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "nombre")
    private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public User(String nombre) {
		super();
		this.nombre = nombre;
	}
    
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<PersonaCurso> personaCursos = new ArrayList<PersonaCurso>();

	public List<PersonaCurso> getPersonaCursos() {
		return personaCursos;
	}

	public void setPersonaCursos(List<PersonaCurso> personaCursos) {
		this.personaCursos = personaCursos;
	}
	
	
	
}
