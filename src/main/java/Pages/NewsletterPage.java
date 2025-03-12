package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class NewsletterPage extends RootPage{
	

	public NewsletterPage(WebDriver driver){
		super(driver);
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
		boolean b = false;
		try {
			b =  newsletterSubscriptionHeading.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	public AccountPage clickOnContinueButtonOnNewsletterPage() {
		continueButton.click();
		return new AccountPage(driver);
	}
	
	public void clickOnNewsletterNORadio() {
		newsletterNO.click();
	}
	
	
	
	
}
