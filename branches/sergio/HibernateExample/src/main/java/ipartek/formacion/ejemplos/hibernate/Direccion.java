package ipartek.formacion.ejemplos.hibernate;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Direccion")
public class Direccion {

	
	@Id
    @GeneratedValue
    @Column(name = "id")
    Long id;
	
	/* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "calle", nullable = false)
    private String calle;
    
    /* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "portal", nullable = false)
    private String portal;
    
    @Basic
    @Column(name = "cp")    
    private int cp = 18;
	
    /*
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="idPersona")  
    private Persona persona;
        
    
    public Persona getPersona()  
    {  
        return persona;  
    }
    
    public void setPersona(Persona persona)  
    {  
        this.persona = persona;  
    }
    */
	
	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getPortal() {
		return portal;
	}



	public void setPortal(String portal) {
		this.portal = portal;
	}



	public int getCp() {
		return cp;
	}



	public void setCp(int cp) {
		this.cp = cp;
	}



	public Long getId() {
		return id;
	}


		

	public Direccion(String calle, String portal, int cp) {
		super();
		this.calle = calle;
		this.portal = portal;
		this.cp = cp;
	}



	public Direccion() {
		
	}
	
	@Override
	public String toString() {
		
		//return super.toString();
		
		String texto = "";
		
		//texto += "Persona: " + getPersona() == null ? "None" : getPersona().getNombre(); 
		texto += "Dire: " + getCalle() + " " + getPortal() + " " + String.valueOf(getCp()) + nl;
		
			
		
		
		return texto;
		
	}

	public static String nl = System.getProperty("line.separator");
}
