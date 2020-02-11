package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validation_UsingIfAndElse {
	
	
	@Test
	public void validUserShouldAbletoLogin() throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=login/");
		
		driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//*[@name='login']")).click();
		
		String dashboardTitleXpath="//*[contains(text(),'Dashboard ')]";
		
		Thread.sleep(5000);
		
		//Validation by using If and else
		
		String expectedTitle="Dashboard- TechFios Test Application - Billing";
		
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equalsIgnoreCase(actualTitle))    {
		System.out.println("Test passed");
		}
		else   {
		System.out.println("Dashboard page did not display");
		
		//throw new RuntimeException("Test Failed");//only when you put wrong info
	}
		
		driver.close();
		driver.quit();
		
		
	}

}
