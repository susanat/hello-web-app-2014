package ipartek.formacion.ejemplos.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Direccion")
public class Direccion {
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY) 
	 private long id;
	 
	 private String calle;
	 private String codigoPostal;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}  
	 
	 
	 

}
