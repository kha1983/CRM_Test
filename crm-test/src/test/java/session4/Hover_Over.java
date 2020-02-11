package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Hover_Over {
	WebDriver driver;
	
	@Test
	public void hoverOverTest()  throws Exception   {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		
		// Action class is needed when executing mouse over.  Example,  https://www.dell.com/en-us
		// Actions action= new Actions(driver);
		// action.moveToElement(driver.findElement(By.linkText("Financing"))).build().perform();
		
		//Element library
		WebElement DEALS_MENU_ELEMENT=driver.findElement(By.xpath("//button[@id='l1_4']"));
		
		
		Actions action=new Actions(driver);
		action.moveToElement(DEALS_MENU_ELEMENT).build().perform();
		
		WebElement WORKSTATION_DEALS_ELEMENT=driver.findElement(By.linkText("Workstation Deals"));
		
		Thread.sleep(2000);
		WORKSTATION_DEALS_ELEMENT.click();
		
		
		//Only close/quit window if testing pass
		//driver.close();
		//driver.quit();
		
		//if testing fail still want o close window
		//@After
		//public void closeEverything()    {
			//driver.close();
			//driver.quit();
		
		
	}

}
