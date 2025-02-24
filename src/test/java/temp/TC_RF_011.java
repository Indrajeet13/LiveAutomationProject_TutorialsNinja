package temp;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;
import utils.Utilities;

public class TC_RF_011 extends Base {
	
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
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void verifyRegisteringAccountByProvidingInvalidTelephone() {
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateBrandNewEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("invalidTelephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
//		String expectedWarningMessage = "Telephone number does not appear to be valid!";
//		boolean state = false;
//		try {
//			
//			String actualWarningMessage = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
//			if(actualWarningMessage.equals(expectedWarningMessage)) {
//				state = true;
//			}
//		} catch(NoSuchElementException e) {
//			state = false;
//		}
//		Assert.assertTrue(state);
		
		
		List<WebElement> warningElements = driver.findElements(By.xpath("//input[@id='input-telephone']/following-sibling::div"));

		if (warningElements.isEmpty()) {
			Assert.fail("Telephone number does not appear to be valid message is missing: This is a bug.");
		} else {
			String warningMessage = warningElements.get(0).getText();
			Assert.assertTrue(warningMessage.contains("Telephone number does not appear to be valid!"),
					"The expected warning message is not displayed.");
		}
	}
	
}
