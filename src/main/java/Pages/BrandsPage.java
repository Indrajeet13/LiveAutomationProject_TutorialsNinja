package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class BrandsPage extends RootPage{
	
	ElementsUtilities elementsUtilities;

	public BrandsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Brand']")
	private WebElement brandsBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToBrandsPage() {
		return elementsUtilities.isElementDisplayed(brandsBreadcrum);
	}
	
	
}
