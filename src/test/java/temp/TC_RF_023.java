package temp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;


public class TC_RF_023 extends Base {
	
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
	public void verifyWorkingOfEveryLinkOnRegisterAccount() throws InterruptedException {
		
		driver.findElement(By.xpath("//i[@class='fa fa-phone']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//i[@class='fa fa-heart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Login']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//i[@class='fa fa-share']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Qafox.com")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Featured']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Search']")).isDisplayed());

		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='Account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());

		driver.navigate().back();
		driver.findElement(By.xpath("//ul[@class='breadcrumb']//i[@class='fa fa-home']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Featured']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='login page']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
	
		driver.navigate().back();
		driver.findElement(By.xpath("//b[normalize-space()='Privacy Policy']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement xOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='×']")));
		driver.findElement(By.xpath("//button[normalize-space()='×']"));
		Assert.assertTrue(xOption.isDisplayed());
		xOption.click();
		
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).isDisplayed());

		driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Forgotten Password")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Forgotten Password']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='Address Book']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Wish List']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='Downloads']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='Recurring payments']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='Reward Points']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Returns']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[normalize-space()='Transactions']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Newsletter']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("About Us")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'About Us')]")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Contact Us")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Contact Us']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Brands")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Brand']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[normalize-space()='My Account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Delivery Information")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Delivery Information')]")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Privacy Policy')]")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Terms & Conditions")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Terms & Conditions')]")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/return/add']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Product Returns']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Site Map")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Site Map']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Gift Certificates")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Gift Certificate']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Affiliate")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Affiliate Program']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Specials")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Special Offers']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[normalize-space()='Order History']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[normalize-space()='Newsletter']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).isDisplayed());

		
	}

}
