package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {
	
	WebDriver driver;
	
	public NewsletterPage(WebDriver driver){
		this.driver = driver;
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
		newsletterYES.click();
	}
	
	public boolean verifyNewsletterSubscriptionHeading() {
		return newsletterSubscriptionHeading.isDisplayed();
	}
	
	public AccountPage clickOnContinueButtonOnNewsletterPage() {
		continueButton.click();
		return new AccountPage(driver);
	}
	
	public void clickOnNewsletterNORadio() {
		newsletterNO.click();
	}
	
	
	
	
}
