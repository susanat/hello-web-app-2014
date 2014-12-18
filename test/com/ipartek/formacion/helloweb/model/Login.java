package com.ipartek.formacion.helloweb.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	assertEquals("No es el idioma esperado", Idioma.EUSKERA.getLocale(),
		loginAdmin(Idioma.EUSKERA.getLocale()));
	assertEquals("No es el idioma esperado", Idioma.INGLES.getLocale(),
		loginAdmin(Idioma.INGLES.getLocale()));
	assertEquals("No es el idioma esperado", Idioma.CASTELLANO.getLocale(),
		loginAdmin(Idioma.CASTELLANO.getLocale()));
    }

    @Test
    public void loginUserOK() {
	WebDriver driver = new HtmlUnitDriver();

	driver.get(URL_APP);
	assertEquals("No coincide Title", driver.getTitle(), "Login");

	// Find the text input element by its name
	WebElement inputUser = driver.findElement(By.name("user"));
	inputUser.sendKeys("usuario");

	WebElement inputPass = driver.findElement(By.name("pass"));
	inputPass.sendKeys("pass");

	// Now submit the form. WebDriver will find the form for us from the
	// element
	inputPass.submit();

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());
	assertEquals("Index Usuario", driver.getTitle());
	// buscar Div donde se muestra los datos del usuario Logeado
	// driver.findElement(By.id("user_login"));

	driver.quit();

    }

    @Test
    public void loginError() {
	WebDriver driver = new HtmlUnitDriver();
	String idioma = Idioma.INGLES.getLocale();

	driver.get(URL_APP);
	assertEquals("No coincide Title", driver.getTitle(), "Login");

	// Find the text input element by its name
	WebElement elementName = driver.findElement(By.name("user"));
	elementName.sendKeys("xxxxx");

	WebElement elementPass = driver.findElement(By.name("pass"));
	elementPass.sendKeys("11741215B");

	Select dropdown = new Select(driver.findElement(By.name("idioma")));

	dropdown.selectByValue(idioma);

	// Now submit the form. WebDriver will find the form for us from the
	// element
	elementPass.submit();
	if (idioma.equals(Idioma.CASTELLANO.getLocale())) {
	    assertTrue(driver.getPageSource().contains("incorrecta"));
	} else if (idioma.equals((Idioma.INGLES.getLocale()))) {
	    assertTrue(driver.getPageSource().contains("Incorrect"));
	} else {
	    assertTrue(driver.getPageSource().contains("zuzena"));
	}

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());

	driver.quit();
    }

    /**
     * Hace un login como administador y entramos al backoffice
     *
     * @param lang
     *            el value para seleccionar el opcion del menu desplegable
     *            (select) en el formulario de login
     * @return idioma que este en el atributo "lang" de la etiqueta html del
     *         backoffice
     */
    private String loginAdmin(String lang) {
	String resul = "";

	WebDriver driver = new HtmlUnitDriver();

	driver.get(URL_APP);
	assertEquals("No coincide Title", driver.getTitle(), "Login");

	// Find the text input element by its name
	WebElement inputUser = driver.findElement(By.name("user"));
	inputUser.sendKeys("admin");

	WebElement inputPass = driver.findElement(By.name("pass"));
	inputPass.sendKeys("admin");

	Select dropdown = new Select(driver.findElement(By.name("idioma")));
	dropdown.selectByValue(lang);

	// Now submit the form. WebDriver will find the form for us from the
	// element
	inputPass.submit();

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());
	assertEquals("Backoffice", driver.getTitle());
	// buscar Div donde se muestra los datos del usuario Logeado
	// driver.findElement(By.id("user_login"));

	// TODO: Check idioma
	inputPass = driver.findElement(By.tagName("html"));
	resul = inputPass.getAttribute("lang");

	driver.quit();
	return resul;
    }

}
