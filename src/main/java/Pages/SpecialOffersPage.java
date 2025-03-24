package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class SpecialOffersPage extends RootPage{

	ElementsUtilities elementsUtilities;

	public SpecialOffersPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Special Offers']")
	private WebElement specialOffersBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToSpecialOffersPage() {
		return elementsUtilities.isElementDisplayed(specialOffersBreadcrumb);
	}
	
}
