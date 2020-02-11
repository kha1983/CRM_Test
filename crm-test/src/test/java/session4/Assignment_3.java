package session4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_3 {
	
	//Automate the following test case:
		//Scenario: CRM -> Add Contact - Add contact and validate contact added in List Contacts
		//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
		//2. Enter username: techfiosdemo@gmail.com
		//3. Enter password: abc123
		//4. Click login button
		//5. Click on CRM in the Side Navigation
		//6. Click on Add Contact
		//7. Fill in the Add Contact Form,
		//8. Click submit,
		//9. Go to CRM -> List Contact Page
		//10. Search for the new contact in the search field,
		//12. Validate contact created.
	
	//Solution:
	@Test
	public void AddContactAndValidateContact()  throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'CRM')]")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'Add Contact')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Full Name')]")).click();
		
		driver.findElement(By.xpath("//*[@name='account']")).sendKeys("Khadak Bahadur Kathayat");
		
		driver.findElement(By.xpath("//*[@name='company']")).sendKeys("Citi Bank");
		
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("khadak.kathayat100@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("9722158094");
		
		driver.findElement(By.xpath("//*[@name='address']")).sendKeys("Irving Texas");
		
		driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Irving");
		
		driver.findElement(By.xpath("//*[@name='state']")).sendKeys("Texas");
		
		driver.findElement(By.xpath("//*[@id='zip']")).sendKeys("75038");
		
		driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Techfios");
		
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(5000);
		
		WebElement CRM_MENU_ELEMENT=driver.findElement(By.xpath("//span[contains(text(),'CRM')]"));
		
		
		Actions action=new Actions(driver);
		action.moveToElement(CRM_MENU_ELEMENT).build().perform();
		
		WebElement List_Contacts_ELEMENT=driver.findElement(By.linkText("List Contacts"));
		
		Thread.sleep(2000);
		List_Contacts_ELEMENT.click();
		
		driver.findElement(By.xpath("//*[@placeholder='Search by Name...']")).sendKeys("Khadak Bahadur Kathayat");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Search')]")).click();
		Thread.sleep(6000);
		

		By recentaddLocator = By.linkText("Khadak Bahadur Kathayat");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(recentaddLocator));
		
		boolean status = driver.findElement(recentaddLocator).isDisplayed();
		
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
