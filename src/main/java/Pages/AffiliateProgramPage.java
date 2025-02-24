package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AffiliateProgramPage {
	
	WebDriver driver;
	
	public AffiliateProgramPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Affiliate Program']")
	private WebElement affiliateProgramText;
	
	
	
	
	
	public boolean didWeNavigateToAffiliateProgramPage() {
		return affiliateProgramText.isDisplayed();
	}
	
}
