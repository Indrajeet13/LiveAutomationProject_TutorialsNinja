package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPolicyPage {
	
	WebDriver driver;
	
	public PrivacyPolicyPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToPrivacyPolicyPage() {
		return privacyPolicyBreadcrum.isDisplayed();
	}
	
	
	
}
