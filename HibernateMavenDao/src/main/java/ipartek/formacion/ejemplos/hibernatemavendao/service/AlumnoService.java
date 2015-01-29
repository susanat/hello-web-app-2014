package ipartek.formacion.ejemplos.hibernatemavendao.service;

import ipartek.formacion.ejemplos.hibernatemavendao.dao.AlumnoDAO;
import ipartek.formacion.ejemplos.hibernatemavendao.dao.IAlumnoDAO;
import ipartek.formacion.ejemplos.hibernatemavendao.dao.ICursoDAO;
import ipartek.formacion.ejemplos.hibernatemavendao.entity.Alumno;

import java.util.List;

public class AlumnoService implements IAlumnoService {

	
	private IAlumnoDAO Dao;
	
	public AlumnoService() {
		Dao = new AlumnoDAO();
	}

	public void GuardarAlumno(Alumno obj) {
		Dao.Guardar(obj);

	}

	public void ActualizarAlumno(Alumno obj) {
		Dao.Actualizar(obj);
	}

	public void EliminarAlumno(Alumno obj) {
		Dao.Eliminar(obj);

	}

	public List<Alumno> ListarAlumnos() {
		return Dao.ListarAlumnos();
	}

	public Alumno BuscarAlumno(int id) {
		return Dao.Buscar(id);
	}

}
