package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
<<<<<<< HEAD
import utils.ElementsUtilities;

public class ShoppingCartPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
=======

public class ShoppingCartPage extends RootPage{
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	
	public ShoppingCartPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartBreadCrumb;
	
	
	
	
	
	public boolean didWeNavigateToShoppingCartPage(){
<<<<<<< HEAD
		return elementsUtilities.isElementDisplayed(shoppingCartBreadCrumb);
=======
		return isElementDisplayed(shoppingCartBreadCrumb);
>>>>>>> 633e2c99f4a3d5170abf58ed8f048888131268a0
	}
	
	
	
	
	
}
