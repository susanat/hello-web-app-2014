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
@Table(name = "Categoria")
public class Categoria {

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
    

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Curso> Cursos = new ArrayList<Curso>();
   	public List<Curso> getCursos() {
		return Cursos;
	}

	public void setCursos(List<Curso> cursos) {
		Cursos = cursos;
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



	public Long getId() {
		return id;
	}
	

	public Categoria(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}



	public Categoria() {
		
	}

}
