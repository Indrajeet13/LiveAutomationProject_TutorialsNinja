package tutorialsninja.tests;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.AccountSuccessPage;
import Pages.FooterOptions;
import Pages.HeaderOptions;
import Pages.LandingPage;
import Pages.RegisterPage;
import Pages.RightColumnOptions;
import tutorialsninja.base.Base;
import utils.MyXLSReader;
import utils.Utilities;

public class Register extends Base {

	public WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod
	public void setup() {

		driver = openBrowserAndApplication();
		prop = Utilities.loadProperties();
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		registerPage = landingPage.selectRegisterOption();

	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority = 1)
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

	@Test(priority = 3)
	public void verifyRegisterWithAllFeilds() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		accountSuccessPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());

		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);
		accountPage = accountSuccessPage.clickOnContinueButton();
		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());

	}

	@Test(priority = 4)
	public void verifyRegisteringWithoutFillingFeilds() {

		registerPage.clickOnContinueButton();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(registerPage.getFirstNameWarningMessage(), expectedFirstNameWarning);
		Assert.assertEquals(registerPage.getLastNameWarningMessage(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarningMessage(), expectedEmailWarning);
		Assert.assertEquals(registerPage.getPasswordWarningMessage(), expectedPasswordWarning);
		Assert.assertEquals(registerPage.getTelephoneWarningMessage(), expectedTelephoneWarning);
		Assert.assertEquals(registerPage.getPrivacyPolicyWarningMessage(), expectedPrivacyPolicyWarning);

	}

	@Test(priority = 5)
	public void verifyRegisteringAccountSayingYesToNewsLetter() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnYesNewsLetter();
		accountSuccessPage = registerPage.clickOnContinueButton();

		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);

		accountPage = accountSuccessPage.clickOnContinueButton();

		newsletterPage = accountPage.clickOnSubscribeUnsubscribeNewsLetter();
		newsletterPage.clickOnNewsletterYESRadio();

		Assert.assertTrue(newsletterPage.verifyNewsletterSubscriptionHeading());
		accountPage = newsletterPage.clickOnContinueButtonOnNewsletterPage();

		Assert.assertTrue(accountPage.verifyNewsletterUpdationSuccessfulMessage());

	}

	@Test(priority = 6)
	public void verifyRegisteringAccountSayingNoToNewsLetter() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		accountSuccessPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());

		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);
		accountPage = accountSuccessPage.clickOnContinueButton();

		newsletterPage = accountPage.clickOnSubscribeUnsubscribeNewsLetter();
		newsletterPage.clickOnNewsletterNORadio();

		Assert.assertTrue(newsletterPage.verifyNewsletterSubscriptionHeading());
		accountPage = newsletterPage.clickOnContinueButtonOnNewsletterPage();
		Assert.assertTrue(accountPage.verifyNewsletterUpdationSuccessfulMessage());
	}

	@Test(priority = 7)
	public void verifyNavigatingToRegisterAccountPageWithMultipleWays() {

		Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		headerOptions.clickOnMyAccountDropMenu();
		loginPage = headerOptions.clickLoginMenu();
		registerPage = loginPage.clickOnContinueButtonOnLoginPage();
		Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());

		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		headerOptions.clickOnMyAccountDropMenu();
		loginPage = headerOptions.clickLoginMenu();
		loginPage.clickOnRegisterOption();
		Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());
	}

	@Test(priority = 8)
	public void verifyRegisteringAccountByProvidingMismatchingPasswords() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("mismatchingPassword"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		registerPage.clickOnContinueButton();

		String expectedWarningMessage = "Password confirmation does not match password!";
		Assert.assertEquals(registerPage.getWarningMessage(), expectedWarningMessage);
	}

	@Test(priority = 9)
	public void verifyRegisteringAccountByProvidingExistingEmail() throws InterruptedException {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("existingEmail"));
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("mismatchingPassword"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		registerPage.clickOnContinueButton();

		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		Assert.assertEquals(registerPage.getEmailAddressAlreadyExistWarningMessage(), expectedWarningMessage);

	}

	@Test(priority = 10)
	public void verifyRegisteringAccountUsingInvalidEmails() throws InterruptedException, IOException {

		String browserName = prop.getProperty("browserName");

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("invalidEmailOne"));
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("mismatchingPassword"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		registerPage.clickOnContinueButton();

		if (browserName.equals("chrome")) {

			Thread.sleep(3000);

			Assert.assertEquals(registerPage.getEmailValidationMessage(),
					"Please include an '@' in the email address. 'eric' is missing an '@'.");
			File srcScreenshot1 = registerPage.getRegistrationForm().getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png"));
			Assert.assertFalse(
					Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png",
							System.getProperty("user.dir") + "\\Screenshots\\sc1Expected.png"));

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailTwo"));
			registerPage.clickOnContinueButton();

			Thread.sleep(3000);

			File srcScreenshot2 = registerPage.getRegistrationForm().getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcScreenshot2, new File(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png"));
			Assert.assertFalse(
					Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png",
							System.getProperty("user.dir") + "\\Screenshots\\sc2Expected.png"));

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailThree"));
			registerPage.clickOnContinueButton();

			Thread.sleep(3000);
			String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
			Assert.assertEquals(registerPage.getWarningMessage(), expectedWarningMessage);

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailFour"));
			registerPage.clickOnContinueButton();

			Thread.sleep(3000);
			File srcScreenshot3 = registerPage.getRegistrationForm().getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcScreenshot3, new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png"));
			Assert.assertFalse(
					Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png",
							System.getProperty("user.dir") + "\\Screenshots\\sc3Expected.png"));

		} else if (browserName.equals("firefox")) {

			Thread.sleep(2000);
			Assert.assertEquals(registerPage.getEmailValidationMessage(), "Please enter an email address.");

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailTwo"));
			registerPage.clickOnContinueButton();
			Assert.assertEquals(registerPage.getEmailValidationMessage(), "Please enter an email address.");

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailThree"));
			registerPage.clickOnContinueButton();
			Assert.assertEquals(registerPage.getWarningMessage(), "E-Mail Address does not appear to be valid!");

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailThree"));
			registerPage.clickOnContinueButton();
			Assert.assertEquals(registerPage.getWarningMessage(), "E-Mail Address does not appear to be valid!");

		} else if (browserName.equals("edge")) {

			Thread.sleep(3000);

			Assert.assertEquals(registerPage.getEmailValidationMessage(),
					"Please include an '@' in the email address. 'eric' is missing an '@'.");
			File srcScreenshot1 = registerPage.getRegistrationForm().getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png"));
			Assert.assertFalse(
					Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png",
							System.getProperty("user.dir") + "\\Screenshots\\sc1Expected.png"));

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailTwo"));
			registerPage.clickOnContinueButton();

			Thread.sleep(3000);
			File srcScreenshot2 = registerPage.getRegistrationForm().getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcScreenshot2, new File(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png"));
			Assert.assertFalse(
					Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png",
							System.getProperty("user.dir") + "\\Screenshots\\sc2Expected.png"));

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailThree"));
			registerPage.clickOnContinueButton();

			Thread.sleep(3000);
			String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
			Assert.assertEquals(registerPage.getWarningMessage(), expectedWarningMessage);

			registerPage.clearEmailField();
			registerPage.enterEmail(prop.getProperty("invalidEmailFour"));
			registerPage.clickOnContinueButton();

			Thread.sleep(3000);
			File srcScreenshot3 = registerPage.getRegistrationForm().getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcScreenshot3, new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png"));
			Assert.assertFalse(
					Utilities.compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png",
							System.getProperty("user.dir") + "\\Screenshots\\sc3Expected.png"));

		}

	}

	@Test(priority = 11)
	public void verifyRegisteringAccountByProvidingInvalidTelephone() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("invalidTelephone"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		registerPage.clickOnContinueButton();

		List<WebElement> warningElements = registerPage.TelephoneIncorrectValidationWarningText();

		if (warningElements.isEmpty()) {
			Assert.fail("Telephone number does not appear to be valid message is missing: This is a bug.");
		} else {
			String warningMessage = warningElements.get(0).getText();
			Assert.assertTrue(warningMessage.contains("Telephone number does not appear to be valid!"),
					"The expected warning message is not displayed.");
		}
	}

	@Test(priority = 12)
	public void verifyRegisteringAccountByProvidingEntriesUsingKeyboardActions()
			throws InterruptedException, IOException {

		Actions actions = new Actions(driver);
		driver = pressKeyMultipleTimes(driver, Keys.TAB, 23);

		actions.sendKeys(prop.getProperty("firstName")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("lastName")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Utilities.generateBrandNewEmail()).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("telephoneNum")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.ENTER).perform();

		accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());

		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);

	}

	@Test(priority = 13)
	public void verifyPlaceholdersOfTextFieldsInRegisterAccountPage() {

		Assert.assertEquals(registerPage.getFirstNameDomAttributePlaceholder(),prop.getProperty("firstNamePlaceholder"));
		Assert.assertEquals(registerPage.getLastNameDomAttributePlaceholder(), prop.getProperty("lastNamePlaceholder"));
		Assert.assertEquals(registerPage.getEmailDomAttributePlaceholder(), prop.getProperty("emailPlaceholder"));
		Assert.assertEquals(registerPage.getTelephoneDomAttributePlaceholder(),prop.getProperty("telephonePlaceholder"));
		Assert.assertEquals(registerPage.getPasswordDomAttributePlaceholder(), prop.getProperty("passwordPlaceholder"));
		Assert.assertEquals(registerPage.getConfirmPasswordDomAttributePlaceholder(),prop.getProperty("ConfirmPasswordPlaceholder"));
	}

	@Test(priority = 14)
	public void verifyMandatoryFieldsInRegisterAccountPage() {

		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";

		String fnContent = registerPage.getFirstNameLabelContent(driver);
		String fnColor = registerPage.getFirstNameLabelColor(driver);
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);

		String lnContent = registerPage.getLastNameLabelContent(driver);
		String lnColor = registerPage.getLastNameLabelColor(driver);
		Assert.assertEquals(lnContent, expectedContent);
		Assert.assertEquals(lnColor, expectedColor);

		String emailContent = registerPage.getEmailLabelContent(driver);
		String emailColor = registerPage.getEmailLabelColor(driver);
		Assert.assertEquals(emailContent, expectedContent);
		Assert.assertEquals(emailColor, expectedColor);

		String teleContent = registerPage.getTelephoneLabelContent(driver);
		String teleColor = registerPage.getTelephoneLabelColor(driver);
		Assert.assertEquals(teleContent, expectedContent);
		Assert.assertEquals(teleColor, expectedColor);

		String passContent = registerPage.getPasswordLabelContent(driver);
		String passColor = registerPage.getPasswordLabelColor(driver);
		Assert.assertEquals(passContent, expectedContent);
		Assert.assertEquals(passColor, expectedColor);

		String passConfirmContent = registerPage.getConfirmPasswordLabelContent(driver);
		String passConfirmColor = registerPage.getConfirmPasswordLabelColor(driver);
		Assert.assertEquals(passConfirmContent, expectedContent);
		Assert.assertEquals(passConfirmColor, expectedColor);

	}

	// Database credentials
	private static final String url = "jdbc:mysql://localhost:3306/opencart_db";
	private static final String username = "root";
	private static final String password = null;

	@Test(priority = 15)
	public void verifyDatabaseTestingOfRegisteringAccount() {

		String firstNameInputData = "Indrajeet";
		registerPage.enterFirstName(firstNameInputData);

		String lastNameInputData = "Yadav";
		registerPage.enterLastName(lastNameInputData);

		String emailInputData = Utilities.generateBrandNewEmail();
		registerPage.enterEmail(emailInputData);

		String passwordInputData = "12345";
		registerPage.enterPassword(passwordInputData);

		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		accountSuccessPage = registerPage.clickOnContinueButton();

		Assert.assertEquals(accountSuccessPage.getPageHeading(), "Your Account Has Been Created!");

		// Database validation
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement("SELECT  FROM `oc_customer` WHERE email = ?")) {
			stmt.setString(1, emailInputData);

			try (ResultSet resultSet = stmt.executeQuery()) {

				if (resultSet.next()) {
					Assert.assertEquals(resultSet.getString("firstname"), firstNameInputData);
					Assert.assertEquals(resultSet.getString("lastname"), lastNameInputData);
					Assert.assertEquals(resultSet.getString("email"), emailInputData);
				} else {
					Assert.fail("No data found in the database for the email: " + emailInputData);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Assert.fail("Database connection or query failed: " + e.getMessage());
		}

	}

	@Test(priority = 16)
	public void verifyRegisteringAccountByProvidingOnlySpace() {

		registerPage.enterFirstName(" ");
		registerPage.enterLastName(" ");
		registerPage.enterEmail(" ");
		registerPage.enterTelephone(" ");
		registerPage.enterPassword(" ");
		registerPage.enterPasswordConfirm(" ");
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnNoNewsLetter();
		registerPage.clickOnContinueButton();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";

		Assert.assertEquals(registerPage.getFirstNameWarningMessage(), expectedFirstNameWarning);
		Assert.assertEquals(registerPage.getLastNameWarningMessage(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarningMessage(), expectedEmailWarning);
		Assert.assertEquals(registerPage.getPasswordWarningMessage(), expectedPasswordWarning);
		Assert.assertEquals(registerPage.getTelephoneWarningMessage(), expectedTelephoneWarning);

	}

	@Test(dataProvider = "PasswordSupplier", priority = 17)
	public void verifyRegisteringAccountByCheckingThePasswordStandards(HashMap<String,String> hMap) {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(hMap.get("Passwords"));
		registerPage.enterPasswordConfirm(hMap.get("Passwords"));
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnYesNewsLetter();
		registerPage.clickOnContinueButton();

		List<WebElement> warningElements = registerPage.getWarningMessageInList();

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

		myXLSReader = new MyXLSReader(System.getProperty("user.dir")+"\\src\\test\\resources\\TutorialsNinjaData.xlsx");
		Object[][] data = Utilities.getTestData(myXLSReader, "RegisterTestsSupplyPasswords", "data");
		return data;

	}

	@Test(priority = 18)
	public void verifyRegisteringAccountFielsHeightWidthAlignment() throws IOException {

		String expectedHeight = "34px";
		String expectedWidth = "701.25px";

		// String actualFirstNameHeight = registerPage.getFirstNameFieldHeight();
		// String actualFirstNameWidth = registerPage.getFirstNameFieldWidth();

		// Test for 1 character input (invalid)
		registerPage.enterFirstName("");
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getFirstNameWarningMessage(),
				"First Name must be between 1 and 32 characters!");

		registerPage.clearFirstNameField();
		registerPage.enterFirstName("a");
		registerPage.clickOnContinueButton();

		registerPage.clearFirstNameField();
		registerPage.enterFirstName("ab");
		registerPage.clickOnContinueButton();

		registerPage.clearFirstNameField();
		registerPage.enterFirstName("asdfghjklqwertyu");
		registerPage.clickOnContinueButton();

		registerPage.clearFirstNameField();
		registerPage.enterFirstName("asdfghjklqwertyusdsdsdasadsaasdasdf");
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getFirstNameWarningMessage(),
				"First Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getFirstNameFieldHeight(), expectedHeight);
		Assert.assertEquals(registerPage.getFirstNameFieldWidth(), expectedWidth);

		// Test for 1 character input (invalid)
		registerPage.clearLastNameField();
		registerPage.enterLastName("");
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getLastNameWarningMessage(), "Last Name must be between 1 and 32 characters!");

		registerPage.clearLastNameField();
		registerPage.enterLastName("a");
		registerPage.clickOnContinueButton();

		registerPage.clearLastNameField();
		registerPage.enterLastName("ab");
		registerPage.clickOnContinueButton();

		registerPage.clearLastNameField();
		registerPage.enterLastName("asdfghjklqwertyu");
		registerPage.clickOnContinueButton();

		registerPage.clearLastNameField();
		registerPage.enterLastName("asdfghjklqwertyusdsdsdasadsaasdasdf");
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getLastNameWarningMessage(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getLastNameNameFieldHeight(), expectedHeight);
		Assert.assertEquals(registerPage.getLastNameFieldWidth(), expectedWidth);

		Assert.assertEquals(registerPage.getLastNameNameFieldHeight(), expectedHeight);
		Assert.assertEquals(registerPage.getEmailFieldWidth(), expectedWidth);

		// Test for 1 character input (invalid)
		registerPage.clearTelephoneField();
		registerPage.enterTelephone("");
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getTelephoneWarningMessage(),
				"Telephone must be between 3 and 32 characters!");

		registerPage.clearTelephoneField();
		registerPage.enterTelephone("123");
		registerPage.clickOnContinueButton();

		registerPage.clearTelephoneField();
		registerPage.enterTelephone("1234567890");
		registerPage.clickOnContinueButton();

		registerPage.clearTelephoneField();
		registerPage.enterTelephone("123456789852369741");
		registerPage.clickOnContinueButton();

		registerPage.clearTelephoneField();
		registerPage.enterTelephone("1234567898523697411234567898523697411254");
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getTelephoneWarningMessage(),
				"Telephone must be between 3 and 32 characters!");

		Assert.assertEquals(registerPage.getTelephoneFieldHeight(), expectedHeight);
		Assert.assertEquals(registerPage.getTelephoneWidth(), expectedWidth);

		// Test for 1 character input (invalid)
		registerPage.clearPasswordField();
		registerPage.enterPassword("");
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getPasswordWarningMessage(), "Password must be between 4 and 20 characters!");

		registerPage.clearPasswordField();
		registerPage.enterPassword("12345");
		registerPage.clickOnContinueButton();

		registerPage.clearPasswordField();
		registerPage.enterPassword("123456789852369741");
		registerPage.clickOnContinueButton();

		registerPage.clearPasswordField();
		registerPage.enterPassword("1234567890123456789012345");
		registerPage.clickOnContinueButton();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String passwordFieldValue = (String) js
				.executeScript("return document.getElementById('input-password').value;");
		Assert.assertTrue(passwordFieldValue.length() <= 20, "Password field accepts more than 20 characters!");

		try {
			Assert.assertTrue(registerPage.passworWarningIsDisplayed(),
					"Expected validation message for password length is missing.");
		} catch (NoSuchElementException e) {
			Assert.fail("Validation message not found! Password field is accepting more than 20 characters.");
		}

		Assert.assertEquals(registerPage.getPasswordFieldHeight(), expectedHeight);
		Assert.assertEquals(registerPage.getPasswordFieldWidth(), expectedWidth);

		Assert.assertEquals(registerPage.getPasswordConfirmFieldHeight(), expectedHeight);
		Assert.assertEquals(registerPage.getPasswordConfirmWidth(), expectedWidth);

		driver = navigateToPage_GivenURL(driver, prop.getProperty("registerPageURL"));

		Utilities.takeScreenshot(driver, "\\Screenshots\\registerPageActualAligment.png");

		Assert.assertTrue(Utilities.compareTwoScreenShots(
				System.getProperty("user.dir") + "\\Screenshots\\registerPageExpectedAligment.png",
				System.getProperty("user.dir") + "\\Screenshots\\registerPageActualAligment.png"));

	}

	@Test(priority = 19)
	public void verifyHeadingAndTrailingSpacesWhileRegisteringPage() {

		SoftAssert softAssert = new SoftAssert();

		String enteredFirstName = "     " + prop.getProperty("firstName") + "      ";
		registerPage.enterFirstName(enteredFirstName);

		String enteredLastName = "      " + prop.getProperty("lastName") + "     ";
		registerPage.enterLastName(enteredLastName);

		String enteredEmail = "      " + Utilities.generateBrandNewEmail() + "   ";
		registerPage.enterEmail(enteredEmail);

		String enteredTelephone = "    " + prop.getProperty("telephoneNum") + "    ";
		registerPage.enterTelephone(enteredTelephone);

		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.checkPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnContinueButton();
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		
		
		accountPage = accountSuccessPage.clickOnContinueButton();
		editAccountInformationPage = accountPage.clickEditYourAccountInformationOption();

		softAssert.assertEquals(editAccountInformationPage.getFirstNameDomAttributeValue(), enteredFirstName.trim());
		softAssert.assertEquals(editAccountInformationPage.getLastNameDomAttributeValue(), enteredLastName.trim());
		softAssert.assertEquals(editAccountInformationPage.getEmailDomAttributeValue(), enteredEmail.trim());
		softAssert.assertEquals(editAccountInformationPage.getTelephoneDomAttributeValue(), enteredTelephone.trim());

	}

	@Test(priority = 20)
	public void verifyPrivacyPolicyFieldsOnRegisteringAccountPage() {

		Assert.assertFalse(registerPage.isPrivacyPolicySelected());
	}

	@Test(priority = 21)
	public void verifyRegisteringAccountWithoutPrivacyPolicySelection() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephoneNum"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.clickOnContinueButton();

		String warningMessage = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(registerPage.getPrivacyPolicyWarningMessage(), warningMessage);

	}

	@Test(priority = 22)
	public void verifyRegisteringAccountVisibilityTogglingOfPasswordFields() {

		Assert.assertEquals(registerPage.getPasswordFieldDomAttributeType(), "password");
		Assert.assertEquals(registerPage.getConfirmPasswordFieldDomAttributeType(), "password");

	}

	@Test(priority = 23)
	public void verifyWorkingOfEveryLinkOnRegisterAccount() throws InterruptedException {
		
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		contactUsPage = headerOptions.selectPhoneIcon();
		Assert.assertTrue(contactUsPage.didWeNavigateToContactUsPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		loginPage = headerOptions.selectHeartIcon();
		Assert.assertTrue(loginPage.verifyLoginBreadCrumb());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		shoppingCart = headerOptions.selectShoppingCartOption();
		Assert.assertTrue(shoppingCart.didWeNavigateToShoppingCartPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		shoppingCart = headerOptions.selectCheckoutOption();
		Assert.assertTrue(shoppingCart.didWeNavigateToShoppingCartPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		landingPage = headerOptions.selectQAFoxHeading();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("landingPageURL"));
		Assert.assertTrue(landingPage.isFeaturedHeadingDisplayed());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		searchPage = headerOptions.clickOnSearchButton();
		Assert.assertTrue(searchPage.verifySearchText());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		loginPage = headerOptions.clickAccountBreadcrumb();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
		
//		registerPage = new RegisterPage(driver);
//		driver = registerPage.getDriverFromRegisterPage();
//		headerOptions = new HeaderOptions(driver);
//		landingPage = headerOptions.clickOnHomeBreadcrumb();
//		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("landingPageURL"));
//		Assert.assertTrue(landingPage.isFeaturedHeadingDisplayed());
//		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		loginPage = registerPage.clickOnLoginPageLinkText();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		registerPage.clickOnPrivacyPolicy();
		Assert.assertTrue(registerPage.waitAndDisplayStatusOfClosePrivacyPolicyOption(driver, 10));
		registerPage.clickOnXButtonOfAlert();
		driver = navigateToPage_GivenURL(driver, prop.getProperty("registerPageURL"));

		registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getPrivacyPolicyWarningMessage(),
				"Warning: You must agree to the Privacy Policy!");
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickLoginTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		forgotPassword = rightColumnOptions.clickForgottenPasswordTextOnRightPanel();
		Assert.assertTrue(forgotPassword.verifyForgotPasswordBreadCrumb());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnMyAccountTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnAddressBookTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnWishListTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnDownlodsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnRecurringPaymentsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnRewardPointsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnReturnsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnTransactionsTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		rightColumnOptions = new RightColumnOptions(driver);
		loginPage = rightColumnOptions.clickOnNewsLetterTextOnRightPanel();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		aboutUsPage = footerOptions.clickOnAboutUsOnBottom();
		Assert.assertTrue(aboutUsPage.verifyAboutUsBreadCrumb());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		contactUsPage = footerOptions.clickOnContactUsOnBottom();
		Assert.assertTrue(contactUsPage.didWeNavigateToContactUsPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		brandsPage = footerOptions.clickOnBrandsTextOnBottom();
		Assert.assertTrue(brandsPage.didWeNavigateToBrandsPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		loginPage = footerOptions.clickOnMyAccountTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		deliveryInformationPage = footerOptions.clickOnDeliveryInformationTextOnBottom();
		Assert.assertTrue(deliveryInformationPage.didWeNavigateToDeliveryInformationPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		privacyPolicyPage = footerOptions.clickOnPrivacyPolicyTextOnBottom();
		Assert.assertTrue(privacyPolicyPage.didWeNavigateToPrivacyPolicyPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		termsAndConditionPage = footerOptions.clickOnTermsAndConditionTextOnBottom();
		Assert.assertTrue(termsAndConditionPage.didWeNavigateToTermsAndConditionPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		productReturnsPage = footerOptions.clickOnReturnsTextOnBottom();
		Assert.assertTrue(productReturnsPage.didWeNavigateToProductReturnsPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		siteMapPage = footerOptions.clickOnSiteMapTextOnBottom();
		Assert.assertTrue(siteMapPage.didWeNavigateToSiteMapPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		giftCertificatesPage = footerOptions.clickOnGiftCertificatesTextOnBottom();
		Assert.assertTrue(giftCertificatesPage.didWeNavigateToGiftCertificatesPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		affiliateProgramPage = footerOptions.clickOnAffiliateTextOnBottom();
		Assert.assertTrue(affiliateProgramPage.didWeNavigateToAffiliateProgramPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		specialOffersPage = footerOptions.clickOnSepcialsTextOnBottom();
		Assert.assertTrue(specialOffersPage.didWeNavigateToSpecialOffersPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		loginPage = footerOptions.clickOnOrderHistoryTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);

		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		footerOptions = new FooterOptions(driver);
		loginPage = footerOptions.clickOnNewsLetterTextOnBottom();
		Assert.assertTrue(loginPage.verifyNewCustomerHeadingOnLoginPage());
		driver = navigateBack(driver);
	}

	@Test(priority = 24)
	public void verifyRegisteringAccountWithoutEnteringPasswordIntoPasswordConfirmField() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("invalidTelephone"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm("");
		registerPage.checkPrivacyPolicy();
		registerPage.clickOnContinueButton();

		String warningMessage = "Password confirmation does not match password!";
		Assert.assertEquals(registerPage.getWarningMessage(), warningMessage);
	}

	@Test(priority = 25)
	public void verifyBreadcrumbTitleHeadingRegisterAccount() {

		Assert.assertTrue(registerPage.getRegisterBreadcrumb());
		registerPage = new RegisterPage(driver);
		driver = registerPage.getDriverFromRegisterPage();
		headerOptions = new HeaderOptions(driver);
		Assert.assertTrue(headerOptions.getAccountBreadcrumb());
		Assert.assertEquals(registerPage.getRegisterAccountText(), prop.getProperty("registerPageTitle"));
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("registerPageURL"));
		Assert.assertEquals(driver.getTitle(), prop.getProperty("registerPageTitle"));
	}

	@Test(priority = 26)
	public void verifyUIOfRegisterAccountPage() {

		Utilities.takeScreenshot(driver, "//ScreenShots//actualRegisterPageUI.png");
		Assert.assertTrue(Utilities.compareTwoScreenShots(
				System.getProperty("user.dir") + "//ScreenShots//actualRegisterPageUI.png",
				System.getProperty("user.dir") + "//ScreenShots//expectedRegisterPageUI.png"));
	}

	@Test(priority = 27)
	public void verifyRegisteringAccountInDifferentEnvironments() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("invalidTelephone"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validPassword"));
		registerPage.clickOnYesNewsLetter();
		registerPage.checkPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		accountSuccessPage.clickOnContinueButton();
		Assert.assertTrue(accountSuccessPage.didWeNavigateToAccountSucessPage());
		Assert.assertEquals(driver.getTitle(), prop.getProperty("accountPageTitle"));

	}
}
