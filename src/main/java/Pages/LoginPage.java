package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class LoginPage extends RootPage{
	

	public LoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	@FindBy(xpath="//h2[normalize-space()='New Customer']")
	private WebElement newCustomerHeading;
	
	@FindBy(xpath="//h2[normalize-space()='Returning Customer']")
	private WebElement returningCustomerHeading;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Login']")
	private WebElement loginBreaddCrumb;
	
	@FindBy(id="input-email")
	private WebElement usernameEmailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	private WebElement forgottenPassword;
	
	
	
	public AccountPage loginToApplication(String emailText, String passwordText) {
		enterUsernameEmail(emailText);
		enterPassword(passwordText);
		return clickLoginButton();
	}

	public void clearPassword() {
		passwordField.clear();
	}
	
	public String getValueForPasswordField() {
		return passwordField.getDomAttribute("value");
	}
	
	public String getTextCopiedIntoEmailField() {
		return usernameEmailField.getDomAttribute("value");
	}
	
	public WebDriver pasteCopiedTextIntoEmailField() {
		Actions actions = new Actions(driver);
		actions.click(usernameEmailField).keyDown(Keys.CONTROL)
		.sendKeys("v").keyUp(Keys.CONTROL);
		return driver;
	}
	
	public WebDriver selectPasswordFieldTextAndCopy() {
		Actions actions = new Actions(driver);
		actions.doubleClick(passwordField).keyDown(Keys.CONTROL)
		.sendKeys("c").keyUp(Keys.CONTROL).perform();
		return driver;
	}
	
	public String getPasswordFieldType() {
		return passwordField.getDomAttribute("type");
	}
	
	public ForgotPasswordPage clickOnForgottenPassword(){
		 forgottenPassword.click();
		 return new ForgotPasswordPage(driver);
	}
	
	public boolean verifyLoginBreadCrumb(){
		boolean b = false;
		try {
			b =  loginBreaddCrumb.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public void clickOnLoginBreadCrumb(){
		loginBreaddCrumb.click();
	}
	
	public boolean verifyNewCustomerHeadingOnLoginPage() {
		boolean b = false;
		try {
			b =  newCustomerHeading.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public String getTextOfNewCustomerHeadingOnLoginPage() {
		String newCustomerHeadingText = null;
		try {
			newCustomerHeadingText = newCustomerHeading.getText();
		} catch (NoSuchElementException e) {
			newCustomerHeadingText = null;
		}
		return newCustomerHeadingText;
	}
	
	public String getTextReturningCustomerHeadingOnLoginPage() {
		String returningCustomerHeadingText = null;
		try {
			returningCustomerHeadingText = returningCustomerHeading.getText();
		} catch (NoSuchElementException e) {
			returningCustomerHeadingText = null;
		}
		return returningCustomerHeadingText;
	}
	
	public RegisterPage clickOnContinueButtonOnLoginPage(){
		continueButton.click();
		return new RegisterPage(driver);
	}
	
	public void clickOnRegisterOption(){
		registerOption.click();
	}
	
	public void enterUsernameEmail(String emailText){
		usernameEmailField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText){
		passwordField.sendKeys(passwordText);
	}
	
	public AccountPage clickLoginButton(){
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String getWarningMessage(){
		String warningMessageText = null;
		try {
			warningMessageText = warningMessage.getText();
		} catch (NoSuchElementException e) {
			warningMessageText = null;
		}
		return warningMessageText;
	}
	
	public String getUserNamePlaceholder(){
		return usernameEmailField.getDomAttribute("placeholder");
	}
	public String getPasswordPlaceholder() {
		return passwordField.getDomAttribute("placeholder");
	}
}
