package Pages;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import Pages.root.RootPage;

public class RegisterPage extends RootPage{

	File srcScreenshot;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
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
		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void enterPasswordConfirm(String passwordConfirmText) {
		passwordConfirmField.sendKeys(passwordConfirmText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void checkPrivacyPolicy() {
		agreePrivacyPolicy.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public void clickOnNoNewsLetter() {
		newsLetterNo.click();
	}

	public String getFirstNameWarningMessage() {
		String firstNameWarningMessageText = null;
		try {
			firstNameWarningMessageText = firstNameWarningMessage.getText();
		} catch (NoSuchElementException e) {
			firstNameWarningMessageText = null;
		}
		return firstNameWarningMessageText;
	}

	public String getLastNameWarningMessage() {
		String lastNameWarningMessageText = null;
		try {
			lastNameWarningMessageText = lastNameWarningMessage.getText();
		} catch (NoSuchElementException e) {
			lastNameWarningMessageText = null;
		}
		return lastNameWarningMessageText;
	}

	public String getEmailWarningMessage() {
		String emailWarningMessageText = null;
		try {
			emailWarningMessageText = emailWarningMessage.getText();
		} catch (NoSuchElementException e) {
			emailWarningMessageText = null;
		}
		return emailWarningMessageText;
	}

	public String getTelephoneWarningMessage() {
		String telephoneWarningMessageText = null;
		try {
			telephoneWarningMessageText = telephoneWarningMessage.getText();
		} catch (NoSuchElementException e) {
			telephoneWarningMessageText = null;
		}
		return telephoneWarningMessageText;
	}

	public String getPasswordWarningMessage() {
		String passwordWarningMessageText = null;
		try {
			passwordWarningMessageText = passwordWarningMessage.getText();
		} catch (NoSuchElementException e) {
			passwordWarningMessageText = null;
		}
		return passwordWarningMessageText;
	}

	public String getPrivacyPolicyWarningMessage() {
		String privacyPolicyWarningMessageText = null;
		try {
			privacyPolicyWarningMessageText = privacyPolicyWarningMessage.getText();
		} catch (NoSuchElementException e) {
			privacyPolicyWarningMessageText = null;
		}
		return privacyPolicyWarningMessageText;
	}

	public void clickOnYesNewsLetter() {
		newsLetterYES.click();
	}

	public boolean didWeNavigateToRegisterAccountPage() {
		boolean b = false;
		try {
			b =  registerAccountHeading.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}

	public void clickOnMyAccountDopMenu() {
		myAccountDropMenu.click();
	}

	public LoginPage selectLoginDopMenu() {
		loginDopMenu.click();
		return new LoginPage(driver);
	}

	public String getWarningMessage() {
		String warningMessageText = null;
		try {
			warningMessageText = warningMessage.getText();
		} catch (NoSuchElementException e) {
			warningMessageText = null;
		}
		return warningMessageText;
	}

	public String getEmailAddressAlreadyExistWarningMessage() {
		String emailAddessAlreadyExistWarningText = null;
		try {
			emailAddessAlreadyExistWarningText = emailAddessAlreadyExistWarning.getText();
		} catch (NoSuchElementException e) {
			emailAddessAlreadyExistWarningText = null;
		}
		return emailAddessAlreadyExistWarningText;
	}

	public String getEmailValidationMessage() {
		return emailField.getDomProperty("validationMessage");
	}
	
	public WebElement getRegistrationForm() {
		return registrationFormDOM;
	}

	public List<WebElement> TelephoneIncorrectValidationWarningText() {
		return driver.findElements(By.xpath("//input[@id='input-telephone']/following-sibling::div"));
	}

	public String getEmailDomAttributePlaceholder() {
		return emailField.getDomAttribute("placeholder");
	}

	public String getFirstNameDomAttributePlaceholder() {
		return firstNameField.getDomAttribute("placeholder");
	}

	public String getLastNameDomAttributePlaceholder() {
		return lastNameField.getDomAttribute("placeholder");
	}

	public String getTelephoneDomAttributePlaceholder() {
		return telephoneField.getDomAttribute("placeholder");
	}

	public String getPasswordDomAttributePlaceholder() {
		return passwordField.getDomAttribute("placeholder");
	}

	public String getConfirmPasswordDomAttributePlaceholder() {
		return passwordConfirmField.getDomAttribute("placeholder");
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
	    firstNameField.clear();
	}
	
	public String getLastNameNameFieldHeight() {
	    return lastNameField.getCssValue("height");
	}

	public String getLastNameFieldWidth() {
	    return lastNameField.getCssValue("width");
	}
	
	public void clearLastNameField() {
	    lastNameField.clear();
	}
	
	public String getEmailNameFieldHeight() {
	    return emailField.getCssValue("height");
	}

	public String getEmailFieldWidth() {
	    return emailField.getCssValue("width");
	}
	
	public void clearEmailField() {
		emailField.clear();
	}
	
	public String getTelephoneFieldHeight() {
	    return telephoneField.getCssValue("height");
	}

	public String getTelephoneWidth() {
	    return telephoneField.getCssValue("width");
	}
	
	public void clearTelephoneField() {
		telephoneField.clear();
	}
	
	public String getPasswordFieldHeight() {
	    return passwordField.getCssValue("height");
	}

	public String getPasswordFieldWidth() {
	    return passwordField.getCssValue("width");
	}
	
	public void clearPasswordField() {
		passwordField.clear();
	}
	
	public boolean passworWarningIsDisplayed(){
		boolean b = false;
		try {
			b =  passwordWarningMessage.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public String getPasswordConfirmFieldHeight() {
	    return passwordConfirmField.getCssValue("height");
	}

	public String getPasswordConfirmWidth() {
	    return passwordConfirmField.getCssValue("width");
	}
	
	public void clearPasswordConfirmField() {
		passwordConfirmField.clear();
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
		loginPageLinkText.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnPrivacyPolicy() {
		privacyPolicyText.click();
		return new LoginPage(driver);
	}
	
	public boolean waitAndDisplayStatusOfClosePrivacyPolicyOption(WebDriver driver, int seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(xOptionPrivacyPolicy));
		return xButtonAlert.isDisplayed();
	}
	
	public void clickOnXButtonOfAlert() {
		xButtonAlert.click();	
	}
	
	

	public boolean getRegisterBreadcrumb() {
		boolean b = false;
		try {
			b =  registerBreadcrumb.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;	
	}
	
	public String getRegisterAccountText() {
		String registerAccountText1 = null;
		try {
			registerAccountText1 = registerAccountText.getText();
		} catch (NoSuchElementException e) {
			registerAccountText1 = null;
		}
		return registerAccountText1;
	}
	

	
}
