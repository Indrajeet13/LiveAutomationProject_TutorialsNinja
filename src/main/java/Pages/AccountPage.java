package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class AccountPage extends RootPage{
	
	ElementsUtilities elementsUtilities;

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
		return elementsUtilities.getTextOfElements(updationSuccessMessage);
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
		return elementsUtilities.isElementDisplayed(newsletterUpdationSuccessfulMessage);
	}
	
	public EditAccountInformationPage clickEditYourAccountInformationOption() {
		elementsUtilities.clickOnElement(editYourAccountInformationOption);
		 return new EditAccountInformationPage(driver);
	}
	
	public boolean isUserLoggedIn() {
		return elementsUtilities.isElementDisplayed(logoutOption);
	}
	
	public AccountLogoutPage clickOnLogoutOption() {
		elementsUtilities.clickOnElement(logoutOption);
		return new AccountLogoutPage(driver);
	}
}
