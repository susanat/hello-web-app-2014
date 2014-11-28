package com.ipartek.formacion.helloweb.bean;

import java.sql.Timestamp;
import java.util.Calendar;



public class ObjComun {

	public static final int DEFAULT_VERSION = 1;
	public static final int DEFAULT_STATUS = 0;
	public static final int DEFAULT_ID = -1;
	public static final long DEFAULT_DATE = 0;
	
	protected int id;
	protected long createdDate;
	protected long modifiedDate;
	protected long deletedDate;
	protected int version;
	protected int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreated_date(long createdDate) {
		this.createdDate = createdDate;
	}

	public long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public long getDeleted_date() {
		return deletedDate;
	}

	public void setDeletedDate(long deletedDate) {
		this.deletedDate = deletedDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Obtiene el estado del objeto
	 * @return boolean 
	 */
	public boolean isStatus() {
		return this.status == 1 ? true : false;
	}

	/**
	 * Asigna el estado del objeto
	 * @param status boolean 
	 */
	public void setStatus(boolean status){
		this.status = (status ? 1 : 0);
	}
	
	/**
	 * Asigna el estado del objeto num�ricamente:
	 * 0 - false, 1 - true
	 * 
	 * @param status int 0 para false y 1 para true
	 * @throws Exception Si el n�mero es distinto a 0 o 1
	 * 
	 */
	public void setStatus(int status) throws Exception {
		if(id != 0 || id !=1 ){
			throw new Exception("No es un valor v�lido para el estado. 0 � 1");
		}else{
			this.status = status;
		}
	}	

	public ObjComun() {
		//inicializo los valores
		this.id = DEFAULT_ID;
		this.createdDate = DEFAULT_DATE;
		this.modifiedDate = DEFAULT_DATE;
		this.deletedDate = DEFAULT_DATE;
		this.version = DEFAULT_VERSION;		
		this.status = DEFAULT_STATUS;
	}

	/**
	 * Constructor to create comun object.
	 * 
	 * @param id id for object
	 * @param created_date Long (Timestamp) Created date for object
	 * @param modified_date Long (Timestamp) Modified date for object
	 * @param version int Version for object
	 * @param status int Status for object
	 */
	public ObjComun(
			int id, 
			long createdDate, 
			long modifiedDate,
			long deletedDate, 
			int version,
			boolean status) {
		this();
		
		this.id = id;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.deletedDate = deletedDate;
		this.version = version;
		this.setStatus(status);
	}
	
	/**
	 * Constructor to create comun object (without id).
	 * 
	 * @param created_date Long (Timestamp) Created date for object
	 * @param modified_date Long (Timestamp) Modified date for object
	 * @param version int Version for object
	 * @param status int Status for object
	 */
	public ObjComun(			
			long createdDate, 
			long modifiedDate,
			long deletedDate, 
			int version,
			boolean status) {
		this();
				
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.deletedDate = deletedDate;
		this.version = version;
		this.setStatus(status);
	}
	
	
	public void initCreatedDate(){
		Timestamp timestampNow = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.createdDate = timestampNow.getTime();
	}
	
	public void initModifiedDate(){
		Timestamp timestampNow = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.modifiedDate = timestampNow.getTime();
	}
	
	public void initDeletedDate(){
		Timestamp timestampNow = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.deletedDate = timestampNow.getTime();
	}
	
	

}
