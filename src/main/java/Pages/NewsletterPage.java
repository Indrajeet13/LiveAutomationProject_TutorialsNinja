package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class NewsletterPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class NewsletterPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	

	public NewsletterPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement newsletterYES; 
	
	@FindBy(xpath="//h1[normalize-space()='Newsletter Subscription']")
	private WebElement newsletterSubscriptionHeading; 
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton; 
	
	@FindBy(xpath="//input[@value='0']")
	private WebElement newsletterNO; 
	
	
	
	
	
	
	public void clickOnNewsletterYESRadio() {
		elementsUtilities.clickOnElement(newsletterYES);
	}
	
	public boolean verifyNewsletterSubscriptionHeading() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(newsletterSubscriptionHeading);
=======
		return isElementDisplayed(newsletterSubscriptionHeading);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	public AccountPage clickOnContinueButtonOnNewsletterPage() {
		elementsUtilities.clickOnElement(continueButton);
		return new AccountPage(driver);
	}
	
	public void clickOnNewsletterNORadio() {
		elementsUtilities.clickOnElement(newsletterNO);
	}
	
	
	
	
}
