package com.ipartek.formacion.busredsociales.dao.interfaz;

import java.util.List;

import com.ipartek.formacion.busredsociales.bean.Usuario;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Usuario de la BBDD.
 * 
 * Tendremos que implementar segun el motor que utilicemos para almacenar los datos.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public interface IUsuarioDAO {
	
	public final static String COL_NAME_ID = "id";
	public final static String COL_NAME_USERNAME = "username";
	public final static String COL_NAME_APELLIDOS = "apellidos";	
	public final static String COL_NAME_PHOTO = "photo";
	
	
	public final static int COL_ID = 1;
	public final static int COL_USERNAME = 2;
	public final static int COL_APELLIDOS = 3;	
	public final static int COL_PHOTO = 4;
	
	public final static String TABLENAME = "user";

	public List<Usuario> getAll() throws DAOException, Exception;
	
	public Usuario getById(Usuario obj) throws DAOException, Exception;
	
	public Usuario getById(int id) throws DAOException, Exception;
	
	public Usuario insert(Usuario obj) throws DAOException, Exception;
		
	public Usuario update(Usuario obj) throws DAOException, Exception;
	
	public boolean delete(Usuario obj) throws DAOException, Exception;
	
	public boolean delete(int id) throws DAOException, Exception;
	
}
