package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsAndConditionPage {
	
	WebDriver driver;
	
	public TermsAndConditionPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Terms & Conditions')]")
	private WebElement termsAndConditionBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToTermsAndConditionPage() {
		return termsAndConditionBreadcrum.isDisplayed();
	}
	
	
}
