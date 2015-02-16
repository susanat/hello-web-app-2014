package net.codejava.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
 * A Java servlet that handles file upload from client.
 * @author www.codejava.net
 */
public class UploadServlet extends HttpServlet {
	
	private final static Logger log = Logger.getLogger(UploadServlet.class);
	
	
	private void configuraLog() throws Exception {
		try{
    		//String pathReal = config.getServletContext().getRealPath("/");
    		//PropertyConfigurator.configure(System.getProperty("catalina.base") + "\\conf\\whoiswhojon\\log4j.properties");//pathReal+"WEB-INF/conf/log4j.properties");
    		    
    		System.out.println(System.getProperty("catalina.base"));
    		
    		//obtenemos el path para el properties dentro del server
    		String pathForServer = System.getProperty("catalina.base");
    		String foleerForPropertiesConf = "conf";
    		String folderForProperties = "UploadServletAppSergio";
    		String pathForProperties = pathForServer + File.separator + 
    								   foleerForPropertiesConf + File.separator + 
    								   folderForProperties + File.separator;
    		
    		
    		String pathForPropertiesParaCopiar = this.getServletContext().getRealPath(File.separator) 
    				+ "WEB-INF" + File.separator 
    				+ "classes" + File.separator    				
    				+ "log4j.properties"; 
    		
    		
    		//creamos la carpeta
    		File dirForProperties = new File(pathForProperties);
    		if (!dirForProperties.exists()) {
    			dirForProperties.mkdir();
    		}
    		
    		//le asignamos permisos de escritura
    		dirForProperties.setWritable(true);
    		
    		//copiamos el fichero properties
    		File fileForPropertiesParaCopiar = new File(pathForPropertiesParaCopiar);
    		
    		copyFileUsingStream(fileForPropertiesParaCopiar, new File(pathForProperties + "log4j.properties"));
    		
    		   		
    		String pathForLog = this.getServletContext().getRealPath(File.separator) + "trazas.log";    		
    		System.setProperty("my.log", pathForLog);    		
    		PropertyConfigurator.configure(pathForProperties + "log4j.properties");
    		
    		
    		
    		
    		
    		//en el properties ${catalina.base}
    		/*
    		String pathForProperties = this.getServletContext().getRealPath(File.separator) 
    				+ "WEB-INF" + File.separator 
    				+ "classes" + File.separator    				
    				+ "log4j.properties";    		
    		String pathForLog = this.getServletContext().getRealPath(File.separator) + "trazas.log";    		
    		System.setProperty("my.log", pathForLog);    		
    		PropertyConfigurator.configure(pathForProperties);
    		*/
    		
    		
    		
    		
    		
    		log.info("cargado log");
    	}catch( Exception e){
    		throw e;
    	}
	}
	
	
	
	
	@Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	
    		
    }
		
	
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE 	= 1024 * 1024 * 3; 	// 4MB
	private static final int MAX_FILE_SIZE 		= 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE 	= 1024 * 1024 * 50; // 50MB

	private static final String[] MIMME_TYPE_ALLOWED = {"image/png", "image/jpeg"}; 
	
	
	/**
	 * handles file upload via HTTP POST method
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean continuar = true;
		
		try {
			configuraLog();
		} catch (Exception e) {
			request.setAttribute("message", "There was an error: " + e.getMessage());
			continuar = false;
		}
		
		
		if(continuar) {
		
			log.info("Entra en el servlet doPost para subir imagen");
			
			//si no hay contenido de tipo fichero
			// checks if the request actually contains upload file
			if (!ServletFileUpload.isMultipartContent(request)) {
				PrintWriter writer = response.getWriter();
				writer.println("Request does not contain upload data");
				writer.flush();
				return;
			}
			
			
			// configures upload settings
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(THRESHOLD_SIZE);
			
			//crea un fichero temporal
			//TODO: mandar a constantes. getProperty("java.io.tmpdir") -> ruta de la carpeta temporal independiente del sistema operativo
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(MAX_REQUEST_SIZE);
			
			// constructs the directory path to store upload file
			//TODO: pasar a constantes lo del File.separator
			String uploadPath = getServletContext().getRealPath("")	
					+ File.separator 
					+ UPLOAD_DIRECTORY.trim();
			
			
			//TODO: ¿habria que comprobar los permisos de la carpeta del servidor?
			//Creamos el directorio si no existe
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			
			
			
			//obtenemos la url del root del proyecto
			/*
			StringBuffer url = request.getRequestURL();
			String uri = request.getRequestURI();
			String ctx = request.getContextPath();
			String base = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
			*/
			
			//path real del root del servidor
			String path = this.getServletContext().getRealPath(File.separator);
					
			
			try {
				// parses the request's content to extract file data
				// puede subir más de un fichero
				List formItems = upload.parseRequest(request);
				Iterator iter = formItems.iterator();
				
				// iterates over form's fields
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						
						//aquí, se supone que se podría modificar el nombre del fichero
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName.trim();
						File storeFile = new File(filePath);
						
						
						
						//chequeamos el fichero 
						String mimeType = getServletContext().getMimeType(fileName);
						if(!inArrayLoop(MIMME_TYPE_ALLOWED, mimeType)){
							throw new Exception ("Formato de fichero no permitido");
						}
						
						
						
						
						
						// saves the file on disk
						item.write(storeFile);
						
						//TODO guardar en BBDD la ruta para luego cargar el fichero
						
						
						
						
						//Le restamos al filePath el path real
						
						filePath = filePath.replace(path,"");
						
						request.setAttribute("path",filePath);
					}
				}
				request.setAttribute("message", "Upload has been done successfully!");
				
			} catch (Exception ex) {
				request.setAttribute("message", "There was an error: " + ex.getMessage());
			}
		}
		
		getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	//TODO: revisar http://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
	/**
	 * Arrays grandes
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean inArraysBinarySearch(String[] arr, String targetValue) {	
		int a =  Arrays.binarySearch(arr, targetValue);
		if(a > 0)
			return true;
		else
			return false;
	}
	
	//TODO: revisar http://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
	/**
	 * Arrays cortos
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean inArrayLoop(String[] arr, String targetValue) {
		for(String s: arr){
			if(s.equals(targetValue))
				return true;
		}
		return false;
	}
	
	//TODO: http://www.journaldev.com/861/4-ways-to-copy-file-in-java
	private void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
}
