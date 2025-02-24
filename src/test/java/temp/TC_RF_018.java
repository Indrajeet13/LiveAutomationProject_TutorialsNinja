package temp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;
import utils.Utilities;


public class TC_RF_018 extends Base {
	
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
	public void verifyRegisteringAccountFielsHeightWidthAlignment() throws InterruptedException , IOException, TimeoutException {

		String expectedHeight = "34px";
		String expectedWidth = "701.25px";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
       // WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
        
        String actualFirstNameHeight = firstNameField.getCssValue("height");
        String actualFirstNameWidth = firstNameField.getCssValue("width");

        Assert.assertEquals(actualFirstNameHeight, expectedHeight);
        Assert.assertEquals(actualFirstNameWidth, expectedWidth);

        // Test for 1 character input (invalid)
        firstNameField.clear();
        firstNameField.sendKeys("");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), "First Name must be between 1 and 32 characters!");

        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("a");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        	
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("ab");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("asdfghjklqwertyu");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
       
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("asdfghjklqwertyusdsdsdasadsaasdasdf");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), "First Name must be between 1 and 32 characters!");

		
		String actualLastNameHeight = driver.findElement(By.id("input-lastname")).getCssValue("height");
		String actualLastNameWidth = driver.findElement(By.id("input-lastname")).getCssValue("width");
		
		// Test for 1 character input (invalid)
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), "Last Name must be between 1 and 32 characters!");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("a");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("ab");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("asdfghjklqwertyu");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
       
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("asdfghjklqwertyusdsdsdasadsaasdasdf");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), "Last Name must be between 1 and 32 characters!");
	
		Assert.assertEquals(actualLastNameHeight, expectedHeight);
		Assert.assertEquals(actualLastNameWidth, expectedWidth);
		
		
		String actualEmailHeight = driver.findElement(By.id("input-email")).getCssValue("height");
		String actualEmailWidth = driver.findElement(By.id("input-email")).getCssValue("width");
		
		Assert.assertEquals(actualEmailHeight, expectedHeight);
		Assert.assertEquals(actualEmailWidth, expectedWidth);
		
		String actualTelephoneHeight = driver.findElement(By.id("input-telephone")).getCssValue("height");
		String actualTelephoneWidth = driver.findElement(By.id("input-telephone")).getCssValue("width");
		
		// Test for 1 character input (invalid)
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), "Telephone must be between 3 and 32 characters!");

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("132");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        
        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123456789852369741");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
       
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("1234567898523697411234567898523697411254");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), "Telephone must be between 3 and 32 characters!");

		Assert.assertEquals(actualTelephoneHeight, expectedHeight);
		Assert.assertEquals(actualTelephoneWidth, actualFirstNameWidth);
		
		String actualPasswordHeight = driver.findElement(By.id("input-password")).getCssValue("height");
		String actualPasswordWidth = driver.findElement(By.id("input-password")).getCssValue("width");
		
		
		// Test for 1 character input (invalid)
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(), "Password must be between 4 and 20 characters!");

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
        
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("123456789852369741");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button
       
        // Re-find the element after clicking the button
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("1234567890123456789012345");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();  // Re-find the continue button

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String passwordFieldValue = (String) js.executeScript("return document.getElementById('input-password').value;");
        Assert.assertTrue(passwordFieldValue.length() <= 20, "Password field accepts more than 20 characters!");
       
        try {
            WebElement warningMessage = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"));
            Assert.assertTrue(warningMessage.isDisplayed(), "Expected validation message for password length is missing.");
        } 
        catch (NoSuchElementException e) {
            Assert.fail("Validation message not found! Password field is accepting more than 20 characters.");
        }
        
		Assert.assertEquals(actualPasswordHeight, expectedHeight);
		Assert.assertEquals(actualPasswordWidth, actualFirstNameWidth);
		
		String actualPasswordConfirmHeight = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String actualPasswordConfirmWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		
		Assert.assertEquals(actualPasswordConfirmHeight, expectedHeight);
		Assert.assertEquals(actualPasswordConfirmWidth, expectedWidth);
		
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAligment.png"));
		
		Assert.assertTrue(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\registerPageExpectedAligment.png", System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAligment.png"));
		
	}

}
