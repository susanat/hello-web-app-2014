package org.tempuri;

public class WSMeteorologicoSoapProxy implements org.tempuri.WSMeteorologicoSoap {
  private String _endpoint = null;
  private org.tempuri.WSMeteorologicoSoap wSMeteorologicoSoap = null;
  
  public WSMeteorologicoSoapProxy() {
    _initWSMeteorologicoSoapProxy();
  }
  
  public WSMeteorologicoSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSMeteorologicoSoapProxy();
  }
  
  private void _initWSMeteorologicoSoapProxy() {
    try {
      wSMeteorologicoSoap = (new org.tempuri.WSMeteorologicoLocator()).getWSMeteorologicoSoap();
      if (wSMeteorologicoSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSMeteorologicoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSMeteorologicoSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSMeteorologicoSoap != null)
      ((javax.xml.rpc.Stub)wSMeteorologicoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.WSMeteorologicoSoap getWSMeteorologicoSoap() {
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap;
  }
  
  public java.lang.String pronosticoRegional() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoRegional();
  }
  
  public java.lang.String pronosticoRegionalxID(int regionID) throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoRegionalxID(regionID);
  }
  
  public java.lang.String pronosticoPorCiudad() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoPorCiudad();
  }
  
  public java.lang.String pronosticoPorCiudadxID(int ciudadID) throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoPorCiudadxID(ciudadID);
  }
  
  public java.lang.String efemerides() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.efemerides();
  }
  
  public java.lang.String fecha() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.fecha();
  }
  
  public java.lang.String hora() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.hora();
  }
  
  public java.lang.String estadoActualRegional() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.estadoActualRegional();
  }
  
  public java.lang.String estadoActualPorCiudad() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.estadoActualPorCiudad();
  }
  
  public java.lang.String pronosticoExtendidoRegion() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoExtendidoRegion();
  }
  
  public java.lang.String pronosticoExtendidoRegionxID(int regionID) throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoExtendidoRegionxID(regionID);
  }
  
  public java.lang.String pronosticoExtendidoCiudad() throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoExtendidoCiudad();
  }
  
  public java.lang.String pronosticoExtendidoCiudadxID(int ciudadID) throws java.rmi.RemoteException{
    if (wSMeteorologicoSoap == null)
      _initWSMeteorologicoSoapProxy();
    return wSMeteorologicoSoap.pronosticoExtendidoCiudadxID(ciudadID);
  }
  
  
}