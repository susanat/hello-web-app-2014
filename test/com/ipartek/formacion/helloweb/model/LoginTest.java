package com.ipartek.formacion.helloweb.model;

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

import com.ipartek.formacion.helloweb.util.EIdioma;

public class LoginTest {

	private static final String URL_APP = "http://localhost:8080/HelloWeb/";

	public LoginTest() {
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
		// assertEquals("No es el idioma esperado", EIdioma.EUSKERA.getLocale(),
		// loginAdmin(EIdioma.EUSKERA.getLocale()));
		// assertEquals("No es el idioma esperado", EIdioma.INGLES.getLocale(),
		// loginAdmin(EIdioma.INGLES.getLocale()));
		assertEquals("No es el idioma esperado", EIdioma.CASTELLANO.getLocale(),
				loginAdmin(EIdioma.CASTELLANO.getLocale()));
	}

	@Test
	public void loginUserOK() {
		// assertEquals("No es el idioma esperado", EIdioma.EUSKERA.getLocale(),
		// loginUser(EIdioma.EUSKERA.getLocale()));
		// assertEquals("No es el idioma esperado", EIdioma.INGLES.getLocale(),
		// loginUser(EIdioma.INGLES.getLocale()));
		assertEquals("No es el idioma esperado", EIdioma.CASTELLANO.getLocale(),
				loginUser(EIdioma.CASTELLANO.getLocale()));
	}

	@Test
	public void loginError() {
		final WebDriver driver = new HtmlUnitDriver();

		driver.get(URL_APP);
		assertEquals("No coincide Title", driver.getTitle(), "Login");
		// Find the text input element by its name
		final WebElement elementName = driver.findElement(By.name("user"));
		elementName.sendKeys("blablabla");
		final WebElement elementPass = driver.findElement(By.name("pass"));
		elementPass.sendKeys("666");
		// Now submit the form. WebDriver will find the form for us from the
		// element
		elementPass.submit();

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

		// buscar Div donde se muestra los mensajes
		final WebElement elementMsgs = driver.findElement(By.className("alert-warning"));
		assertEquals("No va el mensaje de error ", elementMsgs.getText(), "Usuario o contraseña incorrecta");

		driver.quit();
	}

	/**
	 * Hace un login como administrador y entramos al backoffice.
	 *
	 * @param idioma
	 *            value para seleccionar el option del select en el formulario
	 *            de login
	 * @return idioma que esté en el atributo "lang" de la etiqueta "html" del
	 *         backoffice
	 */
	private String loginAdmin(final String idioma) {
		final String res = "";

		final WebDriver driver = new HtmlUnitDriver();
		WebElement element = null;

		driver.get(URL_APP);
		assertEquals("No coincide Title", driver.getTitle(), "Login");

		// Buscar input por su 'name' y cargar value con el método sendKeys()

		element = driver.findElement(By.name("user"));
		element.sendKeys("admin");

		element = driver.findElement(By.name("pass"));
		element.sendKeys("admin");

		final Select dropdown = new Select(driver.findElement(By.name("lang")));
		dropdown.selectByValue(idioma);

		// Now submit the form. WebDriver will find the form for us from the
		// element
		element.submit();

		// Check the title of the page
		assertEquals("No coincide Title", driver.getTitle(), "BackOffice");

		// Check idioma
		// element = driver.findElement(By.tagName("html"));
		// res = element.getAttribute("lang");

		driver.quit();

		return res;
	}

	/**
	 * Hace un login como user y entramos al backoffice.
	 *
	 * @param idioma
	 *            value para seleccionar el option del select en el formulario
	 *            de login
	 * @return idioma que esté en el atributo "lang" de la etiqueta "html" del
	 *         backoffice
	 */
	private String loginUser(final String idioma) {
		String res = "";

		final WebDriver driver = new HtmlUnitDriver();
		WebElement element = null;

		driver.get(URL_APP);
		assertEquals("No coincide Title", driver.getTitle(), "Login");

		// Buscar input por su 'name' y cargar value con el método sendKeys()

		element = driver.findElement(By.name("user"));
		element.sendKeys("user");

		element = driver.findElement(By.name("pass"));
		element.sendKeys("user");

		final Select dropdown = new Select(driver.findElement(By.name("lang")));
		dropdown.selectByValue(idioma);

		// Now submit the form. WebDriver will find the form for us from the
		// element
		element.submit();

		// Check the title of the page
		assertEquals("No coincide Title", driver.getTitle(), "Saludo");

		// Check idioma
		element = driver.findElement(By.tagName("html"));
		res = element.getAttribute("lang");

		driver.quit();

		return res;
	}

}
