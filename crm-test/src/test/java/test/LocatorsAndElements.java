package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsAndElements {
	
	
	@Test
	public void Practice_Class ()  throws Exception  {
		
				
				//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				//WebDriver driver=new ChromeDriver();
				//driver.manage().window().maximize();
				//driver.get("http://objectspy.space");
				
				//Clear the search table
				//driver.findElement(By.className("search")).clear();
				//Thread.sleep(5000);
				
				//Type techfios into search field
				//driver.findElement(By.className("search")).sendKeys("Techfios");
				//Thread.sleep(5000);
				
				//Example of CSS locator
				//driver.findElement(By.cssSelector("input[title='Search']")).click();
				//driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Khadak");
				//driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Kathayat");
				//driver.close();
				//driver.quit();
				
				
				//Click on a linked text (Display in different different colour)
				//Will always have a tagname "a" and url
				//Thread.sleep(5000);
				//driver.findElement(By.linkText("Link Test : New Page")).click();
				
				
				//Partial link text
				//driver.findElement(By.partialLinkText("OS-API Product FrontEnd")).click();
				
				//Close the browser
				//driver.close();
				
				//Quit the driver
				//driver.quit();
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://objectspy.space");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.className("search")).clear();
		
		driver.findElement(By.className("search")).sendKeys("Techfios");
		
		//driver.findElement(By.cssSelector("input[name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.linkText("Link Test : New Page")).click();
		
		driver.findElement(By.partialLinkText("OS-API Product FrontEnd")).click();
		
		driver.close();
		
		driver.quit();
				
	}
}
