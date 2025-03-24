package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class SpecialOffersPage extends RootPage{

	ElementsUtilities elementsUtilities;
=======

public class SpecialOffersPage extends RootPage{

>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0

	public SpecialOffersPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Special Offers']")
	private WebElement specialOffersBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToSpecialOffersPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(specialOffersBreadcrumb);
=======
		return isElementDisplayed(specialOffersBreadcrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
}
