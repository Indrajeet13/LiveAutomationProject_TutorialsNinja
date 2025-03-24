package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class AccountPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class AccountPage extends RootPage{
	
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0

	public AccountPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption; 
	
	@FindBy(xpath="//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
	private WebElement subscribeUnsubscribeNewsLetter;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement newsletterUpdationSuccessfulMessage;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement logoutOption;
	
	@FindBy(linkText="Change your password")
	private WebElement changeYourPassword;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updationSuccessMessage;
	
	
	

	
	public String verifyUpdationSuccessfulMessage() {
<<<<<<< HEAD
		return elementsUtilities.getTextOfElements(updationSuccessMessage);
=======
		return getTextOfElements(updationSuccessMessage);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public ChangePasswordPage clickOnChangeYourPasswordLink() {
		elementsUtilities.clickOnElement(changeYourPassword);
		return new ChangePasswordPage(driver);
	}
	
	public boolean didWeNavigateToAccountPage() {
		return elementsUtilities.isElementDisplayed(editYourAccountInformationOption);
	}
	
	public NewsletterPage clickOnSubscribeUnsubscribeNewsLetter() {
		elementsUtilities.clickOnElement(subscribeUnsubscribeNewsLetter);
		return new NewsletterPage(driver);
	}
	
	public boolean verifyNewsletterUpdationSuccessfulMessage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(newsletterUpdationSuccessfulMessage);
=======
		return isElementDisplayed(newsletterUpdationSuccessfulMessage);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public EditAccountInformationPage clickEditYourAccountInformationOption() {
		elementsUtilities.clickOnElement(editYourAccountInformationOption);
		 return new EditAccountInformationPage(driver);
	}
	
	public boolean isUserLoggedIn() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(logoutOption);
=======
		return isElementDisplayed(logoutOption);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public AccountLogoutPage clickOnLogoutOption() {
		elementsUtilities.clickOnElement(logoutOption);
		return new AccountLogoutPage(driver);
	}
}
