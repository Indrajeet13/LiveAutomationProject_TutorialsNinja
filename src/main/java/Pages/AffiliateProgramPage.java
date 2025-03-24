package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class AffiliateProgramPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class AffiliateProgramPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public AffiliateProgramPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Affiliate Program']")
	private WebElement affiliateProgramText;
	
	
	
	
	
	public boolean didWeNavigateToAffiliateProgramPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(affiliateProgramText);
=======
		return isElementDisplayed(affiliateProgramText);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
}
