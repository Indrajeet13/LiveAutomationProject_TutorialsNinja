package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	WebDriver driver;
	
	public ContactUsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Contact Us']")
	private WebElement contactUSBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToContactUsPage() {
		return contactUSBreadcrum.isDisplayed();
	}
	
	
	
}
