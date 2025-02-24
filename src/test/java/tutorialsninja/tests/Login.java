package tutorialsninja.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AccountLogoutPage;
import Pages.AccountPage;
import Pages.ChangePasswordPage;
import Pages.ForgottenPasswordPage;
import Pages.LandingPage;
import Pages.LoginPage;
import tutorialsninja.base.Base;
import utils.Utilities;

public class Login extends Base{
	
	WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	ForgottenPasswordPage forgotPasswordPage;
	AccountLogoutPage logoutAccountPage;
	ChangePasswordPage changePasswordPage ;
	
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
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials()	{

		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		loginPage.enterUsernameEmail(prop.getProperty("existingEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		accountPage = loginPage.clickLoginButton();
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());
	}
	
	@Test(priority=2)
	public void verifyLoginWithInValidCredentials()	{

		loginPage.enterUsernameEmail(Utilities.generateBrandNewEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickLoginButton();
		
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword()	{

		loginPage.enterUsernameEmail(Utilities.generateBrandNewEmail());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();
		
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword()	{

		loginPage.enterUsernameEmail(Utilities.validEmailRandomizeGenerator());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickLoginButton();
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutCredentials()	{

		loginPage.clickLoginButton();
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);
	}
	
	@Test(priority=6)
	public void verifyForgottenPasswordLinkOnLoginPage()	{
		
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		forgotPasswordPage = loginPage.clickOnForgottenPassword();
		Assert.assertTrue(forgotPasswordPage.didWeNavigateToForgottenPasswordPage());
	}
	
	@Test(priority=7)
	public void verifyLoginUsingKeyboardTabs()	{
		
		driver = pressKeyMultipleTimes(driver, Keys.TAB, 23);
		driver = enterDetailsIntoLoginFieldUsingKeyboard();
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());
	}
	
	@Test(priority=8)
	public void verifyPlaceholdersForEmailAndPasswordField()	{

		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		Assert.assertEquals(loginPage.getUserNamePlaceholder(), prop.getProperty("usernamePlaceholder"));
		Assert.assertEquals(loginPage.getPasswordPlaceholder(), prop.getProperty("passwordPlaceholder"));
	}
	
	@Test(priority=9)
	public void verifyBrowserBackAfterLogin()	{

		loginPage.enterUsernameEmail(Utilities.validEmailRandomizeGenerator());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());
		driver = navigateBack(driver);
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
	}
	
	@Test(priority = 10)
	public void verifyLoggingOutAndBrowserBackAfterLogin()	{

		loginPage.enterUsernameEmail(Utilities.validEmailRandomizeGenerator());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		accountPage = loginPage.clickLoginButton();
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());
		logoutAccountPage = accountPage.clickOnLogoutOption();
		Assert.assertTrue(logoutAccountPage.didWeNavigateToAccountLogoutPage());
		driver = navigateBack(driver);
		accountPage = new AccountPage(driver);
		accountPage.clickEditYourAccountInformationOption();
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());	
	}
	
	@Test(priority = 11)
	public void verifyLoginWithInactiveCredentials()	{

		loginPage.enterUsernameEmail(prop.getProperty("inactivEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);

	}
	
	@Test(priority = 12)
	public void verifyNumberOfUnsuccessfulLoginAttempts()	{

		loginPage.enterUsernameEmail(Utilities.generateBrandNewEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		for(int i=1;i<=5;i++) {
			loginPage.clickLoginButton();
			Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);
		}
		loginPage.clickLoginButton();
		expectedWarning = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);
	}
	
	@Test(priority = 13)
	public void verifyTextEnteredIntoPasswordFieldIsToggledToHideVisibility()	{
		
		String expectedType = "password";
		Assert.assertEquals(loginPage.getPasswordFieldType(), expectedType);
	}
	
	@Test(priority = 14)
	public void verifyCopyingOfTextEnteredIntoPasswordField()	{

		String passwordText = prop.getProperty("samplePassword");
		loginPage.enterPassword(passwordText);
		driver = loginPage.selectPasswordFieldTextAndCopy();
		driver = loginPage.pasteCopiedTextIntoEmailField();
		Assert.assertNotEquals(loginPage.getTextCopiedIntoEmailField(), passwordText);
	}
	
	@Test(priority = 15)
	public void verifyPasswordIsVisibleInPageSource()	{

		String passwordText = prop.getProperty("samplePassword");
		loginPage.enterPassword(passwordText);
		Assert.assertFalse(getHTMLCodeOfPage().contains(passwordText));
		loginPage.clickLoginButton();
		Assert.assertFalse(getHTMLCodeOfPage().contains(passwordText));
	}

	@Test(priority = 16)
	public void verifyLoginIntoApplicationAfterChangingPassword() throws InterruptedException	{
		
		String oldPassword = prop.getProperty("validPassword1");
		String newPassword = prop.getProperty("samplePassword2");
		
		loginPage.enterUsernameEmail(prop.getProperty("existingSampleEmail"));
		loginPage.enterPassword(oldPassword);
		accountPage = loginPage.clickLoginButton();
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());
		
		changePasswordPage = accountPage.clickOnChangeYourPasswordLink();
		Thread.sleep(2000);
		Assert.assertTrue(changePasswordPage.didWeNavigateToPasswordConfirmPage());
		changePasswordPage.enterPassword(newPassword);
		changePasswordPage.enterConfirmPassword(newPassword);
		accountPage = changePasswordPage.clickOnContinueButton();
		String expectedWarning = "Success: Your password has been successfully updated.";
		
		Assert.assertEquals(accountPage.verifyUpdationSuccessfulMessage(), expectedWarning);
		logoutAccountPage = accountPage.clickOnLogoutOption();
		logoutAccountPage.clickOnMyAccountDropMenu();
		loginPage = logoutAccountPage.clickOnLoginOptionDropMenu();
		
		loginPage.enterUsernameEmail(prop.getProperty("existingSampleEmail"));
		loginPage.enterPassword(oldPassword);
		loginPage.clickLoginButton();
		
		expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarning);
		loginPage.clearPassword();
		loginPage.enterPassword(newPassword);
		accountPage = loginPage.clickLoginButton();
		Assert.assertTrue(accountPage.isUserLoggedIn());
		
		Utilities.setProperties("validPassword1", newPassword);
		Utilities.setProperties("samplePassword2", oldPassword);
	}
	
	
}
