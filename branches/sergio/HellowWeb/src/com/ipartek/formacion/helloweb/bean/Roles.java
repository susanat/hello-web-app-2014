package com.ipartek.formacion.helloweb.bean;

public class Roles {

	//con role.alias.name o role.alias.desc buscara en el archivo de lenguaje
	//una key llamada role."parametro alias".name
	//Por ejemplo:
	//Para el rol con alias ADM buscará: 
	// role.adm.name
	// role.adm.desc
	
	
	public static final int ID_NULL = -1;
	public static final String ROLE_NAME_NULL = "role.alias.name";
	public static final String ROLE_DESC_NULL = "role.alias.desc";
	
	
	/**
	 * Identificador del rol
	 */
	private int id;
	
	/**
	 * Alias del rol
	 */
	private String alias;
	
	
	/**
	 * Nombre del rol
	 */
	private String nombre;
	
	/**
	 * Descripción del rol
	 */
	private String descripcion;
	
	/**
	 * Obtiene el identificador del rol
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Añade el identificador del rol
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Obtiene el nombre del rol
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Añade el nombre del rol
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**
	 * Obtiene la descripcion del rol
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Añade la descripción del rol
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

	/**
	 * Obtiene el alias del rol
	 * @return
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Añade el alias del rol
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Constructor de roles
	 * @param id
	 * @param alias
	 * @param nombre
	 * @param descripcion
	 */
	public Roles(int id, String alias, String nombre, String descripcion) {
		super();
		this.id = id;
		this.alias = alias;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	/**
	 * Constructor de roles sin identificador	 
	 * @param alias
	 * @param nombre
	 * @param descripcion
	 */
	public Roles(String alias, String nombre, String descripcion) {
		super();		
		this.alias = alias;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	/**
	 * Constructor de roles solo alias 
	 * @param alias
	 * @param nombre
	 * @param descripcion
	 */
	public Roles(String alias) {
		super();		
		this.alias = alias;		
	}
	

	
	
		
}
