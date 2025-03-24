package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class NewsletterPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
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
		return elementsUtilities.isElementDisplayed(newsletterSubscriptionHeading);
	}
	
	public AccountPage clickOnContinueButtonOnNewsletterPage() {
		elementsUtilities.clickOnElement(continueButton);
		return new AccountPage(driver);
	}
	
	public void clickOnNewsletterNORadio() {
		elementsUtilities.clickOnElement(newsletterNO);
	}
	
	
	
	
}
