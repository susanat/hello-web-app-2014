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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "Persona")
public class Persona {
	
	@Id
    @GeneratedValue
    Long id;
    
	/* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "nombre")
    private String nombre;
    
    @Basic
    @Column(name = "edad")
    private int edad;
    
    
    @Basic
    @Column(name = "apellidos")
    private String apellidos;
    
   
   

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
   
   /* @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(  name="Persona_curso", 
                 joinColumns={@JoinColumn(name="personaId")}, 
                 inverseJoinColumns={@JoinColumn(name="cursoId")}
    		)
    */
    
    //private Set<Curso> cursos = new HashSet<Curso>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.persona", cascade=CascadeType.ALL )    
    private Set<PersonaCurso> personaCurso = new HashSet<PersonaCurso>(0);
    
    
    
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) 
    private Direccion direccion;  
     
   


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {    	
        return nombre;
    }

    public void setNombre( String nombre ) {    	
        this.nombre = nombre;
    }

    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fecha) {
        this.fechaNacimiento = fecha;
    }

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	 public Direccion getDireccion() {
			return direccion;
		}

		public void setDireccion(Direccion direccion) {
			this.direccion = direccion;
		}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
    
    
	
	
	
    public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

/*
	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
  */  
	
	public Set<PersonaCurso> getPersonaCurso() {
		return personaCurso;
	}

	public void setPersonaCurso(Set<PersonaCurso> personaCurso) {
		this.personaCurso = personaCurso;
	}

	@PrePersist
    protected void onCreate() {
    	setFechaCreacion( new Date() );
    	setFechaModificacion(new Date());
    }

    @PreUpdate
    protected void onUpdate() {
    	setFechaModificacion(new Date());
    }
  
    
    
}
