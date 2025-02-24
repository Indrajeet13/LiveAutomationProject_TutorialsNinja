package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;


public class TC_RF_016 extends Base {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = openBrowserAndApplication();

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
	public void verifyRegisteringAccountByProvidingOnlySpace() {

		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), expectedFirstNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), expectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(), expectedEmailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(), expectedPasswordWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), expectedTelephoneWarning);
		
	}
	
}
