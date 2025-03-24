package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class ChangePasswordPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public ChangePasswordPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Change Password']")
	private WebElement changePasswordBreadcrumb;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	
	
	
	
	public AccountPage clickOnContinueButton() {
		elementsUtilities.clickOnElement(continueButton);
		return new AccountPage(driver);
	}
	
	public void enterConfirmPassword(String passwordText) {
		elementsUtilities.enterTextIntoElement(passwordConfirmField, passwordText);
	}
	
	public void enterPassword(String passwordText) {
		elementsUtilities.enterTextIntoElement(passwordField, passwordText);
	}
	
	public boolean didWeNavigateToPasswordConfirmPage() {
		return elementsUtilities.isElementDisplayed(changePasswordBreadcrumb);
	}
	
	
	
}
