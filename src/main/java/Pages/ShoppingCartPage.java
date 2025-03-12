package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class ShoppingCartPage extends RootPage{
	
	public ShoppingCartPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartBreadCrumb;
	
	
	
	
	
	public boolean didWeNavigateToShoppingCartPage(){
		boolean b = false;
		try {
			b =  shoppingCartBreadCrumb.isDisplayed();
		}catch(NoSuchElementException e)
		{
			b = false;
		}
		return b;
	}
	
	
	
	
	
}
