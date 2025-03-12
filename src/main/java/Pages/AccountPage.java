package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class AccountPage extends RootPage{
	

	public AccountPage(WebDriver driver){
		super(driver);
		this.driver = driver;
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
		String messageText = null;
		try {
			messageText = updationSuccessMessage.getText();
		} catch (NoSuchElementException e) {
			messageText = null;
		}
		return messageText;
	}
	
	public ChangePasswordPage clickOnChangeYourPasswordLink() {
		changeYourPassword.click();
		return new ChangePasswordPage(driver);
	}
	
	public boolean didWeNavigateToAccountPage() {
		return editYourAccountInformationOption.isDisplayed();
	}
	
	public NewsletterPage clickOnSubscribeUnsubscribeNewsLetter() {
		subscribeUnsubscribeNewsLetter.click();
		return new NewsletterPage(driver);
	}
	
	public boolean verifyNewsletterUpdationSuccessfulMessage() {
		boolean b = false;
		try {
			b =  newsletterUpdationSuccessfulMessage.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public EditAccountInformationPage clickEditYourAccountInformationOption() {
		 editYourAccountInformationOption.click();
		 return new EditAccountInformationPage(driver);
	}
	
	public boolean isUserLoggedIn() {
		boolean b = false;
		try {
			b =  logoutOption.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public AccountLogoutPage clickOnLogoutOption() {
		logoutOption.click();
		return new AccountLogoutPage(driver);
	}
}
