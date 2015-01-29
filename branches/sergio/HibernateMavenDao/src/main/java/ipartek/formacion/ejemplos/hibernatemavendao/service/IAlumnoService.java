package ipartek.formacion.ejemplos.hibernatemavendao.service;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Alumno;
import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;

import java.util.List;

public interface IAlumnoService {
	
	public void GuardarAlumno(Alumno obj);
    public void ActualizarAlumno(Alumno obj);
    public void EliminarAlumno(Alumno obj);
    public Alumno BuscarAlumno(int id);
    
    
    public List<Alumno> ListarAlumnos();
    

}
