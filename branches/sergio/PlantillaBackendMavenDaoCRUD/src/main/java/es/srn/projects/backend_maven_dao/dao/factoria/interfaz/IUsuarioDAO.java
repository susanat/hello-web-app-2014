package es.srn.projects.backend_maven_dao.dao.factoria.interfaz;

import java.util.List;

import es.srn.projects.backend_maven_dao.bean.Usuario;


/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Usuario de la BBDD.
 * 
 * Tendremos que implementar segun el motor que utilicemos para almacenar los datos.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public interface IUsuarioDAO extends IGenericDAO {
	
	
	public final static String COL_NAME_ID = "id";
	public final static String COL_NAME_USERNAME = "username";
	public final static String COL_NAME_APELLIDOS = "apellidos";	
	public final static String COL_NAME_PHOTO = "photo";
	
	
	public final static int COL_ID = 1;
	public final static int COL_USERNAME = 2;
	public final static int COL_APELLIDOS = 3;	
	public final static int COL_PHOTO = 4;
	
	public final static String TABLENAME = "user";
	
	public void beginTrans() throws Exception;
	public void commit() throws Exception;
	public void rollback() throws Exception;

	public List<Usuario> getAll() throws Exception;
	
	public Usuario getById(Usuario obj) throws Exception;
	
	public Usuario getById(int id) throws Exception;
	
	public Usuario insert(Usuario obj) throws Exception;
		
	public Usuario update(Usuario obj) throws Exception;
	
	public boolean delete(Usuario obj) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
}
