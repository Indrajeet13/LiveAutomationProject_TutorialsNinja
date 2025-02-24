package temp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Utilities;

public class TC_RF_010 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		String browserName = "chrome";

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

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
	public void verifyRegisteringAccountUsingInvalidEmails() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Indrajeet");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Yadav");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("eric");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(3000);
		File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png"));

		Assert.assertFalse(
				Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png",
						System.getProperty("user.dir") + "\\Screenshots\\sc1Expected.png"));

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("eric@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(3000);

		File srcScreenshot2 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot2, new File(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png"));

		Assert.assertFalse(
				Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png",
						System.getProperty("user.dir") + "\\Screenshots\\sc2Expected.png"));

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("eric@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(3000);

		String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),
				expectedWarningMessage);

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("eric@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(3000);

		File srcScreenshot3 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot3, new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png"));

		Assert.assertFalse(
				Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png",
						System.getProperty("user.dir") + "\\Screenshots\\sc3Expected.png"));

	}

}
