/**
 * WSMeteorologicoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSMeteorologicoLocator extends org.apache.axis.client.Service implements org.tempuri.WSMeteorologico {

    public WSMeteorologicoLocator() {
    }


    public WSMeteorologicoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSMeteorologicoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSMeteorologicoSoap
    private java.lang.String WSMeteorologicoSoap_address = "http://www.imn.ac.cr/MeteorologicoWS/MeteorologicoWS.asmx";

    public java.lang.String getWSMeteorologicoSoapAddress() {
        return WSMeteorologicoSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSMeteorologicoSoapWSDDServiceName = "WSMeteorologicoSoap";

    public java.lang.String getWSMeteorologicoSoapWSDDServiceName() {
        return WSMeteorologicoSoapWSDDServiceName;
    }

    public void setWSMeteorologicoSoapWSDDServiceName(java.lang.String name) {
        WSMeteorologicoSoapWSDDServiceName = name;
    }

    public org.tempuri.WSMeteorologicoSoap getWSMeteorologicoSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSMeteorologicoSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSMeteorologicoSoap(endpoint);
    }

    public org.tempuri.WSMeteorologicoSoap getWSMeteorologicoSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.WSMeteorologicoSoapStub _stub = new org.tempuri.WSMeteorologicoSoapStub(portAddress, this);
            _stub.setPortName(getWSMeteorologicoSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSMeteorologicoSoapEndpointAddress(java.lang.String address) {
        WSMeteorologicoSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.WSMeteorologicoSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.WSMeteorologicoSoapStub _stub = new org.tempuri.WSMeteorologicoSoapStub(new java.net.URL(WSMeteorologicoSoap_address), this);
                _stub.setPortName(getWSMeteorologicoSoapWSDDServiceName());
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
        if ("WSMeteorologicoSoap".equals(inputPortName)) {
            return getWSMeteorologicoSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSMeteorologico");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WSMeteorologicoSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSMeteorologicoSoap".equals(portName)) {
            setWSMeteorologicoSoapEndpointAddress(address);
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
