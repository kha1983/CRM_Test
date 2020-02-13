package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment_Four {
	//Homework:
	//Scenario: Add new account on Techfios Site 
	//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	//2. Enter username: techfiosdemo@gmail.com
	//3. Enter password: abc123
	//4. Click login button
	//5. Click on Bank & Cash
	//6. Click on New Account
	//7. Fill in the Add New Account Form (Randomize Account Title and Balance)
	//8. Click submit,

	//​Intermediate:
	//9. Validate the presence of "Account Created Successfully" message

	//Advance: 
	//10. Scroll Down,
	//11. Validate new account showed up in the bottom of the table
	//12. ​Delete that account
	//13. Validate account deleted from the bottom of the table
	
	//Solution:
	
	@Test
	public void AddNewAccountOnTechfiosSite()  throws Exception    {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//*[@name='login']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Bank & Cash')]")).click();
		
		driver.findElement(By.linkText("New Account")).click();
		
		driver.findElement(By.id("account")).sendKeys("Initial Balance");
		
		
		driver.findElement(By.xpath("//*[@name='description']")).sendKeys("My account details");
		
		driver.findElement(By.id("balance")).sendKeys("9000");
		
		driver.findElement(By.xpath("//*[contains(text(),' Submit')]")).click();
		Thread.sleep(5000);
		
		
		//Validation by using If and else

		String expectedTitle="Account Created Successfully- TechFios Test Application - Deposit";
		
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equalsIgnoreCase(actualTitle))    {
		System.out.println("Test passed");
		}
		else   {
		System.out.println(" Account Created Successfully page did not display");
		
		//throw new RuntimeException("Test Failed");//only when you put wrong info
	}
		
		//driver.close();
		//driver.quit();
		

		
	}
	
	

}
