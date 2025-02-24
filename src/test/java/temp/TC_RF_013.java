package temp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;

public class TC_RF_013 extends Base {
	
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
	public void verifyPlaceholdersOfTextFieldsInRegisterAccountPage() {
			
		String expectedFirstNamePlaceHolderText = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("placeholder"), expectedFirstNamePlaceHolderText);
		
		String expectedLastNamePlaceHolderText = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("placeholder"), expectedLastNamePlaceHolderText);
		
		String expectedEmailPlaceHolderText = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("placeholder"), expectedEmailPlaceHolderText);
		
		String expectedTelephonePlaceHolderText = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("placeholder"), expectedTelephonePlaceHolderText);
		
		String expectedPasswordPlaceHolderText = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("placeholder"), expectedPasswordPlaceHolderText);
		
		String expectedConfirmPasswordPlaceHolderText = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("placeholder"), expectedConfirmPasswordPlaceHolderText);

	}
	
}
