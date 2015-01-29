package ipartek.formacion.ejemplos.hibernatemavendao.entity;

public class Curso {

	private Integer id;
	private String nombre;

	public Curso() {
	}

	public Curso(String nombre) {
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
