package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleNewWindowOrTab {
	
	@Test
	public void handleNewWindowOrTab() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.yahoo.com/");
	driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys("Xpath");
	
	
	driver.findElement(By.xpath("//button[@id='header-desktop-search-button']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("XPath Tutorial - w3schools.com")).click();
	
	//This will print all the window handles (which are unique numbers)
	System.out.println(driver.getWindowHandles());
	
	//To loop around and end in the last window
	for (String windowHandle : driver.getWindowHandles()) {
	driver.switchTo().window(windowHandle);
	}
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("SQL")).click();
	
	driver.close();
	driver.quit();
	
	
	}

}
