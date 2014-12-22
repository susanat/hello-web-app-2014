package com.ipartek.formacion.helloweb;

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

	private static final String URL_APP = "http://localhost:8080/HelloWeb";

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
	public void loginOK() {
		String usuario = null;
		String password = null;

		// Prueba de admin
		usuario = "admin";
		password = "admin";
		assertEquals("Login incorrecto para user: " + usuario, "BackOffice",
				loginUser(usuario, password));

		// Prueba de admin
		usuario = "user";
		password = "user";
		assertEquals("Login incorrecto para user: " + usuario, "Saludo",
				loginUser(usuario, password));

		// Prueba de usuario no válido
		usuario = "X";
		password = "X";
		assertEquals("Login incorrecto para user: " + usuario, "Login",
				loginUser(usuario, password));
	}

	private String loginUser(String usuario, String password) {

		WebDriver driver = new HtmlUnitDriver();

		driver.get(URL_APP);
		assertEquals("No coincide Title", driver.getTitle(), "Login");

		// Find the text input element by its name
		WebElement inputUser = driver.findElement(By.name("user"));
		inputUser.sendKeys(usuario);

		WebElement inputPass = driver.findElement(By.name("pass"));
		inputPass.sendKeys(password);

		// Now submit the form. WebDriver will find the form for us from the
		// element
		inputUser.submit();

		// Check the title of the page
		// System.out.println("Page title is: " + driver.getTitle());
		String title = driver.getTitle();

		driver.quit();

		return title;
	}

	@Test
	public void idiomaBackofficeTest() {

		// Probar los idiomas soportados en la aplicación para la parte de
		// backoffice
		for (int i = 0; i < Idioma.values().length; i++) {
			assertEquals(Idioma.values()[i].getLocale(),
					idioma(Idioma.values()[i].getLocale()));
		}

	}

	private String idioma(String locale) {

		WebDriver driver = new HtmlUnitDriver();

		driver.get(URL_APP);

		// Find the text input element by its name
		WebElement inputUser = driver.findElement(By.name("user"));
		inputUser.sendKeys("admin");

		WebElement inputPass = driver.findElement(By.name("pass"));
		inputPass.sendKeys("admin");

		// Seleccionar el idioma Euskera en el select option
		Select dropdown = new Select(driver.findElement(By.name("idioma")));
		dropdown.selectByValue(locale);

		// Now submit the form. WebDriver will find the form for us from the
		// element
		inputUser.submit();

		// Comprobar que el idioma de la página de backoffice index es el
		// seleccionado en el select option
		WebElement element = driver.findElement(By.tagName("html"));
		String idioma = element.getAttribute("lang");

		driver.quit();

		return idioma;
	}

	@Test
	public void loginError() {
		WebDriver driver = new HtmlUnitDriver();

		driver.get(URL_APP);
		assertEquals("No coincide Title", driver.getTitle(), "Login");

		// Find the text input element by its name
		WebElement inputUser = driver.findElement(By.name("user"));
		inputUser.sendKeys("admin2");

		WebElement inputPass = driver.findElement(By.name("pass"));
		inputPass.sendKeys("admin2");

		// Now submit the form. WebDriver will find the form for us from the
		// element
		inputPass.submit();

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

		// buscar Div donde se muestra los mensajes
		WebElement elementMsgs = driver.findElement(By.id("msg"));

		assertEquals("No el mensaje de error ", elementMsgs.getText(),
				"EN_Usuario o clave incorrecta");

		driver.quit();
	}

}
