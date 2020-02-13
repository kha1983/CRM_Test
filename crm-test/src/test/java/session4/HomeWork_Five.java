package session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork_Five {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://techfios.com/test/billing/?ng=admin/");
	}

	@Test
	public void userShouldBeAbleToAddDeposite() throws InterruptedException {
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[contains(@placeholder, 'assword') and contains(@class, 'form-')]"))
				.sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(), 'Sign') and @name='login']")).click();
		driver.manage().window().maximize();
		
		String expectedTitle =  "Dashboard- TechFios Test Application - Billing";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Dashboard Page did not display!");
		
		driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();
		
		driver.findElement(By.linkText("Add Deposit")).click();
		
		driver.findElement(By.xpath("//*[@title='Choose an Account']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//option[@value='houseloan']")).click();
		
		driver.findElement(By.id("description")).sendKeys("My Monthly Payment");
		
		driver.findElement(By.xpath("//*[@name='amount']")).sendKeys("1800");
		
		driver.findElement(By.xpath("//*[contains(text(),' Submit')]")).click();
		
		boolean status=driver.findElement(By.linkText("My Monthly Payment")).isDisplayed();
		
		if(status==true)    {
			System.out.println("Deposit sucessful and test is passed");
		}
		else  {
			System.out.println("Deposit unsucessfull and test is failed");
			
			throw new RuntimeException("Test failed");
		}
		
		driver.close();
		driver.quit();
		
		
}

}
