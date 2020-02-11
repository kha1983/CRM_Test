package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Assignment_1 {
	
	
	//Automate the following test case:
	//Scenario : user will be able to transfer money
	//1.Open browser and go to site http://techfios.com/test/billing/?ng=admin/
	//2.Enter user name:techfiosdemo@gmail.com
	//3.Enter  password:abc123
	//4.Click login button
	//5.Click on transaction in the side navigation
	//6.Click on transfer
	//7.Fill in the New transfer form
	//8.Click submit,
	//9.Validate transfer posted on the table.
	
	//Solution:
	
	@Test
	public void UserWillBeAbleToTransferMoney() throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		
		WebElement TRANSACTION_MENU_ELEMENT=driver.findElement(By.xpath("//span[contains(text(), 'Transactions')]"));
		
		TRANSACTION_MENU_ELEMENT.click();
		
		
		Actions action=new Actions(driver);
		action.moveToElement(TRANSACTION_MENU_ELEMENT).build().perform();
		
		WebElement TRANSFER_ELEMENT=driver.findElement(By.linkText("Transfer"));
		
		Thread.sleep(2000);
		TRANSFER_ELEMENT.click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[contains(text(),'New Transfer')]"));
		
		driver.findElement(By.xpath("//Select[@id='faccount']/option[@value='am testing']")).click();
		
		driver.findElement(By.xpath("//Select[@id='taccount']/option[@value='TechfiosBilling']")).click();
		
		driver.findElement(By.xpath("//*[@name='description']")).sendKeys("My Testing Fee");
		
		driver.findElement(By.xpath("//*[@name='amount']")).sendKeys("15500");
		
		driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Expense");
		
		driver.findElement(By.id("submit")).click();
		
		//String TransferTitleXpath="//*[contains(text(),'My Testing Fee ')]";
		//Thread.sleep(5000);
		
		//String expectedTitle="My Testing Fee";
		
		//String actualTitle=driver.getTitle();
		
		//Assert.assertEquals("Transfer did not display", expectedTitle, actualTitle);
		
		//Only use Explicit Wait
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TransferTitleXpath)));
		
		By RecentTransferLocator = By.linkText("My Testing Fee");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RecentTransferLocator));
		
		boolean status = driver.findElement(RecentTransferLocator).isDisplayed();
		
		if(status==true) {
		System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed!!");
		}
		
		Thread.sleep(5000);

		

		
		
		
		
		

		
		
	

		
		
		
		
		
		
		
		
		
	}
}
