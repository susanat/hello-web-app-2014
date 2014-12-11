package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Role;

public interface IModeloRol {

    ArrayList<Role> getAll();

    Role getByID(int id);

    int insert(Role r);

    int update(Role r);

    boolean delete(int id);

}
