package temp;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;
import utils.Utilities;

public class TC_RF_012 extends Base {
	
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
	public void verifyRegisteringAccountByProvidingEntriesUsingKeyboardActions() throws InterruptedException, IOException {
	
		Actions actions = new Actions(driver);
		
		for(int i=1;i<=23;i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
	
		 actions.sendKeys(prop.getProperty("firstName"))
		 .sendKeys(Keys.TAB) 	// Last Name field
         .pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("lastName"))
         .sendKeys(Keys.TAB) 	// Email field
         .pause(Duration.ofSeconds(1)).sendKeys(Utilities.generateBrandNewEmail())
         .sendKeys(Keys.TAB) 	// Telephone field
         .pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("telephoneNum"))
         .sendKeys(Keys.TAB) 	// Password field
         .pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("validPassword"))
         .sendKeys(Keys.TAB) 	// Confirm Password field
         .pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("validPassword"))
         .sendKeys(Keys.TAB) 	// Newsletter selection (Yes/No)
         .pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_LEFT) // Select "No"
         .sendKeys(Keys.TAB) 	// Privacy Policy checkbox
         .pause(Duration.ofSeconds(1)) 
         .sendKeys(Keys.TAB)	
         .pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE)// Check the box
         .sendKeys(Keys.TAB)
         .pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER) // Click Continue
         .perform();
		
		 Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		 String expectedHeading = "Your Account Has Been Created!";
		 Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(), expectedHeading);
		
	}
		
	
}
