package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class ContactUsPage extends RootPage{

	ElementsUtilities elementsUtilities;
	
=======

public class ContactUsPage extends RootPage{

>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	public ContactUsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Contact Us']")
	private WebElement contactUSBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToContactUsPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(contactUSBreadcrum);
=======
		return isElementDisplayed(contactUSBreadcrum);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
	
}
