package ipartek.formacion.ejemplos.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Curso")
public class Curso {

	
	@Id
    @GeneratedValue
    @Column(name = "idCurso")
    Long id;
    
	/* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "nombre")
    private String nombre;
    
    /* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "codigo")
    private String codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_inicio")
    private Date fInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_fin")
    private Date fFin;

    
    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="cursos")
    private Set<Persona> personas=new HashSet();
    
    
	public Set<Persona> getPersonas() {
		return personas;
	}

	/*
	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
	*/
	
	public Curso(){}

	public Curso(String nombre, String codigo, Date fInicio, Date fFin) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.fInicio = fInicio;
		this.fFin = fFin;
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
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

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}
	
	
	
	

}
