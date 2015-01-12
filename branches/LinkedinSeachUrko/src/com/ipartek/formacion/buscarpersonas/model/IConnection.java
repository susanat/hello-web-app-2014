package com.ipartek.formacion.buscarpersonas.model;

import java.sql.Connection;

public interface IConnection {
    public void connect();

    public void disconnect();

    public Connection getConnection();
    // public IConnection getConnection();
}
