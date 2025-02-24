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

public class TC_RF_006 extends Base {

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
	public void verifyRegisteringAccountSayingNoToNewsLetter() {

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateBrandNewEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("telephoneNum"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),expectedHeading);

		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		driver.findElement(By.xpath("//input[@value='0']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("div[id='content'] h1")).isDisplayed());

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed());

	}

}
