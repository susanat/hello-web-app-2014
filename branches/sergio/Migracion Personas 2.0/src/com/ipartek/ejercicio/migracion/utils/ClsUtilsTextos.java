package com.ipartek.ejercicio.migracion.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Funciones útiles para el tratamiendo de texto.
 *
 * @author Sergio Rubio
 * @version 03.11.2014
 * 
 * - Modificaciones
 * - Casa 20.11.2014
 */
public final class ClsUtilsTextos {
    
    /**
     * Empty constructor.
     */
    private ClsUtilsTextos() {
	
    }
    
    /**
     * Obtiene el texto entre dos textos indicados.
     *    
     * @param texto String con el texto
     * @param limitA String texto límite 
     * @return List<String> con el texto obtenido
     */
    public static List<String> getBetweenTwoCharacters(final String texto, 
	    final String limitA) {
        return getBetweenTwoCharacters(texto, limitA, limitA);
    }
    
    /**
     * Obtiene el texto entre dos textos indicados.
     *    
     * @param texto String con el texto
     * @param limitA String texto límite inferior
     * @param limitB String texto límite superior 
     * @return List<String> con el texto obtenido
     */
    public static List<String> getBetweenTwoCharacters(final String texto, 
	    final String limitA, final String limitB) {
        final List<String> lst = new ArrayList<String>();
        String start = limitA;
        String end = limitB;
        String condition = "(.*?)";
        // "\\([^()]*\\)"
        //String condition = "[^()]*";
        
        @SuppressWarnings("serial")
		final ArrayList<String> list = new ArrayList<String>() { {
            add("(");
            add(")");
            add("[");
            add("]");
            add(".");
        } };
                
        if (list.contains(limitA)) {
            start = "\\" + limitA;
        } else {
            start = limitA;
        }
        
        if (list.contains(limitB)) {
            end = "\\" + limitB;
        } else {
            end = limitB;
        }
        

        //start = a;
        
        //"\\(.*?\\)"
        //String strs = "ZZZZL <%= dsn %> AFFF <%= AFG %>";
        String patternStr = start + condition + end;
        //patternStr = "\\((.*?)\\)";
        
        Pattern pattern = Pattern.compile(patternStr);
        final Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            //System.out.println(matcher.group(1));
            lst.add(matcher.group(1));
        }
        
        return lst;
    }
    
    /**
     * Obtiene una cadena de caracteres iniciando por la última posición.
     * 
     * @param inputString String de entrada
     * @param subStringLength Numero de caracteres a obtener
     * @return String con los caracteres indicados
     */
    public static String getLastnCharacters(final String inputString, 
	    final int subStringLength) {
        int length = inputString.length();
        if (length <= subStringLength) {
            return inputString;
        }
        int startIndex = length - subStringLength;
        return inputString.substring(startIndex);
    }
    
    /**
     * Añade caracteres a la izquierda del texto hasta llegar a 
     * un tamaÃ±o determinado.
     * Si el tamaño total es menor que el del texto, devuelve la cadena intacta.
     * @param texto Texto al que aÃ±adiremos los caracteres
     * @param tamTotal TamaÃ±o total del texto final
     * @param caracter CarÃ¡cter a aÃ±adir
     * @return String con el texto cumplimentado
     */
    public static String padLeft(final String texto, 
	    final int tamTotal, final String caracter) {
	String txtTemp = texto;
	
        if (texto.length() >= tamTotal) {
            return txtTemp;        
        } else {
            
            txtTemp = String.format("%1$" + tamTotal + "s", texto);
            txtTemp = txtTemp.replace(" ", caracter);
            
            //return String.format
            //("%1$" + tamTotal + "s",texto).replace(" ", caracter);
            return txtTemp;
        }
    }
    
    /**
     * Añade caracteres a la derecha del texto hasta 
     * llegar a un tamaño determinado.
     * Si el tamaño total es menor que el del texto, devuelve la cadena intacta.
     * @param texto Texto al que añadiremos los caracteres
     * @param tamTotal tamaño total del texto final
     * @param caracter Caracter a añadir
     * @return String con el texto cumplimentado
     */
    public static String padRight(final String texto, 
	    final int tamTotal, final String caracter) {   
        	
	String txtTemp = "";
	
	if (texto.length() >= tamTotal) {
	    txtTemp =  texto;        
        } else {
            txtTemp = String.format("%1$-" + tamTotal + "s", texto);
            txtTemp = txtTemp.replace(" ", caracter);
        }
	
	return txtTemp;
    }

    
    /**
     * Desordena un string.
     * 
     * @param texto String con texto a desordenar
     * @return String con los caracteres desordenados
     */
    @SuppressWarnings("unused")
    private String desordenarString(final String texto) {

	final List<String> letters = Arrays.asList(texto.split(""));
	Collections.shuffle(letters);

	StringBuffer salida = new StringBuffer();
	for (final String letter : letters) {
	    salida.append(letter);
	}

	return salida.toString();		
    }
    
   
}
