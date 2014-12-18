package com.ipartek.formacion.helloweb.login;

import static org.junit.Assert.assertEquals;

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
    public void loginOKAdmin() {
	assertEquals("<html lang='xx_XX' no es correcto",
		Idioma.EUSKERA.getLocale(),
		loginAdmin(Idioma.EUSKERA.getLocale()));

	assertEquals("<html lang='xx_XX' no es correcto",
		Idioma.INGLES.getLocale(),
		loginAdmin(Idioma.INGLES.getLocale()));

	assertEquals("<html lang='xx_XX' no es correcto",
		Idioma.CASTELLANO.getLocale(),
		loginAdmin(Idioma.CASTELLANO.getLocale()));

    }

    /**
     * Hace un login como administrador y entramos al backoffice
     *
     * @param idioma
     *            - value para seleccionar el option del select en el formulario
     *            de login
     * @return idioma que este en el atributo "lang" de la etiqueta "html" del
     *         backoffice
     */

    private String loginAdmin(String idioma) {
	String result = "";

	WebDriver driver = new HtmlUnitDriver();

	driver.get(URL_APP);
	assertEquals("No coincide Title", driver.getTitle(), "Log-in");

	// Buscar input por su 'name'
	WebElement inputUser = driver.findElement(By.name("user"));
	inputUser.sendKeys("admin");

	WebElement inputPass = driver.findElement(By.name("pass"));
	inputPass.sendKeys("admin");

	Select dropdown = new Select(driver.findElement(By.name("idioma")));
	dropdown.selectByValue(idioma);
	// Now submit the form. WebDriver will find the form for us from the
	// element
	inputPass.submit();
	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());

	assertEquals("Backoffice", driver.getTitle());
	// buscar Div donde se muestra los datos del usuario Loegado
	// driver.findElement(By.id("user_login"));

	// check idioma
	WebElement element = driver.findElement(By.tagName("html"));
	result = element.getAttribute("lang");

	driver.quit();
	return result;
    }

    @Test
    public void loginOKUser() {

	WebDriver driver = new HtmlUnitDriver();

	driver.get(URL_APP);
	assertEquals("No coincide Title", driver.getTitle(), "Log-in");

	// Buscar input por su 'name'
	WebElement inputUser = driver.findElement(By.name("user"));
	inputUser.sendKeys("user");

	WebElement inputPass = driver.findElement(By.name("pass"));
	inputPass.sendKeys("user");

	// Now submit the form. WebDriver will find the form for us from the
	// element
	inputPass.submit();

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());

	assertEquals("Saludo", driver.getTitle());
	// buscar Div donde se muestra los datos del usuario Loegado
	// driver.findElement(By.id("user_login"));

	driver.quit();
    }

    @Test
    public void loginError() {
	WebDriver driver = new HtmlUnitDriver();

	driver.get(URL_APP);
	assertEquals("No coincide Title", driver.getTitle(), "Log-in");

	// Find the text input element by its name
	WebElement inputUser = driver.findElement(By.name("user"));
	inputUser.sendKeys("xxxxx");

	WebElement inputPass = driver.findElement(By.name("pass"));
	inputPass.sendKeys("11741215B");

	// Now submit the form. WebDriver will find the form for us from the
	// element
	inputPass.submit();

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());

	// buscar Div donde se muestra los mensajes
	WebElement elementMsgs = driver.findElement(By.className("alert"));

	assertEquals("No el mensaje de error ", elementMsgs.getText(),
		"User or password incorrect ×Close");

	driver.quit();
    }

}
