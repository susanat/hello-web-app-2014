package ipartek.formacion.ejemplos.hibernatemavendao.dao;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;
import ipartek.formacion.ejemplos.hibernatemavendao.generic.GenericDaoImpl;
import ipartek.formacion.ejemplos.hibernatemavendao.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * @see http://todosobreprogramacion.blogspot.com.es/2013/10/hibernate-implementando-dao-genericos.html
 */
public class CursoDAO extends GenericDaoImpl<Curso, Integer> implements ICursoDAO {

	public List<Curso> ListarCursos() {
		List<Curso> users = new ArrayList<Curso>();
		Transaction trns = null;
		Session session = HibernateUtil.getSession();
		try {
			trns = session.beginTransaction();
			users = session.createQuery("from Curso").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}

}
