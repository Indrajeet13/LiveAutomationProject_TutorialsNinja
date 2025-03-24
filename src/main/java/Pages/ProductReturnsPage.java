package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class ProductReturnsPage extends RootPage{

	ElementsUtilities elementsUtilities;
	
=======

public class ProductReturnsPage extends RootPage{

>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	public ProductReturnsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Product Returns']")
	private WebElement productReturnsText;
	
	
	
	
	
	public boolean didWeNavigateToProductReturnsPage() {
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(productReturnsText);
=======
		return isElementDisplayed(productReturnsText);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
}
