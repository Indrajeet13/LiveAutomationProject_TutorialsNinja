package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class TermsAndConditionPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class TermsAndConditionPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public TermsAndConditionPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Terms & Conditions')]")
	private WebElement termsAndConditionBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToTermsAndConditionPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(termsAndConditionBreadcrum);
=======
		return isElementDisplayed(termsAndConditionBreadcrum);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
}
