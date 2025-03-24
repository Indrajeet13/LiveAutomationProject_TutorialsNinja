package tutorialsninja.tests;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.*;
import tutorialsninja.base.Base;
import utils.Utilities;

public class Login extends Base{
	
	public WebDriver driver;
	Properties prop;
	
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
		forgotPassword = loginPage.clickOnForgottenPassword();
		Assert.assertTrue(forgotPassword.verifyForgotPasswordBreadCrumb());
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
	
	@Test(priority = 17)
	 public void verifyNavigateToDifferentPagesFromLoginPage() {
		 
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		contactUsPage = headerOptions.selectPhoneIcon();
		Assert.assertTrue(contactUsPage.didWeNavigateToContactUsPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		loginPage = headerOptions.selectHeartIcon();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		shoppingCart = headerOptions.selectShoppingCartOption();
		Assert.assertTrue(shoppingCart.didWeNavigateToShoppingCartPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		shoppingCart = headerOptions.selectCheckoutOption();
		Assert.assertTrue(shoppingCart.didWeNavigateToShoppingCartPage());
		driver = navigateBack(driver);
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		landingPage = headerOptions.selectQAFoxHeading();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("landingPageURL"));
		Assert.assertTrue(landingPage.isFeaturedHeadingDisplayed());
		driver = navigateBack(driver);

		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		searchPage = headerOptions.clickOnSearchButton();
		Assert.assertTrue(searchPage.verifySearchText());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		loginPage = headerOptions.clickAccountBreadcrumb();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
//		loginPage.getDriver();
//		headerOptions = new HeaderOptions(driver);
//		landingPage = headerOptions.clickOnHomeBreadcrumb();
//		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("landingPageURL"));
//		Assert.assertTrue(landingPage.isFeaturedHeadingDisplayed());
//		driver = navigateBack(driver);
		
		driver = loginPage.getDriver();
		loginPage.clickOnLoginBreadCrumb();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		
		driver = loginPage.getDriver();
		registerPage = loginPage.clickOnContinueButtonOnLoginPage();
		Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		forgotPassword = loginPage.clickOnForgottenPassword();
		Assert.assertTrue(forgotPassword.verifyForgotPasswordBreadCrumb());
		driver = navigateBack(driver);
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickLoginTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateToPage_GivenURL(driver, prop.getProperty("loginPageURL"));

		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		forgotPassword = rightColumnOptions.clickForgottenPasswordTextOnRightPanel();
		Assert.assertTrue(forgotPassword.verifyForgotPasswordBreadCrumb());
		driver = navigateBack(driver);
	
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnMyAccountTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnAddressBookTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnWishListTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);

		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnDownlodsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);
		
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnRecurringPaymentsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);

		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnRewardPointsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnReturnsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnTransactionsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickOnNewsLetterTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		aboutUsPage = footerOptions.clickOnAboutUsOnBottom();
		Assert.assertTrue(aboutUsPage.verifyAboutUsBreadCrumb());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		contactUsPage = footerOptions.clickOnContactUsOnBottom();
		Assert.assertTrue(contactUsPage.didWeNavigateToContactUsPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		brandsPage = footerOptions.clickOnBrandsTextOnBottom();
		Assert.assertTrue(brandsPage.didWeNavigateToBrandsPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		loginPage = footerOptions.clickOnMyAccountTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		deliveryInformationPage = footerOptions.clickOnDeliveryInformationTextOnBottom();
		Assert.assertTrue(deliveryInformationPage.didWeNavigateToDeliveryInformationPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		privacyPolicyPage = footerOptions.clickOnPrivacyPolicyTextOnBottom();
		Assert.assertTrue(privacyPolicyPage.didWeNavigateToPrivacyPolicyPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		termsAndConditionPage = footerOptions.clickOnTermsAndConditionTextOnBottom();
		Assert.assertTrue(termsAndConditionPage.didWeNavigateToTermsAndConditionPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		productReturnsPage = footerOptions.clickOnReturnsTextOnBottom();
		Assert.assertTrue(productReturnsPage.didWeNavigateToProductReturnsPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		siteMapPage = footerOptions.clickOnSiteMapTextOnBottom();
		Assert.assertTrue(siteMapPage.didWeNavigateToSiteMapPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		giftCertificatesPage = footerOptions.clickOnGiftCertificatesTextOnBottom();
		Assert.assertTrue(giftCertificatesPage.didWeNavigateToGiftCertificatesPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		affiliateProgramPage = footerOptions.clickOnAffiliateTextOnBottom();
		Assert.assertTrue(affiliateProgramPage.didWeNavigateToAffiliateProgramPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		specialOffersPage = footerOptions.clickOnSepcialsTextOnBottom();
		Assert.assertTrue(specialOffersPage.didWeNavigateToSpecialOffersPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		loginPage = footerOptions.clickOnOrderHistoryTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		
		headerOptions = new HeaderOptions(loginPage.getDriver());
		footerOptions = new FooterOptions(loginPage.getDriver());
		loginPage = footerOptions.clickOnNewsLetterTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

	 }
	@Test(priority=18)
	public void verifyDifferentWaysOfNavigatingToLoginPage() {
		
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		registerPage = loginPage.clickOnContinueButtonOnLoginPage();
		loginPage = registerPage.clickOnLoginPageLinkText();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		rightColumnOptions = new RightColumnOptions(loginPage.getDriver());
		loginPage = rightColumnOptions.clickLoginTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		headerOptions = new HeaderOptions(loginPage.getDriver());
		headerOptions.clickOnMyAccountDropMenu();
		loginPage = headerOptions.clickLoginMenu();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		
	}
	
	@Test(priority=19)
	public void verifyBreadcrumbPageHeadingTitleOnLoginPage() {
		
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		Assert.assertEquals(getPageTitle(driver), prop.getProperty("loginPageTitle"));
		Assert.assertEquals(getPageURL(driver), prop.getProperty("loginPageURL"));
		Assert.assertEquals(loginPage.getTextOfNewCustomerHeadingOnLoginPage(), prop.getProperty("expectedHeadingOne"));
		Assert.assertEquals(loginPage.getTextReturningCustomerHeadingOnLoginPage(), prop.getProperty("expectedHeadingTwo"));	
	}
	
	@Test(priority = 20)
	public void verifyUIOfLoginPage() {

		Utilities.takeScreenshot(driver, "//ScreenShots//actualLoginPageUI.png");
		Assert.assertFalse(Utilities.compareTwoScreenShots(
				System.getProperty("user.dir") + "//ScreenShots//actualLoginPageUI.png",
				System.getProperty("user.dir") + "//ScreenShots//expectedLoginPageUI.png"));
	}
	
	@Test(priority = 21)
	public void verifyLoginInAllEnvironments() {
		
		loginPage.enterUsernameEmail(prop.getProperty("existingEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		accountPage = loginPage.clickLoginButton();
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());
		Assert.assertTrue(accountPage.isUserLoggedIn());
		
	}

	
	
}
