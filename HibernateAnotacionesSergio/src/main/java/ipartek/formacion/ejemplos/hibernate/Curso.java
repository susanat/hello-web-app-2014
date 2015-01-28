package ipartek.formacion.ejemplos.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Curso")
public class Curso {

	
	@Id
    @GeneratedValue
    Long id;
	
    @Basic
    @Column(name = "nombre")
    private String nombre;
    
    @Basic
    @Column(name = "codigo")
    private String codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_inicio")
    private Date fechaInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_fin")
    private Date fechaFin;

    
    /* Nombre de 'mappedBy' es el atributo para los Cursos de la Clase Persona 
    @ ManyToMany(fetch = FetchType.LAZY, mappedBy = "cursos")
    */
    
    /*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(  name="Persona_curso", 
                 joinColumns={@JoinColumn(name="cursoId")}, 
                 inverseJoinColumns={@JoinColumn(name="personaId")}
    		)
    */		
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.curso" )
    //private Set <Persona> personas = new HashSet<Persona>(0);
   // private Set<PersonaCurso> personaCurso = new HashSet<PersonaCurso>(0);
    private Set<PersonaCurso> personaCurso = new HashSet<PersonaCurso>(0);
    
	

	

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Set<PersonaCurso> getPersonaCurso() {
		return personaCurso;
	}

	public void setPersonaCurso(Set<PersonaCurso> personaCurso) {
		this.personaCurso = personaCurso;
	}

	/*
	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
    */
	
    
    
	
}
