package ipartek.formacion.ejemplos.hibernatemavendao.service;

import ipartek.formacion.ejemplos.hibernatemavendao.dao.CursoDAO;
import ipartek.formacion.ejemplos.hibernatemavendao.dao.ICursoDAO;
import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;

import java.util.List;

/*
 * Implementacion de la clase de servicio para curso.
 * @see http://todosobreprogramacion.blogspot.com.es/2013/10/hibernate-implementando-dao-genericos.html
 */
public class CursoService implements ICursoService{

	private ICursoDAO CursosDao;

	public CursoService() {
		CursosDao = new CursoDAO();
	}

	public void GuardarCurso(Curso cursoacargar) {
		CursosDao.Guardar(cursoacargar);
	}

	public void ActualizarCurso(Curso cursoacargar) {
		CursosDao.Actualizar(cursoacargar);
	}

	public void EliminarCurso(Curso micurso) {
		CursosDao.Eliminar(micurso);
	}
	
	public Curso BuscarCurso(int id) {				
		return CursosDao.Buscar(id);
	}

	public List<Curso> ListarCursos() {
		return CursosDao.ListarCursos();
	}

}
