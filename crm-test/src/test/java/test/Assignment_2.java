package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_2 {
	
	//Automate the following test case:
	//Scenario: Users will be able to add deposit
	//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	//2. Enter username: techfiosdemo@gmail.com
	//3. Enter password: abc123
	//4. Click login button
	//5. Click on Add Deposit button on Dashboard Page
	//6. Click on Open An Account drop down to expand it,
	//7. Click on any account name,
	//8. Type any description,
	//9. Type any amount,
	//10. Click on submit button,
	//Visually check to make sure the deposit posted

   //Solution:
	
	@Test
	public void Userswillbeabletoadddeposit() throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		driver.findElement(By.linkText("Add Deposit")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//select[@id='account']/option[@value='am testing']")).click();
		
		driver.findElement(By.name("description")).sendKeys("First Deposit");
		
		driver.findElement(By.name("amount")).sendKeys("7000");
		
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(5000);


		By recentDepositLocator = By.linkText("First Deposit");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(recentDepositLocator));
		
		boolean status = driver.findElement(recentDepositLocator).isDisplayed();
		
		if(status==true) {
		System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed!!");
		}
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
		
		

		
		}
		
	
	}


