package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class SiteMapPage extends RootPage{
	
	public SiteMapPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Site Map']")
	private WebElement siteMapBreadcrumb;
	
	
	
	
	
	public boolean didWeNavigateToSiteMapPage() {
		return isElementDisplayed(siteMapBreadcrumb);
	}
}
