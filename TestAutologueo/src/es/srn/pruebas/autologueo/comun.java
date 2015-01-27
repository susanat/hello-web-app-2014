package es.srn.pruebas.autologueo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class comun {

	private String path = "http://localhost:8080/HelloWeb/login_jstl.jsp";
	
	public comun() {
		WebDriver driver = new HtmlUnitDriver();
		

		driver.get(path);
		
		System.out.println(driver.getPageSource());
		
		WebElement inputUser = driver.findElement(By.name("cont1"));
		WebElement inputPassword = driver.findElement(By.name("cont2"));
		
		inputUser.sendKeys("sergio");
		inputPassword.sendKeys("sergio");
		
		inputPassword.submit();
		
		System.out.println(driver.getPageSource());
		
		//<ul class="nav navbar-nav navbar-right">
		List<WebElement> navRight = driver.findElements(By.cssSelector("[class='nav navbar-nav navbar-right']"));
		if(navRight != null && navRight.size() > 0) {
			WebElement nav = navRight.get(0);
			
			System.out.println(nav.toString());
			
			
			
			
		}
		
		
		
	}
	
	
	public static void main(String [ ] args)
	{
	      comun obj = new comun();
	      
	}
	
	
	
	
}
