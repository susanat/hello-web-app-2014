package test;

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
import com.ipartek.formacion.helloweb.util.Constante;

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

	WebDriver driver = new HtmlUnitDriver();

	driver.get(URL_APP);

	assertEquals("No coincide Title", driver.getTitle(), "Login");

	// Find the text input element by its name
	WebElement elementName = driver.findElement(By
		.name(Constante.PARAMETRO_USER));
	elementName.sendKeys(Constante.USER_ADMIN_NAME);

	WebElement elementPass = driver.findElement(By
		.name(Constante.PARAMETRO_PASS));
	elementPass.sendKeys(Constante.USER_ADMIN_PASS);

	Select dropdown = new Select(driver.findElement(By
		.name(Constante.PARAMETRO_IDIOMA)));
	dropdown.selectByValue(Idioma.CASTELLANO.getLocale());
	// Now submit the form. WebDriver will find the form for us from the
	// element
	elementPass.submit();

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());
	WebElement elementHTML = driver.findElement(By.tagName("html"));
	String idioma = elementHTML.getAttribute("lang");
	assertEquals("No es el idioma esperado", Idioma.CASTELLANO.getLocale(),
		idioma);
	// buscar Div donde
	// buscar Div donde se muestra los datos del usuario Loegado
	// driver.findElement(By.id("user_login"));

	driver.quit();
    }

    @Test
    public void loginUserOK() {

	WebDriver driver = new HtmlUnitDriver();

	driver.get(URL_APP);

	assertEquals("No coincide Title", driver.getTitle(), "Login");

	// Find the text input element by its name
	WebElement elementName = driver.findElement(By
		.name(Constante.PARAMETRO_USER));
	elementName.sendKeys(Constante.USER_USER_NAME);

	WebElement elementPass = driver.findElement(By
		.name(Constante.PARAMETRO_PASS));
	elementPass.sendKeys(Constante.USER_USER_PASS);

	Select dropdown = new Select(driver.findElement(By
		.name(Constante.PARAMETRO_IDIOMA)));
	dropdown.selectByValue(Idioma.CASTELLANO.getLocale());
	// Now submit the form. WebDriver will find the form for us from the
	// element
	elementPass.submit();

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());
	WebElement elementHTML = driver.findElement(By.tagName("html"));
	String idioma = elementHTML.getAttribute("lang");
	assertEquals("No es el idioma esperado", Idioma.CASTELLANO.getLocale(),
		idioma);
	// buscar Div donde se muestra los datos del usuario Loegado
	// driver.findElement(By.id("user_login"));

	driver.quit();
    }
}
