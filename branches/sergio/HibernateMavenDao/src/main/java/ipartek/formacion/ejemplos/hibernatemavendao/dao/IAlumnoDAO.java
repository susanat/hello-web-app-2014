package ipartek.formacion.ejemplos.hibernatemavendao.dao;

import java.util.List;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Alumno;
import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;
import ipartek.formacion.ejemplos.hibernatemavendao.generic.GenericDao;

public interface IAlumnoDAO extends GenericDao<Alumno, Integer>{
	public List<Alumno> ListarAlumnos();
	

}
