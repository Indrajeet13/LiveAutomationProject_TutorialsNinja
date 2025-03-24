package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class PrivacyPolicyPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class PrivacyPolicyPage extends RootPage{
	
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public PrivacyPolicyPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToPrivacyPolicyPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(privacyPolicyBreadcrum);
=======
		return isElementDisplayed(privacyPolicyBreadcrum);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
	
}
