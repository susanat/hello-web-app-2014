package ipartek.formacion.ejemplos.hibernatemavendao.entity;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Alumno {

	private Integer id;
	private String nombre;
	private List<Curso> cursos = new LinkedList<Curso>();
	

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void setCurso(Curso obj) {
		this.getCursos().add(obj);
	}

	public Alumno() {
	}

	public Alumno(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	

}
