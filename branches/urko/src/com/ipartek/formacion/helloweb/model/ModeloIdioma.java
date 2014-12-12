package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.helloweb.bean.Languaje;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloIdioma;

public class ModeloIdioma implements IModeloIdioma {
    public static ArrayList<Languaje> idiomas = null;
    private static int pos;

    public static void init() {
	idiomas.add(new Languaje(0, "Euskera"));
	idiomas.add(new Languaje(0, "Castellano"));
	idiomas.add(new Languaje(0, "Ingles"));
	pos = 3;
    }

    public static void destroy() {
	idiomas = null;
    }

    @Override
    public List<Languaje> getAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Languaje getById(final int id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int insert(final Languaje i) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int update(final Languaje i) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public boolean delete(final int id) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean deleteLog(final int id) {
	// TODO Auto-generated method stub
	return false;
    }

}
