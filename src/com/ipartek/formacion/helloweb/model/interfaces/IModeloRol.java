package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.helloweb.bean.Role;

public interface IModeloRol {

	/**
	 * Obtiene una lista de Role
	 * @return List<Role> lista de role
	 */
    public List<Role> getAll();

    /**
     * Obtiene un Role dado el identificador
     * @param id Identificador del rol
     * @return Role con el rol o null si no ha encontrado
     */
    public Role getByID(int id) throws Exception;

    /**
     * Inserta un objeto de tipo Role
     * @param r Objeto a insertar
     * @return Integer , mayor de 0 se ha insertado el objeto 
     */
    public Role insert(Role r) throws Exception;

    /**
     * Actualiza un objeto de tipo Role
     * @param r Objeto a actualizar
     * @return
     */
    public Role update(Role r) throws Exception;

    /**
     * Elimina un objeto por su identificador
     * @param id
     * @return
     */
    public boolean delete(int id) throws Exception;

}
