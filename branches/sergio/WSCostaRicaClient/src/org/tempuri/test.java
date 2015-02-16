package org.tempuri;

import java.rmi.RemoteException;

public class test {

	public test() {
		
	}

	public static void main(String[] args) throws RemoteException {
		System.out.println("Llamar WS Costa Rica");
		
		WSMeteorologicoSoapProxy cliente = new WSMeteorologicoSoapProxy();
		
		System.out.println("La fecha en C.R: " + cliente.fecha());

	}

}
