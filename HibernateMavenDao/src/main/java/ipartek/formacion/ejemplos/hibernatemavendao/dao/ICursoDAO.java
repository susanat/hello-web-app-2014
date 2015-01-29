package ipartek.formacion.ejemplos.hibernatemavendao.dao;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;
import ipartek.formacion.ejemplos.hibernatemavendao.generic.GenericDao;

import java.util.List;

/* Define funcionalidades que no estan asociadas a CRUD dado que ya lo estoy solucionando con GENERIC.
 * @see http://todosobreprogramacion.blogspot.com.es/2013/10/hibernate-implementando-dao-genericos.html
 */
public interface ICursoDAO extends GenericDao<Curso, Integer> {
	public List<Curso> ListarCursos();
		
}
