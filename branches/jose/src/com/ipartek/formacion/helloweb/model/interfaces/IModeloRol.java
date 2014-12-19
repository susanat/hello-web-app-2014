package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.List;

import com.ipartek.formacion.helloweb.bean.Role;

/**
 * Interfaz relativa al modelo del Role.
 * @author Sergio Rubio Nieto
 *
 */
public interface IModeloRol {

	/**
	 * Obtiene una lista de Role.
	 * @return List<Role> lista de role
	 */
    List<Role> getAll();

    /**
     * Obtiene un Role dado el identificador.
     * @param ident Identificador del rol
     * @return Role con el rol o null si no ha encontrado
     * @throws Exception Excepción en caso de error
     */
    Role getByID(int ident) throws java.lang.Exception;

    /**
     * Inserta un objeto de tipo Role.
     * @param obj Objeto a insertar
     * @return Integer , mayor de 0 se ha insertado el objeto
     * @throws Exception Excepción en caso de error 
     */
    Role insert(Role obj) throws java.lang.Exception;

    /**
     * Actualiza un objeto de tipo Role.
     * @param obj Objeto a actualizar
     * @return Role objeto creado o null si no ha sido creado
     * @throws Exception Excepción en caso de error
     */
    Role update(Role obj) throws java.lang.Exception;

    /**
     * Elimina un objeto por su identificador.
     * @param ident Integer identificador del objeto
     * @return true si ha sido borrado o false si no
     * @throws Exception Excepción en caso de error
     */
    boolean delete(int ident) throws java.lang.Exception;

}
