package com.ipartek.formacion.pruebas.wsvcard;


public class VCard {

	Persona persona = null;
	
	public VCard() {
		init();
	}
	
	private void init() {
		this.persona = new Persona("Prueba Sergio", "Apellido Sergio", 25, "sergio@mm.com");
	}
	
	public Persona getVCard(String user, String password) {		
		if(user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			return this.persona;
		} else {
			return new Persona();
		}		
	}

}
