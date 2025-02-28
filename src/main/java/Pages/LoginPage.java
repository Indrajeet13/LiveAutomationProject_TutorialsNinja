package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	@FindBy(xpath="//h2[normalize-space()='New Customer']")
	private WebElement newCustomerHeading;
	
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
	
	
	
	
	public WebDriver getDriver() {
		return driver;
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
		return loginBreaddCrumb.isDisplayed();
	}
	
	public void clickOnLoginBreadCrumb(){
		loginBreaddCrumb.click();
	}
	
	public boolean verifyNewCustomerHeadingOnLoginPage() {
		return newCustomerHeading.isDisplayed();
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
		return warningMessage.getText();
	}
	
	public String getUserNamePlaceholder(){
		return usernameEmailField.getDomAttribute("placeholder");
	}
	public String getPasswordPlaceholder() {
		return passwordField.getDomAttribute("placeholder");
	}
}
