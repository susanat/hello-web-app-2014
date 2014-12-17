package com.ipartek.formacion.helloweb.comun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class proper {
	
	
	private Properties properties = null;
	private String path = "";
	private ServletContext context = null;
	
	
	public proper (String path) throws IOException {
		this.path = path;
		
		loadProperties();
	}
	
	
	
	private void loadProperties() throws IOException {
	
		//Abrir un properties
		//InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/com/ipartek/formacion/helloweb/i18n/" + "lang_es_ES.properties");		
		
		InputStream input = context.getResourceAsStream(path);
		properties.load(input);
		
	}
	
	
	public void setPropertie(Object key, Object value) {
		properties.put(key, value);
		
	}
	
	public void savePropertie() throws IOException {
		
		//File file = new File("C:\\desarrollo\\Web\\apache-tomcat-6.0.43\\webapps\\HelloWeb\\WEB-INF\\classes\\com\\ipartek\\formacion\\helloweb\\i18n\\lang_en_ES.properties");
		File file = new File(path);
		
		//File file = new File(getServletContext().getContextPath() + resourceUrl.toURI());
		OutputStream output = new FileOutputStream(file);
		properties.store(output, "Prueba");
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	
	/*
	 * // First try loading from the current directory
    try {
        File f = new File("server.properties");
        is = new FileInputStream( f );
    }
    catch ( Exception e ) { is = null; }
 
    try {
        if ( is == null ) {
            // Try loading from classpath
            is = getClass().getResourceAsStream("server.properties");
        }
 
        // Try loading properties from the file (if found)
        props.load( is );
    }
    catch ( Exception e ) { }
	 */
	
	
	
	
	
		
	
	
	//salvar
	//URL resourceUrl = getServletContext().getResource("/WEB-INF/classes/com/ipartek/formacion/helloweb/i18n/" + "lang_es_ES.properties");
	
	
	
	

}
