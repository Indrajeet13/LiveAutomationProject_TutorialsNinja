package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class LoginPage extends RootPage{
	
	ElementsUtilities elementsUtilities;

	public LoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
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
		elementsUtilities.clearTextFromTextField(passwordField);
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
		elementsUtilities.clickOnElement(forgottenPassword);
		 return new ForgotPasswordPage(driver);
	}
	
	public boolean verifyLoginBreadCrumb(){
		return elementsUtilities.isElementDisplayed(loginBreaddCrumb);
	}
	
	public void clickOnLoginBreadCrumb(){
		elementsUtilities.clickOnElement(loginBreaddCrumb);
	}
	
	public boolean verifyNewCustomerHeadingOnLoginPage() {
		return elementsUtilities.isElementDisplayed(newCustomerHeading);
	}
	
	public String getTextOfNewCustomerHeadingOnLoginPage() {
		return elementsUtilities.getTextOfElements(newCustomerHeading);
	}
	
	public String getTextReturningCustomerHeadingOnLoginPage() {
		return elementsUtilities.getTextOfElements(returningCustomerHeading);
	}
	
	public RegisterPage clickOnContinueButtonOnLoginPage(){
		elementsUtilities.clickOnElement(continueButton);
		return new RegisterPage(driver);
	}
	
	public void clickOnRegisterOption(){
		elementsUtilities.clickOnElement(registerOption);
	}
	
	public void enterUsernameEmail(String emailText){
		elementsUtilities.enterTextIntoElement(usernameEmailField, emailText);
	}
	
	public void enterPassword(String passwordText){
		elementsUtilities.enterTextIntoElement(passwordField, passwordText);
	}
	
	public AccountPage clickLoginButton(){
		elementsUtilities.clickOnElement(loginButton);
		return new AccountPage(driver);
	}
	
	public String getWarningMessage(){
		return elementsUtilities.getTextOfElements(warningMessage);
	}
	
	public String getUserNamePlaceholder(){
		return usernameEmailField.getDomAttribute("placeholder");
	}
	public String getPasswordPlaceholder() {
		return passwordField.getDomAttribute("placeholder");
	}
}
