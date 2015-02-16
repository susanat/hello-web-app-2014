/**
 * VCardServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.pruebas.wsvcard;

public class VCardServiceLocator extends org.apache.axis.client.Service implements com.ipartek.formacion.pruebas.wsvcard.VCardService {

    public VCardServiceLocator() {
    }


    public VCardServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VCardServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for VCard
    private java.lang.String VCard_address = "http://localhost:8080/WSVCardSergio/services/VCard";

    public java.lang.String getVCardAddress() {
        return VCard_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String VCardWSDDServiceName = "VCard";

    public java.lang.String getVCardWSDDServiceName() {
        return VCardWSDDServiceName;
    }

    public void setVCardWSDDServiceName(java.lang.String name) {
        VCardWSDDServiceName = name;
    }

    public com.ipartek.formacion.pruebas.wsvcard.VCard getVCard() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(VCard_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getVCard(endpoint);
    }

    public com.ipartek.formacion.pruebas.wsvcard.VCard getVCard(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ipartek.formacion.pruebas.wsvcard.VCardSoapBindingStub _stub = new com.ipartek.formacion.pruebas.wsvcard.VCardSoapBindingStub(portAddress, this);
            _stub.setPortName(getVCardWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setVCardEndpointAddress(java.lang.String address) {
        VCard_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ipartek.formacion.pruebas.wsvcard.VCard.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ipartek.formacion.pruebas.wsvcard.VCardSoapBindingStub _stub = new com.ipartek.formacion.pruebas.wsvcard.VCardSoapBindingStub(new java.net.URL(VCard_address), this);
                _stub.setPortName(getVCardWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("VCard".equals(inputPortName)) {
            return getVCard();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsvcard.pruebas.formacion.ipartek.com", "VCardService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsvcard.pruebas.formacion.ipartek.com", "VCard"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("VCard".equals(portName)) {
            setVCardEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
