package ipartek.formacion.ejemplos.hibernatemavendao.service;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;

import java.util.List;

/*
 * Aqui es donde trabajaremos en nuestra capa de servicio la cual utilizara 1 o N clases Dao de nuestro negocio para responder a una funcionalidad especifica.
 * @see http://todosobreprogramacion.blogspot.com.es/2013/10/hibernate-implementando-dao-genericos.html
 */
public interface ICursoService {

	public void GuardarCurso(Curso cursoacargar);
    public void ActualizarCurso(Curso cursoacargar);
    public void EliminarCurso(Curso micurso);
    public Curso BuscarCurso(int id);
    public List<Curso> ListarCursos();
	

}
