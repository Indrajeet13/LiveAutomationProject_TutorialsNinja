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


public class TC_RF_009 extends Base {
	
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
	public void verifyRegisteringAccountByProvidingExistingEmail() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("existingEmail"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("telephoneNum"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),expectedWarningMessage);

	}
	
}
