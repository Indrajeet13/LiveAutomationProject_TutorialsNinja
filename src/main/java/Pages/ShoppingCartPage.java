package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class ShoppingCartPage extends RootPage{
	
	ElementsUtilities elementsUtilities;
	
	public ShoppingCartPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartBreadCrumb;
	
	
	
	
	
	public boolean didWeNavigateToShoppingCartPage(){
		return elementsUtilities.isElementDisplayed(shoppingCartBreadCrumb);
	}
	
	
	
	
	
}
