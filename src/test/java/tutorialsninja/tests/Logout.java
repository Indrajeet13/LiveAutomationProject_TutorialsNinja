package tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import Pages.*;
import tutorialsninja.base.Base;
import utils.Utilities;

public class Logout extends Base {

	@BeforeMethod
	public void setup() {

		driver = openBrowserAndApplication();
		prop = Utilities.loadProperties();
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		loginPage = landingPage.selectLoginOption();
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser(driver);
	}

	@Test(priority=1)
	public void verifyLoggingOutUsingMyAccountDropMenu() {

		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		headerOptions = new HeaderOptions(accountPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		logoutAccountPage = headerOptions.clickLogoutOption();
		Assert.assertTrue(logoutAccountPage.didWeNavigateToAccountLogoutPage());
		driver = logoutAccountPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		headerOptions.clickOnMyAccountDropMenu();
		Assert.assertTrue(headerOptions.isLoginOptionAvailable());
		logoutAccountPage = new AccountLogoutPage(headerOptions.getDriver());
		landingPage = logoutAccountPage.clickOnContinue();
		Assert.assertEquals(getPageURL(landingPage.getDriver()), prop.getProperty("landingPageURL"));
		
	}
	
	@Test(priority=2)
	public void verifyLoggingOutUsingLogoutRightCoulmnOption() {
		
		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		rightColumnOptions = new RightColumnOptions(accountPage.getDriver());
		logoutAccountPage = rightColumnOptions.clickLogoutOptionOnRightPanel();
		Assert.assertTrue(logoutAccountPage.didWeNavigateToAccountLogoutPage());
		driver = logoutAccountPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		headerOptions.clickOnMyAccountDropMenu();
		Assert.assertTrue(headerOptions.isLoginOptionAvailable());
		logoutAccountPage = new AccountLogoutPage(headerOptions.getDriver());
		landingPage = logoutAccountPage.clickOnContinue();
		Assert.assertEquals(getPageURL(landingPage.getDriver()), prop.getProperty("landingPageURL"));
		
	}
	
	@Test(priority=3)
	public void verifyLoggingOutAndBorrowingBack() {
		
		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		headerOptions = new HeaderOptions(accountPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		logoutAccountPage = headerOptions.clickLogoutOption();
		navigateBack(logoutAccountPage.getDriver());
		driver = refreshPage(driver);
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
	}
	
	@Test(priority=4)
	public void verifyThereIsNoLogoutOptionBeforeLogin() {

		headerOptions = new HeaderOptions(landingPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		Assert.assertFalse(headerOptions.isLogoutOptionAvailable());	
	}
	
	@Test(priority=5)
	public void verifyThereIsNoRightColumnLogoutOptionBeforeLogin() {
		
		registerPage = landingPage.navigateToRegisterPage();
		rightColumnOptions = new RightColumnOptions(registerPage.getDriver());
		Assert.assertFalse(rightColumnOptions.isLogoutRightColumnOptionAvailable());
	}
	
	@Test(priority=6)
	public void verifyLoginAfterLogout() {
		
		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		headerOptions = new HeaderOptions(accountPage.getDriver());
		logoutAccountPage = headerOptions.clickLogoutOption();
		headerOptions = new HeaderOptions(logoutAccountPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		loginPage = headerOptions.clickLoginMenu();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountPage.isUserLoggedIn());
		
	}
	
	@Test(priority=7)
	public void verifyBreadCrumbTitleHeadingAndURLOfAccountLogoutPage() {
		
		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		headerOptions = new HeaderOptions(accountPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		headerOptions.clickLogoutOption();
		Assert.assertEquals(getPageTitle(headerOptions.getDriver()), prop.getProperty("accountLogoutPageTitle"));
		Assert.assertEquals(getPageURL(headerOptions.getDriver()), prop.getProperty("accountLogoutPageURL"));
		logoutAccountPage = new AccountLogoutPage(driver);
		Assert.assertEquals(logoutAccountPage.getPageHeading(), prop.getProperty("accountLogoutPageHeading"));
		Assert.assertTrue(logoutAccountPage.didWeNavigateToAccountLogoutPage());
	}

	@Test(priority=8)
	public void verifyUIOfLogoutOptionAndAccountLogoutOption() {
		
		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		headerOptions = new HeaderOptions(accountPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		
		if(prop.getProperty("browserName").equals("chrome")) {
			Utilities.takeScreenshot(headerOptions.getDriver(), "\\Screenshots\\actualLogoutChromeOption.png");
			Assert.assertFalse(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\actualLogoutChromeOption.png", System.getProperty("user.dir")+"\\Screenshots\\expectedLogoutChromeOption.png"));
		}
		else if(prop.getProperty("browserName").equals("firefox")) {
			Utilities.takeScreenshot(headerOptions.getDriver(), "\\Screenshots\\actualLogoutFirefoxOption.png");
			Assert.assertFalse(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\actualLogoutFirefoxOption.png", System.getProperty("user.dir")+"\\Screenshots\\expectedLogoutFirefoxOption.png"));
		}
		else if(prop.getProperty("browserName").equals("edge")) {
			Utilities.takeScreenshot(headerOptions.getDriver(), "\\Screenshots\\actualEdgeFirefoxOption.png");
			Assert.assertFalse(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\actualEdgeFirefoxOption.png", System.getProperty("user.dir")+"\\Screenshots\\expectedLogoutEdgeOption.png"));
		}
		
		logoutAccountPage = headerOptions.clickLogoutOption();
		if(prop.getProperty("browserName").equals("chrome")) {
			Utilities.takeScreenshot(headerOptions.getDriver(), "\\Screenshots\\actualChromeAccountLogoutPage.png");
			Assert.assertFalse(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\actualChromeAccountLogoutPage.png", System.getProperty("user.dir")+"\\Screenshots\\expectedChromeAccountLogoutPage.png"));
		}
		else if(prop.getProperty("browserName").equals("firefox")) {
			Utilities.takeScreenshot(headerOptions.getDriver(), "\\Screenshots\\actualFirefoxAccountLogoutPage.png");
			Assert.assertFalse(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\actualFirefoxAccountLogoutPage.png", System.getProperty("user.dir")+"\\Screenshots\\expectedFirefoxAccountLogoutPage.png"));
		}
		else if(prop.getProperty("browserName").equals("edge")) {
			Utilities.takeScreenshot(headerOptions.getDriver(), "\\Screenshots\\actualEdgeAccountLogoutPage.png");
			Assert.assertFalse(Utilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\actualEdgeAccountLogoutPage.png", System.getProperty("user.dir")+"\\Screenshots\\expectedEdgeAccountLogoutPage.png"));
		}
	}

	@Test(priority=9)
	public void verifyAccountLogoutFuynctionality() {
		
		loginPage = landingPage.navigateToLoginPage();
		accountPage = loginPage.loginToApplication(prop.getProperty("existingEmail"), prop.getProperty("validPassword"));
		headerOptions = new HeaderOptions(accountPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		logoutAccountPage = headerOptions.clickLogoutOption();
		Assert.assertTrue(logoutAccountPage.didWeNavigateToAccountLogoutPage());
		landingPage = logoutAccountPage.clickOnContinue();
		Assert.assertEquals(getPageURL(landingPage.getDriver()), prop.getProperty("landingPageURL"));
		headerOptions = new HeaderOptions(landingPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		Assert.assertTrue(headerOptions.isLoginOptionAvailable());
		
	}
	
	
}
	