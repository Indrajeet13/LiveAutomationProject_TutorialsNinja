package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class PrivacyPolicyPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public PrivacyPolicyPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToPrivacyPolicyPage() {
		return elementsUtilities.isElementDisplayed(privacyPolicyBreadcrum);
	}
	
	
	
}
