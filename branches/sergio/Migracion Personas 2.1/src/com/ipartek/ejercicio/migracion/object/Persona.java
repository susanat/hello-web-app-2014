package com.ipartek.ejercicio.migracion.object;

import java.util.LinkedList;

import com.ipartek.ejercicio.migracion.Constantes;
import com.ipartek.ejercicio.migracion.Validations;
import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsConstantes;

/**
 * Objeto que guardar� los datos de un registro.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public class Persona {
    
    
    public final static int EDAD_DEFAULT = 0; 
    
    
    /**
     * Save the posible errors in data.
     */
    private final LinkedList<eErrorCause> errors; 
    //inicializado en el constructor
        

    /**
     * Variable que guardar� el nombre.
     */
    private String nombre;
    
    /**
     * Variable que guardar� el apellido1.
     */
    private String apellido1;
    
    /**
     * Variable que guardar� la poblaci�n.
     */
    private String poblacion;
    
    /**
     * Variable que guardar� la edad (-1 si es err�nea).  
     */
    private int edad;
    
    /**
     * Variable que guardar� el dni.
     */
    private String email;
    
    /**
     * Variable que guardar� el DNI.
     */
    private String dni;
    
    /**
     * Variable que guardar� el cargo.
     */
    private String cargo;
    
    /**
     * Get all type errors ocurred in object.
     * @return eErrorCause error
     */
    public final LinkedList<eErrorCause> getErrors() {
	return errors;
    }
    
    
    /**
     * Get the value for nombre.
     * @return String with value
     */
    public final String getNombre() {
	return nombre;
    }

    /**
     * Set value in nombre.
     * @param vNombre String
     */
    public final void setNombre(final String vNombre) {
	if (!Validations.isValidUTF8(vNombre)) {
	    errors.add(eErrorCause.UTF8);
	}
		
	this.nombre = vNombre;
    }

    /**
     * Get the value for apellido1.
     * @return String with value
     */
    public final String getApellido1() {
	return apellido1;
    }

    /**
     * Set value in apellido1.
     * 
     * @param apellido1 String
     */
    public final void setApellido1(final String apellido1) {
	if (!Validations.isUTF8MisInterpreted(apellido1)) {
	    errors.add(eErrorCause.UTF8);
	}
		
	this.apellido1 = apellido1;
    }

    /**
     * Get the value for poblaci�n.
     * @return String with value
     */
    public final String getPoblacion() {
	return poblacion;
    }

    
    /**
     * Set value in poblacion.
     * @param poblacion String
     */
    public final void setPoblacion(final String vPoblacion) {
	if (!Validations.isUTF8MisInterpreted(vPoblacion)) {
	    errors.add(eErrorCause.UTF8);
	}
		
	this.poblacion = vPoblacion;
    }

    /**
     * Get the value for edad.
     * @return String with value
     */
    public final int getEdad() {
	return edad;
    }

    /**
     * Añadimos la edad.
     * @param edad 
     */
    public final void setEdad(final String edad) {
	
	
	int edadInsert = EDAD_DEFAULT;
	
	try {
	    //check validations 1.0
	    /*
	    if (!Validations.isValidEdad(edad)) {
		errors.add(eErrorCause.EDAD);		
	    }
	    */
	    
	    //v2.0 Cualquier fallo de la edad implica que esta se ponga a 0, 
	    //pero se marca como error en log pero se inserta en fichero correcto
	    if (!Validations.isValidEdad(edad)) {
		errors.add(eErrorCause.EDAD);				
	    } else {
		//save the edad
		edadInsert = Integer.valueOf(edad);
	    }
	    
	    
	    this.edad = edadInsert;
	    
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
	//quitamos la �ltima coma
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
