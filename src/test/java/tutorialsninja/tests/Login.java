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

import Pages.AboutUsPage;
import Pages.AccountLogoutPage;
import Pages.AccountPage;
import Pages.AffiliateProgramPage;
import Pages.BrandsPage;
import Pages.ChangePasswordPage;
import Pages.ContactUsPage;
import Pages.DeliveryInformationPage;
import Pages.FooterOptions;
import Pages.ForgotPasswordPage;
import Pages.GiftCertificatesPage;
import Pages.HeaderOptions;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.PrivacyPolicyPage;
import Pages.ProductReturnsPage;
import Pages.RegisterPage;
import Pages.RightColumnOptions;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.SiteMapPage;
import Pages.SpecialOffersPage;
import Pages.TermsAndConditionPage;
import tutorialsninja.base.Base;
import utils.Utilities;

public class Login extends Base{
	
	WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	AccountLogoutPage logoutAccountPage;
	ChangePasswordPage changePasswordPage ;
	ContactUsPage contactUsPage;
	ShoppingCartPage shoppingCart;
	SearchPage searchPage;
	RegisterPage registerPage;
	ForgotPasswordPage forgotPassword;
	AboutUsPage aboutUsPage;
	BrandsPage brandsPage;
	DeliveryInformationPage deliveryInformationPage;
	PrivacyPolicyPage privacyPolicyPage;
	TermsAndConditionPage termsAndConditionPage;
	ProductReturnsPage productReturnsPage;
	SiteMapPage siteMapPage;
	GiftCertificatesPage giftCertificatesPage;
	AffiliateProgramPage affiliateProgramPage;
	SpecialOffersPage specialOffersPage;
	HeaderOptions headerOptions;
	RightColumnOptions rightColumnOptions;
	FooterOptions footerOptions;
	
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
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		loginPage = headerOptions.selectHeartIcon();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		shoppingCart = headerOptions.selectShoppingCartOption();
		Assert.assertTrue(shoppingCart.didWeNavigateToShoppingCartPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		shoppingCart = headerOptions.selectCheckoutOption();
		Assert.assertTrue(shoppingCart.didWeNavigateToShoppingCartPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		landingPage = headerOptions.selectQAFoxHeading();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("landingPageURL"));
		Assert.assertTrue(landingPage.isFeaturedHeadingDisplayed());
		driver = navigateBack(driver);

		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		searchPage = headerOptions.clickOnSearchButton();
		Assert.assertTrue(searchPage.verifySearchText());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		loginPage = headerOptions.clickAccountBreadcrumb();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
//		loginPage.getDriver();
//		headerOptions = new HeaderOptions(driver);
//		landingPage = headerOptions.clickOnHomeBreadcrumb();
//		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("landingPageURL"));
//		Assert.assertTrue(landingPage.isFeaturedHeadingDisplayed());
//		driver = navigateBack(driver);
		
		loginPage.getDriver();
		loginPage.clickOnLoginBreadCrumb();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		
		loginPage.getDriver();
		registerPage = loginPage.clickOnContinueButtonOnLoginPage();
		Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		forgotPassword = loginPage.clickOnForgottenPassword();
		Assert.assertTrue(forgotPassword.verifyForgotPasswordBreadCrumb());
		driver = navigateBack(driver);
		
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickLoginTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateToPage_GivenURL(driver, prop.getProperty("loginPageURL"));
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		forgotPassword = rightColumnOptions.clickForgottenPasswordTextOnRightPanel();
		Assert.assertTrue(forgotPassword.verifyForgotPasswordBreadCrumb());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnMyAccountTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnAddressBookTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnWishListTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);

		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnDownlodsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);
		
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnRecurringPaymentsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);

		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnRewardPointsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnReturnsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnTransactionsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnNewsLetterTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		aboutUsPage = footerOptions.clickOnAboutUsOnBottom();
		Assert.assertTrue(aboutUsPage.verifyAboutUsBreadCrumb());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		contactUsPage = footerOptions.clickOnContactUsOnBottom();
		Assert.assertTrue(contactUsPage.didWeNavigateToContactUsPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		brandsPage = footerOptions.clickOnBrandsTextOnBottom();
		Assert.assertTrue(brandsPage.didWeNavigateToBrandsPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		loginPage = footerOptions.clickOnMyAccountTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		deliveryInformationPage = footerOptions.clickOnDeliveryInformationTextOnBottom();
		Assert.assertTrue(deliveryInformationPage.didWeNavigateToDeliveryInformationPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		privacyPolicyPage = footerOptions.clickOnPrivacyPolicyTextOnBottom();
		Assert.assertTrue(privacyPolicyPage.didWeNavigateToPrivacyPolicyPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		termsAndConditionPage = footerOptions.clickOnTermsAndConditionTextOnBottom();
		Assert.assertTrue(termsAndConditionPage.didWeNavigateToTermsAndConditionPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		productReturnsPage = footerOptions.clickOnReturnsTextOnBottom();
		Assert.assertTrue(productReturnsPage.didWeNavigateToProductReturnsPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		siteMapPage = footerOptions.clickOnSiteMapTextOnBottom();
		Assert.assertTrue(siteMapPage.didWeNavigateToSiteMapPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		giftCertificatesPage = footerOptions.clickOnGiftCertificatesTextOnBottom();
		Assert.assertTrue(giftCertificatesPage.didWeNavigateToGiftCertificatesPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		affiliateProgramPage = footerOptions.clickOnAffiliateTextOnBottom();
		Assert.assertTrue(affiliateProgramPage.didWeNavigateToAffiliateProgramPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		specialOffersPage = footerOptions.clickOnSepcialsTextOnBottom();
		Assert.assertTrue(specialOffersPage.didWeNavigateToSpecialOffersPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
		loginPage = footerOptions.clickOnOrderHistoryTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
		loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
		footerOptions = new FooterOptions(driver);
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
		driver = loginPage.getDriver();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickLoginTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = loginPage.getDriver();
		headerOptions = new HeaderOptions(driver);
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
