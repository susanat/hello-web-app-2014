package ipartek.formacion.ejemplos.hibernatemavendao.dao;

import ipartek.formacion.ejemplos.hibernatemavendao.entity.Alumno;
import ipartek.formacion.ejemplos.hibernatemavendao.entity.Curso;
import ipartek.formacion.ejemplos.hibernatemavendao.generic.GenericDaoImpl;
import ipartek.formacion.ejemplos.hibernatemavendao.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class AlumnoDAO extends GenericDaoImpl<Alumno, Integer> implements IAlumnoDAO {

	public List<Alumno> ListarAlumnos() {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		Transaction trns = null;
		Session session = HibernateUtil.getSession();
		try {
			trns = session.beginTransaction();
			alumnos = session.createQuery("from Alumno").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return alumnos;
	}
	
	

}
