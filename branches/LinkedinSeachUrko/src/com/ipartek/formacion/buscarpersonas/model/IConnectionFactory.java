package com.ipartek.formacion.buscarpersonas.model;

import com.ipartek.formacion.buscarpersonas.exception.ModelException;

public interface IConnectionFactory {
    IConnection getIConnection() throws ModelException;
}
