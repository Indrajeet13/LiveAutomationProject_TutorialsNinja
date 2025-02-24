package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;

public class TC_RF_014 extends Base {

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
	public void verifyMandatoryFieldsInRegisterAccountPage() {

		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		String fnContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",firstNameLabel);
		String fnColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);

		WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		String lnContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastNameLabel);
		String lnColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastNameLabel);
		Assert.assertEquals(lnContent, expectedContent);
		Assert.assertEquals(lnColor, expectedColor);

		WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
		String emailContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emailLabel);
		String emailColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emailLabel);
		Assert.assertEquals(emailContent, expectedContent);
		Assert.assertEquals(emailColor, expectedColor);

		WebElement teleLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		String teleContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", teleLabel);
		String teleColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", teleLabel);
		Assert.assertEquals(teleContent, expectedContent);
		Assert.assertEquals(teleColor, expectedColor);

		WebElement passLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
		String passContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passLabel);
		String passColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passLabel);
		Assert.assertEquals(passContent, expectedContent);
		Assert.assertEquals(passColor, expectedColor);

		WebElement passConfirmLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
		String passConfirmContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",passConfirmLabel);
		String passConfirmColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",passConfirmLabel);
		Assert.assertEquals(passConfirmContent, expectedContent);
		Assert.assertEquals(passConfirmColor, expectedColor);

	}

}
