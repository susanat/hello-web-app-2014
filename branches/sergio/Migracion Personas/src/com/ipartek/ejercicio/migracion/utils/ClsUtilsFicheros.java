package com.ipartek.ejercicio.migracion.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de recopilación de funciones útiles para trabajar con ficheros.
 * 
 * @author baskito
 * @version 20.11.2014
 */
public final class ClsUtilsFicheros {
    
        static {
            System.out.println("This is first static block");
        }
        
    	/**
    	 * Empty constructor.
    	 */
    	private ClsUtilsFicheros() {
    	    
    	}
    

    	/**
    	 * Barra simple.
    	 */
	private static final String BARRA_PATH_SIMPLE = "/";
	
	/**
	 * Barra doble.
	 */
	private static final String BARRA_PATH_DOBLE = "\\";

	/**
	 * Comprueba si existe un fichero.
	 * @param path path y nombre del fichero
	 * @return true if exists, false if not
	 */
	public static boolean existeFichero(final String path) {

		File fFile = new File(path);
		return (fFile.exists() ? true : false);
	}

	/**
	 * Combina dos rutas.
	 * 
	 * @param path1 string con la Ruta inicial
	 * @param path2 string con la Ruta a añadir
	 * @return String con la ruta completa
	 */
	public static String combinarRutas(final String path1, final String path2) {

		File file1 = new File(path1);
		File file2 = new File(file1, path2);
		return file2.getPath().toString();

	}

	/**
	 * Muestra el espacion libre de una unidad.
	 * @param unidad String unidad indicada.
	 * @return Long con el espacion libre
	 */
	private static long espacioLibre(final String unidad) {
		File drive = new File(unidad);
		return drive.getFreeSpace();
	}
	/**
	 * Comprueba si existe espacion libre en una unidad.
	 * 
	 * @param unidad Unidad a comprobar
	 * @param mayorQue Espacion libre necesario
	 * @return true si existe espacio libre, false si no
	 */
	public static boolean existeExpacioLibre(
		final String unidad, final Long mayorQue) {
		return espacioLibre(unidad) > mayorQue;
	}

	/**
	 * Comprueba si existe espacio libre en la unidad.
	 * @param unidad unidad a comprobar
	 * @return true si existe espacio libre, false si no
	 */
	public static boolean existeExpacioLibre(final String unidad) {
		return espacioLibre(unidad) > 0;
	}

	/**
	 * Comprueba si un path tiene la barra final.
	 * @param path String path a comprobar
	 * @return String con el path más la barra al final
	 */
	public static String checkBarraFinal(final String path) {
	    	String localPath = path;
		String barra = "";
		// comprobamos el tipo de ruta:
		if (localPath.contains(BARRA_PATH_SIMPLE)) {
			barra = BARRA_PATH_SIMPLE;
		} else if (localPath.contains(BARRA_PATH_DOBLE)) {
			barra = BARRA_PATH_DOBLE;
		}
		
		if (!localPath.endsWith(barra)) {
		    localPath += barra;
		}
		return localPath;
	}

	/**
	 * Obtiene el path absoluto de un path relativo.
	 * @param relativePath String path relativo
	 * @return String con el path absoluto
	 */
	public static String getAbsolutePath(final String relativePath) {
		Path path = Paths.get(relativePath);
		String spath = path.toAbsolutePath().toString();
		spath = spath.replace(".", "");
		return spath;
	}

	/**
	 * Lee un fichero y devuelve un string. <br>
	 * 
	 * Ejemplos: The StandardCharsets class define some constants for the
	 * encodings required of all Java runtimes: - String content =
	 * readFile("test.txt", StandardCharsets.UTF_8);
	 * 
	 * The platform default is available from the Charset class itself: - String
	 * content = readFile("test.txt", Charset.defaultCharset());
	 * 
	 * @param path
	 *            Ruta del fichero
	 * @param encoding
	 *            Codificación
	 * @return String con el fichero leído
	 * @throws IOException
	 */
	public static String readFile1(final String path, final Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}

