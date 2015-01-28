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
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Basic
    @Column(name = "edad")
    private int edad;
    
    
    @Basic
    @Column(name = "apellidos", nullable = false)
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
   
      
    //Una persona estará en n filas de la tabla que la relaciona PersonaCurso. 
    //El pk.persona será el objeto persona de la tabla creadora de id PersonaCursoId
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.persona", cascade=CascadeType.ALL )    
    private Set<PersonaCurso> personaCurso = new HashSet<PersonaCurso>(0);
        
    
    //@OneToOne(fetch = FetchType.LAZY, mappedBy = "persona", cascade={CascadeType.ALL}) 
    @OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
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

	public Persona(String nombre, int edad, String apellidos,
			Date fechaNacimiento, Date fechaCreacion, Date fechaModificacion,
			Direccion direccion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.direccion = direccion;
	}
	
	public Persona() {
		
	}
  
    
    
}
