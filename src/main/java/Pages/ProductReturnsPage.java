package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import Pages.root.RootPage;
import utils.ElementsUtilities;

public class ProductReturnsPage extends RootPage{

	ElementsUtilities elementsUtilities;
	
	public ProductReturnsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		elementsUtilities = new ElementsUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Product Returns']")
	private WebElement productReturnsText;
	
	
	
	
	
	public boolean didWeNavigateToProductReturnsPage() {
		return elementsUtilities.isElementDisplayed(productReturnsText);
	}
	
	
}
