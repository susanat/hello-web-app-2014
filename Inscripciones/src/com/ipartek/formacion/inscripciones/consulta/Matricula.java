package com.ipartek.formacion.inscripciones.consulta;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Matricula {

	
	private int id;	
	
	private long firstaccessMil;
	private String firstaccess;
	
	private String firstname;
	private String lastname;
	private String email;
	
	
	private long lastaccessMil;
	private String lastaccess;
	
	
	private long lastloginMil;
	private String lastlogin;
	
	
	public Matricula() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getFirstaccessMil() {
		return firstaccessMil;
	}
	
	public String getFirstaccess() {
		return firstaccess;
	}


	public void setFirstaccessMil(long firstaccessMil) {
		this.firstaccessMil = firstaccessMil;
		this.firstaccess = getDate(firstaccessMil * 1000, "dd/MM/yyyy hh:mm:ss");
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getLastaccessMil() {
		return lastaccessMil;
	}


	public void setLastaccessMil(long lastaccessMil) {
		this.lastaccessMil = lastaccessMil;
		this.lastaccess = getDate(lastaccessMil * 1000 , "dd/MM/yyyy hh:mm:ss");
	}


	public Long getLastloginMil() {
		return this.lastloginMil;
	}


	public void setLastloginMil(long lastloginMil) {
		this.lastloginMil = lastloginMil;
		this.lastlogin = getDate(lastloginMil * 1000, "dd/MM/yyyy hh:mm:ss");
	}


	public Matricula(int id, long firstaccessMil, String firstname,
			String lastname, String email, long lastaccessMil, long lastloginMil) {
		super();
		this.id = id;
		this.setFirstaccessMil( firstaccessMil );
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.setLastaccessMil(lastaccessMil);
		this.setLastloginMil(lastloginMil);
	}
	
	
	/**
	 * Return date in specified format.
	 * @param milliSeconds Date in milliseconds
	 * @param dateFormat Date format 
	 * @return String representing date in specified format
	 */
	public static String getDate(long milliSeconds, String dateFormat)
	{
	    // Create a DateFormatter object for displaying date in specified format.
	    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

	    // Create a calendar object that will convert the date and time value in milliseconds to date. 
	     Calendar calendar = Calendar.getInstance();
	     calendar.setTimeInMillis(milliSeconds);
	     return formatter.format(calendar.getTime());
	
	}
	

}
