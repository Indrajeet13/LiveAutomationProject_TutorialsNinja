package temp;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;
import utils.Utilities;

public class TC_RF_007 extends Base {
	
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplication();
		prop = Utilities.loadProperties();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}

	@AfterMethod
	public void teardown()
	{
		if(driver !=null) {
			driver.quit();
		}
	}
	
	@Test
	public void verifyNavigatingToRegisterAccountPageWithMultipleWays() {
	
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).isDisplayed());
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).isDisplayed());
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).isDisplayed());

	}
	
}
