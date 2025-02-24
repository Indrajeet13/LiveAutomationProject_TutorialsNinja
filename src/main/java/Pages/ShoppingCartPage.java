package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartBreadCrumb;
	
	
	
	
	
	public boolean didWeNavigateToShoppingCartPage(){
		return shoppingCartBreadCrumb.isDisplayed();
	}
	
	
	
	
	
}
