package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class AffiliateProgramPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public AffiliateProgramPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Affiliate Program']")
	private WebElement affiliateProgramText;
	
	
	
	
	
	public boolean didWeNavigateToAffiliateProgramPage() {
		return elementsUtilities.isElementDisplayed(affiliateProgramText);
	}
	
}
