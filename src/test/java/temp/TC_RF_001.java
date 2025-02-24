package temp;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AccountPage;
import Pages.AccountSuccessPage;
import Pages.LandingPage;
import Pages.RegisterPage;
import tutorialsninja.base.Base;
import utils.Utilities;

public class TC_RF_001 extends Base {
	
	WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;

	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplication();
		prop = Utilities.loadProperties();
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		registerPage = landingPage.selectRegisterOption();

	}

	@AfterMethod
	public void teardown()
	{
		if(driver !=null) {
			//driver.quit();
		}
	}
	
	@Test
	public void RegisterWithMandatoryFeilds() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.checkPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
	
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);
		accountPage = accountSuccessPage.clickOnContinueButton();
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());
	
	}
	

}
