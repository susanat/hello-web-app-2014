package com.ipartek.formacion.pruebas.wsvcard;

public class VCardProxy implements com.ipartek.formacion.pruebas.wsvcard.VCard {
  private String _endpoint = null;
  private com.ipartek.formacion.pruebas.wsvcard.VCard vCard = null;
  
  public VCardProxy() {
    _initVCardProxy();
  }
  
  public VCardProxy(String endpoint) {
    _endpoint = endpoint;
    _initVCardProxy();
  }
  
  private void _initVCardProxy() {
    try {
      vCard = (new com.ipartek.formacion.pruebas.wsvcard.VCardServiceLocator()).getVCard();
      if (vCard != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)vCard)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)vCard)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (vCard != null)
      ((javax.xml.rpc.Stub)vCard)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ipartek.formacion.pruebas.wsvcard.VCard getVCard() {
    if (vCard == null)
      _initVCardProxy();
    return vCard;
  }
  
  public com.ipartek.formacion.pruebas.wsvcard.Persona getVCard(java.lang.String user, java.lang.String password) throws java.rmi.RemoteException{
    if (vCard == null)
      _initVCardProxy();
    return vCard.getVCard(user, password);
  }
  
  
}