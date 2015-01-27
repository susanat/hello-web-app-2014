package es.srn.pruebas.autologueo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestAutologueo {
	
	private String path = "http://localhost:8080/HelloWeb/login_jstl.jsp";

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
	public void test() {
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get(path);
		
		
		
		System.out.println(driver.getPageSource());
		
	}
	
	

}
