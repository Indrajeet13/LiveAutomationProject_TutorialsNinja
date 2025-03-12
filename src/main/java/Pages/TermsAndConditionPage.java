package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class TermsAndConditionPage extends RootPage{
	
	public TermsAndConditionPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Terms & Conditions')]")
	private WebElement termsAndConditionBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToTermsAndConditionPage() {
		boolean b = false;
		try {
			b =  termsAndConditionBreadcrum.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	
}
