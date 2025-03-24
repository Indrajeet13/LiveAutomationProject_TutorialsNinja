package Pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;
=======
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0

public class RegisterPage extends RootPage{

	File srcScreenshot;
	WebDriverWait wait;
	JavascriptExecutor jse;
	ElementsUtilities elementsUtilities;

	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(name = "agree")
	private WebElement agreePrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@value='0']")
	private WebElement newsLetterNo;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement newsLetterYES;

	@FindBy(xpath = "//div[@id='content']//h1")
	private WebElement registerAccountHeading;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginDopMenu;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement warningMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAddessAlreadyExistWarning;

	@FindBy(xpath = "//form[@class='form-horizontal']")
	private WebElement registrationFormDOM;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneInvalidWarning;

	@FindBy(css = "label[for='input-firstname']")
	private WebElement firstNameLabel;
	
	@FindBy(css = "label[for='input-lastname']")
	private WebElement lastNameLabel;
	
	@FindBy(css = "label[for='input-email']")
	private WebElement emailLabel;
	
	@FindBy(css = "label[for='input-telephone']")
	private WebElement teleLabel;
	
	@FindBy(css = "label[for='input-password']")
	private WebElement passLabel;
	
	@FindBy(css = "label[for='input-confirm']")
	private WebElement passConfirmLabel;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement incorrectValidationMessage;
	
	@FindBy(xpath = "//a[normalize-space()='login page']")
	private WebElement loginPageLinkText;
	
	@FindBy(xpath = "//b[normalize-space()='Privacy Policy']")
	private WebElement privacyPolicyText;
	
	@FindBy(xpath = "//button[normalize-space()='×']")
	private WebElement xButtonAlert;
	
	private By xOptionPrivacyPolicy = By.xpath("//button[normalize-space()='×']");

	
 
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[normalize-space()='Register']")
	private WebElement registerBreadcrumb;
	
	@FindBy(xpath = "//h1[normalize-space()='Register Account']")
	private WebElement registerAccountText;
	
	
	
	public void enterFirstName(String firstNameText) {
		elementsUtilities.enterTextIntoElement(firstNameField, firstNameText);
	}

	public void enterLastName(String lastNameText) {
		elementsUtilities.enterTextIntoElement(lastNameField, lastNameText);
	}

	public void enterEmail(String emailText) {
		elementsUtilities.enterTextIntoElement(emailField, emailText);
	}

	public void enterTelephone(String telephoneText) {
		elementsUtilities.enterTextIntoElement(telephoneField, telephoneText);
	}

	public void enterPasswordConfirm(String passwordConfirmText) {
		elementsUtilities.enterTextIntoElement(passwordConfirmField, passwordConfirmText);
	}

	public void enterPassword(String passwordText) {
		elementsUtilities.enterTextIntoElement(passwordField, passwordText);
	}

	public void checkPrivacyPolicy() {
		elementsUtilities.clickOnElement(agreePrivacyPolicy);
	}

	public AccountSuccessPage clickOnContinueButton() {
		elementsUtilities.clickOnElement(continueButton);
		return new AccountSuccessPage(driver);
	}

	public void clickOnNoNewsLetter() {
		elementsUtilities.clickOnElement(newsLetterNo);
	}

	public String getFirstNameWarningMessage() {
<<<<<<< HEAD
		return elementsUtilities.getTextOfElements(firstNameWarningMessage);
	}

	public String getLastNameWarningMessage() {
		return elementsUtilities.getTextOfElements(lastNameWarningMessage);
	}

	public String getEmailWarningMessage() {
		return elementsUtilities.getTextOfElements(emailWarningMessage);
	}

	public String getTelephoneWarningMessage() {
		return elementsUtilities.getTextOfElements(telephoneWarningMessage);
	}

	public String getPasswordWarningMessage() {
		return elementsUtilities.getTextOfElements(passwordWarningMessage);
=======
		return getTextOfElements(firstNameWarningMessage);
	}

	public String getLastNameWarningMessage() {
		return getTextOfElements(lastNameWarningMessage);
	}

	public String getEmailWarningMessage() {
		return getTextOfElements(emailWarningMessage);
	}

	public String getTelephoneWarningMessage() {
		return getTextOfElements(telephoneWarningMessage);
	}

	public String getPasswordWarningMessage() {
		return getTextOfElements(passwordWarningMessage);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	

	public String getPrivacyPolicyWarningMessage() {
<<<<<<< HEAD
		return elementsUtilities.getTextOfElements(privacyPolicyWarningMessage);
=======
		return getTextOfElements(privacyPolicyWarningMessage);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}

	public void clickOnYesNewsLetter() {
		elementsUtilities.clickOnElement(newsLetterYES);
	}

	public boolean didWeNavigateToRegisterAccountPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(registerAccountHeading);
=======
		return isElementDisplayed(registerAccountHeading);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}

	public void clickOnMyAccountDopMenu() {
		elementsUtilities.clickOnElement(myAccountDropMenu);
	}

	public LoginPage selectLoginDopMenu() {
		elementsUtilities.clickOnElement(loginDopMenu);
		return new LoginPage(driver);
	}

	public String getWarningMessage() {
<<<<<<< HEAD
		return elementsUtilities.getTextOfElements(warningMessage);
	}

	public String getEmailAddressAlreadyExistWarningMessage() {
		return elementsUtilities.getTextOfElements(emailAddessAlreadyExistWarning);
=======
		return getTextOfElements(warningMessage);
	}

	public String getEmailAddressAlreadyExistWarningMessage() {
		return getTextOfElements(emailAddessAlreadyExistWarning);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}

	public String getEmailValidationMessage() {
		return getDomAttributeOfElement(emailField,"validationMessage");
	}
	
	public WebElement getRegistrationForm() {
		return registrationFormDOM;
	}

	public List<WebElement> TelephoneIncorrectValidationWarningText() {
		return driver.findElements(By.xpath("//input[@id='input-telephone']/following-sibling::div"));
	}

	public String getEmailDomAttributePlaceholder() {
		return getDomAttributeOfElement(emailField,"placeholder");
	}

	public String getFirstNameDomAttributePlaceholder() {
		return getDomAttributeOfElement(firstNameField,"placeholder");
	}

	public String getLastNameDomAttributePlaceholder() {
		return getDomAttributeOfElement(lastNameField,"placeholder");
	}

	public String getTelephoneDomAttributePlaceholder() {
		return getDomAttributeOfElement(telephoneField,"placeholder");
	}

	public String getPasswordDomAttributePlaceholder() {
		return getDomAttributeOfElement(passwordField,"placeholder");
	}

	public String getConfirmPasswordDomAttributePlaceholder() {
		return getDomAttributeOfElement(passwordConfirmField,"placeholder");
	}

	public String getFirstNameLabelContent(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String fnContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",firstNameLabel);
		return fnContent;
	}

	public String getFirstNameLabelColor(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String fnColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
		return fnColor;
	}
	
	public String getLastNameLabelContent(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String lnContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastNameLabel);
		return lnContent;
	}

	public String getLastNameLabelColor(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String lnColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastNameLabel);
		return lnColor;
	}
	
	public String getEmailLabelContent(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String emailContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emailLabel);
		return emailContent;
	}

	public String getEmailLabelColor(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String emailColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emailLabel);
		return emailColor;
	}
	
	public String getTelephoneLabelContent(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String teleContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", teleLabel);
		return teleContent;
	}

	public String getTelephoneLabelColor(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String teleColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", teleLabel);
		return teleColor;
	}
	
	public String getPasswordLabelContent(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String passContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passLabel);
		return passContent;
	}

	public String getPasswordLabelColor(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String passColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passLabel);
		return passColor;
	}
	
	public String getConfirmPasswordLabelContent(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String passConfirmContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passConfirmLabel);
		return passConfirmContent;
	}

	public String getConfirmPasswordLabelColor(WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		String passConfirmColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passConfirmLabel);
		return passConfirmColor;
	}
	
	public List<WebElement> getWarningMessageInList() {
		return driver.findElements(By.xpath("//div[@class='text-danger']"));
	}
	
	public String getFirstNameFieldHeight() {
	    return firstNameField.getCssValue("height");
	}

	public String getFirstNameFieldWidth() {
	    return firstNameField.getCssValue("width");
	}
	
	public void clearFirstNameField() {
		elementsUtilities.clearTextFromTextField(firstNameField);
	}
	
	public String getLastNameNameFieldHeight() {
	    return lastNameField.getCssValue("height");
	}

	public String getLastNameFieldWidth() {
	    return lastNameField.getCssValue("width");
	}
	
	public void clearLastNameField() {
		elementsUtilities.clearTextFromTextField(lastNameField);
	}
	
	public String getEmailNameFieldHeight() {
	    return emailField.getCssValue("height");
	}

	public String getEmailFieldWidth() {
	    return emailField.getCssValue("width");
	}
	
	public void clearEmailField() {
		elementsUtilities.clearTextFromTextField(emailField);
	}
	
	public String getTelephoneFieldHeight() {
	    return telephoneField.getCssValue("height");
	}

	public String getTelephoneWidth() {
	    return telephoneField.getCssValue("width");
	}
	
	public void clearTelephoneField() {
		elementsUtilities.clearTextFromTextField(telephoneField);
	}
	
	public String getPasswordFieldHeight() {
	    return passwordField.getCssValue("height");
	}

	public String getPasswordFieldWidth() {
	    return passwordField.getCssValue("width");
	}
	
	public void clearPasswordField() {
		elementsUtilities.clearTextFromTextField(passwordField);
	}
	
	public boolean passworWarningIsDisplayed(){
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(passwordWarningMessage);
=======
		return isElementDisplayed(passwordWarningMessage);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public String getPasswordConfirmFieldHeight() {
	    return passwordConfirmField.getCssValue("height");
	}

	public String getPasswordConfirmWidth() {
	    return passwordConfirmField.getCssValue("width");
	}
	
	public void clearPasswordConfirmField() {
		elementsUtilities.clearTextFromTextField(passwordConfirmField);
	}
	
	public boolean isPrivacyPolicySelected() {
		return agreePrivacyPolicy.isSelected();
	}

	public String getPasswordFieldDomAttributeType() {
		return passwordField.getDomAttribute("type");
	}

	public String getConfirmPasswordFieldDomAttributeType() {
		return passwordConfirmField.getDomAttribute("type");
	}

	public LoginPage clickOnLoginPageLinkText() {
		elementsUtilities.clickOnElement(loginPageLinkText);
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnPrivacyPolicy() {
		elementsUtilities.clickOnElement(privacyPolicyText);
		return new LoginPage(driver);
	}
	
	public boolean waitAndDisplayStatusOfClosePrivacyPolicyOption(WebDriver driver, int seconds) {
		return isElementDisplayedAfterWaiting(xOptionPrivacyPolicy,seconds);
	}
	
	public void clickOnXButtonOfAlert() {
		elementsUtilities.clickOnElement(xButtonAlert);	
	}

	public boolean getRegisterBreadcrumb() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(registerBreadcrumb);
	}
	
	public String getRegisterAccountText() {
		return elementsUtilities.getTextOfElements(registerAccountText);
=======
		return isElementDisplayed(registerBreadcrumb);
	}
	
	public String getRegisterAccountText() {
		return getTextOfElements(registerAccountText);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	

	
}
