package ipartek.formacion.ejemplos.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity 
@Table(name = "Direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Basic
	@Column(name = "Calle")
	private String calle;
	
	@Basic
	@Column(name = "CP")
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

	public Direccion(String calle, String codigoPostal) {
		super();
		this.calle = calle;
		this.codigoPostal = codigoPostal;
	}

	public Direccion() {

	}
	 
	
	/*
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Persona persona;
	
	
	public Persona getPersona() {
		return this.persona;
	}
 
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "persona"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = true )
	private int personaId;
		
	public Integer getPesonaId() {
		return this.personaId;
	}
 
	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}
	*/
 

	 
	 

}
