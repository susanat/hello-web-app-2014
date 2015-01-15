package com.ipartek.ejercicio.migracion.object;

import java.util.LinkedList;

import com.ipartek.ejercicio.migracion.Constantes;
import com.ipartek.ejercicio.migracion.Validations;
import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsConstantes;

/**
 * Objeto que guardará los datos de un registro.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public class Persona {
    
    /**
     * Save the posible errors in data.
     */
    private final LinkedList<eErrorCause> errors; 
    //inicializado en el constructor
        

    /**
     * Variable que guardará el nombre.
     */
    private String nombre;
    
    /**
     * Variable que guardará el apellido1.
     */
    private String apellido1;
    
    /**
     * Variable que guardará la población.
     */
    private String poblacion;
    
    /**
     * Variable que guardará la edad (-1 si es errónea).  
     */
    private int edad;
    
    /**
     * Variable que guardará el dni.
     */
    private String email;
    
    /**
     * Variable que guardará el DNI.
     */
    private String dni;
    
    /**
     * Variable que guardará el cargo.
     */
    private String cargo;
    
    /**
     * Get all type errors ocurred in object.
     * @return eErrorCause error
     */
    public LinkedList<eErrorCause> getErrors() {
	return errors;
    }
    
    
    /**
     * Get the value for nombre.
     * @return String with value
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * Set value in nombre.
     * @param vNombre String
     */
    public void setNombre(final String vNombre) {
	if (!Validations.isValidUTF8(vNombre)) {
	    errors.add(eErrorCause.UTF8);
	}
		
	this.nombre = vNombre;
    }

    /**
     * Get the value for apellido1.
     * @return String with value
     */
    public String getApellido1() {
	return apellido1;
    }

    /**
     * Set value in apellido1.
     * 
     * @param apellido1 String
     */
    public void setApellido1(final String apellido1) {
	if (!Validations.isUTF8MisInterpreted(apellido1)) {
	    errors.add(eErrorCause.UTF8);
	}
		
	this.apellido1 = apellido1;
    }

    /**
     * Get the value for población.
     * @return String with value
     */
    public String getPoblacion() {
	return poblacion;
    }

    
    /**
     * Set value in poblacion.
     * @param poblacion String
     */
    public void setPoblacion(final String vPoblacion) {
	if (!Validations.isUTF8MisInterpreted(vPoblacion)) {
	    errors.add(eErrorCause.UTF8);
	}
		
	this.poblacion = poblacion;
    }

    /**
     * Get the value for edad.
     * @return String with value
     */
    public int getEdad() {
	return edad;
    }

    public void setEdad(final String edad) {
	
	try {
	    //check validations 
	    if (!Validations.isValidEdad(edad)) {
		errors.add(eErrorCause.EDAD);		
	    }
	    //save the edad
	    this.edad = Integer.valueOf(edad);
	} catch (Exception ex) {
	    //error in edad passed, save -1
	    this.edad = -1;
	}	
	
    }

    /**
     * Get the value for email.
     * @return String with value
     */
    public String getEmail() {
	return email;
    }

    public void setEmail(final String email) {
	
	if (!Validations.isValidEmail(email)) {
	    errors.add(eErrorCause.EMAIL);
	}
	
	this.email = email;
    }

    /**
     * Get the value for DNI.
     * @return String with value
     */
    public String getDni() {
	return dni;
    }

    public void setDni(String dni) {
	if (!Validations.isValidDNI(dni)) {
	    errors.add(eErrorCause.DNI);
	}
	
	this.dni = dni;
    }

    /**
     * Get the value for Cargo.
     * @return String with value
     */
    public String getCargo() {
	return cargo;
    }

    
    public void setCargo(String cargo) {
	
	if (!Validations.isUTF8MisInterpreted(cargo)) {
	    errors.add(eErrorCause.UTF8);
	}
		
	this.cargo = cargo;	
    }

    
    /**
     * Create a new object empty.
     */
    public Persona() {
	//initialize list of errors
	errors = new LinkedList<eErrorCause>();
    }
    
    /**
     * Check if object has error.
     * 
     * @return true if yes, false if not
     */
    public boolean hasErrors() {
	
	if (errors != null) {
	    if (errors.size() > 0) { 
		return true; 
	    }
	}	
		
	return false;		
    }
    

    @Override
    public String toString() {
	
	StringBuffer text = new StringBuffer();
	
	//configuramos los errores
	if (errors != null && errors.size() > 0) {
	    for (eErrorCause errorCause : errors) {
		text.append(errorCause.toString()).append(ClsUtilsConstantes.STR_COMMA); 
	    }
	}
	//quitamos la última coma
	if (text.length() > 0) {
	   text = new StringBuffer(text.substring(0,text.length() - 1));
	   text.append("=>");
	}
	
	text.append(nombre).append(ClsUtilsConstantes.STR_COMMA);
	text.append(apellido1).append(ClsUtilsConstantes.STR_COMMA);
	text.append(poblacion).append(ClsUtilsConstantes.STR_COMMA);
	text.append(edad).append(ClsUtilsConstantes.STR_COMMA);
	text.append(email).append(ClsUtilsConstantes.STR_COMMA);
	text.append(dni).append(ClsUtilsConstantes.STR_COMMA);
	text.append(cargo).append(ClsUtilsConstantes.STR_COMMA);
	
		
	return text.toString();
    }

}
