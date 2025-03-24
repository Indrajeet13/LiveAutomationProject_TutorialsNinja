package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class ContactUsPage extends RootPage{

	ElementsUtilities elementsUtilities;
	
	public ContactUsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Contact Us']")
	private WebElement contactUSBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToContactUsPage() {
		return elementsUtilities.isElementDisplayed(contactUSBreadcrum);
	}
	
	
	
}
