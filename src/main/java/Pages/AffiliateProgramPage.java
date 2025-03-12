package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class AffiliateProgramPage extends RootPage{
	
	public AffiliateProgramPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Affiliate Program']")
	private WebElement affiliateProgramText;
	
	
	
	
	
	public boolean didWeNavigateToAffiliateProgramPage() {
		boolean b = false;
		try {
			b =  affiliateProgramText.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
}
