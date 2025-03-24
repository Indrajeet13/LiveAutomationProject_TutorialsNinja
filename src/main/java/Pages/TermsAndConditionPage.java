package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class TermsAndConditionPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public TermsAndConditionPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Terms & Conditions')]")
	private WebElement termsAndConditionBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToTermsAndConditionPage() {
		return elementsUtilities.isElementDisplayed(termsAndConditionBreadcrum);
	}
	
	
}
