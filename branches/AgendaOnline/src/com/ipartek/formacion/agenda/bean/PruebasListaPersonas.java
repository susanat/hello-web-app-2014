package com.ipartek.formacion.agenda.bean;

import java.util.ArrayList;

/**
 * Clase Abstracta de PRUEBAS con una lista de Personas
 * 
 * @author Jose
 *
 */
public abstract class PruebasListaPersonas {
	public ArrayList<Persona> listaNula() {
		ArrayList<Persona> listaPersona = null;
		return listaPersona;
	}

	public ArrayList<Persona> listaVacia(){
		ArrayList<Persona> listaPersona=new ArrayList<Persona>();
		return listaPersona;
	}
	
	public ArrayList<Persona> listaConUnaPersona(){
		ArrayList<Persona> listaPersona=new ArrayList<Persona>();

		Persona p=new Persona();
		p.setNombre("Tiger");
		p.setApellidos("Nixon");
		p.setTelFijo(949999011);
		p.setTelMovil(666666001);
		listaPersona.add(p);
		
		return listaPersona;		
	}
	
	public ArrayList<Persona> listaCompleta(){
		ArrayList<Persona> listaPersona=new ArrayList<Persona>();
		
		Persona p=new Persona();
		p.setNombre("Tiger");
		p.setApellidos("Nixon");
		p.setTelFijo(949999011);
		p.setTelMovil(666666001);
		listaPersona.add(p);
		
		p=new Persona();
		p.setNombre("Garrett");
		p.setApellidos("Winters");
		p.setTelFijo(949999012);
		p.setTelMovil(666666002);
		listaPersona.add(p);
		
		p=new Persona();
		p.setNombre("Ashton");
		p.setApellidos("Cox");
		p.setTelFijo(949999013);
		p.setTelMovil(666666003);
		listaPersona.add(p);

		p=new Persona();
		p.setNombre("Cedric");
		p.setApellidos("Kelly");
		p.setTelFijo(949999014);
		p.setTelMovil(666666004);
		listaPersona.add(p);

		p=new Persona();
		p.setNombre("Airi");
		p.setApellidos("Satou");
		p.setTelFijo(949999015);
		p.setTelMovil(666666005);
		listaPersona.add(p);

		p=new Persona();
		p.setNombre("Brielle");
		p.setApellidos("Williamson");
		p.setTelFijo(949999016);
		p.setTelMovil(666666006);
		listaPersona.add(p);

		p=new Persona();
		p.setNombre("Herrod");
		p.setApellidos("Chandler");
		p.setTelFijo(949999017);
		p.setTelMovil(666666007);
		listaPersona.add(p);

		p=new Persona();
		p.setNombre("Rhona");
		p.setApellidos("Davidson");
		p.setTelFijo(949999018);
		p.setTelMovil(666666008);
		listaPersona.add(p);
		
		p=new Persona();
		p.setNombre("Colleen");
		p.setApellidos("Hurst");
		p.setTelFijo(949999019);
		p.setTelMovil(666666009);
		listaPersona.add(p);

		p=new Persona();
		p.setNombre("Sonya");
		p.setApellidos("Frost");
		p.setTelFijo(949999020);
		p.setTelMovil(666666010);
		listaPersona.add(p);

		p=new Persona();
		p.setNombre("Jena");
		p.setApellidos("Gaines");
		p.setTelFijo(949999021);
		p.setTelMovil(666666011);
		listaPersona.add(p);
		
		p=new Persona();
		p.setNombre("Quinn");
		p.setApellidos("Flynn");
		p.setTelFijo(949999022);
		p.setTelMovil(666666012);
		listaPersona.add(p);
		
		p=new Persona();
		p.setNombre("Charde");
		p.setApellidos("Marshall");
		p.setTelFijo(949999023);
		p.setTelMovil(666666013);
		listaPersona.add(p);
		
		p=new Persona();
		p.setNombre("Haley");
		p.setApellidos("Kennedy");
		p.setTelFijo(949999024);
		p.setTelMovil(666666014);
		listaPersona.add(p);
		
		p=new Persona();
		p.setNombre("Tatyana");
		p.setApellidos("Fitzpatrick");
		p.setTelFijo(949999025);
		p.setTelMovil(666666015);
		listaPersona.add(p);

		return listaPersona;
	}
}
