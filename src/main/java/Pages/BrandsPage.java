package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class BrandsPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class BrandsPage extends RootPage{
	
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0

	public BrandsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Brand']")
	private WebElement brandsBreadcrum;
	
	
	
	
	
	public boolean didWeNavigateToBrandsPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(brandsBreadcrum);
=======
		return isElementDisplayed(brandsBreadcrum);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
}
