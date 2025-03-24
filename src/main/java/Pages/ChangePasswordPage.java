package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class ChangePasswordPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class ChangePasswordPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
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
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(changePasswordBreadcrumb);
=======
		return isElementDisplayed(changePasswordBreadcrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
	
}
