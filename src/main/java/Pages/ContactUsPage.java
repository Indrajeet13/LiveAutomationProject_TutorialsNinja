package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class ContactUsPage extends RootPage{

	public ContactUsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Contact Us']")
	private WebElement contactUSBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToContactUsPage() {
		return isElementDisplayed(contactUSBreadcrum);
	}
	
	
	
}
