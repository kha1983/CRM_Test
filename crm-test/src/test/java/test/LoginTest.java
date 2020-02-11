package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginTest {
	
	@Test
	public void validUserShouldAbletoLogin()  throws Exception  {
		
				//Set Chrome as default browser
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://techfios.com/test/billing/?ng=login/");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");
				
				driver.findElement(By.xpath("//input[contains(@placeholder,'Password') and contains(@class,'form-control')]")).sendKeys("abc123");
				
				driver.findElement(By.xpath("//*[contains(text(),'Sign in') and @name='login']")).click();
				Thread.sleep(5000);
				
				//driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")).click();
				
				//or
				
				//Xpath Axis
				//String dashboardTitleXpath="//div[@id='page-wrapper']//descendant::h2[contains(text(),'Dashboard ')]";
				String dashboardTitleXpath="//*[contains(text(),'Dashboard ')]";
				Thread.sleep(5000);
				
				String expectedTitle="Dashboard- TechFios Test Application - Billing";
				
				String actualTitle=driver.getTitle();
				
				//Testing by If and else
				//if(expectedTitle.equalsIgnoreCase(actualTitle))    {
					//System.out.println("Test passed");
				//}
				//else   {
					//System.out.println("Dashboard page did not display");
					
					//throw new RuntimeException("Test Failed");//only when you put wrong info
				//}
				
				
				//Or
				Assert.assertEquals("Dashboard did not display", expectedTitle, actualTitle);
				
				//Only use Explicit Wait
				WebDriverWait wait=new WebDriverWait(driver, 10);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardTitleXpath)));
				
				//wait.until(isTrue)
				
				
				Thread.sleep(5000);
				driver.close();
				driver.quit();
	}

}
