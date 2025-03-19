package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class PrivacyPolicyPage extends RootPage{
	
	
	public PrivacyPolicyPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToPrivacyPolicyPage() {
		return isElementDisplayed(privacyPolicyBreadcrum);
	}
	
	
	
}
