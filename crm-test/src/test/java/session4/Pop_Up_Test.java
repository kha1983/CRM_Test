package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pop_Up_Test {
	
	//1) To click on the 'Cancel' button of the alert.
		//driver.switchTo().alert().dismiss();
	//2) To click on the 'OK' button of the alert.
		//driver.switchTo().alert().accept();
	//3) To capture the alert message.
		//driver.switchTo().alert().getText();
	//4) To send some data to alert box.
		//driver.switchTo().alert().sendKeys("Text");
	
	@Test
	public void handlePopUp() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	//Implicit wait
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	
	
	driver.findElement(By.xpath("//form[@name='loginform']/descendant::input[@type='submit']")).click();
	Thread.sleep(5000);
	
	//How to handle pop_up
	driver.switchTo().alert().accept();
	

	}


}
