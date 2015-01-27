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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "Persona")
public class Persona {
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    Long id;
    
	/* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    /* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    
    @Basic
    @Column(name = "edad")    
    private int edad = 18;
    
    /*
     * Las fechas son más complejas, 
     * ya que no hay forma de saber a priori si un Date de java es un TIME, DATE o TIMESTAMP de base de datos 
     * (sólo hora, sólo fecha o fecha y hora). 
     * Por ello, debemos poner la annotation @Temporal, 
     * indicando detrás qué tipo de campo deseamos en base de datos. 
     *  
     * */
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_nacimiento", nullable = false)
    private Date fechaNacimiento;
    
    
    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name="PersonaCurso", 
    			joinColumns={@JoinColumn(name="idPersona")}, 
    			inverseJoinColumns={@JoinColumn(name="idCurso")})
    private Set<Curso> cursos =new HashSet<Curso>();

   
    
    public Long getId() {
        return id;
    }

    /*
    private void setId(Long id) {
        this.id = id;
    }
    */

    
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
    
    public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})	
	private Direccion direccion;
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	

	public Persona(String nombre, String apellidos, int edad,
			Date fechaNacimiento) {
		super();		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;		
	}
    
	public Persona() {}
    
	
	@Override
	public String toString() {
		
		//return super.toString();
		
		String texto = "";
		
		texto += "Nombre: " + getNombre() + nl;
		texto += "apellidos: " + getApellidos() + nl;
		texto += "edad: " + getEdad() + nl;
		texto += "fechaNacimiento: " + getFechaNacimiento() + nl;
		
		String none = getDireccion() == null ? "none" : getDireccion().toString();
		
		
		texto += "Direccion: " + none + nl;
		
		int size = getCursos() == null ? 0 : getCursos().size();		
		texto += (String) ("Nº cursos: " + String.valueOf(size) + nl);
		
		
		
		
		return texto;
		
	}
	
	public static String nl = System.getProperty("line.separator");
    
}
