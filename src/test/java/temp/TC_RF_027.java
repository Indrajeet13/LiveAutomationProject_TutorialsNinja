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

public class TC_RF_027 extends Base {
	
	WebDriver driver;
	Properties prop;

	@BeforeMethod()
	public void setup() {

		driver = openBrowserAndApplication();
		prop = Utilities.loadProperties();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}
	
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void verifyRegisteringAccountInDifferentEnvironments()  {

		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNum"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed());
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed());
		Assert.assertEquals(driver.getTitle(), "My Account");

	}
	
}
