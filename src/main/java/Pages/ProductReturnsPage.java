package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;

public class ProductReturnsPage extends RootPage{

	public ProductReturnsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Product Returns']")
	private WebElement productReturnsText;
	
	
	
	
	
	public boolean didWeNavigateToProductReturnsPage() {
		return isElementDisplayed(productReturnsText);
	}
	
	
}