	/**
	 * Otra forma de leer un fichero usando scanner.
	 * @param path
	 *            Ruta del fichero	
	 * @return String con el fichero leído
	 * @throws FileNotFoundException Excepción relativa a los ficheros
	 */
	public static String readFile2(final String path) 
		throws FileNotFoundException {

		String content = "";
		content = new Scanner(new File(path)).useDelimiter("\\Z").next();
		// System.out.println(content);

		return content;
	}

	/**
	 * Lee un fichero usando FileInputStream.
	 * 
	 * - orientado a ficheros pequeños.
	 * 
	 * @param path Ruta del fichero
	 * @param encoding Tipo de codificación
	 * @return String con los datos del fichero
	 */
	public static String readFile3(final String path, final Charset encoding) {
		FileInputStream fis = null;
		byte[] data = null;
		String content = "";

		try {
			File file = new File(path);
			fis = new FileInputStream(file);
			data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			content = new String(data, encoding);

		} catch (FileNotFoundException ex) {
		    Logger.getLogger(ClsUtilsFicheros.class.getName()).log(
				Level.SEVERE, null, ex);
		} catch (IOException ex) {
		    Logger.getLogger(ClsUtilsFicheros.class.getName()).log(
				Level.SEVERE, null, ex);
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
				Logger.getLogger(ClsUtilsFicheros.class.getName()).log(
					Level.SEVERE, null, ex);
			}
		}
		return content;
	}

	/**
	 * http://www.javapractices.com/topic/TopicAction.do?Id=42. 
	 * Note: the javadoc
	 * of Files.readAllLines says it's intended for small files. But its
	 * implementation uses buffering, so it's likely good even for fairly large
	 * files.
	 * @param aFileName string con el path y nombre del fichero
	 * @param encoding Charset con la codificación
	 * @return List<String> Lista con las líneas del fichero
	 * @throws IOException Excepción en lectura/escritura del fichero
	 */
	public static List<String> readSmallTextFile(final String aFileName,
			final Charset encoding) 
				throws IOException {
		Path path = Paths.get(aFileName);
		return Files.readAllLines(path, encoding);
	}

	/**
	 * 
	 * @param aLines List<String> con lineas a escribir en el fichero
	 * @param aFileName String Nombre del fichero
	 * @param encoding Charset codificación del fichero
	 * @throws IOException Excepción en lectura/escritura del fichero
	 */
	public static void writeSmallTextFile(final List<String> aLines,
			final String aFileName, final Charset encoding) throws IOException {
		Path path = Paths.get(aFileName);
		Files.write(path, aLines, encoding);
	}

	// For larger files
	
	/**
	 * since 1.7.
	 * 
	 * @param aFileName
	 * @param encodig
	 * @return
	 * @throws IOException
	 */
	/*
	public static List<String> readLargerTextFile(String aFileName,
			Charset encodig) throws IOException {
		Path path = Paths.get(aFileName);
		List<String> texto = new ArrayList<String>();
		try (Scanner scanner = new Scanner(path, encodig.name())) {
			while (scanner.hasNextLine()) {
				// process each line in some way
				texto.add(scanner.nextLine());
			}
		}
		return texto;
	}
	*/

	/*
	public static List<String> readLargerTextFileAlternate(String aFileName,
			Charset encoding) throws IOException {
		Path path = Paths.get(aFileName);
		List<String> texto = new ArrayList<String>();
		try (BufferedReader reader = Files.newBufferedReader(path, encoding)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				// process each line in some way
				texto.add(line);
			}
		}
		return texto;
	}
	*/

	/**
	 * since 1.7.
	 * @param aFileName
	 * @param aLines
	 * @param encoding
	 * @throws IOException
	 */
	/*
	public static void writeLargerTextFile(String aFileName,
			List<String> aLines, Charset encoding) throws IOException {
		Path path = Paths.get(aFileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path, encoding)) {
			for (String line : aLines) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
	*/

	/**
	 * Lee un fichero utilizando scanner.
	 * 
	 * @param path String ruta del fichero
	 * @param encoding Charset codificación del fichero 
	 * @return List<String> lineas del fichero
	 * @throws IOException Excepción en lectura/escritura del fichero 
	 */
	public static List<String> readWithScanerToList(final String path,
			final Charset encoding) 
				throws IOException {
		Path fFilePath = Paths.get(path);
		List<String> texto = new ArrayList<String>();

		Scanner scanner = new Scanner(fFilePath, encoding.name());
		// procesamos la lectura en filas
		while (scanner.hasNextLine()) {
			texto.add(scanner.nextLine());
		}

		scanner.close();

		return texto;
	}
	
	/**
	 * Lee un fichero utilizando bufferedReader.
	 * @param filename String nombre y path del fichero a leer
	 * @return List<String> con las líneas del fichero
	 * @throws Exception Excepción general
	 */
	public static List<String> readFile(final String filename)
		throws Exception {
	    String line = null;
	    List<String> records = new ArrayList<String>();

	    // wrap a BufferedReader around FileReader
	    BufferedReader bufferedReader = new BufferedReader(
		    new FileReader(filename));

	    // use the readLine method of the BufferedReader 
	    // to read one line at a time.
	    // the readLine method returns null when there is 
	    //nothing else to read.
	    while ((line = bufferedReader.readLine()) != null) {
		records.add(line);
	    }

	    // close the BufferedReader when we're done
	    bufferedReader.close();
	    return records;
	}
	
	/**
	 * TODO: testear
	 * @param filename
	 * @param lstLineas
	 * @throws IOException
	 */
	public static void writeFile1(final String filename,final List<String> lstLineas) 
		throws IOException {
		
	    File fout = new File(filename);
	    FileOutputStream fos = new FileOutputStream(fout);

	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

	    for (String linea : lstLineas) {
		bw.write(linea);
		bw.newLine();
	    }

	    bw.close();
	}
	
	
	/**
	 * Use file writer
	 * 
	 * @throws IOException
	 */
	public static void writeFile2(final String filename,final List<String> lstLineas) 
		throws IOException {
	    FileWriter fw = new FileWriter(filename);

	    for (String linea : lstLineas) {
		fw.write(linea + ClsUtilsConstantes.SALTO_DE_LINEA);
		
	    }
	    fw.close();
	}
	
	public static void writeFile2(final String filename,final String texto) 
		throws IOException {
	    FileWriter fw = new FileWriter(filename);

	    
	    fw.write(texto);
		
	    
	    fw.close();
	}

	/**
	 * Use print writer
	 * 
	 * @throws IOException
	 */
	public static void writeFile3(final String filename,final List<String> lstLineas) 
		throws IOException {
	    PrintWriter pw = new PrintWriter(new FileWriter(filename));

	    for (String linea : lstLineas) {
		pw.write(linea + ClsUtilsConstantes.SALTO_DE_LINEA);
	    }

	    pw.close();
	}

	/**
	 * Use OutputStreamWriter
	 * 
	 * @throws IOException
	 */
	public static void writeFile4(final String filename,final List<String> lstLineas) 
		throws IOException {
	    File fout = new File(filename);
	    FileOutputStream fos = new FileOutputStream(fout);

	    //permite charset
	    OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));

	    for (String linea : lstLineas) {
		osw.write(linea + ClsUtilsConstantes.SALTO_DE_LINEA);
	    }

	    osw.close();
	}
	
	public static void writeFile4(final String filename,final String texto) 
		throws IOException {
	    File fout = new File(filename);
	    FileOutputStream fos = new FileOutputStream(fout);

	    //permite charset
	    OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
	    
	    osw.write(texto);	    

	    osw.close();
	}
	
	/**
	 * Create a foleder if not exist.
	 * 
	 * @param path String path to locate folder
	 * @param name Name for folder
	 * @return File folder path. If not creted return null
	 */
	public static File createFolder(final String path, final String name) {
	    
	    File filePath = new File(path);
	    File theDir = new File(filePath, name);
	    	    // if the directory does not exist, create it
	    if (!theDir.exists()) {		
		try {
		    theDir.mkdir();		    
		} catch (SecurityException se) {
		    theDir = null;
		}
	    }
	    
	    return theDir;	    
	}
	
}
