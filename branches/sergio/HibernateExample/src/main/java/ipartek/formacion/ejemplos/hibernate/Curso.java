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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Curso")
public class Curso {

	
	@Id
    @GeneratedValue
    @Column(name = "id")
    Long id;
    
	/* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "nombre")
    private String nombre;
    
    /* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "codigo", nullable = false, length = 15)
    private String codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_inicio", nullable = false)
    private Date fInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_fin", nullable = false)
    private Date fFin;

    
    //Si queremos que curso no meta relación en la tabla al añadir una persona nueva dentro del curso
    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="cursos")
     
    /*
    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name="PersonaCurso", 
    			joinColumns={@JoinColumn(name="idCurso")}, 
    			inverseJoinColumns={@JoinColumn(name="idPersona")})
    */
    private Set<Persona> personas=new HashSet<Persona>();
    
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

	/*
	private void setId(Long id) {
		this.id = id;
	}
	*/

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
		
	
	// HERE IS THE NEW ANNOTATION CODE WE'VE ADDED
	@ManyToOne
	private Categoria categoria;
      
    public Categoria getCategoria()  
    {  
        return categoria;  
    }  
    public void setCategoria(Categoria categoria)  
    {  
        this.categoria = categoria;  
    }  

	@Override
	public String toString() {
		
		//return super.toString();		
		String texto = "";
		
		texto += "Nombre: " + getNombre() + nl;
		texto += "Codigo: " + getCodigo() + nl;
		texto += "finicio: " + getfInicio() + nl;
		texto += "ffin: " + getfFin() + nl;
		
		String cat = categoria == null ? "none" : categoria.getNombre();
		texto += (String) ("Categoria: " + cat + nl);
		
		int size = getPersonas() == null ? 0 : getPersonas().size();
		texto += (String) ("Nº alumnos: " + String.valueOf(size) + nl);
				
		
		return texto;
		
	}
	
	
	public static String nl = System.getProperty("line.separator");
	

}
