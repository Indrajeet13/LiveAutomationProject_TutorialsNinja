package temp;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tutorialsninja.base.Base;
import utils.Utilities;


public class TC_RF_019 extends Base {
	
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
	public void verifyHeadingAndTrailingSpacesWhileRegisteringPage() {
		
		SoftAssert softAssert = new SoftAssert();
		
		String enteredFirstName = "     "+prop.getProperty("firstName")+"      ";
		driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstName);
		
		String enteredLastName = "      "+prop.getProperty("lastName")+"     ";
		driver.findElement(By.id("input-lastname")).sendKeys(enteredLastName);
		
		String enteredEmail = "      "+Utilities.generateBrandNewEmail()+"   ";
		driver.findElement(By.id("input-email")).sendKeys(enteredEmail);
		
		String enteredTelephone = "    "+prop.getProperty("telephoneNum")+"    ";
		driver.findElement(By.id("input-telephone")).sendKeys(enteredTelephone);
		
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		softAssert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.findElement(By.linkText("Edit your account information")).click();

		softAssert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("value"), enteredFirstName.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("value"), enteredLastName.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("value"), enteredEmail.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("value"), enteredTelephone.trim());
		
		
	}
	
	
	
}
