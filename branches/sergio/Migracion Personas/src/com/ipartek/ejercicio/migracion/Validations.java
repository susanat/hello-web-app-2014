package com.ipartek.ejercicio.migracion;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.aeat.valida.Validador;
import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsNumeros;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsTextos;

/**
 * This class has function to do some validations.
 * @author baskito
 *
 */
public final class Validations {

    /**
     * Empty constructor.
     */
    private Validations() {

    }

    /**
     * Check if number of fields is expected.
     * 
     * @param line line to check
     * @param numberFields number of fields for line
     * @return enum errorCause
     */
    public static eErrorCause isValidNumberFields(final String line,
	    final int numberFields) {

	eErrorCause errorCause = null;

	String[] splited = line.split(Constantes.STR_SEPARATOR);

	if (splited.length < numberFields) {
	    errorCause = eErrorCause.MIN_FIELDS;
	} else if (splited.length > numberFields) {
	    errorCause = eErrorCause.MAX_FIELDS;
	}

	return errorCause;
    }

    /**
     * Check valid email.
     * 
     * <br>
     * Need library valnif.jar
     * 
     * @see https
     *      ://amatellanes.wordpress.com/2013/07/30/java-validar-dni-nie-o-cif
     *      -en-java/
     * @see https
     *      ://www.agenciatributaria.es/AEAT.desarrolladores/Desarrolladores/
     *      Descarga_de_modulos/Descarga_de_modulos.html
     * @param dni
     *            String with dni format: (00000000X)
     * @return false if not valid format, true if ok
     */
    public static boolean isValidDNI(final String dni) {

	//completamos el DNI hasta nueve caracteres
	String dniTemp = ClsUtilsTextos.padLeft(dni, 
		Constantes.DNI_MIN_SIZE, Constantes.DNI_CARACTER);
	
	boolean checkOk = false;
	
	Validador validador = new Validador();
	int e = validador.checkNif(dniTemp);

	if (e > 0) {
	    checkOk = true;
	}
	
	return checkOk;

    }

    /**
     * Check if string is has valid UTF8.
     * 
     * @param input String to check
     * @return boolean True if is valid, false if not 
     */
    public static boolean isValidUTF8(final String input) {
	
	/*
	@SuppressWarnings("unused")
	byte[] myBytes = null;

	try {
	    myBytes = input.getBytes(Constantes.CHARSET_OUTPUT.toString());
	} catch (UnsupportedEncodingException e) {
	    return false;
	}

	return true;
	*/
	return true;
    }

    /**
     * Validate if a UTF-8 string contains mal-encoded characters.
     * 
     * @param input
     *            Text to check
     * @return boolean false if has error, true if not
     */
    public static boolean isUTF8MisInterpreted(final String input) {
	// convenience overload for the most common UTF-8 misinterpretation
	// which is also the case in your question
	return isUTF8MisInterpreted(input, "Windows-1252");
    }

    /**
     * Validate if a UTF-8 string contains mal-encoded characters.
     * 
     * @param input
     *            Text to check
     * @param encoding
     *            Type of encoding based
     * @return boolean false if has error, true if not
     */
    public static boolean isUTF8MisInterpreted(final String input,
	    final String encoding) {

	CharsetDecoder decoder = Charset.forName(
		Constantes.CHARSET_OUTPUT.toString()).newDecoder();
	CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
	ByteBuffer tmp;
	try {
	    tmp = encoder.encode(CharBuffer.wrap(input));
	} catch (CharacterCodingException e) {
	    return false;
	}

	try {
	    decoder.decode(tmp);
	    return true;
	} catch (CharacterCodingException e) {
	    return false;
	}
    }

    /**
     * Check if edad if correct.
     * 
     * <br> - Check if is a number 
     * <br> - Check if is lower that min number and bigger that max number
     * 
     * @param edad String with edad;
     * @return True if is correct, false if not
     * 
     * @throws Exception number format exceptions
     */
    public static boolean isValidEdad(final String edad) 
	    throws NumberFormatException {

	if (!ClsUtilsNumeros.isNumeric(edad)) {
	    throw new NumberFormatException();
	}

	int numberEdad = Integer.valueOf(edad);

	if (numberEdad < Constantes.MIN_EDAD
		|| numberEdad > Constantes.MAX_EDAD) {
	    return false;
	}

	return true;

    }

    /**
     * Check for valid email.
     * 
     * Need library javax.mail.jar
     * 
     * @see https://java.net/projects/javamail/pages/Home
     * @param email String with the email
     * @return true if is correct, false if not
     */
    public static boolean isValidEmail(final String email) {
	boolean isValid = false;
	try {
	    //
	    // Create InternetAddress object and validated the supplied
	    // address which is this case is an email address.
	    final InternetAddress internetAddress = new InternetAddress(email);
	    internetAddress.validate();
	    isValid = true;
	} catch (AddressException e) {
	    // Redundante, pero bueno...
	    isValid = false;
	}

	return isValid;
    }
}
