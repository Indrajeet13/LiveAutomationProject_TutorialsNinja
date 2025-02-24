package temp;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsninja.base.Base;
import utils.Utilities;

public class TC_RF_026 extends Base {
	
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
	public void verifyUIOfRegisterAccountPage() throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenShot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcScreenShot, new File(System.getProperty("user.dir")+"//ScreenShots//actualRegisterPageUI.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"//ScreenShots//actualRegisterPageUI.png", System.getProperty("user.dir")+"//ScreenShots//expectedRegisterPageUI.png"));

	}
	
}
