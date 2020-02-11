package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_iFrame {
	
	
	@Test
	public void HandleIFrame ()  throws Exception    {
		
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		Thread.sleep(5000);
		
		//we can switch over the elements in frames using 3 ways.
		//By Index - driver.switchTo().frame(0);
		//By Name or Id - driver.switchTo().frame("iframe1"); or driver.switchTo().frame("id of the element");
		//By Web Element - driver.switchTo().frame(WebElement);
		driver.switchTo().frame(2);
		
		//System.out.println(driver.findElement(By.tagName("frame")).getSize());
		driver.findElement(By.linkText("java.sql")).click();
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(1);
		
		//Or
		driver.switchTo().frame("packageFrame");
		Thread.sleep(3000);
		
		
		
		driver.findElement(By.linkText("Blob")).click();
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
		
		
	}

}
