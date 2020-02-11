package test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Validation_UsingAssert {
	
	@Test
	public void validUserShouldAbletoLogin() throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=login/");
		
		driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//*[@name='login']")).click();
		
		String dashboardTitleXpath="//*[contains(text(),'Dashboard ')]";
		
		//Thread Sleep
		Thread.sleep(5000);
		
		String expectedTitle="Dashboard- TechFios Test Application - Billing";
		
		String actualTitle=driver.getTitle();
		
		Assert.assertEquals("Dashboard did not display", expectedTitle, actualTitle);
		
		//Explicit wait
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardTitleXpath)));
		
		driver.close();
		driver.quit();
		
	}

}
