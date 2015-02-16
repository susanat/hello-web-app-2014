/**
 * WSMeteorologicoSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface WSMeteorologicoSoap extends java.rmi.Remote {
    public java.lang.String pronosticoRegional() throws java.rmi.RemoteException;
    public java.lang.String pronosticoRegionalxID(int regionID) throws java.rmi.RemoteException;
    public java.lang.String pronosticoPorCiudad() throws java.rmi.RemoteException;
    public java.lang.String pronosticoPorCiudadxID(int ciudadID) throws java.rmi.RemoteException;
    public java.lang.String efemerides() throws java.rmi.RemoteException;
    public java.lang.String fecha() throws java.rmi.RemoteException;
    public java.lang.String hora() throws java.rmi.RemoteException;
    public java.lang.String estadoActualRegional() throws java.rmi.RemoteException;
    public java.lang.String estadoActualPorCiudad() throws java.rmi.RemoteException;
    public java.lang.String pronosticoExtendidoRegion() throws java.rmi.RemoteException;
    public java.lang.String pronosticoExtendidoRegionxID(int regionID) throws java.rmi.RemoteException;
    public java.lang.String pronosticoExtendidoCiudad() throws java.rmi.RemoteException;
    public java.lang.String pronosticoExtendidoCiudadxID(int ciudadID) throws java.rmi.RemoteException;
}
