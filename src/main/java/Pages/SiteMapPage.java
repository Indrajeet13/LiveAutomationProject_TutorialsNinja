package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class SiteMapPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public SiteMapPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Site Map']")
	private WebElement siteMapBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToSiteMapPage() {
		return elementsUtilities.isElementDisplayed(siteMapBreadcrumb);
	}
}
