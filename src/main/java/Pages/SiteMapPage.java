package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class SiteMapPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class SiteMapPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public SiteMapPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Site Map']")
	private WebElement siteMapBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToSiteMapPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(siteMapBreadcrumb);
=======
		return isElementDisplayed(siteMapBreadcrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
}
