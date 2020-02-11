package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VariousElements {
	
	@Test
	public void exploreVariousElements()  throws Exception  {
		
		//Set  the properties for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		
		//create the object for chromedriver and it will open the chrome browser
		WebDriver driver=new ChromeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Delete cookies and history
		driver.manage().deleteAllCookies();
		
		
		//to open the test site
		driver.get("https://objectspy.space");
		
		//Make window maximize
		driver.manage().window().maximize();
		
		//Slow down java 5000 mili second
		Thread.sleep(5000);
		
		//Click on Radio Button Male
		driver.findElement(By.id("sex-0")).click();
		Thread.sleep(5000);
		
		//Type something in fields
		driver.findElement(By.name("firstname")).sendKeys("Khadak");
		Thread.sleep(5000);
		
		//Click on Link Text
		//driver.findElement(By.linkText("Link Test : New Page")).click();
		//Thread.sleep(3000);
		
		//Click on partial Link
		driver.findElement(By.partialLinkText("OS-API Product FrontEnd")).click();
		Thread.sleep(5000);
		
		
		//Will close the browser
		driver.close();
		
		//will quit the browser
		driver.quit();

		
		
	}
	

}
