package com.ipartek.formacion.buscarpersonas.model;

import java.sql.Connection;

import com.ipartek.formacion.buscarpersonas.exception.ModelException;

public interface IConnection {
    public void connect() throws ModelException;

    public void disconnect() throws ModelException;

    public Connection getConnection();
    // public IConnection getConnection();
}
