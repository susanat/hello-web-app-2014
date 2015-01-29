package ipartek.formacion.ejemplos.hibernatemavendao.generic;

import ipartek.formacion.ejemplos.hibernatemavendao.exception.UnableToSaveException;
import ipartek.formacion.ejemplos.hibernatemavendao.util.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.Session;


/*
 * @see http://todosobreprogramacion.blogspot.com.es/2013/10/hibernate-implementando-dao-genericos.html
 */
public class GenericDaoImpl<Entity, K extends Serializable> implements
		GenericDao<Entity, K> {

	
	private Session session = null;
	
	//casos es necesario tener acceso al tipo de la clase genérica en el contexto de ejecución
	public Class<Entity> domainClass = getDomainClass();

	
	protected Class getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass()
					.getGenericSuperclass();
			domainClass = (Class) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	private Session getHibernateTemplate() {
		//****** He cambiado algo raro con lo del artículo
		
		if(session == null) {
			session = HibernateUtil.getSession();
		}
		
		session.beginTransaction();
		return session;
	}

	public Entity Buscar(K id) {
		//@see http://www.dosideas.com/noticias/java/835-hibernate-y-los-metodos-get-y-load.html
		
		/*
		Entity returnValue = (Entity) getHibernateTemplate().load(domainClass,
				id);
		*/
		Entity returnValue = (Entity) getHibernateTemplate().get(domainClass,
				id);
		
		session.getTransaction().commit();	
		return returnValue;
	}

	public void Actualizar(Entity t) throws UnableToSaveException {
		try {
			getHibernateTemplate().update(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new UnableToSaveException(e);
		}
	}

	public void Guardar(Entity t) throws UnableToSaveException {
		try {
			getHibernateTemplate().save(t);
			session.getTransaction().commit();
			session.clear();
		} catch (HibernateException e) {
			throw new UnableToSaveException(e);
		}
	}

	public void Eliminar(Entity t) {
		getHibernateTemplate().delete(t);
		session.getTransaction().commit();
	}
}
