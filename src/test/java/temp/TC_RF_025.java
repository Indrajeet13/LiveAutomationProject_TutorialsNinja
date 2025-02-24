package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;



public class TC_RF_025 extends Base {
	
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
	
	@Test()
	public void verifyBreadcrmTitleHeadingRegisterAccount() {

		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Register']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Account']")).isDisplayed());
		
		String expectedHeading = "Register Account";
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText(), expectedHeading);
		
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
		
		String expectedTitle = "Register Account";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
}
