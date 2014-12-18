package com.ipartek.formacion.helloweb.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import com.ipartek.formacion.helloweb.i18n.Idioma;


public class Login {
	
	private static final String URL_APP = "http://localhost:8080/HelloWeb/";

	public Login() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void loginAdminOK() {
		
		assertEquals("<html lang='xx_XX'> no es correcto", Idioma.EUSKERA.getLocale(), loginAdmin( Idioma.EUSKERA.getLocale()));
		assertEquals("<html lang='xx_XX'> no es correcto", Idioma.INGLES.getLocale(), loginAdmin( Idioma.INGLES.getLocale()));
		assertEquals("<html lang='xx_XX'> no es correcto", Idioma.CASTELLANO.getLocale(), loginAdmin( Idioma.CASTELLANO.getLocale()));
			
	}
	
	/**
	 * Hace un login como administrador y entramos al backoffice	  
	 * @param idioma value para selecionar el option del select en el formulario de login
	 * @return idioma que este el el atributo "lang" de la etiqueta "html" del backoffice
	 */
	private String loginAdmin ( String idioma ){
		String resul = "";
		
		WebDriver driver = new HtmlUnitDriver();
	    
	    driver.get(URL_APP);
	    assertEquals("No coincide Title" ,driver.getTitle(), "Login");
	    
	    //buscar input por su 'name' y cargar value con la funcion sendKeys()
        WebElement element = driver.findElement( By.name("user") );
        element.sendKeys("admin");

        element = driver.findElement(By.name("pass"));
        element.sendKeys("admin");
        
        
        Select dropdown = new Select(driver.findElement(By.name("idioma")));
        dropdown.selectByValue( idioma );
        
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        
        // Check the title of the page
        assertEquals("No estamos en Backoffice","BackOffice", driver.getTitle());
        
        //check Idioma
        element = driver.findElement(By.tagName("html"));
        resul = element.getAttribute("lang");
        
        
	    driver.quit();	
		
		return resul;
	}

	
	@Test
	public void loginUserOK() {
		fail("not implemented");
	}
	
	@Test
	public void loginError() {
		fail("not implemented");
	}
	
	
	
}
