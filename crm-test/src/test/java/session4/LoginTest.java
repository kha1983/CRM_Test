package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	@Test
	public void openBrowser()     {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		
		driver.get("https://www.yahoo.com");
	
	
		driver.close();
		driver.quit();
		
		
		
	}
	
	

}
