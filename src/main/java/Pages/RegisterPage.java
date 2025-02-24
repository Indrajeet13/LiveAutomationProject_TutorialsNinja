package Pages;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	WebDriver driver;
	File srcScreenshot;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public RegisterPage(WebDriver driver) {
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
	
	@FindBy(xpath = "//i[@class='fa fa-phone']")
	private WebElement phoneIcon;
	
	@FindBy(xpath = "//i[@class='fa fa-heart']")
	private WebElement heartIconOption;
	
	@FindBy(xpath = "//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
	private WebElement shoppingCartOption;
	
	@FindBy(xpath = "//i[@class='fa fa-share']")
	private WebElement checkoutOption;
	
	@FindBy(linkText = "Qafox.com")
	private WebElement QAFoxHeading;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[normalize-space()='Account']")
	private WebElement accountBreadcrumb;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//i[@class='fa fa-home']")
	private WebElement homeBreadcrumb;
	
	@FindBy(xpath = "//a[normalize-space()='login page']")
	private WebElement loginPageLinkText;
	
	@FindBy(xpath = "//b[normalize-space()='Privacy Policy']")
	private WebElement privacyPolicyText;
	
	@FindBy(xpath = "//button[normalize-space()='×']")
	private WebElement xButtonAlert;
	
	private By xOptionPrivacyPolicy = By.xpath("//button[normalize-space()='×']");
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Login']")
	private WebElement loginTextOnRightPanel;
	
	@FindBy(linkText = "Forgotten Password")
	private WebElement forgottenPasswordOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
	private WebElement myAccountTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Address Book']")
	private WebElement addressBookTextOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Wish List']")
	private WebElement wishListTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Downloads']")
	private WebElement downloadsTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Recurring payments']")
	private WebElement recurringPaymentsTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Reward Points']")
	private WebElement rewardPointsTextOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Returns']")
	private WebElement returnsTextOnRightPanel;
	
	@FindBy(xpath = "//a[normalize-space()='Transactions']")
	private WebElement transactionsTextOnRightPanel;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Newsletter']")
	private WebElement newsletterTextOnRightPanel;
	
	@FindBy(linkText = "About Us")
	private WebElement aboutUsTextOnBottom;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsTextOnBottom;
	
	@FindBy(linkText = "Brands")
	private WebElement brandsTextOnBottom;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//a[normalize-space()='My Account']")
	private WebElement myAccountTextOnBottom;
	
	@FindBy(linkText = "Delivery Information")
	private WebElement deliveryInformationTextOnBottom;
	
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyTextOnBottom;
	
	@FindBy(linkText = "Terms & Conditions")
	private WebElement termsConditionTextOnBottom;
	
	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/return/add'][normalize-space()='Returns']")
	private WebElement returnsTextOnBottom;
	
	@FindBy(linkText = "Site Map")
	private WebElement siteMapTextOnBottom;
	
	@FindBy(linkText = "Gift Certificates")
	private WebElement giftCertificatesTextOnBottom;
	
	@FindBy(linkText = "Affiliate")
	private WebElement affiliateTextOnBottom;
	
	@FindBy(linkText = "Specials")
	private WebElement specialsTextOnBottom;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//a[normalize-space()='Order History']")
	private WebElement orderHistoryTextOnBottom;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//a[normalize-space()='Newsletter']")
	private WebElement newsletterTextOnBottom;

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
		return firstNameWarningMessage.getText();
	}

	public String getLastNameWarningMessage() {
		return lastNameWarningMessage.getText();
	}

	public String getEmailWarningMessage() {
		return emailWarningMessage.getText();
	}

	public String getTelephoneWarningMessage() {
		return telephoneWarningMessage.getText();
	}

	public String getPasswordWarningMessage() {
		return passwordWarningMessage.getText();
	}

	public String getPrivacyPolicyWarningMessage() {
		return privacyPolicyWarningMessage.getText();
	}

	public void clickOnYesNewsLetter() {
		newsLetterYES.click();
	}

	public boolean didWeNavigateToRegisterAccountPage() {
		return registerAccountHeading.isDisplayed();
	}

	public void clickOnMyAccountDopMenu() {
		myAccountDropMenu.click();
	}

	public LoginPage selectLoginDopMenu() {
		loginDopMenu.click();
		return new LoginPage(driver);
	}

	public String getWarningMessage() {
		return warningMessage.getText();
	}

	public String getEmailAddressAlreadyExistWarningMessage() {
		return emailAddessAlreadyExistWarning.getText();
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
		return passwordWarningMessage.isDisplayed();
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
	
	public ContactUsPage selectPhoneIcon() {
		phoneIcon.click();
		return new ContactUsPage(driver);
	}
	
	public LoginPage selectHeartIcon() {
		heartIconOption.click();
		return new LoginPage(driver);
	}
	
	public ShoppingCartPage selectShoppingCartOption() {
		shoppingCartOption.click();
		return new ShoppingCartPage(driver);
	}
	
	public ShoppingCartPage selectCheckoutOption() {
		checkoutOption.click();
		return new ShoppingCartPage(driver);
	}
	
	public LandingPage selectQAFoxHeading() {
		QAFoxHeading.click();
		return new LandingPage(driver);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public LoginPage clickAccountBreadcrumb() {
		accountBreadcrumb.click();
		return new LoginPage(driver);
	}
	
	public LandingPage clickOnHomeBreadcrumb() {
		homeBreadcrumb.click();
		return new LandingPage(driver);
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
	
	public LoginPage clickLoginTextOnRightPanel() {
		loginTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public ForgotPasswordPage clickForgottenPasswordTextOnRightPanel() {
		forgottenPasswordOnRightPanel.click();	
		return new ForgotPasswordPage(driver);
	}
	
	public LoginPage clickOnMyAccountTextOnRightPanel() {
		myAccountTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnAddressBookTextOnRightPanel() {
		addressBookTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnWishListTextOnRightPanel() {
		wishListTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnDownlodsTextOnRightPanel() {
		downloadsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnRecurringPaymentsTextOnRightPanel() {
		recurringPaymentsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnRewardPointsTextOnRightPanel() {
		rewardPointsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnReturnsTextOnRightPanel() {
		returnsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnTransactionsTextOnRightPanel() {
		transactionsTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnNewsLetterTextOnRightPanel() {
		newsletterTextOnRightPanel.click();	
		return new LoginPage(driver);
	}
	
	public AboutUsPage clickOnAboutUsOnBottom() {
		aboutUsTextOnBottom.click();	
		return new AboutUsPage(driver);
	}
	
	public ContactUsPage clickOnContactUsOnBottom() {
		contactUsTextOnBottom.click();	
		return new ContactUsPage(driver);
	}
	
	public BrandsPage clickOnBrandsTextOnBottom() {
		brandsTextOnBottom.click();	
		return new BrandsPage(driver);
	}
	
	public LoginPage clickOnMyAccountTextOnBottom() {
		myAccountTextOnBottom.click();	
		return new LoginPage(driver);
	}
	
	public DeliveryInformationPage clickOnDeliveryInformationTextOnBottom() {
		deliveryInformationTextOnBottom.click();	
		return new DeliveryInformationPage(driver);
	}
	
	public PrivacyPolicyPage clickOnPrivacyPolicyTextOnBottom() {
		privacyPolicyTextOnBottom.click();	
		return new PrivacyPolicyPage(driver);
	}
	
	public TermsAndConditionPage clickOnTermsAndConditionTextOnBottom() {
		termsConditionTextOnBottom.click();	
		return new TermsAndConditionPage(driver);
	}
	
	public ProductReturnsPage clickOnReturnsTextOnBottom() {
		returnsTextOnBottom.click();	
		return new ProductReturnsPage(driver);
	}
	
	public SiteMapPage clickOnSiteMapTextOnBottom() {
		siteMapTextOnBottom.click();	
		return new SiteMapPage(driver);
	}
	
	public GiftCertificatesPage clickOnGiftCertificatesTextOnBottom() {
		giftCertificatesTextOnBottom.click();	
		return new GiftCertificatesPage(driver);
	}
	
	public AffiliateProgramPage clickOnAffiliateTextOnBottom() {
		affiliateTextOnBottom.click();	
		return new AffiliateProgramPage(driver);
	}
	
	public SpecialOffersPage clickOnSepcialsTextOnBottom() {
		specialsTextOnBottom.click();	
		return new SpecialOffersPage(driver);
	}
	
	public LoginPage clickOnOrderHistoryTextOnBottom() {
		orderHistoryTextOnBottom.click();	
		return new LoginPage(driver);
	}
	
	public LoginPage clickOnNewsLetterTextOnBottom() {
		newsletterTextOnBottom.click();	
		return new LoginPage(driver);
	}
	
	public boolean getRegisterBreadcrumb() {
		return registerBreadcrumb.isDisplayed();	
	}
	
	public boolean getAccountBreadcrumb() {
		return accountBreadcrumb.isDisplayed();	
	}
	
	public String getRegisterAccountText() {
		return registerAccountText.getText();	
	}
	
}
