package es.srn.projects.backendmavendao.dao.factoria.interfaz;

import java.util.List;

import es.srn.projects.backendmavendao.bean.Usuario;


/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Usuario de la BBDD.
 * 
 * Tendremos que implementar segun el motor que utilicemos para almacenar los datos.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public interface IUsuarioDAO extends IGenericDAO {
	
	public final static String TABLENAME = "user";
	
	public final static String COL_NAME_ID = "id";
	public final static String COL_NAME_USERNAME = "username";
	public final static String COL_NAME_APELLIDOS = "apellidos";	
	public final static String COL_NAME_PHOTO = "photo";	
	public final static String COL_NAME_PASSWORD = "password";
	public final static String COL_NAME_EMAIL = "email";
	public final static String COL_NAME_STATUS = "status";	
	public final static String COL_NAME_TIMEZONE = "timezone";
			

	/**
	 * Obtiene todos los elementos de la tabla.
	 * @return Listado de elementos o listado vacío si no existe ninguno
	 * @throws Exception Excepción.
	 */
	public List<Usuario> getAll() throws Exception;
	
	public Usuario getById(Usuario obj) throws Exception;
	
	public Usuario getById(int id) throws Exception;
	
	public Usuario insert(Usuario obj) throws Exception;
		
	public Usuario update(Usuario obj) throws Exception;
	
	public boolean delete(Usuario obj) throws Exception;
	
	public boolean delete(int id) throws Exception;

	
	
}
