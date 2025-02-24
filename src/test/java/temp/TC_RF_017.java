package temp;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;
import utils.Utilities;

public class TC_RF_017 extends Base {

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

	@Test(dataProvider = "PasswordSupplier")
	public void verifyRegisteringAccountByCheckingThePasswordStandards(String passwordText) {

		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNum"));
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		List<WebElement> warningElements = driver.findElements(By.xpath("//div[@class='text-danger']"));

		if (warningElements.isEmpty()) {
			Assert.fail("Password complexity error message is missing: This is a bug.");
		} else {
			String warningMessage = warningElements.get(0).getText();
			Assert.assertTrue(warningMessage.contains("Password entered is not matching the Complexity standards"),
					"The expected warning message is not displayed.");
		}

	}

	@DataProvider(name = "PasswordSupplier")
	public Object[][] supplyPasswordsDataCombinations() {

		Object[][] data = { { "12345" }, { "abcdefg" }, { "1245asas" }, { "abs1212$" }, { "ABCD123#" } };
		return data;

	}

}
