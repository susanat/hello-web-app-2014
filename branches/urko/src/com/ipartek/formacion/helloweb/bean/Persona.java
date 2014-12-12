package com.ipartek.formacion.helloweb.bean;

public class Persona {
    public static final int ID_NULL = -1;
    public static final int EDAD_NULL = -1;
    private int codigo;
    private String nombre;
    private String userName;
    private int edad;
    private String password;
    private Rol rol;

    public Persona() {
	this.codigo = ID_NULL;
	this.nombre = "";
	this.userName = "";
	this.edad = EDAD_NULL;
	setRol(Rol.USUARIO);
    }

    public Persona(final String pdefecto) {
	this.codigo = -1;
	this.nombre = pdefecto;
	this.userName = pdefecto;
	this.edad = 18;
	setRol(Rol.USUARIO);
    }

    public Persona(final int pcodigo, final String pnombre) {
	this.codigo = pcodigo;
	this.nombre = pnombre;
	this.userName = "";
	this.edad = -1;
	setRol(Rol.USUARIO);
    }

    public Persona(final int pcodigo, final String pnombre,
	    final String puserName, final String ppassword, final Rol prol) {
	super();
	this.codigo = pcodigo;
	this.nombre = pnombre;
	this.userName = puserName;
	this.password = ppassword;
	this.rol = prol;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String pnombre) {
	this.nombre = pnombre;
    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(final int edad) {
	this.edad = edad;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(final String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(final String password) {
	this.password = password;
    }

    public Rol getRol() {
	return rol;
    }

    public void setRol(final Rol rol) {
	this.rol = rol;
    }

    private void obtenerRolPersona() {

	// this.rol = RolService.find(this);

    }

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(final int pcodigo) {
	this.codigo = pcodigo;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return this.nombre + " " + this.userName + " " + this.edad + " " + "";
    }

    public enum Rol {
	USUARIO("1", "usuario"), ADMINISTRADOR("0", "administrador");
	private String nombre;
	private String codigo;

	Rol(final String rcodigo, final String nRol) {
	    this.codigo = rcodigo;
	    this.nombre = nRol;
	}

	public String getNombre() {
	    return this.nombre;
	}

	public String getCodigo() {
	    return this.codigo;
	}
    }
}
