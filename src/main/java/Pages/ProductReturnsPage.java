package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReturnsPage {
	
	WebDriver driver;
	
	public ProductReturnsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Product Returns']")
	private WebElement productReturnsText;
	
	
	
	
	
	public boolean didWeNavigateToProductReturnsPage() {
		return productReturnsText.isDisplayed();
	}
	
	
}
