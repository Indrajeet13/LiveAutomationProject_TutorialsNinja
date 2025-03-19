package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class SpecialOffersPage extends RootPage{


	public SpecialOffersPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Special Offers']")
	private WebElement specialOffersBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToSpecialOffersPage() {
		return isElementDisplayed(specialOffersBreadcrumb);
	}
	
}
