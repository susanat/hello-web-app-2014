/**
 * VCardService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.pruebas.wsvcard;

public interface VCardService extends javax.xml.rpc.Service {
    public java.lang.String getVCardAddress();

    public com.ipartek.formacion.pruebas.wsvcard.VCard getVCard() throws javax.xml.rpc.ServiceException;

    public com.ipartek.formacion.pruebas.wsvcard.VCard getVCard(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
